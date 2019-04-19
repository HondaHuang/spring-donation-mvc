package com.hh.bean;

import java.util.Date;

public class DonorBean {

	private Integer id;
	private String name;
	private String address;
	private Long contact;
	private Double donatedamt;
	private Date donatedate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getContact() {
		return contact;
	}

	public void setContact(Long contact) {
		this.contact = contact;
	}

	public Double getDonatedamt() {
		return donatedamt;
	}

	public void setDonatedamt(Double donatedamt) {
		this.donatedamt = donatedamt;
	}

	public Date getDonatedate() {
		return donatedate;
	}

	public void setDonatedate(Date donatedate) {
		this.donatedate = donatedate;
	}

	@Override
	public String toString() {
		return "DonorBean [id=" + id + ", name=" + name + ", address=" + address + ", contact=" + contact
				+ ", donatedamt=" + donatedamt + ", donatedate=" + donatedate + "]";
	}

}
