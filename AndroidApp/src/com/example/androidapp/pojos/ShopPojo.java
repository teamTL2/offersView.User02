package com.example.androidapp.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ShopPojo  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7550923528851007194L;
	
	private String name;
	private String street;// Mporei na min xriazete!!
	private String phone;
	private String region;
	private String zipCode;
	private String coordinates;// ???(X,Y)???
	private double latitude;
	private double longitude;
	private List<OfferPojo> offers;

	public ShopPojo() {
		offers = new ArrayList<OfferPojo>();
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}

	public List<OfferPojo> getOffers() {
		return offers;
	}
	
	public void addOffer(OfferPojo offer) {
		offers.add(offer);
	}

	public void setOffers(List<OfferPojo> offers) {
		this.offers = offers;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getRegion() {
		return region;
	}


	public void setRegion(String region) {
		this.region = region;
	}


	public String getZipCode() {
		return zipCode;
	}


	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	
	
	

}
