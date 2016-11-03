package com.coolweather.app.model;

public class City {
	
	private int id;
	private int provinceId;
	private String cityName;
	private String cityCode;
	

	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id=id;
	}
	
	public String getCityName(){
		return cityName;
	}
	
	public void  setCityName(String name){
		this.cityName=name;
	}
	
	public String getCityCode(){
		return cityCode;
	}
	
	public void setCityCode(String code){
		this.cityCode=code;
	}
	
	public int getProvinceId(){
		return provinceId;
	}
	
	public void setProvinceId(int id){
		this.provinceId=id;
	}
	
}
