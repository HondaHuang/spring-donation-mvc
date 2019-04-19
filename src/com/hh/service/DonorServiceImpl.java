package com.hh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hh.dao.DonorDAO;
import com.hh.model.Donor;

@Service("donorService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DonorServiceImpl implements DonorService {

	@Autowired
	private DonorDAO donorDAO;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void addDonor(Donor donor) {
		donorDAO.addDonor(donor);
	}

	@Override
	public List<Donor> listDonors() {
		return donorDAO.listDonors();
	}

	@Override
	public Donor getDonor(Integer id) {
		return donorDAO.getDonor(id);
	}

	@Override
	public void deleteDonor(Donor donor) {
		donorDAO.deleteDonor(donor);
	}

}
