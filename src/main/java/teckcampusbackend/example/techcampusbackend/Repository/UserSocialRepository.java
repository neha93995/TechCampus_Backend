package teckcampusbackend.example.techcampusbackend.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import teckcampusbackend.example.techcampusbackend.Models.UserSocialLinks;

public interface UserSocialRepository extends JpaRepository<UserSocialLinks, Integer>{

	List<UserSocialLinks> findByUserId(Integer user_id);
}
