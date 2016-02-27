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
 * Keyres entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "keyres", catalog = "wcg")
public class Keyres implements java.io.Serializable {

	// Fields

	private Integer id;
	private Publickey publickey;
	private String keytitle;
	private Integer fodderid;

	// Constructors

	/** default constructor */
	public Keyres() {
	}

	/** full constructor */
	public Keyres(Publickey publickey, String keytitle, Integer fodderid) {
		this.publickey = publickey;
		this.keytitle = keytitle;
		this.fodderid = fodderid;
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
	@JoinColumn(name = "pkid")
	public Publickey getPublickey() {
		return this.publickey;
	}

	public void setPublickey(Publickey publickey) {
		this.publickey = publickey;
	}

	@Column(name = "keytitle", length = 30)
	public String getKeytitle() {
		return this.keytitle;
	}

	public void setKeytitle(String keytitle) {
		this.keytitle = keytitle;
	}

	@Column(name = "fodderid")
	public Integer getFodderid() {
		return this.fodderid;
	}

	public void setFodderid(Integer fodderid) {
		this.fodderid = fodderid;
	}

}