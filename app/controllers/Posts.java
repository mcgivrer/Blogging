package controllers;

import play.*;
import play.mvc.*;

@Check("admin")
@With(Security.class)
public class Posts extends CRUD {

}
