package main.model;

public class User {
	private int id;
	private String email;
	private String password; 
	private String fullname;
	private String screenname;
	private String phone_number;
	private String info;
	private int gender;
	public User(){
	}
	public User(String email,String password,String fullname,String screenname,String phone_number,String info,int gender){
		this.email=email;
		this.password=password;
		this.fullname=fullname;
		this.screenname=screenname;
		this.phone_number=phone_number;
		this.info=info;
		this.gender=gender;
	}

	public String getEmail() {		return email;	}
	public String getPassword() {		return password;	}
	public void setPassword(String password) {		this.password = password;	}
	public String getFullname() {		return fullname;	}
	public void setFullname(String fullname) {		this.fullname = fullname;	}
	public String getScreenname() {		return screenname;	}
	public void setScreenname(String screenname) {		this.screenname = screenname;	}
	public String getPhone_number() {		return phone_number;	}
	public void setPhone_number(String phone_number) {		this.phone_number = phone_number;	}
	public String getInfo() {		return info;	}
	public void setInfo(String info) {		this.info = info;	}
	public int getGender() {		return gender;	}
	public void setGender(int gender) {		this.gender = gender;	}
	public int getId() {		return id;	}
}