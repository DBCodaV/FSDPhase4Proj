package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Visit {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long visit_id;
	private float cost;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id")
	private Pet pet;

	private String date;

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public long getVisit_id() {
		return visit_id;
	}

	public void setVisit_id(long visit_id) {
		this.visit_id = visit_id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

}
