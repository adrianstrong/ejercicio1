package org.example;

import dao.AlumnoDAO;
import models.Alumno;

public class Main {
    public static void main(String[] args) {

        AlumnoDAO alumnoDAO = new AlumnoDAO();
/*        alumnoDAO.insertarAlumno(new Alumno(1,"Adrian", "66666", "hola@example.com", 5.0 ,9.0));
        alumnoDAO.insertarAlumno(new Alumno(2,"Pedro", "66666", "hola@example.com", 4.0 ,3.0));
        alumnoDAO.insertarAlumno(new Alumno(3,"Luis", "66666", "hola@example.com", 6.0 ,2.0));
        alumnoDAO.insertarAlumno(new Alumno(4,"Francisco", "66666", "hola@example.com", 7.0 ,7.0));
        alumnoDAO.insertarAlumno(new Alumno(5,"Antonio", "66666", "hola@example.com", 7.0 ,8.0));
        alumnoDAO.insertarAlumno(new Alumno(6,"Jaime", "66666", "hola@example.com", 1.0 ,3.0));
        alumnoDAO.insertarAlumno(new Alumno(7,"Daniel", "66666", "hola@example.com", 6.0 ,6.0));
        alumnoDAO.insertarAlumno(new Alumno(8,"Jorge", "66666", "hola@example.com", 6.0 ,6.0));*/

        //hola
        alumnoDAO.listarTodo();
        alumnoDAO.listarSuspensos();
        alumnoDAO.estadisticas();

    }
}