package teckcampusbackend.example.techcampusbackend.Controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import teckcampusbackend.example.techcampusbackend.Models.Blog_image;
import teckcampusbackend.example.techcampusbackend.Models.Blogs;
import teckcampusbackend.example.techcampusbackend.Models.TechTopics;
import teckcampusbackend.example.techcampusbackend.Models.Users;
import teckcampusbackend.example.techcampusbackend.Repository.BlogImageRepository;
import teckcampusbackend.example.techcampusbackend.Repository.BlogRepository;
import teckcampusbackend.example.techcampusbackend.Repository.TechTopicsRepository;
import teckcampusbackend.example.techcampusbackend.Repository.UserRepository;
import teckcampusbackend.example.techcampusbackend.Utility.CloudinaryService;

@RestController
@RequestMapping("/blogs")
public class BlogController {
	
	@Autowired
	private BlogRepository blogRepo;
	
	@Autowired
	private TechTopicsRepository topicRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private BlogImageRepository blogImageRepo;
	
	private CloudinaryService cloudinaryService = null;

    @Autowired
    public void ImageController(CloudinaryService cloudinaryService) {
        this.cloudinaryService = cloudinaryService;
    }
	
	@GetMapping("/all")
	public List<Blogs> getAllBlogs()
	{
		List<Blogs> allBlogs = blogRepo.findAll();
		return allBlogs;
	}
	
	@GetMapping("/topic/{id}")
	public List<Blogs> getBlogByTopic(@PathVariable("id") Integer topicId)
	{
		List<Blogs> allBlogs = null;
		try {
			System.out.println(topicId);
			 allBlogs = blogRepo.findAllByTechTopicId(topicId);
			System.out.println("--------------------------------"+allBlogs);
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return allBlogs;
	}
	
	
	
	@GetMapping("/{id}")
	public Optional<Blogs> getBlogsByID(@PathVariable("id") Integer id)
	{
		Optional<Blogs> blog = blogRepo.findById(id);
		return blog;
	}
	
	
	@PostMapping("/post")
	public Blogs postBlog(@RequestPart(value = "images" , required = false) List<MultipartFile> images ,
			@RequestParam String title, 
			@RequestParam String content ,
			@RequestParam Integer topicId ,
			@RequestParam Integer userId
			)
	{
		
		if(userId==0)
		{
			return null;
		}
		
		if(topicId==0)
		{
			return null;
		}
		
		Optional<Users> userOptional = userRepo.findById(userId);
		if(userOptional.isEmpty())
		{
			return null;
		}
		Optional<TechTopics> topicOptional = topicRepo.findById(topicId);
		if(topicOptional.isEmpty())
		{
			return null;
		}
		
		Blogs blog = new Blogs();
		
		blog.setUser(userOptional.get());
		blog.setTechTopic(topicOptional.get());
		blog.setCreateAt(LocalDate.now());
		blog.setContent(content);
		blog.setTitle(title);
		Blogs saveBlog = blogRepo.save(blog);
		
		if(saveBlog==null)
		{
			return null;
		}
		
		List<Blog_image> imagesList = new ArrayList<>();
		
		for(MultipartFile image: images)
		{
			if (image != null && !image.isEmpty()) {
				Blog_image blogImage = new Blog_image();
	        	
	        	try {
					String url = cloudinaryService.uploadImage(image);
					blogImage.setBlog(saveBlog);
					blogImage.setImage(url);
					imagesList.add(blogImage);
					System.out.println("-------------  "+blogImage);
					
				
				} catch (IOException e) {
					
					System.out.println(e.getMessage());
				}

	        }
		}
		
		try {
			blogImageRepo.saveAll(imagesList);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}		
		return saveBlog;
	}	

}
