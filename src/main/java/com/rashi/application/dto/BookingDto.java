package com.rashi.application.dto;

public class BookingDto {

	private  int id;
	private String name;
	private String email;
	private double price;
	 private String address;
	 private String plot_area;
	 private String dimensions;
	 private String image;
	 
	 public BookingDto() {
		 
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPlot_area() {
		return plot_area;
	}

	public void setPlot_area(String plot_area) {
		this.plot_area = plot_area;
	}

	public String getDimensions() {
		return dimensions;
	}

	public void setDimensions(String dimensions) {
		this.dimensions = dimensions;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	 
}
