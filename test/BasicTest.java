import models.User;

import org.junit.Before;
import org.junit.Test;

import play.test.Fixtures;
import play.test.UnitTest;

public class BasicTest extends UnitTest {
	@Before
	public void setup(){
		//Fixtures.deleteAll();
	}
    @Test
    public void userCreateTest() {
    	//create User
    	User user=new User("admin","admin","Administrator","HomeBlogging","","","","a","admin");
    	user.save();
        assertNotNull(user.id);
    }
    @Test
    public void userUpdateTest() {
    	//create User
    	User user=new User("admin","admin","Administrator","HomeBlogging","","","","a","admin");
    	user.save();
    	assertNotNull(user.id);
        user.firstname="Administrateur";
        user.save();
        assertEquals("Administrateur", user.firstname);
    }
    @Test
    public void userRetrieveTest() {
    	//create User
    	User user=new User("admin","admin","Administrator","HomeBlogging","","","","a","admin");
    	user.save();
    	//create User
    	User userRead = User.find("byUsername","admin").first();
    	assertNull(userRead);
//    	assertNotEquals()
    }
}