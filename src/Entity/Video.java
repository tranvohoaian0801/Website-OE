package Entity;

import java.io.Serializable;

import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name="Video")
@NamedQuery(name="Video.findAll", query="SELECT o FROM Video o")
public class Video implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	private String id;

	@Column(name="Active")
	private boolean active;

	@Column(name="Description")
	private String description;

	@Column(name="Poster")
	private String poster;

	@Column(name="Titile")
	private String title;

	@Column(name="Views")
	private int views;
	
	@Column(name="link")
	private String link;

	public Video() {
	}

	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public boolean isActive() {
		return active;
	}



	public void setActive(boolean active) {
		this.active = active;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getPoster() {
		return poster;
	}



	public void setPoster(String poster) {
		this.poster = poster;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public int getViews() {
		return views;
	}



	public void setViews(int views) {
		this.views = views;
	}



	public String getLink() {
		return link;
	}



	public void setLink(String link) {
		this.link = link;
	}

	public Video(String id, boolean active, String description, String poster, String title, int views,
			String link) {
		super();
		this.id = id;
		this.active = active;
		this.description = description;
		this.poster = poster;
		this.title = title;
		this.views = views;
		this.link = link;
	}



	
	}

