package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import modelo.Autor;
import modelo.Libro;

import java.util.List;

public class AutorDAO {
    private EntityManagerFactory emf;

    public AutorDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void insertarAutor(Autor autor) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(autor);
        em.getTransaction().commit();
        em.close();
    }

    public List<Libro> obtenerLibros(int id) {
        EntityManager em = emf.createEntityManager();
        Autor autor = em.find(Autor.class, id);
        List<Libro> libros = autor.getLibros();
        libros.toString();
        em.close();
        return libros;
    }
}
