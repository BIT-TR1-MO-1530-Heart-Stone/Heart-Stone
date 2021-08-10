package model;

public class User {
	private int id;
	private String username;   
	private String password; 
	private String email;
	private String gender;
	private String country;
	private String first_name;
	private String last_name;
	
	public User() {
	}
 
	public User(String username, String password,String email,String gender,String country,String first_name,String last_name) {
 
		this.username = username;
		this.password = password;
		this.email = email;
		this.gender = gender;
		this.country = country;
		this.first_name = first_name;
		this.last_name  = last_name;
	}
 
	public int getId() {
		return id;
	}
 
	public void setId(int id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
 
	public void setEmail(String email) {
		this.email = email;
	}
 
	public String getUsername() {
		return username;
	}
 
	public void setUsername(String username) {
		this.username = username;
	}
 
	public String getPassword() {
		return password;
	}
 
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFirst_name() {
		return first_name;
	}
 
	public void setFirstname(String first_name) {
		this.first_name = first_name;
	}
	
	public String getLast_name() {
		return last_name;
	}
	
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	
 
}