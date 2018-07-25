package com.example.myapp.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "Link")
@DiscriminatorValue("Link")
public class Link extends Widget {
	private String href;
	
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
}
