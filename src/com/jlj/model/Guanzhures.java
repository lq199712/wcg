package com.jlj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Guanzhures entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "guanzhures", catalog = "wcg")
public class Guanzhures implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer fodderid;
	private Integer isshow;
	private String publicaccount;

	// Constructors

	/** default constructor */
	public Guanzhures() {
	}

	/** full constructor */
	public Guanzhures(Integer fodderid, Integer isshow, String publicaccount) {
		this.fodderid = fodderid;
		this.isshow = isshow;
		this.publicaccount = publicaccount;
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

	@Column(name = "fodderid")
	public Integer getFodderid() {
		return this.fodderid;
	}

	public void setFodderid(Integer fodderid) {
		this.fodderid = fodderid;
	}

	@Column(name = "isshow")
	public Integer getIsshow() {
		return this.isshow;
	}

	public void setIsshow(Integer isshow) {
		this.isshow = isshow;
	}

	@Column(name = "publicaccount", length = 30)
	public String getPublicaccount() {
		return this.publicaccount;
	}

	public void setPublicaccount(String publicaccount) {
		this.publicaccount = publicaccount;
	}

}