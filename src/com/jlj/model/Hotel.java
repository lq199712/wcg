package com.jlj.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Hotel entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "hotel", catalog = "wcg")
public class Hotel implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String image;
	private String tel;
	private String hotelintro;
	private String project;
	private String publicaccount;
	private Set<Room> rooms = new HashSet<Room>(0);

	// Constructors

	/** default constructor */
	public Hotel() {
	}

	/** full constructor */
	public Hotel(String name, String image, String tel, String hotelintro,
			String project, String publicaccount, Set<Room> rooms) {
		this.name = name;
		this.image = image;
		this.tel = tel;
		this.hotelintro = hotelintro;
		this.project = project;
		this.publicaccount = publicaccount;
		this.rooms = rooms;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "image", length = 100)
	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Column(name = "tel", length = 30)
	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "hotelintro", length = 65535)
	public String getHotelintro() {
		return this.hotelintro;
	}

	public void setHotelintro(String hotelintro) {
		this.hotelintro = hotelintro;
	}

	@Column(name = "project", length = 65535)
	public String getProject() {
		return this.project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	@Column(name = "publicaccount", length = 30)
	public String getPublicaccount() {
		return this.publicaccount;
	}

	public void setPublicaccount(String publicaccount) {
		this.publicaccount = publicaccount;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "hotel")
	public Set<Room> getRooms() {
		return rooms;
	}

	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}
	
	

}