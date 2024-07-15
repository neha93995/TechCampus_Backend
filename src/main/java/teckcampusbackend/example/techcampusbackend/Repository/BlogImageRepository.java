package teckcampusbackend.example.techcampusbackend.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import teckcampusbackend.example.techcampusbackend.Models.Blog_image;

public interface BlogImageRepository  extends JpaRepository<Blog_image, Integer> {

	List<Blog_image> findAllByBlogId(Integer id);
 
}
