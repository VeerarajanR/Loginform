package entry;

public class Doctor {
	private int id;
	private String name;
	private String type;
	private String time;
	
	
	
	
	
	public Doctor(String name, String type, String time) {
		super();
		this.name = name;
		this.type = type;
		this.time = time;
	}
	public Doctor(int id, String name, String type, String time) {
		super();
		this.id = id;
		this.name = name;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	

}
