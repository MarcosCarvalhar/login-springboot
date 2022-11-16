package com.loginspringboot.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users_table", schema = "public")

public class UsersModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	String login;
	
	String password;
	
	String email;
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id, login, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsersModel other = (UsersModel) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id) && Objects.equals(login, other.login)
				&& Objects.equals(password, other.password);
	}

	@Override
	public String toString() {
		return "UsersModel [id=" + id + ", login=" + login + ", email=" + email + "]";
	}
	
	
	
}
