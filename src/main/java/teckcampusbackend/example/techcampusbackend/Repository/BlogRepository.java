package teckcampusbackend.example.techcampusbackend.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import teckcampusbackend.example.techcampusbackend.Models.Blogs;

public interface BlogRepository extends JpaRepository<Blogs, Integer> {

	@Query("SELECT b FROM Blogs b LEFT JOIN FETCH b.images img WHERE b.techTopic.id = :topicId ORDER BY b.id DESC")
	  List<Blogs> findAllByTechTopicId(Integer topicId);

	@Query("SELECT b FROM Blogs b LEFT JOIN FETCH b.images img ORDER BY b.id DESC ")
	 List<Blogs> findAll();
}
