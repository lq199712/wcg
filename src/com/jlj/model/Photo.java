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
 * Photo entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "photo", catalog = "wcg")
public class Photo implements java.io.Serializable {

	// Fields

	private Integer id;
	private Phototype phototype;
	private String photourl;
	private String photoname;

	// Constructors

	/** default constructor */
	public Photo() {
	}

	/** full constructor */
	public Photo(Phototype phototype, String photourl, String photoname) {
		this.phototype = phototype;
		this.photourl = photourl;
		this.photoname = photoname;
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
	@JoinColumn(name = "ptid")
	public Phototype getPhototype() {
		return this.phototype;
	}

	public void setPhototype(Phototype phototype) {
		this.phototype = phototype;
	}

	@Column(name = "photourl", length = 100)
	public String getPhotourl() {
		return this.photourl;
	}

	public void setPhotourl(String photourl) {
		this.photourl = photourl;
	}

	@Column(name = "photoname", length = 30)
	public String getPhotoname() {
		return this.photoname;
	}

	public void setPhotoname(String photoname) {
		this.photoname = photoname;
	}

}