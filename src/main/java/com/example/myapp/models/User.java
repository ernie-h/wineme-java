package com.example.myapp.models;
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
  // @ManyToOne
  // @JsonIgnore
  // private Store store;
  

  // public void set(User newUser) {
  //   this.username = newUser.username != null ? newUser.username : this.username;
  //   this.password = newUser.password != null ? newUser.password : this.password;
  //   this.email = newUser.email != null ? newUser.email : this.email;
  // }
   /**
   * @return the store
   */
  // public Store getStore() {
  //   return store;
  // }

  // /**
  //  * @param store the personality to set
  //  */
  // public void setStore(Store store) {
  //   this.store = store;
  //}

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
