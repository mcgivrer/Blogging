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
@With(Secure.class)
public class Tags extends CRUD {

}
