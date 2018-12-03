package com.example.myapp.models;

import javax.persistence.*;


@Entity
@Table(name="user")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int user_id;
  
  @Column(nullable = false)
  private String username;
  
  @Column(nullable = false)
  private String password;
  
  @Column(nullable = false)
  private String email;
  
  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private MyersBriggs personality;
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "store_id", nullable = true)
  private Store store;
  
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
