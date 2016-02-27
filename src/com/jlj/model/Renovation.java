package com.jlj.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Renovation entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "renovation", catalog = "wcg")
public class Renovation implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Integer renotype;
	private String reporttime;
	private String address;
	private String content;
	private Integer renostate;
	private String image1;
	private String image2;
	// Constructors

	/** default constructor */
	public Renovation() {
	}
	
	

	public Renovation(Integer id, String name, Integer renotype, String reporttime,
			String address, String content, Integer renostate, String image1,
			String image2) {
		this.id = id;
		this.name = name;
		this.renotype = renotype;
		this.reporttime = reporttime;
		this.address = address;
		this.content = content;
		this.renostate = renostate;
		this.image1 = image1;
		this.image2 = image2;
	}


	@Column(name = "address", length = 100)
	public String getAddress() {
		return address;
	}

	@Column(name = "content", length = 1000)
	public String getContent() {
		return content;
	}

	/** full constructor */
	

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	@Column(name = "image1", length = 50)
	public String getImage1() {
		return image1;
	}


	@Column(name = "image2", length = 50)
	public String getImage2() {
		return image2;
	}

	@Column(name = "name", length = 20)
	public String getName() {
		return this.name;
	}

	@Column(name = "renostate", length = 11)
	public Integer getRenostate() {
		return renostate;
	}

	@Column(name = "reporttime", length = 50)
	public String getReporttime() {
		return reporttime;
	}

	@Column(name = "renotype", length = 11)
	public Integer getRenotype() {
		return renotype;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRenostate(Integer renostate) {
		this.renostate = renostate;
	}

	public void setReporttime(String reporttime) {
		this.reporttime = reporttime;
	}

	public void setRenotype(Integer renotype) {
		this.renotype = renotype;
	}
	
	


	
	

}