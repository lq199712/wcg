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
@Table(name = "sontype", catalog = "wcg")
public class Sontype implements java.io.Serializable {

	// Fields

	private Integer id;
	private Bigtype bigtype;
	private String name;
	private String enname;
	private String image;
	private Integer isshow;
	private Integer producttype;
	private Integer orderid;
	private Set<Pagearticle> pagearticles = new HashSet<Pagearticle>(0);

	// Constructors

	/** default constructor */
	public Sontype() {
	}

	/** full constructor */
	public Sontype(Bigtype bigtype, String name, String enname, String image,
			Integer isshow,Integer producttype,Integer orderid, Set<Pagearticle> pagearticles) {
		this.bigtype = bigtype;
		this.name = name;
		this.enname = enname;
		this.image = image;
		this.isshow = isshow;
		this.producttype = producttype;
		this.orderid = orderid;
		this.pagearticles = pagearticles;
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
	@JoinColumn(name = "btid")
	public Bigtype getBigtype() {
		return this.bigtype;
	}

	public void setBigtype(Bigtype bigtype) {
		this.bigtype = bigtype;
	}

	@Column(name = "name", length = 30)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "enname", length = 30)
	public String getEnname() {
		return this.enname;
	}

	public void setEnname(String enname) {
		this.enname = enname;
	}

	@Column(name = "image", length = 100)
	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Column(name = "isshow")
	public Integer getIsshow() {
		return this.isshow;
	}

	public void setIsshow(Integer isshow) {
		this.isshow = isshow;
	}

	@Column(name = "producttype")
	public Integer getProducttype() {
		return producttype;
	}

	public void setProducttype(Integer producttype) {
		this.producttype = producttype;
	}

	@Column(name = "orderid")
	public Integer getOrderid() {
		return orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sontype")
	public Set<Pagearticle> getPagearticles() {
		return this.pagearticles;
	}

	public void setPagearticles(Set<Pagearticle> pagearticles) {
		this.pagearticles = pagearticles;
	}

}