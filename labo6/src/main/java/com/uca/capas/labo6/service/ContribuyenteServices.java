package com.uca.capas.labo6.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.labo6.domain.Contribuyente;

public interface ContribuyenteServices {
	
	public List<Contribuyente> findAll() throws DataAccessException;
	public void insertContribuyente(Contribuyente contribuyente) throws DataAccessException;
	
}
