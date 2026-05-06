package modelo;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String titulo;
    @ManyToMany
    private List<Autor> autores = new ArrayList<>();
    private int anyoPublicacion;
    private String genero;
    private double precio;
    private int ejemplaresDisponibles;

    public Libro(String titulo, int anyoPublicacion, String genero, double precio, int ejemplaresDisponibles) {
        this.titulo = titulo;
        this.anyoPublicacion = anyoPublicacion;
        this.genero = genero;
        this.precio = precio;
        this.ejemplaresDisponibles = ejemplaresDisponibles;
    }

    public Libro() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public int getAnyoPublicacion() {
        return anyoPublicacion;
    }

    public void setAnyoPublicacion(int anyoPublicacion) {
        this.anyoPublicacion = anyoPublicacion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getEjemplaresDisponibles() {
        return ejemplaresDisponibles;
    }

    public void setEjemplaresDisponibles(int ejemplaresDisponibles) {
        this.ejemplaresDisponibles = ejemplaresDisponibles;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", anyoPublicacion=" + anyoPublicacion +
                ", genero='" + genero + '\'' +
                ", precio=" + precio +
                ", ejemplaresDisponibles=" + ejemplaresDisponibles +
                '}';
    }
}
