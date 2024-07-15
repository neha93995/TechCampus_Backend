package teckcampusbackend.example.techcampusbackend.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class UserSocialLinks {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	private String plateform;
	private String url;
	
	@ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;
	
	
	
	public UserSocialLinks() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPlateform() {
		return plateform;
	}
	public void setPlateform(String plateform) {
		this.plateform = plateform;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		return "UserSocialLinks [id=" + id + ", plateform=" + plateform + ", url=" + url + ", user=" + user + "]";
	}
	
	
	

}
