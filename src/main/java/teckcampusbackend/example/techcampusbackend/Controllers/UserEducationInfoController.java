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

import teckcampusbackend.example.techcampusbackend.Models.UserEducationInfo;
import teckcampusbackend.example.techcampusbackend.Models.Users;
import teckcampusbackend.example.techcampusbackend.Repository.UserEducationInfoRepository;
import teckcampusbackend.example.techcampusbackend.Repository.UserRepository;

@RestController
@RequestMapping("/user/education-info")
public class UserEducationInfoController {
	
	@Autowired
	private UserEducationInfoRepository userEducationRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping
	public List<UserEducationInfo> getAllEducationInfo()
	{
		List<UserEducationInfo> educationInfo = userEducationRepo.findAll();
		return educationInfo;
	}
	
	 @GetMapping("/{user_id}")
	    public ResponseEntity<List<UserEducationInfo>> getUserEducationInfo(@PathVariable("user_id") Integer user_id) {
	        List<UserEducationInfo> userEducationInfoList = userEducationRepo.findByUserId(user_id);

	        if (!userEducationInfoList.isEmpty()) {
	            return ResponseEntity.ok(userEducationInfoList);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	 
	 @PostMapping
	 public UserEducationInfo postUserEducationInfo(@RequestBody UserEducationInfo userEducationInfo)
	 {
//		 System.out.println(socialLink);
         if (userEducationInfo.getUser() == null || userEducationInfo.getUser().getId() == null) {
//         	return ResponseEntity.badRequest().body("User ID is required for each social link");
         	return null;
         }

         Optional<Users> userOptional = userRepo.findById(userEducationInfo.getUser().getId());
         if (userOptional.isEmpty()) {
//         	return ResponseEntity.badRequest().body("User not found for ID: " + socialLink.getUser().getId());
         	return null;
         }

         Users user = userOptional.get();
         userEducationInfo.setUser(user);
		return userEducationRepo.save(userEducationInfo);
	 }
	
	
}
