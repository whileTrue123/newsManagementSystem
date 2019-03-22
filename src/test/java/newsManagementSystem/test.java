package newsManagementSystem;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.zhoujie.model.User;
import com.zhoujie.service.UserService;

/** 
* @author zhoujie
*/

@RunWith(SpringJUnit4ClassRunner.class)
// ∏ÊÀﬂjunit spring≈‰÷√Œƒº˛
@ContextConfiguration({"classpath:spring/spring-mybatis.xml"})
public class test {
		private static Logger logger = Logger.getLogger(test.class);

	    @Resource
	    public UserService userService = null;
	    
	    @Test
	    public void getUserByIdTest(){
	     
	        User user = userService.getUserById(1);
	        System.out.println(user.getUsername());
			logger.info(JSON.toJSONString(user));
	    }
}
