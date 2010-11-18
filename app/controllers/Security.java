/**
 * 
 */
package controllers;

import models.User;


/**
 * @author frederic
 *
 */
public class Security extends controllers.Secure.Security {
	
	/**
	 * Authentication method
	 * @param email
	 * @param password
	 * @return
	 */
	public static boolean authenticate(String email, String password){
		return User.connect(email,password)!=null;
	}
	
	/**
	 * Route to Controller/method on positive authentication
	 */
	static void onAuthenticated(){
		Admin.index();	
	}
	
	/**
	 * Route to Controller/Method on Diconnection
	 */
	static void onDisconnected(){
		Application.index();
	}
	
	static boolean check(String profile) {
	    if("admin".equals(profile)) {
	        return User.find("byEmail", connected()).<User>first().isAdmin();
	    }
	    return false;
	}
}
