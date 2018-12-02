package com.example.myapp.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity(name = "Wine")
@Table(name = "wine")
public class Wine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int wineId;
    private String title;
    private String variety;
    @Column(length=2000)
    private String description;
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            },
            mappedBy = "wines")
    List<Store> stores = new ArrayList<Store>();
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            },
            mappedBy = "wines")
    List<User> users = new ArrayList<User>();

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
        this.description = description;
    }

    public List<Store> getStores() {
        return this.stores;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }

    public List<User> getUsers() {
        return this.users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }


}