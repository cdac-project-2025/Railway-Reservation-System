package com.railway.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "customers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class Customer extends BaseEntity {
	@Column(length = 50)
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "email", referencedColumnName = "email")
	private User email;
	
	@Column(length = 50, nullable = false)
	private String query;
	
	@Column(length = 50)
	private String suggestion;
}