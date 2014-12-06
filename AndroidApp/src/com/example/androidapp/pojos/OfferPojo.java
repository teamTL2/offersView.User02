package com.example.androidapp.pojos;

import java.io.Serializable;

public class OfferPojo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8815345304257124858L;
	
	private String productName;
	private String productDiscount; // p.x. -20%

	public OfferPojo() {}
	
	public OfferPojo(String productName, String productDiscount) {
		super();
		this.productName = productName;
		this.productDiscount = productDiscount;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDiscount() {
		return productDiscount;
	}

	public void setProductDiscount(String productDiscount) {
		this.productDiscount = productDiscount;
	}

}
