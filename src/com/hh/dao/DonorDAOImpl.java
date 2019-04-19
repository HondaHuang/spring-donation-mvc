package com.hh.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hh.model.Donor;

@Repository("donorDAO")
public class DonorDAOImpl implements DonorDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addDonor(Donor donor) {
		sessionFactory.getCurrentSession().saveOrUpdate(donor);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Donor> listDonors() {
		return (List<Donor>) sessionFactory.getCurrentSession().createCriteria(Donor.class).list();
	}

	@Override
	public Donor getDonor(Integer id) {
		return (Donor) sessionFactory.getCurrentSession().get(Donor.class, id);
	}

	@Override
	public void deleteDonor(Donor donor) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Donor WHERE id = " + donor.getId()).executeUpdate();
	}

}
