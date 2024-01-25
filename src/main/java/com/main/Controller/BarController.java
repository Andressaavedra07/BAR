package com.main.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.main.InterfaceServicios.IArraysServicio;
import com.main.Model.BarRequest;
import com.main.Model.arrays;

@RestController
@RequestMapping("/bar")
public class BarController {

	@Autowired
	private IArraysServicio arrayData;

	@PostMapping("/procesar")
	@ResponseStatus(HttpStatus.CREATED)
	public Map<String, Object> procesar(@RequestBody BarRequest barRequest) {

		Map<String, Object> response = new HashMap<>();
		if (barRequest.getId() >= 1 && barRequest.getId() <= 5) {

			List<Integer> respuesta = new ArrayList<>();

			arrays listaQ = arrayData.lista_arrays(barRequest.getId());
			listaQ.getInput_array();

			String[] a = listaQ.getInput_array().split(",");

			int[] p = { 2, 3, 5, 7, 11, 13, 17 };

			for (int i = 0; i < barRequest.getQ(); i++) {

				List<Integer> b = new ArrayList<>();
				List<String> ai = new ArrayList<>();

				for (String vaso : a) {

					int vas = Integer.parseInt(vaso);
					// validacion si es divisible

					if (esPrimo(p[i]) && vas % p[i] == 0) {
						b.add(vas);
					} else {
						ai.add(vas + "");
					}

				}

				respuesta.addAll(b);
				a = ai.toArray(new String[ai.size()]);

				System.out.println("A = " + ai);
				System.out.println("B = " + respuesta);
			}

			respuesta.addAll(Arrays.stream(a).map(Integer::parseInt).collect(Collectors.toList())); // Almacena los
																									// valores restantes
																									// // de Ai al final
			System.out.println("FINAL " + respuesta);
			response.put("RESPUESTA", respuesta);
			// Respuesta
			return response;
		} else {

			response.put("ERROR", "Debe ingresar un numero entre 1 y 5 para ejecutar la acccion. ");
			return response;
		}

	}

// validacion numero primo
	private boolean esPrimo(int num) {
		if (num < 2) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}
