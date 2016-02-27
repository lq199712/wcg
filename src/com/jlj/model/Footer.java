package com.jlj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Footer entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "footer", catalog = "wcg")
public class Footer implements java.io.Serializable {

	// Fields

	private Integer id;
	private String company;
	private String foottitle;
	private Integer isshow;
	private String publicaccount;

	// Constructors

	/** default constructor */
	public Footer() {
	}

	/** full constructor */
	public Footer(String company, String foottitle, Integer isshow,
			String publicaccount) {
		this.company = company;
		this.foottitle = foottitle;
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

	@Column(name = "company", length = 50)
	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Column(name = "foottitle", length = 100)
	public String getFoottitle() {
		return this.foottitle;
	}

	public void setFoottitle(String foottitle) {
		this.foottitle = foottitle;
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