package teckcampusbackend.example.techcampusbackend.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import teckcampusbackend.example.techcampusbackend.Models.Blogs;

public interface BlogRepository extends JpaRepository<Blogs, Integer> {

	  List<Blogs> findAllByTechTopicId(Integer topicId);

	
}
