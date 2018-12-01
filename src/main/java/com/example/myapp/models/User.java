package com.example.myapp.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="user")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int user_id;
  private String username;
  private String password;
  private String email;
  @Enumerated(EnumType.STRING)
  private MyersBriggs personality;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "store_id")
  private Store store;
  @ManyToMany(fetch = FetchType.LAZY,
  cascade = {
      CascadeType.PERSIST,
      CascadeType.MERGE
  })
  @JoinTable(name = "user_reviews",
  joinColumns = { @JoinColumn(name = "user_id") },
  inverseJoinColumns = { @JoinColumn(name = "wine_id") })
  List<Wine> wines = new ArrayList<Wine>();
   /**
   * @return the store
   */
  public Store getStore() {
    return store;
  }

  /**
   * @param store the personality to set
   */
  public void setStore(Store store) {
    this.store = store;
  }

  /**
   * @return the personality
   */
  public MyersBriggs getPersonality() {
    return personality;
  }

  /**
   * @param personality the personality to set
   */
  public void setPersonality(MyersBriggs personality) {
    this.personality = personality;
  }

  public int getUserId() {
    return user_id;
  }

  public void setUserId(int id) {
    this.user_id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
