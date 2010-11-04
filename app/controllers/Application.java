package controllers;

import play.*;
import play.mvc.*;
import play.test.Fixtures;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
    	
    	if(User.count()==0){
    		Fixtures.load("init-data.yml");
    	}
    	List<Post> posts = Post.find("order by createdAt desc").fetch(2);
        render(posts);
    }

}
