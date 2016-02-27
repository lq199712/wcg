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
 * Bigtype entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "complaint", catalog = "wcg")
public class Complaint implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String telphone;
	private Integer comptype;
	private String content;
	private String publicaccount;
	private String comptime;
	private Integer compstate;
	private String image;
	private String ip;
	// Constructors

	/** default constructor */
	public Complaint() {
	}

	/** full constructor */
	public Complaint(String name, String telphone,  Integer comptype, String content,
			String publicaccount,String comptime, String image) {
		this.name = name;
		this.telphone = telphone;
		this.comptype = comptype;
		this.content = content;
		this.publicaccount = publicaccount;
		this.comptime = comptime; 
		this.image = image;
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


	@Column(name = "publicaccount", length = 50)
	public String getPublicaccount() {
		return this.publicaccount;
	}

	public void setPublicaccount(String publicaccount) {
		this.publicaccount = publicaccount;
	}

	@Column(name = "telphone", length = 50)
	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	@Column(name = "comptype", length = 11)
	public Integer getComptype() {
		return comptype;
	}

	public void setComptype(Integer comptype) {
		this.comptype = comptype;
	}

	@Column(name = "content", length = 1000)
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "comptime", length = 30)
	public String getComptime() {
		return comptime;
	}

	public void setComptime(String comptime) {
		this.comptime = comptime;
	}

	@Column(name = "compstate", length = 11)
	public Integer getCompstate() {
		return compstate;
	}

	public void setCompstate(Integer compstate) {
		this.compstate = compstate;
	}

	@Column(name = "image", length = 50)
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Column(name = "ip", length = 30)
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	
	

}