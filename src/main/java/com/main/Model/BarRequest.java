package com.main.Model;

public class BarRequest {
	private Long id;
	private int Q;

	// Constructor, getters y setters

	public BarRequest(int Q, Long id) {
		this.id = id;
		this.Q = Q;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQ() {
		return Q;
	}

	public void setQ(int Q) {
		this.Q = Q;
	}
}