package com.jlj.model;

import java.util.Date;
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
 * Resmessage entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "resmessage", catalog = "wcg")
public class Resmessage implements java.io.Serializable {

	// Fields

	private Integer id;
	private Fodder fodder;
	private String tousername;
	private String fromusername;
	private Date createtime;

	// Constructors

	/** default constructor */
	public Resmessage() {
	}

	/** full constructor */
	public Resmessage(Fodder fodder, String tousername, String fromusername,
			Date createtime) {
		this.fodder = fodder;
		this.tousername = tousername;
		this.fromusername = fromusername;
		this.createtime = createtime;
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
	@JoinColumn(name = "fodderid")
	public Fodder getFodder() {
		return this.fodder;
	}

	public void setFodder(Fodder fodder) {
		this.fodder = fodder;
	}

	@Column(name = "tousername", length = 50)
	public String getTousername() {
		return this.tousername;
	}

	public void setTousername(String tousername) {
		this.tousername = tousername;
	}

	@Column(name = "fromusername", length = 30)
	public String getFromusername() {
		return this.fromusername;
	}

	public void setFromusername(String fromusername) {
		this.fromusername = fromusername;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "createtime", length = 19)
	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

}