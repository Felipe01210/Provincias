package com.jacaranda.utilities;

import java.util.Objects;

public class Pueblo  implements Comparable<Pueblo>{

	private String nombre;
	private String codigo;
	private Integer numeroHabitantes;
	private Double rentaPerCapital;
	private Double superficie;
	
	public Pueblo(String nombre, String codigo, Integer numeroHabitantes, Double rentaPerCapital, Double superficie) {
		this.nombre = nombre;
		this.codigo = codigo;
		this.numeroHabitantes = numeroHabitantes;
		this.rentaPerCapital = rentaPerCapital;
		this.superficie = superficie;
	}
	
	public Pueblo(String nombre, String codigo) {
		this.nombre = nombre;
		this.codigo = codigo;
		
	}

	public String getCodigo() {
		return codigo;
	}

	private void setCodigo(String codigo) {
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

	@Override
	public int hashCode() {
		return Objects.hash(codigo, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		boolean sonIguales=false;
		if (this != null) {
			if (this==obj) {
				sonIguales=true;
			}else {
				Pueblo other = (Pueblo) obj;
				sonIguales=this.codigo.equals(other.getCodigo()) &&
						this.nombre.equals(other.getNombre());
			}
		}
	
		return sonIguales;
	}

	@Override
	public int compareTo(Pueblo otroPueblo) {
		int result=0;
		if (otroPueblo!=null) {
			result=this.codigo.compareTo(otroPueblo.getCodigo());
			if (result==0) {
				result=this.nombre.compareTo(otroPueblo.getNombre());
			}
		}
		return result;
	}

	@Override
	public String toString() {
		return "Pueblo [nombre=" + nombre + ", codigo=" + codigo + ", numeroHabitantes=" + numeroHabitantes
				+ ", rentaPerCapital=" + rentaPerCapital + ", superficie=" + superficie + "]";
	}
	
	
	
	
	
}
