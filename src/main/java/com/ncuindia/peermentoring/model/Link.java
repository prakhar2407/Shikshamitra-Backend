package com.ncuindia.peermentoring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Entity Annotation Represents that the class is an Entity
@Entity
//Table Annotation is used to map the entity in the SQL Table
@Table(name="Link")
public class Link {
	//Its is used to specify the primary key of the entity
	@Id
	//it specifies the generation strategies for value of primary keys
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="name", nullable=false)
	private String name;
	@Column(name="link", nullable = false)
	private String link;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Link() {
		super();
	}
	
	public Link(String name, String link) {
		super();
		this.name = name;
		this.link = link;
	}
	
	@Override
	public String toString() {
		return "Link [id=" + id + ", name=" + name + ", link=" + link + "]";
	}
	
	
	

	
}
