package teckcampusbackend.example.techcampusbackend.Models;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;


@Entity
public class Users  {
	
	protected Users()
	{
		
	}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String username;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private UserPersonalInformation personalInfo;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference
    @JsonIgnore
    private List<UserEducationInfo> educationInfo;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    @JsonManagedReference
    private List<UserSocialLinks> socialLinks;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    @JsonManagedReference
    private List<UserSkills> skills;
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    @JsonManagedReference(value="user-blog")
    private List<Blogs> blogs;
    
    

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public UserPersonalInformation getPersonalInfo() {
		return personalInfo;
	}

	public void setPersonalInfo(UserPersonalInformation personalInfo) {
		this.personalInfo = personalInfo;
	}

	public List<UserEducationInfo> getEducationInfos() {
		return educationInfo;
	}

	public void setEducationInfos(List<UserEducationInfo> educationInfo) {
		this.educationInfo = educationInfo;
	}

	public List<UserSocialLinks> getSocialLinks() {
		return socialLinks;
	}

	public void setSocialLinks(List<UserSocialLinks> socialLinks) {
		this.socialLinks = socialLinks;
	}

	public List<UserSkills> getSkills() {
		return skills;
	}

	public void setSkills(List<UserSkills> skills) {
		this.skills = skills;
	}
	
	
	public List<Blogs> getBlogs() {
		return blogs;
	}
	
	public void setBlogs(List<Blogs> blogs) {
		this.blogs = blogs;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", email=" + email + ", password=" + password + ", username=" + username
				+ ", personalInfo=" + personalInfo + ", educationInfo=" + educationInfo + ", socialLinks=" + socialLinks
				+ ", skills=" + skills + ", blogs=" + blogs + "]";
	}	

}
