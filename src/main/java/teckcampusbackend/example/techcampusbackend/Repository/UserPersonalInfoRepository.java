package teckcampusbackend.example.techcampusbackend.Repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import teckcampusbackend.example.techcampusbackend.Models.UserPersonalInformation;

public interface UserPersonalInfoRepository extends JpaRepository<UserPersonalInformation, Integer>{
	 Optional<UserPersonalInformation> findByUserId(Integer userID);

}
