package controllers;

import play.*;
import play.mvc.*;
import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
        List<Post> posts = Post.find("order by createdAt desc").fetch(1);
        List<Posts> oldposts = Post.find("order by createdAt desc").fetch(1, 5);
        List<Category> categories = Category.find("title!='root' order by pos asc").fetch();
        render(posts,oldposts,categories);
    }

    public static void category(Long id){
        if(id==0){
            index();
        }else{
            List<Post> posts = Post.find("category.id="+id+" order by createdAt desc").fetch(1);
            List<Posts> oldposts = Post.find("order by createdAt desc").fetch(1, 5);
            List<Category> categories = Category.find("title!='root' order by pos asc").fetch();
            render(posts,oldposts,categories);    
        }
    }
    
    public static void tag(String tag){
        List<Post> posts = Post.findTaggedWith(tag);
        List<Category> categories = Category.find("title!='root' order by pos asc").fetch();
        render(posts,categories);    
    }
    
    public static void postBy(Long authorId){
        List<Post> posts = Post.find("author.id="+authorId+" order by createdAt desc").fetch(3);
        List<Posts> oldposts = Post.find("order by createdAt desc").fetch(3, 5);
        List<Category> categories = Category.find("title!='root' order by pos asc").fetch();
        render(posts,oldposts,categories);
    }

    public static void postFrom(String createdAt){
        List<Post> posts = Post.find("createdAt='"+createdAt+"' order by author.username desc").fetch(3);
        List<Posts> oldposts = Post.find("order by createdAt desc").fetch(3, 5);
        List<Category> categories = Category.find("title!='root' order by pos asc").fetch();
        render(posts,oldposts,categories);
    }
    
}

