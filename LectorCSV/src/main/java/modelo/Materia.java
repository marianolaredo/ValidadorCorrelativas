package modelo;

import java.util.List;
import java.util.Objects;
import java.util.ArrayList;
import modelo.Alumno;
import modelo.Inscripcion;


public class Materia {
	private String nombre;
	private List <Materia> correlativas;
	
	public Materia(String nombre) {
		this.nombre = nombre;
		correlativas = new ArrayList<Materia>();
	}
	
	public boolean puedeCursar(Alumno alumno) {
		boolean correlativasAprobadas = true;
		
		for(Materia correlativa : this.correlativas) {
			if (!alumno.aproboMateria(correlativa)) {
				correlativasAprobadas = false;
			}
		}
		return correlativasAprobadas;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String nuevoNombre) {
		this.nombre = nuevoNombre;
	}
	
	public void agregarMateriaCorrelativa(Materia materia) {
		this.correlativas.add(materia);
	}
	
	public void eliminarMateriaCorrelativas(Materia materia) {
		this.correlativas.remove(materia);
	}

	@Override
	public String toString() {
		return "Materia [nombre=" + nombre + ", correlativas=" + correlativas + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(correlativas, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Materia other = (Materia) obj;
		return Objects.equals(correlativas, other.correlativas) && Objects.equals(nombre, other.nombre);
	}
	
	
}