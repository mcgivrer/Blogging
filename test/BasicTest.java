import java.util.List;

import models.User;

import org.junit.Test;

import play.test.UnitTest;

public class BasicTest extends UnitTest {

    @Test
    public void userCreateTest() {
    	//create User
    	User user=new User("admin","admin","Administrator","HomeBlogging","","","",new Boolean(true),"admin");
    	user.save();
        assertNull(user.id);
    }
    @Test
    public void userUpdateTest() {
    	//create User
    	User user=new User("admin","admin","Administrator","HomeBlogging","","","",new Boolean(true),"admin");
    	user.save();
        assertNull(user.id);
        user.firstname="Administrateur";
        user.save();
    }
    @Test
    public void userRetrieveTest() {
    	//create User
    	User user=new User("admin","admin","Administrator","HomeBlogging","","","",new Boolean(true),"admin");
    	user.save();
    	//create User
    	List<User> users = User.find("byUsername","admin").fetch(1);
    	assertNull(users);
//    	assertNotEquals()
    }
}