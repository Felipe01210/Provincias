package com.jacaranda.utilities;

import java.util.HashSet;
import java.util.Set;

public class Provincia {

	private String nombre;
	private String codigo;
	private Integer numeroHabitantes;
	private Double rentaPerCapital;
	private Double superficie;
	private Set<Pueblo> listaPueblos= new HashSet<Pueblo>();
	
	
	public Provincia(String nombre, String codigo) {
		if (nombre==null || codigo==null || codigo.length()!=2 || !nombre.equals(nombre.toUpperCase())) {
			throw new ProvinciaException("No se ha podido crear la provincia");
		}else {
			if (codigo.length()==2) {
				for (int i = 0; i<codigo.length();i++) {
					if (Character.isDigit(i)) {
						throw new ProvinciaException("No se ha podido crear la provincia CHARACTER");
					}
				}
			}
		}
		
		this.nombre = nombre;
		this.codigo = codigo;
	}
	
	private boolean existePueblo(String nombrePueblo) {
	
		return this.listaPueblos.contains(nombrePueblo);
	}

	
	public boolean addPueblo(Pueblo pu) {
		boolean resultado=false;
		//!this.listaPueblos.contains(pu) 
		if (existePueblo(pu.getNombre())) {
			throw new ProvinciaException("Error,no se ha podido añadir el pueblo");
		}else {
			this.listaPueblos.add(pu);
			resultado=true;
		}
		
		return resultado;
	}
	
	public String listadoNombrePueblos () {
	
		StringBuilder sb = new StringBuilder();
		for (Pueblo i : listaPueblos) {
			sb.append(i.getNombre()+"\n");
		}
		
		return sb.toString();
	}
	
	public String listadoPueblos () {
		
		StringBuilder sb = new StringBuilder();
		for (Pueblo i : listaPueblos) {
			sb.append(i+"\n");
		}
		
		return sb.toString();
	}
	
	public boolean delPueblo (String nombre) {
		boolean res=false;
		if (existePueblo(nombre)) {
			for (Pueblo i : listaPueblos) {
				if (nombre.equals(i.getNombre())) {
					this.listaPueblos.remove(nombre);
					res=true;
				}
			}
		}
		return res; 
	}
	
	
	public Integer numPueblos () {
		return this.listaPueblos.size();
	}
	
	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public Integer getNumeroHabitantes() {
		return numeroHabitantes;
	}


	public void setNumeroHabitantes(Integer numeroHabitantes) {
		this.numeroHabitantes = numeroHabitantes;
	}


	public Double getRentaPerCapital() {
		return rentaPerCapital;
	}


	public void setRentaPerCapital(Double rentaPerCapital) {
		this.rentaPerCapital = rentaPerCapital;
	}


	public Double getSuperficie() {
		return superficie;
	}


	public void setSuperficie(Double superficie) {
		this.superficie = superficie;
	}


	public String getNombre() {
		return nombre;
	}


	public String getInformacionPueblo(String nombre) {
		StringBuilder sb =  new StringBuilder();
		
		if (existePueblo(nombre)) {
			for (Pueblo pueblo : listaPueblos) {
				if (nombre.equals(pueblo.getNombre())) {
					sb.append(pueblo);
				}
			}
		}
		
		return sb.toString();
	}
	
	
	
}
