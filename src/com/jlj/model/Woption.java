package com.jlj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Fodderarticle entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "woption", catalog = "wcg")
public class Woption implements java.io.Serializable {

	// Fields
	private Integer id;
	private Wvote wvote;
	private String name;
	private String image;
	private Integer number;
	private String msg;

	// Constructors

	public Woption(Integer id, Wvote wvote, String name, String image,
			Integer number, String msg) {
		super();
		this.id = id;
		this.wvote = wvote;
		this.name = name;
		this.image = image;
		this.number = number;
		this.msg = msg;
	}

	/** default constructor */
	public Woption() {
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
	@JoinColumn(name = "wid")
	public Wvote getWvote() {
		return wvote;
	}

	public void setWvote(Wvote wvote) {
		this.wvote = wvote;
	}

	@Column(name = "name", length = 30)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "image", length = 50)
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Column(name = "number")
	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	@Column(name = "msg", length = 1000)
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}


}