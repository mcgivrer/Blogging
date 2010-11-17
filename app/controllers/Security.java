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
	public static boolean authenticate(String email, String password){
		return User.connect(email,password)!=null;
	}
	static void onAuthenticated(){
		Admin.index();	
	}
	
	static void onDisconnect(){
		Application.index();
	}
	
	static boolean check(String profile) {
	    if("admin".equals(profile)) {
	        return User.find("byEmail", connected()).<User>first().isAdmin();
	    }
	    return false;
	}
}
