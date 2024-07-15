package teckcampusbackend.example.techcampusbackend.Controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import teckcampusbackend.example.techcampusbackend.Service.FileService;
import teckcampusbackend.example.techcampusbackend.payload.FileResponse;

@RestController
@RequestMapping("/file")
public class FileController {
	
	
	@Autowired
	private FileService fileService;
	
	@Value("${project.image}")
	private String path;
	
	@PostMapping("/upload")
	public ResponseEntity<FileResponse> fileUpload(@RequestParam("image") MultipartFile image )
	{
		
		String filename = null;
		try {
			 filename = this.fileService.uploadImage(path, image);
		} catch (Exception e) {
			return  new ResponseEntity<>(new FileResponse(null, "image is not uploaded due to some internal error !"), HttpStatus.OK);
		}
		
		return  new ResponseEntity<>(new FileResponse(filename, "image is successffulyy uploaded!!"), HttpStatus.OK);
	}

}
