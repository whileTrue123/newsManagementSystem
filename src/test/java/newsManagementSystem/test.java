package newsManagementSystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zhoujie.model.User;
import com.zhoujie.service.UserService;

/** 
* @author zhoujie
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:applicationContext.xml"})
public class test {

	    @Autowired
	    public UserService userService;
	    
	    @Test
	    public void getUserByIdTest(){
	     
	        User user = userService.getUserById(1);
	        System.out.println(user.getUsername());
	    }
	    
}
