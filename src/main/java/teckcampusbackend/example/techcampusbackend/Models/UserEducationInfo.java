package teckcampusbackend.example.techcampusbackend.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class UserEducationInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	 @ManyToOne
	    @JoinColumn(name = "user_id", nullable = false)
	    @JsonBackReference
	    private Users user;

	    private String degree;
	    private String branch;
	    private String collage;
	    private String percent;
	    
		public UserEducationInfo() {
			super();
		}
		
		public Integer getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public Users getUser() {
			return user;
		}
		public void setUser(Users user) {
			this.user = user;
		}
		public String getDegree() {
			return degree;
		}
		public void setDegree(String degree) {
			this.degree = degree;
		}
		public String getBranch() {
			return branch;
		}
		public void setBranch(String branch) {
			this.branch = branch;
		}
		public String getCollage() {
			return collage;
		}
		public void setCollage(String collage) {
			this.collage = collage;
		}
		public String getPercent() {
			return percent;
		}
		public void setPercent(String percent) {
			this.percent = percent;
		}
		
		@Override
		public String toString() {
			return "UserEducationInfo [id=" + id + ", user=" + user + ", degree=" + degree + ", branch=" + branch
					+ ", collage=" + collage + ", percent=" + percent + "]";
		}
	    
	    
	    
}
