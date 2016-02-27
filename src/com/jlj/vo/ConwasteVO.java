package com.jlj.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Autores entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@XmlRootElement(name="ConwasteVO")
public class ConwasteVO implements java.io.Serializable {

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
	public ConwasteVO(Integer id, String unit, String person, String phone,
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
	public ConwasteVO() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSum() {
		return sum;
	}

	public void setSum(String sum) {
		this.sum = sum;
	}

	public String getCarnumber() {
		return carnumber;
	}

	public void setCarnumber(String carnumber) {
		this.carnumber = carnumber;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public String getTimelimit() {
		return timelimit;
	}

	public void setTimelimit(String timelimit) {
		this.timelimit = timelimit;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getForquery() {
		return forquery;
	}

	public void setForquery(String forquery) {
		this.forquery = forquery;
	}

	
	

	
	
	
}