package com.bilgeadam.homework.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bodys")
@ToString(exclude = { "door", "window" })
public class Body {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "body_oid")
	private long oid;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "door_oid", nullable = false)
	private Door door;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "window_oid", nullable = false)
	private Window window;
	
	@Column(name = "body_type", length = 50, nullable = false, unique = true)
	private String type;
	
	@OneToMany(mappedBy = "body")
	private Set<Car> cars;
	
	public void addCar(Car car) {
		if (this.cars == null) {
			this.cars = new HashSet<>();
		}
		this.cars.add(car);
	}

}
