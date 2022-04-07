package com.jacaranda.utilities;

public abstract class Poblacion {
	
	protected String nombre;
	protected String codigo;
	protected int numeroHabitantes;
	protected double rentaPerCapital;
	protected double superficie;
	
	
	public Poblacion(String nombre, String codigo){
		this.nombre = nombre;
		this.codigo = codigo;
		comprobarCod();
	}
	
	public Poblacion(String nombre, String codigo, int numH, double rent, double superficie) {
		this.nombre = nombre;
		this.codigo = codigo;
		this.numeroHabitantes = numH; 
		this.rentaPerCapital = rent;
		this.superficie = superficie;
		comprobarCod();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getNumeroHabitantes() {
		return numeroHabitantes;
	}

	public void setNumeroHabitantes(int numeroHabitantes) {
		if (numeroHabitantes < 0) {
			throw new ProvinciaException("Numero de habitantes negativo no aceptada");
		}
		this.numeroHabitantes = numeroHabitantes;
	}

	public double getRentaPerCapital() {
		return rentaPerCapital;
	}

	public void setRentaPerCapital(double rentaPerCapital) {
		if (rentaPerCapital < 0.0) {
			throw new ProvinciaException("Renta negativa no aceptada");
		}
		this.rentaPerCapital = rentaPerCapital;
	}

	public double getSuperficie() {
		return superficie;
	}

	public void setSuperficie(double superficie) {
		if (superficie < 0.0) {
			throw new ProvinciaException("Superficie negativa no aceptada");
		}
		this.superficie = superficie;
	}
	
	public abstract int getTamanoMax();
	
	public void comprobarCod(){
		if (nombre==null || codigo==null || codigo.length()!=getTamanoMax() || !nombre.equals(nombre.toUpperCase())) {
			throw new ProvinciaException("No se ha podido crear la provincia");
		}else {
			if (codigo.length()==getTamanoMax()) {
				for (int i = 0; i<codigo.length();i++) {
					if (!Character.isDigit(codigo.charAt(i))) {
						throw new ProvinciaException("No se ha podido crear la provincia CHARACTER");
					}
				}
			}
		}
	}

}
