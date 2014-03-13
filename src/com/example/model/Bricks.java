package com.example.model;


public class Bricks {

	//fields
	private int id;
	private String name;
	private String colour;
	
	
	
	
	//empty constructor
	public Bricks()
	{
	}
	
	//constructor
	public Bricks(int id, String name, String colour) {
		this.id = id;
		this.name = name;
		this.colour = colour;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}
	
	@Override
	public String toString()
	{
		return this.name;
	}
}