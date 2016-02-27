package com.jlj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Autores entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "conwaste", catalog = "wcg")
public class Conwaste implements java.io.Serializable {

	// Fields

	private Integer id;
	private String unit;
	private String person;
	private String phone;
	private String sum;
	private String carnumber;
	private String line;
	private String timelimit;
	private Integer status;
	private String note;
	private String forquery;

	// Constructors
	/** full constructor */
	public Conwaste(Integer id, String unit, String person, String phone,
			String sum, String carnumber, String line, String timelimit,
			Integer status, String note,String forquery) {
		super();
		this.id = id;
		this.unit = unit;
		this.person = person;
		this.phone = phone;
		this.sum = sum;
		this.carnumber = carnumber;
		this.line = line;
		this.timelimit = timelimit;
		this.status = status;
		this.note = note;
		this.forquery = forquery;
	}

	/** default constructor */
	public Conwaste() {
	}

	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "unit", length = 40)
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Column(name = "person", length = 20)
	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	@Column(name = "phone", length = 20)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "sum")
	public String getSum() {
		return sum;
	}

	public void setSum(String sum) {
		this.sum = sum;
	}

	@Column(name = "carnumber", length = 65535)
	public String getCarnumber() {
		return carnumber;
	}

	public void setCarnumber(String carnumber) {
		this.carnumber = carnumber;
	}

	@Column(name = "line", length = 65535)
	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	@Column(name = "timelimit", length = 65535)
	public String getTimelimit() {
		return timelimit;
	}

	public void setTimelimit(String timelimit) {
		this.timelimit = timelimit;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "note", length = 65535)
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Column(name = "forquery", length = 65535)
	public String getForquery() {
		return forquery;
	}

	public void setForquery(String forquery) {
		this.forquery = forquery;
	}

	

	
	
	
}