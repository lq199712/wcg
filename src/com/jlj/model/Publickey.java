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
 * Publickey entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "publickey", catalog = "wcg")
public class Publickey implements java.io.Serializable {

	// Fields

	private Integer id;
	private String title;
	private String publicaccount;
	private Set<Keyres> keyreses = new HashSet<Keyres>(0);

	// Constructors

	/** default constructor */
	public Publickey() {
	}

	/** full constructor */
	public Publickey(String title, String publicaccount, Set<Keyres> keyreses) {
		this.title = title;
		this.publicaccount = publicaccount;
		this.keyreses = keyreses;
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

	@Column(name = "title", length = 50)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "publicaccount", length = 30)
	public String getPublicaccount() {
		return this.publicaccount;
	}

	public void setPublicaccount(String publicaccount) {
		this.publicaccount = publicaccount;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "publickey")
	public Set<Keyres> getKeyreses() {
		return this.keyreses;
	}

	public void setKeyreses(Set<Keyres> keyreses) {
		this.keyreses = keyreses;
	}

}