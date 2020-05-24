package com.uca.capas.labo6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.labo6.dao.ContribuyenteDAO;
import com.uca.capas.labo6.domain.Contribuyente;

@Service
public class ContribuyenteServicesImpl implements ContribuyenteServices {

	@Autowired
	private ContribuyenteDAO contribuyenteDAO;
	
	@Override
	public List<Contribuyente> findAll() throws DataAccessException {
		return contribuyenteDAO.findAll();
	}

	@Override
	public void insertContribuyente(Contribuyente contribuyente) throws DataAccessException {
		contribuyenteDAO.insertContri(contribuyente);
	}

}