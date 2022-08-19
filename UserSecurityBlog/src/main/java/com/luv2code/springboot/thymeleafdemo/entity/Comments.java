package com.luv2code.springboot.thymeleafdemo.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "comment")
public class Comments {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "comment_id")
	private int comment_id; // commentId
	private String username;
	private String body;
	private String email;
	@ManyToMany(mappedBy = "userRoles")
	private Set<User> users;
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "user_id", nullable = false) private User user;
	 */
	/*
	 * private int user_id;
	 * 
	 * public int getUser_id() { return user_id; }
	 * 
	 * public void setUser_id(int user_id) { this.user_id = user_id; }
	 */

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Comments() {

	}

	public int getComment_id() {
		return comment_id;
	}

	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Comments [comment_id=" + comment_id + ", username=" + username + ", body=" + body + ", email=" + email
				+ "]";
	}

}