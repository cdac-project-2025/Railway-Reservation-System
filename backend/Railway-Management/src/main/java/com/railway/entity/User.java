package com.railway.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true, exclude = "password")
public class User extends BaseEntity{
	@Column(length = 50, nullable = false)
	private String name;
	
	@Column(length = 50, unique = true, nullable = false)
	private String userName;
	
	@Column(length = 50, nullable = false)
	private String password;
	
	@Column(length = 50, unique = true, nullable = false)
	private String email;
	
	@Column(length = 10, nullable = false)
	private String phoneNo;
}