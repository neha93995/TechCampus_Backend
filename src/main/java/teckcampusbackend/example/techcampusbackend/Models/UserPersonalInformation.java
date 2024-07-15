package teckcampusbackend.example.techcampusbackend.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class UserPersonalInformation {
	
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer id;
	 
	 
	 @OneToOne
	 @JoinColumn(name = "user_id", nullable = false)
	 private Users user;

	 private String fullname;
	 private String location;
	 private String birthDate;
	 private String avatar;
	 private String gender;
	 private String description;
	 
	 
	 
	 
	public UserPersonalInformation() {
		super();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public void setAbout(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "UserPersonalInformation [id=" + id + ", user=" + user + ", fullname=" + fullname + ", location="
				+ location + ", birthDate=" + birthDate + ", avatar=" + avatar + ", gender=" + gender + ", description="
				+ description + "]";
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
