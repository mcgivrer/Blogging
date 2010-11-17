/**
 * 
 */
package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;

import play.data.validation.Email;
import play.data.validation.MaxSize;
import play.data.validation.MinSize;
import play.data.validation.Required;
import play.db.jpa.Model;

/**
 * @author frederic
 *
 */
@Entity
public class User extends Model {
	
	public enum UserRole {
		ADMINISTRATOR,
		MODERATOR,
		USER
	}
	
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
	@Enumerated(EnumType.STRING)
	public UserRole role;
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
			UserRole role){
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
		return this.username+" ("+this.firstname+" "+this.lastname+")";
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
	
	public boolean isAdmin(){
		return this.role.equals(UserRole.ADMINISTRATOR);
	}

	public boolean isModerator(){
		return this.role.equals(UserRole.MODERATOR);
	}

	public boolean isUser(){
		return this.role.equals(UserRole.USER);
	}
}
