package teckcampusbackend.example.techcampusbackend.Service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import teckcampusbackend.example.techcampusbackend.Service.FileService;

@Service
public class FileServiceImpl implements FileService{

	@Override
	public String uploadImage(String path, MultipartFile file) {
		
		
		// File name 
		
		String name = file.getOriginalFilename();
		
		// FullPath
		
		String filePath = path+File.separator+name;

		// create folder if not created
		
		File f = new File(path);
		
		if(!f.exists())
		{
			f.mkdir();
		}
		
		
		// file copy
		
		
		try {
			Files.copy(file.getInputStream(), Paths.get(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return name;
	}
	
	

}
