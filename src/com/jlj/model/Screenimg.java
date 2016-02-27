package com.jlj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Screenimg entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "screenimg", catalog = "wcg")
public class Screenimg implements java.io.Serializable {

	// Fields

	private Integer id;
	private String title;
	private String linkurl;
	private String imageurl;
	private Integer isshow;
	private String publicaccount;
	private Integer imgtype;//图片类型
	private Integer imgorder;//图片排序
	
	// Constructors

	/** default constructor */
	public Screenimg() {
	}

	/** full constructor */
	public Screenimg(String title, String linkurl, String imageurl,
			Integer isshow, String publicaccount, Integer imgtype, Integer imgorder) {
		this.title = title;
		this.linkurl = linkurl;
		this.imageurl = imageurl;
		this.isshow = isshow;
		this.publicaccount = publicaccount;
		this.imgtype = imgtype;
		this.imgorder = imgorder;
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

	@Column(name = "linkurl", length = 100)
	public String getLinkurl() {
		return this.linkurl;
	}

	public void setLinkurl(String linkurl) {
		this.linkurl = linkurl;
	}

	@Column(name = "imageurl", length = 100)
	public String getImageurl() {
		return this.imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
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

	@Column(name = "imgtype")
	public Integer getImgtype() {
		return imgtype;
	}

	public void setImgtype(Integer imgtype) {
		this.imgtype = imgtype;
	}

	@Column(name = "imgorder")
	public Integer getImgorder() {
		return imgorder;
	}

	public void setImgorder(Integer imgorder) {
		this.imgorder = imgorder;
	}

	
	
}