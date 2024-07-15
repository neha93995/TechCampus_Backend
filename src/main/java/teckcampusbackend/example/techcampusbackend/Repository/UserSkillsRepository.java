package teckcampusbackend.example.techcampusbackend.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import teckcampusbackend.example.techcampusbackend.Models.UserSkills;

public interface UserSkillsRepository extends JpaRepository<UserSkills, Integer> {

	List<UserSkills> findByUserId(Integer userID);

}
