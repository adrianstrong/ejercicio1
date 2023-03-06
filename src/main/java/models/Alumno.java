package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Alumno {
    @Id
    @GeneratedValue
    private Integer id;
    private String nombre;
    private String telefono;
    private String email;
    private Double ad;
    private Double di;

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", ad=" + ad +
                ", di=" + di +
                '}';
    }

}

