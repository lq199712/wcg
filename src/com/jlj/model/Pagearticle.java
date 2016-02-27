package com.jlj.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Pagearticle entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "pagearticle", catalog = "wcg")
public class Pagearticle implements java.io.Serializable {

	// Fields

	private Integer id;
	private Sontype sontype;
	private String name;
	private String shortname;
	private String image;
	private Integer isshow;
	private Float price;
	private Float discount;
	private String pphone;
	private Calendar createtime;
	private String videourl;
	private String description;
	private String project;
	private Integer articletype;
	private String articlelink;
	private String publicaccount;

	// Constructors

	/** default constructor */
	public Pagearticle() {
	}

	/** full constructor */
	public Pagearticle(Sontype sontype, String name, String shortname,
			String image, Integer isshow, Float price, Float discount,String pphone,
			Calendar createtime,String videourl, String description, String project,Integer articletype,String articlelink,String publicaccount) {
		this.sontype = sontype;
		this.name = name;
		this.shortname = shortname;
		this.image = image;
		this.isshow = isshow;
		this.price = price;
		this.pphone = pphone;
		this.discount = discount;
		this.createtime = createtime;
		this.videourl = videourl;
		this.description = description;
		this.project = project;
		this.articletype = articletype;
		this.articlelink = articlelink;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "stid")
	public Sontype getSontype() {
		return this.sontype;
	}

	public void setSontype(Sontype sontype) {
		this.sontype = sontype;
	}

	@Column(name = "name", length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "shortname", length = 100)
	public String getShortname() {
		return this.shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
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

	@Column(name = "price", precision = 12, scale = 0)
	public Float getPrice() {
		return this.price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	@Column(name = "discount", precision = 12, scale = 0)
	public Float getDiscount() {
		return this.discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createtime", length = 0)
	public Calendar getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Calendar createtime) {
		this.createtime = createtime;
	}

	
	@Column(name = "videourl", length = 255)
	public String getVideourl() {
		return videourl;
	}

	public void setVideourl(String videourl) {
		this.videourl = videourl;
	}

	@Column(name = "description", length = 65535)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "project", length = 65535)
	public String getProject() {
		return this.project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	
	@Column(name = "articletype")
	public Integer getArticletype() {
		return articletype;
	}

	public void setArticletype(Integer articletype) {
		this.articletype = articletype;
	}

	@Column(name = "publicaccount", length = 30)
	public String getPublicaccount() {
		return publicaccount;
	}

	public void setPublicaccount(String publicaccount) {
		this.publicaccount = publicaccount;
	}

	@Column(name = "articlelink", length = 255)
	public String getArticlelink() {
		return articlelink;
	}

	public void setArticlelink(String articlelink) {
		this.articlelink = articlelink;
	}

	@Column(name = "pphone", length = 20)
	public String getPphone() {
		return pphone;
	}

	public void setPphone(String pphone) {
		this.pphone = pphone;
	}
	
	

}