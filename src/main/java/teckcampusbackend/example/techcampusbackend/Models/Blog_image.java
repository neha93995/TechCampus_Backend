package teckcampusbackend.example.techcampusbackend.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Blog_image {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;

	    @Column(nullable = false)
	    private String image;

	    @ManyToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name = "blog_id", nullable = false)
	    @JsonBackReference(value = "blog-image")
	    private Blogs blog;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getImage() {
			return image;
		}

		public void setImage(String image) {
			this.image = image;
		}

		public Blogs getBlog() {
			return blog;
		}

		public void setBlog(Blogs blog) {
			this.blog = blog;
		}

		@Override
		public String toString() {
			return "Blog_image [id=" + id + ", image=" + image + "]";
		}
	    
	    
	
}
