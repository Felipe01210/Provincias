package com.jacaranda.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.jacaranda.utilities.Provincia;
import com.jacaranda.utilities.ProvinciaException;

class ProvinciaTest {

	@Test
	void testCrearProvinciaDatos() {
		Provincia pr = new Provincia("Sevilla","11445");
		assertEquals(pr.getClass().getSimpleName(), "Provincia");
		
		/*
		try {
			Provincia pr = new Provincia("Sevilla","11445");
		} catch (Exception e) {
			assert(false);
		}
		assert(true);
		*/
	}
	
	@Test
	void testCrearProvinciaNombreNull() {
		try {
			Provincia pr = new Provincia(null,"11445");
			assert(false);
		} catch (ProvinciaException pe) {
			assert(true);
		}
	}
	

}
