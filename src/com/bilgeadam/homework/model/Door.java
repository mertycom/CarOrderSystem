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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "doors")
@ToString(exclude = { "body"})
public class Door {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "door_oid")
	private long oid;
	
	@Column(name = "door_piece", unique = true)
	private int piece;
	
	@OneToMany(mappedBy = "door")
	private Set<Body> body;
	
	public void addBody(Body body) {
		if (this.body == null) {
			this.body = new HashSet<>();
		}
		this.body.add(body);
	}

}
