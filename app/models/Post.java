/**
 * 
 */
package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Lob;

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
	@Lob
	public String header="";
	@Required
	@Lob
	public String content;
	@Required
	public char status;
	@Required
	public User author;
	public Date createdAt;
	
	public Post(String title, String header, String content, User author, Date createdAt){
		this.content=content;
		this.header=header;
		this.title=title;
		this.author=author;
		if(createdAt==null){
		this.createdAt = new Date();
		}else{
			this.createdAt = createdAt;
		}
		this.status='c';
	}
	
	public String toString(){
		return (this.title + " - " + this.author);
	}
	
}