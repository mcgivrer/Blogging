/**
 * 
 */
package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import play.data.validation.Required;
import play.db.jpa.Model;

/**
 * @author frederic
 *
 */
@Entity
public class Post extends Model {
	@Required
	public String title;
	@Required
	@ManyToOne
	public Category category;
	@Lob
	public String header;
	@Required
	@Lob
	public String content;
	@Required
	@ManyToOne
	public User author;
	public Date createdAt;
	@Required
	public String status;
	
	public Post(String title, Category category, String header, String content, User author, Date createdAt){
		this.content=content;
		this.category = category;
		this.header=header;
		this.title=title;
		this.author=author;
		if(createdAt==null){
			this.createdAt = new Date();
		}else{
			this.createdAt = createdAt;
		}
		this.status="c";
	}
	
	
	public void publish(){
		this.status = "p";
	}
	
	public String toString(){
		return (this.title + " - " + this.author);
	}
	
}