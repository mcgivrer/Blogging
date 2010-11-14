/**
 * 
 */
package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.data.validation.Required;
import play.db.jpa.Model;

/**
 * @author frederic
 *
 */
@Entity
public class User extends Model {
	@Required
	public String username;
	@Required
	public String password;
	public String firstname;
	public String lastname;
	@Required
	public String email;
	public String blog;
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
			String blog,
			String image,
			String status,
			String role){
		this.username=username;
		this.password=password;
		this.firstname=firstname;
		this.lastname=lastname;
		this.email=email;
		this.blog=blog;
		this.image=image;
		this.status=status;
		this.role=role;
	}
	
	public String toString(){
		return this.username+" / "+this.firstname+" "+this.lastname + (this.status=="a" ? "enabled" : "disabled");
	}
}
