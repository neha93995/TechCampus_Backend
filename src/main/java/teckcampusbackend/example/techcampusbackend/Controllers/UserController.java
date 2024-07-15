package teckcampusbackend.example.techcampusbackend.Controllers;


import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import teckcampusbackend.example.techcampusbackend.Models.Users;
import teckcampusbackend.example.techcampusbackend.Repository.UserRepository;


@RestController
public class UserController {
	
	private UserRepository repository;
	
	public UserController(UserRepository repository)
	{
		this.repository = repository;
	}
	
	@GetMapping("/users")
	public List<Users> helloUser()
	{
		List<Users> users = repository.findAll();
		return users;
	}
	

//	@GetMapping("/users")
//	public List<Users> getUsers()
//	{
//		List<Users> users = repository.findAll();
//		Optional<Users> user = repository.findById(1);
//		System.out.println("----------------------------------"+users);
//		return users;
//	}
	
	@PostMapping("/signup")
	public Users  createUser(@RequestBody Users user)
	{
		Users findUser = repository.findByEmail(user.getEmail());
		if(findUser==null)
		{
			Users createdUser = repository.save(user);
			
			return createdUser;
			
		}
		return null;
	}
	
	@PostMapping("/login")
	public Users loginUser(@RequestBody  LoginRequest loginRequest )
	{
		 String email = loginRequest.getEmail();
	        String password = loginRequest.getPassword();
	        Users findUser = repository.findByEmail(email);
	        if (findUser.getPassword().equals(password)) {
                return findUser;
            } else {
//                 ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
                 return null;
            }
	}
	
	

	
	
	
}

class LoginRequest {
    private String email;
    private String password;
    
    LoginRequest(){}
    
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
	@Override
	public String toString() {
		return "LoginRequest [email=" + email + ", password=" + password + "]";
	}

    
}
