package teckcampusbackend.example.techcampusbackend.Repository;



import org.springframework.data.jpa.repository.JpaRepository;

import teckcampusbackend.example.techcampusbackend.Models.Users;

public interface UserRepository extends JpaRepository<Users, Integer>{
	
	
	 Users findByEmail(String email);
	 
	
}
