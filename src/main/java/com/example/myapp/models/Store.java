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

  public int getStoreId() {
    return store_id;
  }

  public void setStoreId(int store_id) {
    this.store_id = store_id;
  }

  /**
   * @return the location
   */
  public String getLocation() {
    return location;
  }

  /**
   * @param location the location to set
   */
  public void setLocation(String location) {
    this.location = location;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
