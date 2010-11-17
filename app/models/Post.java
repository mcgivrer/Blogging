/**
 * 
 */
package models;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
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

	@ManyToMany(cascade = CascadeType.PERSIST)
	public Set<Tag> tags;

	public Post(String title, Category category, String header, String content,
			User author, Date createdAt) {
		this.content = content;
		this.category = category;
		this.header = header;
		this.title = title;
		this.author = author;
		this.tags = new TreeSet<Tag>();
		if (createdAt == null) {
			this.createdAt = new Date();
		} else {
			this.createdAt = createdAt;
		}
		this.status = "c";
	}

	public void publish() {
		this.status = "p";
	}

	public Post tagItWith(String name) {
	    tags.add(Tag.findOrCreateByName(name));
	    return this;
	}
	
	public static List<Post> findTaggedWith(String tag) {
	    return Post.find(
	        "select distinct p from Post p join p.tags as t where t.name = ?", tag
	    ).fetch();
	}
	
	public String toString() {
		return (this.title + " - " + this.author);
	}

}
