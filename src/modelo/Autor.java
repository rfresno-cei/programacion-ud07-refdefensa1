package modelo;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nombre;
    private String nacionalidad;
    private int anyoNacimiento;
    @ManyToMany(mappedBy = "autores")
    private List<Libro> libros = new ArrayList<>();

    public Autor(String nombre, String nacionalidad, int anyoNacimiento) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.anyoNacimiento = anyoNacimiento;
    }

    public Autor() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public int getAnyoNacimiento() {
        return anyoNacimiento;
    }

    public void setAnyoNacimiento(int anyoNacimiento) {
        this.anyoNacimiento = anyoNacimiento;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", anyoNacimiento=" + anyoNacimiento +
                '}';
    }
}
