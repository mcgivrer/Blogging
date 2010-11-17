package controllers;
 
import play.*;
import play.mvc.*;
 
import java.util.*;
 
import models.*;
 
@With(Secure.class)
public class Admin extends Controller {
   
    @Before
    static void setConnectedUser() {
        if(Security.isConnected()) {
            User user = User.find("byEmail", Security.connected()).first();
            renderArgs.put("user", user);
        }
    }
 
    public static void index() {
    	List<Post> posts=Post.find("byAuthor",((User)renderArgs.get("user"))).fetch();
        render(posts);
    }
    
}