package com.example.myapp.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "wineType")
public class WineType {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int wineTypeId;
  private String name;
  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "wine_type_id")
  private List<Wine> wines = new ArrayList<Wine>();

    public List<Wine> getWines() {
        return this.wines;
    }

    public void setWines(List<Wine> wines) {
        this.wines = wines;
    }

    public int getWineTypeId() {
        return this.wineTypeId;
    }

    public void setWineTypeId(int wineTypeId) {
        this.wineTypeId = wineTypeId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
