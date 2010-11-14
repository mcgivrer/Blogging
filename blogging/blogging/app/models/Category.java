/**
 * 
 */
package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.data.validation.Required;
import play.db.jpa.Model;

/**
 * @author frederic
 *
 */
@Entity
public class Category extends Model {
	@Required
	public String title;
	public String description;
	@Required
	public Integer pos;
	@Required
	public Date createdAt;
	@Required
	@ManyToOne
	public User author;
	@Required
	public String status;
//	@OneToMany
//	public List<Post> posts;
	
	public Category(String title,
					String description, 
					Integer pos, 
					Date createdAt, 
					User author, 
					String status){
		this.title=title;
		this.description=description;
		this.pos=pos;
		if(createdAt.equals(null)){
			this.createdAt = new Date();
		}else{
			this.createdAt = createdAt;
		}
		this.author = author;
		this.status = status;
	}
	
	public String toString(){
		return this.title + " / " + (this.status.equals("a")?"enabled":"disabled");
	}
}
