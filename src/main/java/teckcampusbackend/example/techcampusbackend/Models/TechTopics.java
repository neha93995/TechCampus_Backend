package teckcampusbackend.example.techcampusbackend.Models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class TechTopics {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;

	 
	 	@Column(nullable = false)
	    private String title;
	 	
	 	@Column(nullable = false)
	 	private String description;

	 	@OneToMany(mappedBy = "techTopic", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    @JsonManagedReference(value = "tech-topic")
	 	@JsonIgnore
	    private List<Blogs> blogs;
	 	
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

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public List<Blogs> getBlogs() {
			return blogs;
		}

		public void setBlogs(List<Blogs> blogs) {
			this.blogs = blogs;
		}

		@Override
		public String toString() {
			return "TechTopics [id=" + id + ", title=" + title + ", description=" + description + ", blogs=" + blogs
					+ "]";
		}

		
	    
	    

}
