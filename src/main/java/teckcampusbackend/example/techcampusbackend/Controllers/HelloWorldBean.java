package teckcampusbackend.example.techcampusbackend.Controllers;

public class HelloWorldBean {

	private String message;
	
	HelloWorldBean(String message)
	{
		this.message= message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + "]";
	}
	
	
}
