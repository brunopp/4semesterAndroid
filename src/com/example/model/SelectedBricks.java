package com.example.model;

public class SelectedBricks {
	
	//fields
	private int id;
	private int kId;
	private int bId;
	
	// empty constructor
	public SelectedBricks()
	{
	}
	
	//constructor
	public SelectedBricks(int id, int kId, int bId) {
		this.id = id;
		this.kId = kId;
		this.bId = bId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getkId() {
		return kId;
	}

	public void setkId(int kId) {
		this.kId = kId;
	}

	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
	}
	
	
	
}
