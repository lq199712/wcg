package com.jlj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Autores entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "autores", catalog = "wcg")
public class Autores implements java.io.Serializable {

	// Fields

	private Integer id;
	private String content;
	private String publicaccount;

	// Constructors

	/** default constructor */
	public Autores() {
	}

	/** full constructor */
	public Autores(String content, String publicaccount) {
		this.content = content;
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

	@Column(name = "content", length = 65535)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "publicaccount", length = 30)
	public String getPublicaccount() {
		return this.publicaccount;
	}

	public void setPublicaccount(String publicaccount) {
		this.publicaccount = publicaccount;
	}

}