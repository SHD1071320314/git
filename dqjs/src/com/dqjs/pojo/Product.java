package com.dqjs.pojo;

public class Product {
	private int product_id;//��Ʒid
	private String product_url;//��ƷͼƬurl
	private int product_enable;//��Ʒ�Ƿ���ʾ
	private String product_name;
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_url() {
		return product_url;
	}
	public void setProduct_url(String product_url) {
		this.product_url = product_url;
	}
	public int getProduct_enable() {
		return product_enable;
	}
	public void setProduct_enable(int product_enable) {
		this.product_enable = product_enable;
	}
}
