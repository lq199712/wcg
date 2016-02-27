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
 * Bigtype entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "bigtype", catalog = "wcg")
public class Bigtype implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String enname;
	private String image;
	private Integer isshow;
	private Integer islinkonly;
	private String linkurl;
	private Integer orderid;
	private String publicaccount;
	private Integer btype;
	private Set<Sontype> sontypes = new HashSet<Sontype>(0);

	// Constructors

	/** default constructor */
	public Bigtype() {
	}

	/** full constructor */
	public Bigtype(String name, String enname, String image, Integer isshow, Integer islinkonly, String linkurl,Integer orderid,
			String publicaccount,Integer btype, Set<Sontype> sontypes) {
		this.name = name;
		this.enname = enname;
		this.image = image;
		this.isshow = isshow;
		this.islinkonly = islinkonly;
		this.linkurl = linkurl;
		this.orderid = orderid;
		this.publicaccount = publicaccount;
		this.btype = btype;
		this.sontypes = sontypes;
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

	@Column(name = "name", length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "enname", length = 20)
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

	
	@Column(name = "orderid")
	public Integer getOrderid() {
		return orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	@Column(name = "publicaccount", length = 30)
	public String getPublicaccount() {
		return this.publicaccount;
	}

	public void setPublicaccount(String publicaccount) {
		this.publicaccount = publicaccount;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "bigtype")
	public Set<Sontype> getSontypes() {
		return this.sontypes;
	}

	public void setSontypes(Set<Sontype> sontypes) {
		this.sontypes = sontypes;
	}

	@Column(name = "islinkonly")
	public Integer getIslinkonly() {
		return islinkonly;
	}

	public void setIslinkonly(Integer islinkonly) {
		this.islinkonly = islinkonly;
	}

	@Column(name = "linkurl", length = 255)
	public String getLinkurl() {
		return linkurl;
	}

	public void setLinkurl(String linkurl) {
		this.linkurl = linkurl;
	}

	@Column(name = "btype")
	public Integer getBtype() {
		return btype;
	}

	public void setBtype(Integer btype) {
		this.btype = btype;
	}
	
	

}