package model;

import java.util.List;

public class Member {
	private Long id;
	private String username;
	private String password;
	private String email;
	private boolean gender;
	private String address;
	private String tel;
	private List<Role> roles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Member(Long id, String username, String password, String email, boolean gender, String address, String tel) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.gender = gender;
		this.address = address;
		this.tel = tel;
	}

	public Member() {
	}

	public Member(Long id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}

}
