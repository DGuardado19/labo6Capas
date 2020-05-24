package com.uca.capas.labo6.controller;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.labo6.domain.Contribuyente;
import com.uca.capas.labo6.domain.Importancia;
import com.uca.capas.labo6.service.ContribuyenteServices;
import com.uca.capas.labo6.service.ImportanciaServices;

@Controller
public class MainController {
	@Autowired
	private ContribuyenteServices contribuyenteService;
	@Autowired
	private ImportanciaServices importanciaService;
	
	@RequestMapping("/index")
	public ModelAndView init() {
		ModelAndView mav = new ModelAndView();
		List<Importancia> importancialist = null;
		try {
			importancialist = importanciaService.findAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		mav.addObject("importancialist", importancialist);
		mav.addObject("contribuyente", new Contribuyente());
		mav.setViewName("index");
		return mav;
	}

	@RequestMapping("/mostrar")
	public ModelAndView mostrarContribuyentes() {
		ModelAndView mav = new ModelAndView();
		List<Contribuyente> contribuyenteslist = null;
		try {
			contribuyenteslist = contribuyenteService.findAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		mav.addObject("list", contribuyenteslist);
		mav.setViewName("mostrar");
		return mav;
	}
	
	@RequestMapping("/procesar")
	public ModelAndView insertar(@ModelAttribute Contribuyente contribuyente) {
		ModelAndView mav = new ModelAndView();
		Calendar fecha = Calendar.getInstance();
		String fecha1 = String.valueOf(fecha.get(Calendar.YEAR)) + "/"+
				String.valueOf(fecha.get(Calendar.MONTH)+1) + "/"+
				String.valueOf(fecha.get(Calendar.DAY_OF_MONTH));
			try {
				Date f = new SimpleDateFormat("yyyy/MM/dd").parse(fecha1);
				contribuyente.setF_fecha_ingreso(f);
				contribuyenteService.insertContribuyente(contribuyente);
				mav.setViewName("ingreso");
			} catch (Exception e) {
				e.printStackTrace();
			}
		return mav;
	}
	
	
}
