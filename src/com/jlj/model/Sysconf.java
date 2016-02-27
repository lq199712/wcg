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
 * Sysconf entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sysconf", catalog = "wcg")
public class Sysconf implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Date deadline;
	private Integer status;
	private String version;
	
	// Constructors

	/** default constructor */
	public Sysconf() {
	}

	/** full constructor */
	public Sysconf(String name, Date deadline, Integer status,String version) {
		this.name = name;
		this.deadline = deadline;
		this.status = status;
		this.version = version;
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

	@Column(name = "name", length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "deadline", length = 10)
	public Date getDeadline() {
		return this.deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "version", length = 6)
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	
}