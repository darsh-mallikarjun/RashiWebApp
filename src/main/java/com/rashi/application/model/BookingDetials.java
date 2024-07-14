package com.rashi.application.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "booking_detials")
public class BookingDetials {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
     private int id;

	private String name;
	
	private String email;
	
	 private double price;
	 private String address;
	 private String plot_area;
	 private String dimensions;
	 private String image;
	 
	public BookingDetials(){
		 
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
	public BookingDetials(double price, String email, String name, String address, String plot_area, String dimensions,
			String image) {
		super();
		this.name = name;
		this.email = email;
		this.price = price;
		this.address = address;
		this.plot_area = plot_area;
		this.dimensions = dimensions;
		this.image = image;
	}
	@Override
	public String toString() {
		return "BookingDetials [id=" + id + ", name=" + name + ", email=" + email + ", price=" + price + ", address="
				+ address + ", plot_area=" + plot_area + ", dimensions=" + dimensions + ", image=" + image + "]";
	}
	 


	
}
