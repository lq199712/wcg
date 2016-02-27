package com.jlj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Footer entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "txl", catalog = "wcg")
public class Addressbook implements java.io.Serializable {

	// Fields
	private Integer id;
	private String name;
	private String lochus;
	private String shortnumber;
	private String  mobiletelphone;
	private String mobileshortnumber;
	

	// Constructors

	public Addressbook(Integer id, String name, String lochus,
			String shortnumber,String  mobiletelphone,String mobileshortnumber) {
		this.id = id;
		this.name = name;
		this.lochus = lochus;
		this.shortnumber = shortnumber;
		this.mobiletelphone = mobiletelphone;
		this.mobileshortnumber = mobileshortnumber;
	}

	/** default constructor */
	public Addressbook() {
	}

	/** full constructor */

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

	@Column(name = "lochus", length = 30)
	public String getLochus() {
		return lochus;
	}

	public void setLochus(String lochus) {
		this.lochus = lochus;
	}

	@Column(name = "shortnumber", length = 30)
	public String getShortnumber() {
		return shortnumber;
	}

	public void setShortnumber(String shortnumber) {
		this.shortnumber = shortnumber;
	}

	@Column(name = "mobiletelphone", length = 30)
	public String getMobiletelphone() {
		return mobiletelphone;
	}

	public void setMobiletelphone(String mobiletelphone) {
		this.mobiletelphone = mobiletelphone;
	}

	@Column(name = "mobileshortnumber", length = 30)
	public String getMobileshortnumber() {
		return mobileshortnumber;
	}

	public void setMobileshortnumber(String mobileshortnumber) {
		this.mobileshortnumber = mobileshortnumber;
	}

	

}