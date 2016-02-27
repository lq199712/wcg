package com.jlj.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
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
 * Fodder entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "fodder", catalog = "wcg")
public class Fodder implements java.io.Serializable {

	// Fields

	private Integer id;
	private String msgtype;
	private Integer savetype;
	private Integer funcflag;
	private String content;
	private String mediaid;
	private String title;
	private String description;
	private String musicurl;
	private String hqmusicurl;
	private String thumbmediaid;
	private Integer articlecount;
	private String picurl;
	private String url;
	private String publicaccount;
	private Date createdate;
	private List<Fodderarticle> fodderarticles = new ArrayList<Fodderarticle>(0);
	private Set<Resmessage> resmessages = new HashSet<Resmessage>(0);

	// Constructors

	/** default constructor */
	public Fodder() {
	}

	/** full constructor */
	public Fodder(String msgtype, Integer savetype, Integer funcflag,
			String content, String mediaid, String title, String description,
			String musicurl, String hqmusicurl, String thumbmediaid,
			Integer articlecount, String picurl, String url,
			String publicaccount, Date createdate, List<Fodderarticle> fodderarticles,
			Set<Resmessage> resmessages) {
		this.msgtype = msgtype;
		this.savetype = savetype;
		this.funcflag = funcflag;
		this.content = content;
		this.mediaid = mediaid;
		this.title = title;
		this.description = description;
		this.musicurl = musicurl;
		this.hqmusicurl = hqmusicurl;
		this.thumbmediaid = thumbmediaid;
		this.articlecount = articlecount;
		this.picurl = picurl;
		this.url = url;
		this.publicaccount = publicaccount;
		this.createdate = createdate;
		this.fodderarticles = fodderarticles;
		this.resmessages = resmessages;
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

	@Column(name = "msgtype", length = 20)
	public String getMsgtype() {
		return this.msgtype;
	}

	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}

	@Column(name = "savetype")
	public Integer getSavetype() {
		return this.savetype;
	}

	public void setSavetype(Integer savetype) {
		this.savetype = savetype;
	}

	@Column(name = "funcflag")
	public Integer getFuncflag() {
		return this.funcflag;
	}

	public void setFuncflag(Integer funcflag) {
		this.funcflag = funcflag;
	}

	@Column(name = "content", length = 65535)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "mediaid", length = 30)
	public String getMediaid() {
		return this.mediaid;
	}

	public void setMediaid(String mediaid) {
		this.mediaid = mediaid;
	}

	@Column(name = "title", length = 50)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "description", length = 65535)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "musicurl", length = 100)
	public String getMusicurl() {
		return this.musicurl;
	}

	public void setMusicurl(String musicurl) {
		this.musicurl = musicurl;
	}

	@Column(name = "hqmusicurl", length = 100)
	public String getHqmusicurl() {
		return this.hqmusicurl;
	}

	public void setHqmusicurl(String hqmusicurl) {
		this.hqmusicurl = hqmusicurl;
	}

	@Column(name = "thumbmediaid", length = 30)
	public String getThumbmediaid() {
		return this.thumbmediaid;
	}

	public void setThumbmediaid(String thumbmediaid) {
		this.thumbmediaid = thumbmediaid;
	}

	@Column(name = "articlecount")
	public Integer getArticlecount() {
		return this.articlecount;
	}

	public void setArticlecount(Integer articlecount) {
		this.articlecount = articlecount;
	}

	@Column(name = "picurl", length = 100)
	public String getPicurl() {
		return this.picurl;
	}

	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}

	@Column(name = "url", length = 100)
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "publicaccount", length = 30)
	public String getPublicaccount() {
		return this.publicaccount;
	}

	public void setPublicaccount(String publicaccount) {
		this.publicaccount = publicaccount;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "createdate", length = 10)
	public Date getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "fodder")
	public List<Fodderarticle> getFodderarticles() {
		return this.fodderarticles;
	}

	public void setFodderarticles(List<Fodderarticle> fodderarticles) {
		this.fodderarticles = fodderarticles;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "fodder")
	public Set<Resmessage> getResmessages() {
		return this.resmessages;
	}

	public void setResmessages(Set<Resmessage> resmessages) {
		this.resmessages = resmessages;
	}

}