package teckcampusbackend.example.techcampusbackend.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import teckcampusbackend.example.techcampusbackend.Models.TechTopics;

public interface TechTopicsRepository  extends JpaRepository<TechTopics, Integer>{
	
	 @Query("SELECT t FROM TechTopics t WHERE t.title LIKE %:searchTerm%")
	 List<TechTopics> findByNameContaining(@Param("searchTerm") String searchTerm);

}
