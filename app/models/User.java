/**
 * 
 */
package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.data.validation.Email;
import play.data.validation.MaxSize;
import play.data.validation.MinSize;
import play.data.validation.Required;
import play.db.jpa.Model;
import controllers.Security;

/**
 * @author frederic
 *
 */
@Entity
public class User extends Model {
	@Required
	@MaxSize(30)
	public String username;
	@Required
	@MinSize(4)
	@MaxSize(25)
	public String password;
	@MaxSize(50)
	public String firstname;
	@MaxSize(50)
	public String lastname;
	@Required
	@Email
	@MaxSize(100)
	public String email;
	@MaxSize(100)
	public String webblog;
	public String image="test";
	public String status="a";
	@Required
	public String role="user";
	@OneToMany
	public List<Post> posts;
	
	public User(	String username,
			String password,
			String firstname,
			String lastname,
			String email,
			String webblog,
			String image,
			String status,
			String role){
		this.username=username;
		this.password=password;
		this.firstname=firstname;
		this.lastname=lastname;
		this.email=email;
		this.webblog=webblog;
		this.image=image;
		this.status=status;
		this.role=role;
	}
	
	public String toString(){
		return this.username+" / "+this.firstname+" "+this.lastname + (this.status=="a" ? "enabled" : "disabled");
	}
	/**
	 * Find Method to implement user connection. 
	 * @param email
	 * @param password
	 * @return
	 */
	public static User connect(String email, String password){
		return User.find("byEmailAndPassword",email,password).first();
	}
}
