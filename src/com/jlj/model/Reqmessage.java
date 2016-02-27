package com.jlj.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Reqmessage entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "reqmessage", catalog = "wcg")
public class Reqmessage implements java.io.Serializable {

	// Fields

	private Integer id;
	private String tousername;
	private String fromusername;
	private String createtime;
	private String msgtype;
	private String msgid;
	private Integer savetype;
	private String content;
	private String picurl;
	private String mediaid;
	private String format;
	private String thumbmediaid;
	private String locationX;
	private String locationY;
	private String scale;
	private String linklabel;
	private String title;
	private String description;
	private String url;
	private Date reqtime;

	// Constructors

	/** default constructor */
	public Reqmessage() {
	}

	/** full constructor */
	public Reqmessage(String tousername, String fromusername,
			String createtime, String msgtype, String msgid,
			Integer savetype, String content, String picurl, String mediaid,
			String format, String thumbmediaid, String locationX,
			String locationY, String scale, String linklabel, String title,
			String description, String url, Date reqtime) {
		this.tousername = tousername;
		this.fromusername = fromusername;
		this.createtime = createtime;
		this.msgtype = msgtype;
		this.msgid = msgid;
		this.savetype = savetype;
		this.content = content;
		this.picurl = picurl;
		this.mediaid = mediaid;
		this.format = format;
		this.thumbmediaid = thumbmediaid;
		this.locationX = locationX;
		this.locationY = locationY;
		this.scale = scale;
		this.linklabel = linklabel;
		this.title = title;
		this.description = description;
		this.url = url;
		this.reqtime = reqtime;
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

	@Column(name = "tousername", length = 30)
	public String getTousername() {
		return this.tousername;
	}

	public void setTousername(String tousername) {
		this.tousername = tousername;
	}

	@Column(name = "fromusername", length = 50)
	public String getFromusername() {
		return this.fromusername;
	}

	public void setFromusername(String fromusername) {
		this.fromusername = fromusername;
	}

	@Column(name = "createtime", length = 20)
	public String getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	@Column(name = "msgtype", length = 20)
	public String getMsgtype() {
		return this.msgtype;
	}

	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}

	@Column(name = "msgid", length = 20)
	public String getMsgid() {
		return this.msgid;
	}

	public void setMsgid(String msgid) {
		this.msgid = msgid;
	}

	@Column(name = "savetype")
	public Integer getSavetype() {
		return this.savetype;
	}

	public void setSavetype(Integer savetype) {
		this.savetype = savetype;
	}

	@Column(name = "content", length = 65535)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "picurl", length = 100)
	public String getPicurl() {
		return this.picurl;
	}

	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}

	@Column(name = "mediaid", length = 30)
	public String getMediaid() {
		return this.mediaid;
	}

	public void setMediaid(String mediaid) {
		this.mediaid = mediaid;
	}

	@Column(name = "format", length = 30)
	public String getFormat() {
		return this.format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	@Column(name = "thumbmediaid", length = 30)
	public String getThumbmediaid() {
		return this.thumbmediaid;
	}

	public void setThumbmediaid(String thumbmediaid) {
		this.thumbmediaid = thumbmediaid;
	}

	@Column(name = "location_x", length = 30)
	public String getLocationX() {
		return this.locationX;
	}

	public void setLocationX(String locationX) {
		this.locationX = locationX;
	}

	@Column(name = "location_y", length = 30)
	public String getLocationY() {
		return this.locationY;
	}

	public void setLocationY(String locationY) {
		this.locationY = locationY;
	}

	@Column(name = "scale", length = 30)
	public String getScale() {
		return this.scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	@Column(name = "linklabel", length = 100)
	public String getLinklabel() {
		return this.linklabel;
	}

	public void setLinklabel(String linklabel) {
		this.linklabel = linklabel;
	}

	@Column(name = "title", length = 50)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "description", length = 100)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "url", length = 100)
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "reqtime", length = 19)
	public Date getReqtime() {
		return this.reqtime;
	}

	public void setReqtime(Date reqtime) {
		this.reqtime = reqtime;
	}

}