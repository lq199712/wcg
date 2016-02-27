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
 * Footer entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wvote", catalog = "wcg")
public class Wvote implements java.io.Serializable {

	// Fields
	private Integer id;
	private String name;
	private String keywordname;
	private String starttime;
	private String endtime;
	private String image;
	private Integer number;
	private String content;
	private Set<Woption> woptions = new HashSet<Woption>(0);
	private String wvoteip;
	private String wvotetel;
	// Constructors


	public Wvote(Integer id, String name, String keywordname, String starttime,
			String endtime, String image, Integer number, String content,
			Set<Woption> woptions) {
		this.id = id;
		this.name = name;
		this.keywordname = keywordname;
		this.starttime = starttime;
		this.endtime = endtime;
		this.image = image;
		this.number = number;
		this.content = content;
		this.woptions = woptions;
	}


	/** default constructor */
	public Wvote() {
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
	
	
	@Column(name = "name", length = 30)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "keywordname", length = 30)
	public String getKeywordname() {
		return keywordname;
	}

	public void setKeywordname(String keywordname) {
		this.keywordname = keywordname;
	}

	@Column(name = "starttime", length = 30)
	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	@Column(name = "endtime", length = 30)
	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	@Column(name = "image", length = 50)
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Column(name = "number")
	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	@Column(name = "content", length = 1000)
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "wvote")
	public Set<Woption> getWoptions() {
		return woptions;
	}

	public void setWoptions(Set<Woption> woptions) {
		this.woptions = woptions;
	}

	@Column(name = "wvoteip", length = 1000)
	public String getWvoteip() {
		return wvoteip;
	}


	public void setWvoteip(String wvoteip) {
		this.wvoteip = wvoteip;
	}

	@Column(name = "wvotetel", length = 1000)
	public String getWvotetel() {
		return wvotetel;
	}


	public void setWvotetel(String wvotetel) {
		this.wvotetel = wvotetel;
	}

	

}