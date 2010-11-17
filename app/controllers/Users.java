/**
 * 
 */
package controllers;

import play.mvc.With;

/**
 * @author frederic
 *
 */
@Check("admin")
@With(Security.class)
public class Users extends CRUD {

}
