package com.hh.dao;

import java.util.List;

import com.hh.model.Donor;

public interface DonorDAO {

	public void addDonor(Donor donor);

	public List<Donor> listDonors();

	public Donor getDonor(Integer id);

	public void deleteDonor(Donor donor);
}
