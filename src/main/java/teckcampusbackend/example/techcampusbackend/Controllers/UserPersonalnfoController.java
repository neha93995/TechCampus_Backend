package teckcampusbackend.example.techcampusbackend.Controllers;


import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import teckcampusbackend.example.techcampusbackend.Models.UserPersonalInformation;
import teckcampusbackend.example.techcampusbackend.Models.Users;
import teckcampusbackend.example.techcampusbackend.Repository.UserPersonalInfoRepository;
import teckcampusbackend.example.techcampusbackend.Repository.UserRepository;
import teckcampusbackend.example.techcampusbackend.Utility.CloudinaryService;



@RestController
@RequestMapping("/user/personal-info")
public class UserPersonalnfoController {
	
	@Value("${project.image}")
	private String path;
	
	@Autowired
	private UserPersonalInfoRepository userPersonalRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	 private CloudinaryService cloudinaryService = null;

	    @Autowired
	    public void ImageController(CloudinaryService cloudinaryService) {
	        this.cloudinaryService = cloudinaryService;
	    }
	
	@GetMapping("/all")
	public List<UserPersonalInformation> getAllPersonalInfo()
	{
		return userPersonalRepo.findAll();
	}
	
	
	@GetMapping("/{user_id}")
	public Optional<UserPersonalInformation> getUserPersonalInfo(@PathVariable("user_id") Integer user_id) {

	    Optional<UserPersonalInformation> personalInfo = userPersonalRepo.findByUserId(user_id);
	    if (personalInfo.isPresent()) {
	        return personalInfo;
	    } else {
	        return Optional.empty();
	    }
	}
	
	@PostMapping
	public UserPersonalInformation createUserPersonalInfo(@RequestPart(value = "avatar", required = false) MultipartFile avatar, 
			@RequestParam Integer id, 
			@RequestParam String fullname, 
			@RequestParam String gender ,
			@RequestParam String description,
			@RequestParam String birthDate,
			@RequestParam String location,
			@RequestParam Integer userId)
		
	{
		// Handle the personal info
        UserPersonalInformation userPersonalInfo = new UserPersonalInformation();
        userPersonalInfo.setFullname(fullname);
        userPersonalInfo.setLocation(location);
        userPersonalInfo.setBirthDate(birthDate);
        userPersonalInfo.setGender(gender);
        userPersonalInfo.setDescription(description);
        if(id!=0 && id!=null)
        {
        	userPersonalInfo.setId(id);
        }
        
        
        if(userId==0 || userId==null )
        {
        	return null;
        }
        Optional<Users> userOptional = userRepo.findById(userId);
        if(userOptional.isEmpty())
        {
        	return null;
        }
        userPersonalInfo.setUser(userOptional.get());
        
        
        // Handle the avatar file if it exists
        if (avatar != null && !avatar.isEmpty()) {
        	
        	try {
				String url = cloudinaryService.uploadImage(avatar);
				userPersonalInfo.setAvatar(url);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//            String avatarPath = saveAvatarFile(avatar); // Implement this method to save the file and return its path
//            userPersonalInfo.setAvatar(avatarPath);
        }
        
        
        // Save the personal info
        UserPersonalInformation savedInfo = userPersonalRepo.save(userPersonalInfo);
        return savedInfo;
        
	}

	

}
