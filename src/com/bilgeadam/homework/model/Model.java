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
@Table(name = "models")
@ToString(exclude = { "cars"})
public class Model {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "model_oid")
	private long oid;
	
	@Column(name = "model_name", length = 50, nullable = false, unique = true)
	private String modelName;
	
	@OneToMany(mappedBy = "model")
	private Set<Car> cars;

}
