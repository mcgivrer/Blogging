package controllers;

import play.*;
import play.mvc.*;
import play.test.Fixtures;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
    	List<Post> posts = Post.find("order by createdAt desc").fetch(1);
    	List<Posts> oldposts = Post.find("order by createdAt desc").fetch(1, 5);
    	List<Category> categories = Category.find("order by pos").fetch();
        render(posts,oldposts,categories);
    }
	public static void category(Long id){
    	List<Post> posts = Post.find("where category_id=&id order by createdAt desc").fetch(1);
    	List<Posts> oldposts = Post.find("order by createdAt desc").fetch(1, 5);
    	List<Category> categories = Category.find("order by pos").fetch();
        render(posts,oldposts,categories);	
	}
}
