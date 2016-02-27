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
 * Message entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "message", catalog = "wcg")
public class Message implements java.io.Serializable {

	// Fields
	private Integer id;
	private String name;
	private String messagetime;
	private String messagecontent;
	private Integer messagestate;
	private String publicaccount;
	private String messageip;
	private String replyname;
	private String replytime;
	private String replycontent;
	private Integer  isshow;
	// Constructors

	public Message(Integer id, String name, String messagetime,
			String messagecontent, Integer messagestate, String publicaccount,
			String messageip, String replyname, String replytime,
			String replycontent,Integer isshow) {
		super();
		this.id = id;
		this.name = name;
		this.messagetime = messagetime;
		this.messagecontent = messagecontent;
		this.messagestate = messagestate;
		this.publicaccount = publicaccount;
		this.messageip = messageip;
		this.replyname = replyname;
		this.replytime = replytime;
		this.replycontent = replycontent;
	}

	/** default constructor */
	public Message() {
	}

	/** full constructor */

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

	@Column(name = "messagetime", length = 30)
	public String getMessagetime() {
		return messagetime;
	}

	public void setMessagetime(String messagetime) {
		this.messagetime = messagetime;
	}

	@Column(name = "messagecontent", length = 1000)
	public String getMessagecontent() {
		return messagecontent;
	}

	public void setMessagecontent(String messagecontent) {
		this.messagecontent = messagecontent;
	}

	@Column(name = "messagestate", length = 11)
	public Integer getMessagestate() {
		return messagestate;
	}

	public void setMessagestate(Integer messagestate) {
		this.messagestate = messagestate;
	}

	@Column(name = "messageip", length = 50)
	public String getMessageip() {
		return messageip;
	}

	public void setMessageip(String messageip) {
		this.messageip = messageip;
	}

	@Column(name = "replyname", length = 30)
	public String getReplyname() {
		return replyname;
	}

	public void setReplyname(String replyname) {
		this.replyname = replyname;
	}

	@Column(name = "replytime", length = 30)
	public String getReplytime() {
		return replytime;
	}

	public void setReplytime(String replytime) {
		this.replytime = replytime;
	}

	@Column(name = "replycontent", length = 1000)
	public String getReplycontent() {
		return replycontent;
	}

	public void setReplycontent(String replycontent) {
		this.replycontent = replycontent;
	}

	@Column(name = "isshow")
	public Integer getIsshow() {
		return isshow;
	}

	public void setIsshow(Integer isshow) {
		this.isshow = isshow;
	}

	
	

}