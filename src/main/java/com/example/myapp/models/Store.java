package com.example.myapp.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

// import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "store")
public class Store {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int store_id;
  private String name;
  private String location;
  @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            })
  @JoinTable(name = "stock",
    joinColumns = { @JoinColumn(name = "store_id") },
    inverseJoinColumns = { @JoinColumn(name = "wine_id") })
  private List<Wine> wines = new ArrayList<Wine>();
  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "store_id")
  private List<User> users = new ArrayList<User>();

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
