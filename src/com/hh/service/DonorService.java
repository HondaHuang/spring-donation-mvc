package com.hh.service;

import java.util.List;

import com.hh.model.Donor;

public interface DonorService {

	public void addDonor(Donor donor);

	public List<Donor> listDonors();

	public Donor getDonor(Integer id);

	public void deleteDonor(Donor donor);
}
