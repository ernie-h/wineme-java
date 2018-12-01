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
    private String name;
    private String flavorProfile;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wine_type_id")
    private WineType wineType;
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

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlavorProfile() {
        return this.flavorProfile;
    }

    public void setFlavorProfile(String flavorProfile) {
        this.flavorProfile = flavorProfile;
    }

    public WineType getWineType() {
        return this.wineType;
    }

    public void setWineType(WineType wineType) {
        this.wineType = wineType;
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