package com.jlj.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Sontype entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "room", catalog = "wcg")
public class Room implements java.io.Serializable {

	// Fields

	private Integer id;
	private Hotel hotel;
	private String name;
	private String intro;
	private String image;
	private Integer price;
	private Integer discount;
	private String detail;

	// Constructors

	/** default constructor */
	public Room() {
	}

	/** full constructor */
	public Room(Hotel hotel, String name, String intro, String image,
			Integer price,Integer discount,String detail) {
		this.hotel = hotel;
		this.name = name;
		this.intro = intro;
		this.image = image;
		this.price = price;
		this.discount = discount;
		this.detail = detail;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hid")
	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	@Column(name = "name", length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "intro", length = 50)
	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	@Column(name = "image", length = 100)
	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Column(name = "price")
	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Column(name = "discount")
	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	@Column(name = "detail", length = 65535)
	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}



	

	

}