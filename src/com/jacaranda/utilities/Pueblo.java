package com.jacaranda.utilities;

import java.util.Objects;

public class Pueblo extends Poblacion  implements Comparable<Pueblo>{
	
	private static final int LONGCOD = 5;
	
	public Pueblo(String nombre, String codigo, Integer numeroHabitantes, Double rentaPerCapital, Double superficie) {
		super(nombre,codigo,numeroHabitantes,rentaPerCapital,superficie);
	}
	
	public Pueblo(String nombre, String codigo) {
		super(nombre,codigo);
		
	}
	
	@Override
	public int getTamanoMax() {
		// TODO Auto-generated method stub
		return LONGCOD;
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
		return "Pueblo [nombre=" + nombre +"\n"+ ", codigo=" + codigo +"\n"+ ", numeroHabitantes=" + numeroHabitantes
				+"\n"+ ", rentaPerCapital=" + rentaPerCapital +"\n"+ ", superficie=" + superficie + "]";
	}

	
	
	
	
}
