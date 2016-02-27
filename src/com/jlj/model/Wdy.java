package com.jlj.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Footer entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wdy", catalog = "wcg")
public class Wdy implements java.io.Serializable {

	// Fields
	private Integer id;
	private String name;
	private String keywordname;
	private String starttime;
	private String endtime;
	private String image;
	private String content;
	private Integer number;
	private String wdyip;
	private String wdytel;
	
	private String answer1;
	private Integer number1;
	private String answer2;
	private Integer number2;
	private String answer3;
	private Integer number3;
	private String answer4;
	private Integer number4;
	private String answer5;
	private Integer number5;
	private String answer6;
	private Integer number6;
	
	// Constructors


	


	


	public Wdy(Integer id, String name, String keywordname, String starttime,
			String endtime, String image, String content, Integer number,
			String wdyip, String wdytel, String answer1, Integer number1,
			String answer2, Integer number2, String answer3, Integer number3,
			String answer4, Integer number4, String answer5, Integer number5,
			String answer6, Integer number6) {
		super();
		this.id = id;
		this.name = name;
		this.keywordname = keywordname;
		this.starttime = starttime;
		this.endtime = endtime;
		this.image = image;
		this.content = content;
		this.number = number;
		this.wdyip = wdyip;
		this.wdytel = wdytel;
		this.answer1 = answer1;
		this.number1 = number1;
		this.answer2 = answer2;
		this.number2 = number2;
		this.answer3 = answer3;
		this.number3 = number3;
		this.answer4 = answer4;
		this.number4 = number4;
		this.answer5 = answer5;
		this.number5 = number5;
		this.answer6 = answer6;
		this.number6 = number6;
	}


	/** default constructor */
	public Wdy() {
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
	
	
	@Column(name = "name", length = 30)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "keywordname", length = 30)
	public String getKeywordname() {
		return keywordname;
	}

	public void setKeywordname(String keywordname) {
		this.keywordname = keywordname;
	}

	@Column(name = "starttime", length = 30)
	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	@Column(name = "endtime", length = 30)
	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	@Column(name = "image", length = 50)
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Column(name = "number")
	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}
	
	
	@Column(name = "wdyip", length = 1000)
	public String getWdyip() {
		return wdyip;
	}


	public void setWdyip(String wdyip) {
		this.wdyip = wdyip;
	}

	@Column(name = "wdytel", length = 1000)
	public String getWdytel() {
		return wdytel;
	}


	public void setWdytel(String wdytel) {
		this.wdytel = wdytel;
	}


	@Column(name = "answer1", length = 30)
	public String getAnswer1() {
		return answer1;
	}


	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}


	@Column(name = "number1")
	public Integer getNumber1() {
		return number1;
	}


	public void setNumber1(Integer number1) {
		this.number1 = number1;
	}

	@Column(name = "answer2", length = 30)
	public String getAnswer2() {
		return answer2;
	}


	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}

	@Column(name = "number2")
	public Integer getNumber2() {
		return number2;
	}


	public void setNumber2(Integer number2) {
		this.number2 = number2;
	}

	@Column(name = "answer3", length = 30)
	public String getAnswer3() {
		return answer3;
	}


	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}

	@Column(name = "number3")
	public Integer getNumber3() {
		return number3;
	}


	public void setNumber3(Integer number3) {
		this.number3 = number3;
	}

	@Column(name = "answer4", length = 30)
	public String getAnswer4() {
		return answer4;
	}


	public void setAnswer4(String answer4) {
		this.answer4 = answer4;
	}

	@Column(name = "number4")
	public Integer getNumber4() {
		return number4;
	}


	public void setNumber4(Integer number4) {
		this.number4 = number4;
	}

	@Column(name = "answer5", length = 30)
	public String getAnswer5() {
		return answer5;
	}


	public void setAnswer5(String answer5) {
		this.answer5 = answer5;
	}

	@Column(name = "number5")
	public Integer getNumber5() {
		return number5;
	}


	public void setNumber5(Integer number5) {
		this.number5 = number5;
	}

	@Column(name = "answer6", length = 30)
	public String getAnswer6() {
		return answer6;
	}


	public void setAnswer6(String answer6) {
		this.answer6 = answer6;
	}

	@Column(name = "number6")
	public Integer getNumber6() {
		return number6;
	}


	public void setNumber6(Integer number6) {
		this.number6 = number6;
	}

	@Column(name = "content", length = 1000)
	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}

	
	

}