package com.jacaranda.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.jacaranda.utilities.Provincia;
import com.jacaranda.utilities.ProvinciaException;
import com.jacaranda.utilities.Pueblo;

class ProvinciaTest {

	@Test
	void testCrearProvinciaDatos() { //funciona
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
	void testListadoNombrePueblo() {  //no funciona
		Provincia sevilla = new Provincia("SEVILLA","11");
		sevilla.addPueblo("BRENES","01011",2000,33.33,33.33);
		sevilla.addPueblo("CANTILLANA","01011",2000,33.33,33.33);
		sevilla.addPueblo("RINCONADA","01011",2000,33.33,33.33);
		assertEquals(sevilla.listadoNombrePueblos().split(System.lineSeparator()).length,3);
	}
	
	@Test
	void testInformacionPueblo() { //no funciona
		Provincia sevilla = new Provincia("SEVILLA","11");
		sevilla.addPueblo("BRENES","01011",2000,33.33,33.33);
		sevilla.addPueblo("CANTILLANA","01011",2000,33.33,33.33);
		sevilla.addPueblo("RINCONADA","01011",2000,33.33,33.33);
		assertEquals(sevilla.getInformacionPueblo("BRENES").split(System.lineSeparator()).length,5);
	}
	
	@Test
	void testCrearProvinciaNombreNull() { //funciona
		try {
			Provincia pr = new Provincia(null,"11");
			assert(false);
		} catch (ProvinciaException pe) {
			assert(true);
		}
	}
	
	@Test
	void testCrearProvinciaCodigoNull() { //funciona
		try {
			Provincia pr = new Provincia("Sevilla",null);
			assert(false);
		} catch (ProvinciaException pe) {
			assert(true);
		}
	}
	
	@Test
	void testOutOfRangeAbajo() { //funciona
		try {
			Provincia pr = new Provincia("Sevilla","1");
			assert(false);
		} catch (ProvinciaException pe) {
			assert(true);
		}
	}
	
	@Test
	void testOutOfRangeArriba() { //funciona
		try {
			Provincia pr = new Provincia("Sevilla","111");
			assert(false);
		} catch (ProvinciaException pe) {
			assert(true);
		}
	}
	
	@Test
	void testAddPueblo() { //no funciona
		Provincia sevilla = new Provincia("SEVILLA","11");
		assertEquals(sevilla.getListaPueblos().size(),0);
		sevilla.addPueblo("BRENES","01011",2000,33.33,33.33);
		assertEquals(sevilla.getListaPueblos().size(),1);
	}
	
	@Test
	void  testAddPuebloRepe() { //no funciona
		Provincia sevilla = new Provincia("SEVILLA","11");
		assertEquals(sevilla.getListaPueblos().size(),0);
		sevilla.addPueblo("BRENES","01011",2000,33.33,33.33);
		assertEquals(sevilla.getListaPueblos().size(),1);
		try {
			sevilla.addPueblo("BRENES","01011",2000,33.33,33.33);
			assert(false);
		}catch(ProvinciaException p) {
			assert(true);
		}
	}
	
	@Test
	void creacionDeProvinciaRentaNegativo() { //funciona
		try {
			Provincia pr = new Provincia("SEVILLA", "11");
			pr.setRentaPerCapital(-12.05);
			assert(false);
		}catch (ProvinciaException p) {
			assert(true);
		}
	}
	
	@Test
	void creacionDeProvinciaHabitantesNegativo() { //funciona
		try {
			Provincia pr = new Provincia("SEVILLA", "11");
			pr.setNumeroHabitantes(-12);
			assert(false);
		}catch (ProvinciaException p) {
			assert(true);
		}
	}
	
	@Test
	void creacionDeProvinciaSuperficieNegativo() { //funciona
		try {
			Provincia pr = new Provincia("SEVILLA", "11");
			pr.setSuperficie(-12.05);
			assert(false);
		}catch (ProvinciaException p) {
			assert(true);
		}
	}
	
	@Test
	void borrarPueblo() { //no funciona
	Provincia pr = new Provincia("SEVILLA", "22");
	assertEquals(pr.getListaPueblos().size(),0);
	pr.addPueblo("MINAS", "11111", 10, 10.10, 10.0);
	assertEquals(pr.getListaPueblos().size(),1);
	pr.delPueblo("MINAS");
	assertEquals(pr.getListaPueblos().size(),0);
	}
	

}
