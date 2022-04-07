package com.jacaranda.utilities;

import java.util.HashSet;
import java.util.Set;

public class Provincia extends Poblacion {
	
	private static final int LONGCOD = 2;
	private Set<Pueblo> listaPueblos= new HashSet<Pueblo>();
	
	
	public Provincia(String nombre, String codigo) {
		super(nombre,codigo);
	}
	
	
	@Override
	public int getTamanoMax() {
		// TODO Auto-generated method stub
		return LONGCOD;
	}
	
	private boolean existePueblo(String nombrePueblo) {
		boolean res = false;
		for(Pueblo i : this.listaPueblos) {
			if (i.getNombre().equals(nombrePueblo)) {
				res = true;
			}
		}
		return res;
	}

	
	public boolean addPueblo(String nombre, String codigo, int numH, double renta, double superficie) {
		boolean resultado=false;
		//!this.listaPueblos.contains(pu) 
		if (existePueblo(nombre)) {
			throw new ProvinciaException("Error,no se ha podido añadir el pueblo");
		}else {
			this.listaPueblos.add(new Pueblo(nombre,codigo,numH,renta,superficie));
			this.setRentaPerCapital(this.getRentaPerCapital()+renta);
			this.setNumeroHabitantes(this.getNumeroHabitantes()+numH);
			this.setSuperficie(this.getSuperficie()+superficie);
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
					this.listaPueblos.remove(i);
					this.setRentaPerCapital(this.getRentaPerCapital()-i.getRentaPerCapital());
					this.setNumeroHabitantes(this.getNumeroHabitantes()-i.getNumeroHabitantes());
					this.setSuperficie(this.getSuperficie()-i.getSuperficie());
					res=true;
				}
			}
		}
		return res; 
	}
	
	
	public Integer numPueblos () {
		return this.listaPueblos.size();
	}
	
	public Set<Pueblo> getListaPueblos() {
		return listaPueblos;
	}

	public void setListaPueblos(Set<Pueblo> listaPueblos) {
		this.listaPueblos = listaPueblos;
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
