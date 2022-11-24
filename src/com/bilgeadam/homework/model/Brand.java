package com.bilgeadam.homework.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "brands")
@ToString
public class Brand {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "brand_oid")
	private long oid;
	
	@Column(name = "brand_name", length = 50, nullable = false, unique = true)
	private String brandName;
	
	@OneToMany(mappedBy = "brand")
	private Set<Car> cars;
	
	public void addCar(Car car) {
		if (this.cars == null) {
			this.cars = new HashSet<>();
		}
		this.cars.add(car);
	}

}
