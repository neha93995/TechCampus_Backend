package teckcampusbackend.example.techcampusbackend.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import teckcampusbackend.example.techcampusbackend.Models.TechTopics;
import teckcampusbackend.example.techcampusbackend.Repository.TechTopicsRepository;


@RestController
public class TechTopicController {
	
	@Autowired
	private TechTopicsRepository techTopicRepo;
	
	@GetMapping("/tech-topics")
	public List<TechTopics> getAllTopics()
	{
		List<TechTopics> allTopics  = techTopicRepo.findAll();
		return allTopics;
	}
	
	
	 @GetMapping("tech-topics/search")
	    public List<TechTopics> searchTopics(@RequestParam String query) {
		 System.out.println("=-----------------------------"+query);
	        return techTopicRepo.findByNameContaining(query);
//		 return null;
	 }
	


}
