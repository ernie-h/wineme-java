package com.example.myapp.models;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "Paragraph")
@DiscriminatorValue("Paragraph")
public class Paragraph extends Widget {

}
