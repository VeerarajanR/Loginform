package entry;

public class User {
	private int id;
	private String name;
	private String email;
	private String mobile;
	private String type;
	private String time;
	
	public User() {
	}
	
	

	



	public User(String name, String email, String mobile, String type, String time) {
		super();
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.type = type;
		this.time = time;
	}



	public User(int id, String name, String email, String mobile, String type, String time) {
//		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.type = type;
		this.time = time;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
}
