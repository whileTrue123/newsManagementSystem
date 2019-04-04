<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
	function newsTypeDelete(newsTypeId){
		if(confirm("确认要删除这条新闻类别吗？")){
			$.post("delete.action", 			//url
					{newstypeid:newsTypeId},  	//data
					function(result){ 			//callback
						var result=eval('('+result+')');		//将json字符串转换成json对象
						if(result.success){
							alert("删除成功!");
							window.location.href="${pageContext.request.contextPath}/backList.action";
						}else{
							alert(result.errorMsg);
						}
				})
		}
	}
</script>
</head>
<body>
<div class="data_list backMain">
	<div class="dataHeader navi">
		${navCode}
	</div>
	<div class="data_content">
		<table class="table table-hover table-bordered">
			<tr>
				<th>序号</th>
				<th>新闻类别名称</th>
				<th>操作</th>
			</tr>
			<c:forEach var="newsTypeBack" items="${newsTypeBackList }" varStatus="status">
				<tr>
					<td>${newsTypeBack.newstypeid }</td>
					<td>${newsTypeBack.typename }</td>
					<td><button class="btn btn-mini btn-info" type="button" onclick="javascript:window.location='${pageContext.request.contextPath}/preSave.action?newsTypeId=${newsTypeBack.newstypeid }'">修改</button>&nbsp;&nbsp;<button class="btn btn-mini btn-danger" type="button" onclick="newsTypeDelete(${newsTypeBack.newstypeid})">删除</button></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>
</body>
</html>