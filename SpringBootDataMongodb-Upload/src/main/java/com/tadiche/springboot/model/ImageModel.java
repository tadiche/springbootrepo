package com.tadiche.springboot.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "package_delivery")
public class ImageModel {
	@Id
	String _id;
	String barcode;
	String barcodeType;
	//byte[] picByte;
	String picName;
	
	/**
	 * @return the picName
	 */
	public String getPicName() {
		return picName;
	}
	/**
	 * @param picName the picName to set
	 */
	public void setPicName(String picName) {
		this.picName = picName;
	}
	/**
	 * @return the _id
	 */
	public String get_id() {
		return _id;
	}
	/**
	 * @param _id the _id to set
	 */
	public void set_id(String _id) {
		this._id = _id;
	}
	/**
	 * @return the barcode
	 */
	public String getBarcode() {
		return barcode;
	}
	/**
	 * @param barcode the barcode to set
	 */
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	/**
	 * @return the barcodeType
	 */
	public String getBarcodeType() {
		return barcodeType;
	}
	/**
	 * @param barcodeType the barcodeType to set
	 */
	public void setBarcodeType(String barcodeType) {
		this.barcodeType = barcodeType;
	}
	/**
	 * @return the picByte
	 */
	/*public byte[] getPicByte() {
		return picByte;
	}*/
	/**
	 * @param picByte the picByte to set
	 */
	/*public void setPicByte(byte[] picByte) {
		this.picByte = picByte;
	}*/

	/*public ImageModel(String barcode, String barcodeType, String picName ,byte[] picByte) {
		super();
		this.barcode = barcode;
		this.barcodeType = barcodeType;
		this.picName = picName;
		this.picByte = picByte;
	}*/
	public ImageModel(String barcode, String barcodeType, String picName ) {
		super();
		this.barcode = barcode;
		this.barcodeType = barcodeType;
		this.picName = picName;
	}
}
