package newsManagementSystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhoujie.model.User;
import com.zhoujie.service.UserService;

/** 
* @author zhoujie
*/
public class test {

	    public static void main(String[] args) {
			ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
			UserService userservice = (UserService) applicationContext.getBean("userService");
			User user = userservice.getUserById(1);
			System.out.println(user.getUsername());
			
		}
	    
}
