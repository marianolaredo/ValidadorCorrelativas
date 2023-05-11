package modelo;

import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import modelo.Alumno;
import modelo.Inscripcion;
import modelo.Materia;

public class LectorDeArchivos {
	
	String rutaArchivoInscripciones;
	List<ArchivoInscripciones> LineasArchivosInscripciones;
	
	public LectorDeArchivos (String rutaArchivoInscripciones) {
		this.rutaArchivoInscripciones = rutaArchivoInscripciones;
		LineasArchivosInscripciones = new ArrayList <ArchivoInscripciones>();
	}
	
	public void parsearArchivo() {
		List<ArchivoInscripciones> listaDeInscripciones = null;
		 try {
	            // En esta primera línea definimos el archivos que va a ingresar
	            listaDeInscripciones = new CsvToBeanBuilder(new FileReader(this.rutaArchivoInscripciones))
	 // con esta configuración podemos skipear la primera línea de nuestro archivo CSV
                         .withSkipLines(1)
    // con esta configuración podemos elegir cual es el caracter que vamos a usar para delimitar
	                    .withSeparator(';')
   // Es necesario definir el tipo de dato que va a generar el objeto que estamos queriendo parsear a partir del CSV
	                    .withType(ArchivoInscripciones.class)
	                    .build()
	                    .parse();

	        } catch (IOException e) {
	        e.printStackTrace();
	    }
		 
		 this.LineasArchivosInscripciones = listaDeInscripciones;
				
	}
	
	     public ArrayList<Inscripcion> listarInscripciones(Collection<Materia> materias, Collection <Alumno> alumnos){
	    	boolean InscripcionYaCargada = false;
	    	ArrayList<Inscripcion> inscripciones = new ArrayList<Inscripcion>();
	    	for(ArchivoInscripciones lineaArchivoinscripciones : this.LineasArchivosInscripciones) {
	    		InscripcionYaCargada = false;
	    		Alumno alumnoNuevo = null;
	    		Materia materiaNuevo = null;
	    		
	    		// coleccion alumnos
	    		
	    	for(Alumno alumno : alumnos) {
	    		if(alumno.getNombre().equals(lineaArchivoinscripciones.getNombreAlumno())) {
	    			alumnoNuevo = alumno;
	    		}
	    	}
	    	
	    	   // coleccion materias
	    	
	    	for(Materia materia : materias) {
	    		if(materia.getNombre().equals(lineaArchivoinscripciones.getMateria())) {
	    			materiaNuevo = materia;
	    		}
	    	}
	    	Inscripcion nuevaInscripcion = new Inscripcion(alumnoNuevo, materiaNuevo, lineaArchivoinscripciones.getFechaDeInscripcion());
	    	
	    	for (Inscripcion inscripcionGuardada : inscripciones ) {
	    		if(inscripcionGuardada.equals(nuevaInscripcion)) {
	    			InscripcionYaCargada = true;
	    			break;
	    		}
	    	}
	    	
	    	if(!InscripcionYaCargada) {
	    	    inscripciones.add(nuevaInscripcion);
	    	}
	    	
	    	} //fuera del for
	    	
	    	return inscripciones;
	     }
	 	     
	     
}
