package teckcampusbackend.example.techcampusbackend.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
public class HelloWorldController {
	
	@GetMapping("/")
	public String helloWorld()
	{
		return "Hello World";
	}
	
	@GetMapping("/hello-world-bean")
	public HelloWorldBean helloWorldBean()
	{
		return new HelloWorldBean("Hello world Bean");
	}
	
	@PostMapping("/hello-bean/upload")
	public void uploadData(@RequestParam("avatar") MultipartFile file , @RequestParam String email , @RequestParam String name)
	{
		System.out.println("---------------------------"+file);
		System.out.println("---------------------------"+name);
		System.out.println("---------------------------"+email);
	}
}
