package com.example.myapp.models;

import javax.persistence.*;

// import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "store")
public class Store {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int store_id;
  
  @Column(nullable = false)
  private String name;
  @Column(nullable = false)
  private String location;
	@Column(nullable = false, length = 6)
	private Double longitude;
	@Column(nullable = false, length = 6)
	private Double latitude;
	
	public int getStoreId() { return store_id; }
	public void setStoreId(int store_id) { this.store_id = store_id; }
	
	public String getLocation() { return location; }
	public void setLocation(String location) { this.location = location; }
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public Double getLongitude() { return longitude; }
	public void setLongitude(double longitude) { this.longitude = longitude; }
	
	public Double getLatitude() { return latitude; }
	public void setLatitude(double latitude) { this.latitude = latitude; }
}
