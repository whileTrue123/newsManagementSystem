package com.zhoujie.controller;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zhoujie.model.Comment;
import com.zhoujie.model.News;
import com.zhoujie.model.NewsType;
import com.zhoujie.model.PageBean;
import com.zhoujie.service.CommentService;
import com.zhoujie.service.NewsService;
import com.zhoujie.service.NewsTypeService;
import com.zhoujie.service.PageService;
import com.zhoujie.utils.DateUtil;
import com.zhoujie.utils.NavUtil;
import com.zhoujie.utils.PageUtil;
import com.zhoujie.utils.ResponseUtil;
import com.zhoujie.utils.StringUtil;

/**
 * @author zhoujie
 */

@Controller
public class NewsController {

	private final static String imagePath = "C:\\workspace\\newsManagementSystem\\src\\main\\webapp\\userImage\\";
	private final static int pageSize = 10;

	@Resource
	private NewsService newsService;
	@Resource
	private NewsTypeService newsTypeService;
	@Resource
	private CommentService commentService;
	@Resource
	private PageService pageService;

	@RequestMapping(value = "/newsPreSave")
	public String newsPreSave(HttpServletRequest request, HttpServletResponse response) throws ParseException {
		String newsId = request.getParameter("newsId");
		if (StringUtil.isNotEmpty(newsId)) {
			News news = newsService.selectByPrimaryKey(Integer.parseInt(newsId));
			request.setAttribute("news", news);
			request.setAttribute("navCode", NavUtil.genNewsManageNavigation("新闻管理", "新闻修改"));
		} else {
			request.setAttribute("navCode", NavUtil.genNewsManageNavigation("新闻管理", "新闻添加"));
		}
		List<NewsType> newsTypeList = newsTypeService.getTypeList();
		request.setAttribute("newsTypeList", newsTypeList);
		request.setAttribute("mainPage", "/background/news/newsSave.jsp");
		return "/background/mainTemp";
	}

	@RequestMapping(value = "/newsSave", method = RequestMethod.POST)
	public String newsSave(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		FileItemFactory factory = new DiskFileItemFactory(); // 采用默认临界值和系统临时文件夹
																// 构造文件项工厂对象。
		ServletFileUpload upload = new ServletFileUpload(factory);// 创建一个文件上传解析器
		upload.setHeaderEncoding("UTF-8");
		List<FileItem> items = null;
		try {
			items = upload.parseRequest(request);// 使用ServletFileUpload解析器解析上传数据
		} catch (Exception e) {
			e.printStackTrace();
		}
		News news = new News();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = format.format(new Date());
		news.setPublishdate(format.parse(date));
		for (FileItem item : items) {
			if (item.isFormField()) {
				String fieldName = item.getFieldName();
				if ("newsId".equals(fieldName)) {
					if (StringUtil.isNotEmpty(item.getString("utf-8"))) {
						news.setNewsid(Integer.parseInt(item.getString("utf-8")));
					}
				}
				if ("title".equals(fieldName)) {
					news.setTitle(item.getString("utf-8"));
				}
				if ("content".equals(fieldName)) {
					news.setContent(item.getString("utf-8"));
				}
				if ("author".equals(fieldName)) {
					news.setAuthor(item.getString("utf-8"));
				}
				if ("typeId".equals(fieldName)) {
					news.setTypeid(Integer.parseInt(item.getString("utf-8")));
				}
				if ("isHead".equals(fieldName)) {
					news.setIshead(Integer.parseInt(item.getString("utf-8")));
				}
				if ("isImage".equals(fieldName)) {
					news.setIsimage(Integer.parseInt(item.getString("utf-8")));
				}
				if ("isHot".equals(fieldName)) {
					news.setIshot(Integer.parseInt(item.getString("utf-8")));
				}
				if ("imageName".equals(fieldName) && news.getImagename() == null) {
					if (StringUtil.isNotEmpty(item.getString("utf-8"))) {
						String imageName = DateUtil.getCurrentDateStr();
						news.setImagename(imageName + ".jpg");
						// String filePath = imagePath + news.getImagename();
						// item.write(new File(filePath));
					}
				}
			} else if (!"".equals(item.getName())) {// picFile
				try {
					String imageName = DateUtil.getCurrentDateStr();
					if (!item.isFormField() && item.getName() != null && !"".equals(item.getName())) {
						news.setImagename(imageName + ".jpg");
						String filePath = imagePath + news.getImagename();
						item.write(new File(filePath));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		if (news.getNewsid() != null && news.getNewsid() != 0) {
			newsService.updateByPrimaryKeyWithBLOBs(news);
		} else {
			newsService.insertSelective(news);
		}
		return "redirect:/newsBackList.action";
	}

	@RequestMapping(value = "/newsBackList")
	public String newsBackList(HttpServletRequest request, HttpServletResponse response, Model model) {
		String bDate = request.getParameter("s_bPublishDate");
		String aDate = request.getParameter("s_aPublishDate");
		String s_title = request.getParameter("s_title");
		String page = request.getParameter("page");
		HttpSession session = request.getSession();
		if (StringUtil.isEmpty(page)) {
			page = "1";
			session.setAttribute("s_bPublishDate", bDate);
			session.setAttribute("s_aPublishDate", aDate);
			session.setAttribute("s_title", s_title);
		} else {
			bDate = (String) session.getAttribute("s_bPublishDate");
			aDate = (String) session.getAttribute("s_aPublishDate");
			s_title = (String) session.getAttribute("s_title");
		}
		News news = new News();
		if (StringUtil.isNotEmpty(s_title)) {
			news.setTitle(s_title);
		}
		int total = 0;
		total = newsService.newsCounts(news.getTypeid(), news.getTitle(), aDate, bDate);
		System.out.println(total);
		String pageCode = PageUtil.getPagation(request.getContextPath() + "/newsBackList.action", total,
				Integer.parseInt(page), pageSize);
		PageBean pageBean = new PageBean(Integer.parseInt(page), pageSize);
		List<News> newsBackList = newsService.newsList(news.getTypeid(), news.getTitle(), pageBean.getStart(),
				pageBean.getPageSize(), bDate, aDate);
		request.setAttribute("pageCode", pageCode);
		request.setAttribute("newsBackList", newsBackList);
		request.setAttribute("navCode", NavUtil.genNewsManageNavigation("新闻管理", "新闻列表"));
		request.setAttribute("mainPage", "/background/news/newsList.jsp");
		return "/background/mainTemp";
	}

	@RequestMapping(value = "/newsDelete")
	public void newsDelete(HttpServletRequest request, HttpServletResponse response, Model model) {
		String newsId = request.getParameter("newsId");
		int i = newsService.deleteByPrimaryKey(Integer.parseInt(newsId));
		Boolean delFlag = false;
		if (i == 1) {
			delFlag = true;
		} else {
			delFlag = false;
		}
		try {
			ResponseUtil.write(delFlag, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/newsShow")
	public String newsShow(HttpServletRequest request, HttpServletResponse response) {
		String newsId = request.getParameter("newsId");
		int id = Integer.parseInt(newsId);
		newsService.newsClickCount(id);
		List<News> newestNewsList = newsService.newestNewsList();//最新新闻
		request.setAttribute("newestNewsList",newestNewsList);
		List<News> hotNewsList = newsService.hotNewsList();//热门新闻
		request.setAttribute("hotNewsList", hotNewsList);
		News news = newsService.selectByPrimaryKey(id);
		// Comment s_comment=new Comment();
		// s_comment.setNewsid(id);
		List<Comment> commentList = commentService.CommentList(id, 0, 0, null, null);
		request.setAttribute("commentList", commentList);
		request.setAttribute("news", news);
		request.setAttribute("pageCode", pageService.genUpAndDownPageCode(newsService.getUpAndDownPageId(id)));
		request.setAttribute("navCode",
				NavUtil.genNewsNavigation(news.getTypeName(), news.getTypeid() + "", news.getTitle()));
		request.setAttribute("title", news.getTitle());
		request.setAttribute("mainPage", "news/newsShow.jsp");
		return "foreground/newsTemp";
	}

	/**
	 * 前台点击“更多”后的展示
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/newsList")
	public String newsList(HttpServletRequest request, HttpServletResponse response) {
		String typeId = request.getParameter("typeId");
		String page = request.getParameter("page");
		if (StringUtil.isEmpty(page)) {
			page = "1";
		}
		News s_news = new News();
		if (StringUtil.isNotEmpty(typeId)) {
			s_news.setTypeid(Integer.parseInt(typeId));
		}
		int total = newsService.newsCounts(s_news.getTypeid(), s_news.getTitle(), null, null);
		PageBean pageBean = new PageBean(Integer.parseInt(page), pageSize);
		List<News> newestNewsListWithType = newsService.newsList(s_news.getTypeid(), s_news.getTitle(),
				pageBean.getStart(), pageBean.getPageSize(), null, null);
		request.setAttribute("newestNewsListWithType", newestNewsListWithType);
		String typeName = newsTypeService.selectByPrimaryKey(Integer.parseInt(typeId)).getTypename();
		request.setAttribute("navCode", NavUtil.genNewsListNavigation(typeName, typeId));
		request.setAttribute("pageCode",
				PageUtil.getUpAndDownPagation(total, Integer.parseInt(page), pageSize, typeId));
		request.setAttribute("mainPage", "news/newsList.jsp");
		request.setAttribute("title", typeName);
		return "foreground/newsTemp";
	}
}
