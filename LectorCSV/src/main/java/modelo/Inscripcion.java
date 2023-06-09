package modelo;

import java.time.LocalDate;
import java.util.Objects;
import modelo.Alumno;
import modelo.Materia;

public class Inscripcion {
	
	private Alumno alumno;
	private Materia materia;
	private LocalDate fecha; 
	
	public boolean aprobada() {
		return this.materia.puedeCursar(alumno);
		
	}
	
	public Inscripcion (Alumno alumno, Materia materia, LocalDate fecha) {
		//super();
		this.alumno = alumno;
		this.materia = materia;
		this.fecha = fecha;	
		
	}
	
	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	@Override
	public int hashCode() {
		return Objects.hash(alumno, fecha, materia);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Inscripcion other = (Inscripcion) obj;
		return Objects.equals(alumno, other.alumno) && Objects.equals(fecha, other.fecha)
				&& Objects.equals(materia, other.materia);
	}

	@Override
	public String toString() {
		return "Inscripcion [alumno=" + alumno + ", materia=" + materia + ", fecha=" + fecha + "]";
	}
	
	
	
	
	
    }






