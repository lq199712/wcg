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
 * Phototype entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "phototype", catalog = "wcg")
public class Phototype implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String publicaccount;
	private Set<Photo> photos = new HashSet<Photo>(0);

	// Constructors

	/** default constructor */
	public Phototype() {
	}

	/** full constructor */
	public Phototype(String name, String publicaccount, Set<Photo> photos) {
		this.name = name;
		this.publicaccount = publicaccount;
		this.photos = photos;
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

	@Column(name = "publicaccount", length = 30)
	public String getPublicaccount() {
		return this.publicaccount;
	}

	public void setPublicaccount(String publicaccount) {
		this.publicaccount = publicaccount;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "phototype")
	public Set<Photo> getPhotos() {
		return this.photos;
	}

	public void setPhotos(Set<Photo> photos) {
		this.photos = photos;
	}

}