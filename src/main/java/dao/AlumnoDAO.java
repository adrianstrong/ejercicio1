package dao;

import org.example.ObjectDBUtil;
import models.Alumno;

import javax.persistence.TypedQuery;
import java.util.ArrayList;

public class AlumnoDAO {

    public void insertarAlumno(Alumno alumno){
        if(alumno== null) return;
        try{
            var em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
            em.getTransaction().begin();
            em.persist(alumno);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e){
            System.out.println("Error al añadir pedido: " + e.getMessage());
        }

    }

    public void listarTodo() {
        ArrayList<Alumno> salida;
        var em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        TypedQuery<Alumno> q = em.createQuery("SELECT alumno from Alumno alumno", Alumno.class);
        salida = (ArrayList<Alumno>) q.getResultList();
        salida.forEach(alumno -> {
            System.out.println(alumno.getNombre() + " " + alumno.getAd() + " " + alumno.getDi());
        });
    }

    public void listarSuspensos() {
        ArrayList<Alumno> salida;
        var em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        TypedQuery<Alumno> q = em.createQuery("SELECT alumno from Alumno alumno WHERE alumno.ad < 5.0 OR alumno.di < 5.0", Alumno.class);
        salida = (ArrayList<Alumno>) q.getResultList();
        System.out.println(salida);
    }


    public void estadisticas(){
        var em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        TypedQuery<Double> q = em.createQuery("SELECT alumno.ad from Alumno alumno", Double.class);
        TypedQuery<Double> q2 = em.createQuery("SELECT alumno.di from Alumno alumno", Double.class);
        TypedQuery<Alumno> todos = em.createQuery("SELECT alumno from Alumno alumno", Alumno.class);


        double sum = q.getResultList().stream()
                .mapToDouble(a -> a)
                .sum();

        double sum2 = q.getResultList().stream()
                .mapToDouble(a -> a)
                .sum();

        int aprobados = 0;

        for (Alumno alumno : todos.getResultList()) {
            if (alumno.getAd() > 5 ||alumno.getDi() > 5) {
                aprobados++;
            }
        }

        double adMedia = sum / q.getResultList().size();
        double diMedia = sum2 / q2.getResultList().size();
        double mediaAprobados = aprobados / Double.parseDouble(String.valueOf(todos.getResultList().size()));
        System.out.println("Nota media de AD: " + adMedia);
        System.out.println("Nota media de DI: " + diMedia);
        System.out.println("Ratio aprobados: " + mediaAprobados);

    }

}
