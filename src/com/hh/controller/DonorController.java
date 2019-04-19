package com.hh.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hh.bean.DonorBean;
import com.hh.model.Donor;
import com.hh.service.DonorService;

@Controller
public class DonorController {

	@Autowired
	private DonorService donorService;

	private Donor prepareModel(DonorBean donorBean) {
		Donor donor = new Donor();
		donor.setId(donorBean.getId());
		donor.setName(donorBean.getName());
		donor.setAddress(donorBean.getAddress());
		donor.setContact(donorBean.getContact());
		donor.setDonatedamt(donorBean.getDonatedamt());
		donor.setDonatedate(donorBean.getDonatedate());
		donorBean.setId(null);
		return donor;
	}

	private List<DonorBean> prepareListofBean(List<Donor> donors) {
		List<DonorBean> beans = null;
		if (donors != null && !donors.isEmpty()) {
			beans = new ArrayList<>();
			DonorBean bean = null;
			for (Donor donor : donors) {
				bean = new DonorBean();
				bean.setId(donor.getId());
				bean.setName(donor.getName());
				bean.setAddress(donor.getAddress());
				bean.setContact(donor.getContact());
				bean.setDonatedamt(donor.getDonatedamt());
				bean.setDonatedate(donor.getDonatedate());
				beans.add(bean);
			}
		}
		return beans;
	}

	private DonorBean prepareDonorBean(Donor donor) {
		DonorBean bean = new DonorBean();
		bean.setId(donor.getId());
		bean.setName(donor.getName());
		bean.setAddress(donor.getAddress());
		bean.setContact(donor.getContact());
		bean.setDonatedamt(donor.getDonatedamt());
		bean.setDonatedate(donor.getDonatedate());
		return bean;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveDonor(@ModelAttribute("command") DonorBean donorBean, BindingResult result) {
		System.out.println("hi " + donorBean);
		Donor donor = prepareModel(donorBean);
		donorService.addDonor(donor);
		return new ModelAndView("redirect:/add.html");
	}

	@RequestMapping(value = "/donors", method = RequestMethod.GET)
	public ModelAndView listDonors() {
		Map<String, Object> model = new HashMap<>();
		model.put("donors", prepareListofBean(donorService.listDonors()));
		return new ModelAndView("donorsList", model);
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addDonor(@ModelAttribute("command") DonorBean donorBean, BindingResult result) {
		Map<String, Object> model = new HashMap<>();
		model.put("donors", prepareListofBean(donorService.listDonors()));
		return new ModelAndView("addDonor", model);
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView welcome() {
		return new ModelAndView("index");
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView editDonor(@ModelAttribute("command") DonorBean donorBean, BindingResult result) {
		donorService.deleteDonor(prepareModel(donorBean));
		Map<String, Object> model = new HashMap<>();
		model.put("donor", null);
		model.put("donors", prepareListofBean(donorService.listDonors()));
		return new ModelAndView("addDonor", model);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView deleteDonor(@ModelAttribute("command") DonorBean donorBean, BindingResult result) {
		Map<String, Object> model = new HashMap<>();
		model.put("donor", prepareDonorBean(donorService.getDonor(donorBean.getId())));
		model.put("donors", prepareListofBean(donorService.listDonors()));
		return new ModelAndView("addDonor", model);
	}

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public ModelAndView viewDonor(@ModelAttribute("command") DonorBean donorBean, BindingResult result) {
		Map<String, Object> model = new HashMap<>();
		return new ModelAndView("viewDonor", model);
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView searchDonor(@ModelAttribute("command") DonorBean donorBean, BindingResult result) {
		Map<String, Object> model = new HashMap<>();
		model.put("donor", prepareDonorBean(donorService.getDonor(donorBean.getId())));
		return new ModelAndView("viewDonor", model);
	}
}
