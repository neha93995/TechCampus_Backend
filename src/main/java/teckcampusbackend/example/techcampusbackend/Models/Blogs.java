package teckcampusbackend.example.techcampusbackend.Models;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Blogs {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;

	    @Column(nullable = false)
	    private String title;

	    @Column(nullable = false, length = 10000)
	    private String content;

	    @Column(nullable = false)
	    private Integer likes = 0;

	    @Column(nullable = false)
	    private Integer dislikes = 0;

	    private LocalDate createAt;

	    @ManyToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name = "topic_id", nullable = false)
	    @JsonBackReference(value = "tech-topic")
	    private TechTopics techTopic;

	    @ManyToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name = "user_id", nullable = false)
	    @JsonBackReference(value = "user-blog")
	    private Users user;

	    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	    @JsonIgnore
	    @JsonManagedReference(value = "blog-image")
	    private List<Blog_image> images;



		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public Integer getLikes() {
			return likes;
		}

		public void setLikes(Integer likes) {
			this.likes = likes;
		}

		public Integer getDislikes() {
			return dislikes;
		}

		public void setDislikes(Integer dislikes) {
			this.dislikes = dislikes;
		}

		public LocalDate getCreateAt() {
			return createAt;
		}

		public void setCreateAt(LocalDate createAt) {
			this.createAt = createAt;
		}

		public TechTopics getTechTopic() {
			return techTopic;
		}

		public void setTechTopic(TechTopics techTopic) {
			this.techTopic = techTopic;
		}

		public Users getUser() {
			return user;
		}

		public void setUser(Users user) {
			this.user = user;
		}

		public List<Blog_image> getImages() {
			return images;
		}

		public void setImages(List<Blog_image> images) {
			this.images = images;
		}

		@Override
	    public String toString() {
	        return "Blogs{" +
	                "id=" + id +
	                ", title='" + title + '\'' +
	                ", content='" + content + '\'' +
	                ", likes=" + likes +
	                ", dislikes=" + dislikes +
	                ", createAt=" + createAt +
	                '}';
	    }
}
