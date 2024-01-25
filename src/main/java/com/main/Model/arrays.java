package com.main.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class arrays {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String input_array;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInput_array() {
		return input_array;
	}

	public void setInput_array(String input_array) {
		this.input_array = input_array;
	}

}
