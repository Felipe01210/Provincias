package com.jacaranda.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.jacaranda.utilities.Provincia;
import com.jacaranda.utilities.ProvinciaException;
import com.jacaranda.utilities.Pueblo;

class ProvinciaTest {

	@Test
	void testCrearProvinciaDatos() {
		Provincia pr = new Provincia("SEVILLA","11");
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
	void testListadoNombrePueblo() {
		Provincia sevilla = new Provincia("SEVILLA","11");
		sevilla.addPueblo("Brenes","01",2000,33.33,33.33);
		sevilla.addPueblo("Cantillana","01",2000,33.33,33.33);
		sevilla.addPueblo("La Rinconada","01",2000,33.33,33.33);
		assertEquals(sevilla.listadoNombrePueblos().split(System.lineSeparator()).length,3);
	}
	
	@Test
	void testInformacionPueblo() {
		Provincia sevilla = new Provincia("SEVILLA","11");
		sevilla.addPueblo("Brenes","01",2000,33.33,33.33);
		sevilla.addPueblo("Cantillana","01",2000,33.33,33.33);
		sevilla.addPueblo("La Rinconada","01",2000,33.33,33.33);
		assertEquals(sevilla.getInformacionPueblo("Brenes").split(System.lineSeparator()).length,5);
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
	
	@Test
	void testCrearProvinciaCodigoNull() {
		try {
			Provincia pr = new Provincia("Sevilla",null);
			assert(false);
		} catch (ProvinciaException pe) {
			assert(true);
		}
	}
	
	@Test
	void testOutOfRangeAbajo() {
		try {
			Provincia pr = new Provincia("Sevilla","1");
			assert(false);
		} catch (ProvinciaException pe) {
			assert(true);
		}
	}
	
	@Test
	void testOutOfRangeArriba() {
		try {
			Provincia pr = new Provincia("Sevilla","111");
			assert(false);
		} catch (ProvinciaException pe) {
			assert(true);
		}
	}
	
	@Test
	void testAddPueblo() {
		Provincia sevilla = new Provincia("SEVILLA","11");
		assertEquals(sevilla.getListaPueblos().size(),0);
		sevilla.addPueblo("Brenes","01",2000,33.33,33.33);
		assertEquals(sevilla.getListaPueblos().size(),1);
	}
	
	@Test
	void  testAddPuebloRepe() {
		Provincia sevilla = new Provincia("SEVILLA","11");
		assertEquals(sevilla.getListaPueblos().size(),0);
		sevilla.addPueblo("Brenes","01",2000,33.33,33.33);
		assertEquals(sevilla.getListaPueblos().size(),1);
		try {
			sevilla.addPueblo("Brenes","01",2000,33.33,33.33);
			assert(false);
		}catch(ProvinciaException p) {
			assert(true);
		}
	}
	
	@Test
	void creacionDeProvinciaRentaNegativo() {
		try {
			Provincia pr = new Provincia("SEVILLA", "11");
			pr.setRentaPerCapital(-12.05);
			assert(false);
		}catch (ProvinciaException p) {
			assert(true);
		}
	}
	
	@Test
	void creacionDeProvinciaHabitantesNegativo() {
		try {
			Provincia pr = new Provincia("SEVILLA", "11");
			pr.setNumeroHabitantes(-12);
			assert(false);
		}catch (ProvinciaException p) {
			assert(true);
		}
	}
	
	@Test
	void creacionDeProvinciaSuperficieNegativo() {
		try {
			Provincia pr = new Provincia("SEVILLA", "11");
			pr.setSuperficie(-12.05);
			assert(false);
		}catch (ProvinciaException p) {
			assert(true);
		}
	}
	
	@Test
	void borrarPueblo() {
	Provincia pr = new Provincia("SEVILLA", "22");
	assertEquals(pr.getListaPueblos().size(),0);
	pr.addPueblo("Minas", "11", 10, 10.10, 10.0);
	assertEquals(pr.getListaPueblos().size(),1);
	pr.delPueblo("Minas");
	assertEquals(pr.getListaPueblos().size(),0);
	}
	

}
