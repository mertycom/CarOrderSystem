package com.bilgeadam.homework.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "windows")
@ToString
public class Window {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "window_oid")
	private long oid;
	
	@Column(name = "window_number", nullable = false,unique = true)
	private int number;

	@OneToMany(mappedBy = "window")
	private Set<Body> bodys;
	
}
