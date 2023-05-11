package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import modelo.Inscripcion;
import modelo.Materia;

public class Alumno {
	private String nombre;
	private String legajo;
	private ArrayList <Materia> materiasAprobadas;
	
	public boolean aproboMateria(Materia materia) {
		return this.materiasAprobadas.contains(materia);
	
	}
	public Alumno (String nombre, String legajo) {
	    super();
		this.nombre = nombre;
		this.legajo = legajo;
		materiasAprobadas = new ArrayList<Materia>();
	}


	public String getNombre() {
	return nombre;
	}
	public void setNombre(String nombre) {
	this.nombre = nombre;
	}
	public String getLegajo() {
	return legajo;
	}
	public void setLegajo(String legajo) {
	this.legajo = legajo;
	}
	public void agregarMateriasAprobadas(Materia materia) {
		this.materiasAprobadas.add(materia);
	}
	
	public void eliminarMateriasAprobadas(Materia materia) {
		this.materiasAprobadas.remove(materia);
	}
	

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", legajo=" + legajo + ", materiasAprobadas=" + materiasAprobadas + "]";
	}
	
	@Override
	public int hashCode() {
	return Objects.hash(legajo, nombre);
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(legajo, other.legajo) && Objects.equals(nombre, other.nombre);
	}
}
