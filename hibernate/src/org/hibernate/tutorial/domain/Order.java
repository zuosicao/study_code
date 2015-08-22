package org.hibernate.tutorial.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ords")
public class Order {

	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne
	@JoinColumn(name="curstomId",nullable=false)
	private Curstom curstom;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Curstom getCurstom() {
		return curstom;
	}

	public void setCurstom(Curstom curstom) {
		this.curstom = curstom;
	}
	
}
