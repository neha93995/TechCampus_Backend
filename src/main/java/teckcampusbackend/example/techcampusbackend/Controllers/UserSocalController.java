package teckcampusbackend.example.techcampusbackend.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import teckcampusbackend.example.techcampusbackend.Models.UserSocialLinks;
import teckcampusbackend.example.techcampusbackend.Models.Users;
import teckcampusbackend.example.techcampusbackend.Repository.UserRepository;
import teckcampusbackend.example.techcampusbackend.Repository.UserSocialRepository;


@RestController
@RequestMapping("/user/social-links")
public class UserSocalController {
	
	@Autowired
	private UserSocialRepository  userSocialRepo;
	
	@Autowired
	private UserRepository usersRepo;
		
	@GetMapping("/all")
	public List<UserSocialLinks> getAllSocialLinks()
	{
		List<UserSocialLinks> allUserSocialLinks =  userSocialRepo.findAll();
		return allUserSocialLinks;
		
	}
	
	@GetMapping("/{user_id}")
	public List<UserSocialLinks> getUserSocialLinks(@PathVariable("user_id") Integer user_id )
	{
		List<UserSocialLinks> userSocialLinks = userSocialRepo.findByUserId(user_id);
		return userSocialLinks;
	}
	
	@PostMapping
	public ResponseEntity<List<UserSocialLinks>> postAllSocialLinks(@RequestBody List<UserSocialLinks> socialLinks)
	{
		System.out.println(socialLinks);
		for (UserSocialLinks socialLink : socialLinks) {
			System.out.println(socialLink);
            if (socialLink.getUser() == null || socialLink.getUser().getId() == null) {
//            	return ResponseEntity.badRequest().body("User ID is required for each social link");
            	return null;
            }

            Optional<Users> userOptional = usersRepo.findById(socialLink.getUser().getId());
            if (userOptional.isEmpty()) {
//            	return ResponseEntity.badRequest().body("User not found for ID: " + socialLink.getUser().getId());
            	return null;
            }

            Users user = userOptional.get();
            socialLink.setUser(user);
        }

        List<UserSocialLinks> savedSocialLinks = userSocialRepo.saveAll(socialLinks);
         return ResponseEntity.ok(savedSocialLinks);
	}

}
