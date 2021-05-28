package com.gallery.entity;

public class Painting {
	private Integer id;
	private String pname;
	private Integer category;
	private Integer price;
	private String preview;
	private String descrption;
	
	public Painting() {}
	
	public Painting(Integer id, String pname, Integer category, Integer price, String preview, String descrption) {
		super();
		this.id = id;
		this.pname = pname;
		this.category = category;
		this.price = price;
		this.preview = preview;
		this.descrption = descrption;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Integer getCategory() {
		return category;
	}
	public void setCategory(Integer category) {
		this.category = category;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getPreview() {
		return preview;
	}
	public void setPreview(String preview) {
		this.preview = preview;
	}
	public String getDescrption() {
		return descrption;
	}
	public void setDescrption(String descrption) {
		this.descrption = descrption;
	}
	
	

}
