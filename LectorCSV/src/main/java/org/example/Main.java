package org.example;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;
import modelo.LectorDeArchivos;
import modelo.Materia;
import modelo.Alumno;
import modelo.Inscripcion;
import modelo.ArchivoInscripciones;

public class Main {
    public static void main(String[] args) {
        //En la variable args va a viajar la ruta del archivo que queremos que abra el programa
        if(args.length == 0){
            System.out.println("ERROR: No ingresaste ningún archivo como argumento!");
            System.exit(88);
        }

        LectorDeArchivos lectorDeArchivos = new LectorDeArchivos(args[0]);
        lectorDeArchivos.parsearArchivo();
        
        Materia programacionI = new Materia("Programacion I");
        Materia programacionII = new Materia("Programacion II");
        Materia programacionIII = new Materia("Programacion III");
        Materia baseDeDatos = new Materia("Base de Datos");
        
        //Agregamos Correlativas
        programacionII.agregarMateriaCorrelativa(programacionI);
        programacionIII.agregarMateriaCorrelativa(programacionII);
        baseDeDatos.agregarMateriaCorrelativa(programacionII);
        
        Collection<Materia> materias = new ArrayList<Materia>();
        materias.add(baseDeDatos);
        materias.add(programacionI);
        materias.add(programacionII);
        materias.add(programacionIII);
        
        Alumno alumnojose = new Alumno ("Jose Rodriguez", " FE1234");
        Alumno alumnoSosa = new Alumno ("Vanesa Sosa", " FE1264");
        Alumno alumnoPerez = new Alumno ("Lucia Perez", " FE1235");
        
        alumnoSosa.agregarMateriasAprobadas(programacionI);
        alumnoSosa.agregarMateriasAprobadas(programacionII);
        alumnoPerez.agregarMateriasAprobadas(programacionI);
        
        Collection <Alumno> alumnos = new ArrayList <Alumno>();
        
        alumnos.add(alumnojose);
        alumnos.add(alumnoSosa);
        alumnos.add(alumnojose);
        
        ArrayList<Inscripcion> inscripciones = lectorDeArchivos.listarInscripciones(materias, alumnos);
        
        for(Inscripcion inscripcion : inscripciones) {
        	System.out.println(inscripcion.getAlumno().getNombre() + " " + inscripcion.getMateria().getNombre()+ " " + inscripcion.aprobada());
        }
}
}