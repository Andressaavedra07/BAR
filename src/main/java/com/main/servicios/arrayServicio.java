package com.main.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.InterfaceServicios.IArraysServicio;
import com.main.Model.arrays;
import com.main.Repository.IArrays;

@Service
public class arrayServicio implements IArraysServicio {

	@Autowired
	private IArrays data;

	@Override
	public arrays lista_arrays(Long id) {
		return data.findById(id);
	}

}
