package es.codeurjc.daw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
@Entity
public class Post {

	interface Basic {
	}

	interface Extended {
	}

	interface Full extends Basic, Extended {
	}

	@JsonView(Basic.class)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@JsonView(Basic.class)
	private String title;

	@JsonView(Extended.class)
	private String content;

	@JsonView(Extended.class)
	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
	private List<Comment> comments = new ArrayList<>();

	public Post() {

	}

	public Post(String title, String content) {
		this.title = title;
		this.content = content;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public List<Comment> getComments() {
		return comments;
	}

	@Override
	public String toString() {
		return this.title + " (" + comments.size() + " comments)";
	}

}
