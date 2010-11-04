/**
 * 
 */
package models;

import javax.persistence.Entity;

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
	public String email;
	public String blog;
	public String avatar;
	public Boolean active;
	@Required
	public String role="user";

	
	public User(	String username,
			String password,
			String firstname,
			String lastname,
			String email,
			String blog,
			String avatar,
			Boolean active,
			String role){
		this.username=username;
		this.password=password;
		this.firstname=firstname;
		this.lastname=lastname;
		this.email=email;
		this.blog=blog;
		this.avatar=avatar;
		this.role=role;
		this.active=new Boolean(true);
	}
	
	public String toString(){
		return this.username+" / "+this.firstname+" "+this.lastname;
	}
}
