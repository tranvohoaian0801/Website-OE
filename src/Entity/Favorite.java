package Entity;

import java.io.Serializable;
import java.security.Timestamp;

import javax.persistence.*;

@Entity
@NamedQuery(name="Favorite.findAll", query="SELECT f FROM Favorite f")
@Table(name="Favorite")
public class Favorite implements Serializable {
	
	
		private static final long serialVersionUID = 1L;
	
		@Id
		@Column(name="ID")
		private String id;
	
		@Column(name="LideDate")
		private String likeDate;
		
		@Column(name="isLike")
		private boolean isLike;
	
		//bi-directional many-to-one association to User
		@ManyToOne
		@JoinColumn(name="UserID")
		private User user;
	
		//bi-directional many-to-one association to Video
		@ManyToOne
		@JoinColumn(name="VideoID")
			private Video video;
	
			public Favorite() {
			}

			public String getId() {
				return id;
			}

			public void setId(String id) {
				this.id = id;
			}

			public String getLikeDate() {
				return likeDate;
			}

			public void setLikeDate(String likeDate) {
				this.likeDate = likeDate;
			}

			public User getUser() {
				return user;
			}

			public void setUser(User user) {
				this.user = user;
			}

			public Video getVideo() {
				return video;
			}

			public void setVideo(Video video) {
				this.video = video;
			}

			
			public boolean getIsLike() {
				return isLike;
			}

			public void setIsLike(boolean isLike) {
				this.isLike = isLike;
			}

			public Favorite(String id, String likeDate, boolean isLike, User user, Video video) {
				super();
				this.id = id;
				this.likeDate = likeDate;
				this.isLike = isLike;
				this.user = user;
				this.video = video;
			}

			
		
	
		
	}


