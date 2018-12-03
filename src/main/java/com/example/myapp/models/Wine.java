package com.example.myapp.models;

import javax.persistence.*;
@Entity(name = "Wine")
@Table(name = "wine")
public class Wine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int wineId;
    
    @Column(nullable = false)
    private String title;
    
    @Column(nullable = false)
    private String variety;
    
    @Column(length = 2000, nullable = false)
    private String description;

    public int getWineId() {
        return this.wineId;
    }

    public void setWineId(int wineId) {
        this.wineId = wineId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getVariety() {
        return this.variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description.toLowerCase();
    }
}