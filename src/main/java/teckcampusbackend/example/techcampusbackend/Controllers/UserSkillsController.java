package teckcampusbackend.example.techcampusbackend.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import teckcampusbackend.example.techcampusbackend.Models.UserSkills;
import teckcampusbackend.example.techcampusbackend.Models.Users;
import teckcampusbackend.example.techcampusbackend.Repository.UserRepository;
import teckcampusbackend.example.techcampusbackend.Repository.UserSkillsRepository;


@RestController
@RequestMapping("/user/skills")
public class UserSkillsController {

	
	@Autowired
	private UserSkillsRepository userSkillRepo;
	
	@Autowired
	private UserRepository userRepo;
	

	
	@GetMapping
	public List<UserSkills> getAllUsersSkills()
	{
		List<UserSkills> allSkills = userSkillRepo.findAll();
		return allSkills;
	}
	
	@GetMapping("/{id}")
	public List<UserSkills> getUserSkills(@PathVariable Integer id) {  
		 
		return userSkillRepo.findByUserId(id);
	}
	
	@PostMapping
	public List<UserSkills> postUserSkills(@RequestBody List<UserSkills> userSkills)
	{
		
		for(UserSkills userSkill : userSkills)
		{
			if(userSkill.getUser()==null || userSkill.getUser().getId()==null)
			{
				return null;
			}
			
			Optional<Users> userOptional = userRepo.findById(userSkill.getUser().getId());
			
			if(userOptional.isEmpty())
			{
				return null;
			}
			
			Users user = userOptional.get();
			userSkill.setUser(user);
			
			
		}
		
		List<UserSkills> savedUserSkiils =  userSkillRepo.saveAll(userSkills);
		return savedUserSkiils;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUserSkill(@PathVariable Integer id) {
	    // Check if the skill exists
	    if (userSkillRepo.existsById(id)) {
	        userSkillRepo.deleteById(id);
	        return ResponseEntity.ok("User skill deleted successfully.");
	    } else {
	        return ResponseEntity.status(404).body("User skill not found.");
	    }
	}
	
}
