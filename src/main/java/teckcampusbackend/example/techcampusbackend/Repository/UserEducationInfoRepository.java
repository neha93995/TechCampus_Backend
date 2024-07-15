package teckcampusbackend.example.techcampusbackend.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import teckcampusbackend.example.techcampusbackend.Models.UserEducationInfo;

public interface UserEducationInfoRepository extends JpaRepository<UserEducationInfo, Integer> {

	 List<UserEducationInfo> findByUserId(Integer userID);
}
