//package techcampus.example.techcampus.security;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import techcampus.example.techcampus.Models.Users;
//import techcampus.example.techcampus.Repository.UserRepository;
//
//public class CustomUserDetailsService implements UserDetailsService {
//
//	
//	@Autowired
//	private UserRepository userRepository;
//	
//	@Override
//	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//		Users user = userRepository.findByEmail(email);
//		
//		if(user==null)
//		{
//			throw new  UsernameNotFoundException("User not found");
//		}
//		
//		return new CustomUserDetails(user);
//	}
//
//}
//package teckcampusbackend;


