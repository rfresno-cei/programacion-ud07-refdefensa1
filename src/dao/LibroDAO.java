package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import modelo.Libro;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibroDAO {
    EntityManagerFactory emf;

    public LibroDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void insertarLibro(Libro libro) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(libro);
        em.getTransaction().commit();
        em.close();
    }

    public void borrarLibro(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Libro libro = em.find(Libro.class, id);
        if (libro != null) {
            em.remove(libro);
        }
        em.getTransaction().commit();
        em.close();
    }

    public Libro obtenerLibro(int id) {
        EntityManager em = emf.createEntityManager();
        Libro libro = em.find(Libro.class, id);
        em.close();
        return libro;
    }

    public List<Libro> obtenerLibros() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Libro> query = em.createQuery("select l from Libro l", Libro.class);
        List<Libro> libros = query.getResultList();
        em.close();
        return libros;
    }

    public List<Libro> obtenerLibrosGenero(String genero) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Libro> query = em.createQuery("select l from Libro l where l.genero = :genero", Libro.class);
        query.setParameter("genero", genero);
        List<Libro> libros = query.getResultList();
        em.close();
        return libros;
    }

    public List<Libro> obtenerLibrosMenos3() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Libro> query = em.createQuery("select l from Libro l where l.ejemplaresDisponibles < 3", Libro.class);
        List<Libro> libros = query.getResultList();
        em.close();
        return libros;
    }

    public List<Libro> obtenerLibrosAPartir2000() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Libro> query = em.createQuery("select l from Libro l where l.anyoPublicacion >= 2000", Libro.class);
        List<Libro> libros = query.getResultList();
        em.close();
        return libros;
    }

    public List<Libro> obtenerLibrosAutor(String texto) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Libro> query = em.createQuery("select l from Libro l where l.autor like :texto", Libro.class);
        query.setParameter("texto", "%" + texto + "%");
        List<Libro> libros = query.getResultList();
        em.close();
        return libros;
    }

    public List<Libro> obtenerLibrosMasCaros() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Libro> query = em.createQuery("select l from Libro l order by l.precio desc", Libro.class);
        query.setMaxResults(5);
        List<Libro> libros = query.getResultList();
        em.close();
        return libros;
    }

    public long obtenerTotalLibros() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Long> query = em.createQuery("select count(l) from Libro l", Long.class);
        long total = query.getSingleResult();
        em.close();
        return total;
    }

    public double obtenerMediaPrecio() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Double> query = em.createQuery("select avg(l.precio) from Libro l", Double.class);
        double media = query.getSingleResult();
        em.close();
        return media;
    }

    public Libro obtenerMasAntiguo() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Libro> query = em.createQuery("select l from Libro l order by l.anyoPublicacion asc", Libro.class);
        query.setMaxResults(1);
        Libro libro = query.getSingleResult();
        em.close();
        return libro;
    }

    public Map<String, Long> obtenerGruposGeneros() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Object[]> query = em.createQuery("select l.genero, count(l) from Libro l group by l.genero", Object[].class);
        List<Object[]> grupos = query.getResultList();
        Map<String, Long> res = new HashMap<>();
        for (Object[] grupo : grupos) {
            String genero = (String) grupo[0];
            Long num = (Long) grupo[1];
            res.put(genero, num);
        }
        em.close();
        return res;
    }

    public Map<String, Double> obtenerPreciosGeneros() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Object[]> query = em.createQuery("select l.genero, avg(l.precio) from Libro l group by l.genero", Object[].class);
        List<Object[]> grupos = query.getResultList();
        Map<String, Double> res = new HashMap<>();
        for (Object[] grupo : grupos) {
            String genero = (String) grupo[0];
            Double num = (Double) grupo[1];
            res.put(genero, num);
        }
        em.close();
        return res;
    }

    public List<String> obtenerGenerosMuchos() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<String> query = em.createQuery("select l.genero from Libro l group by l.genero having sum(l.ejemplaresDisponibles) > 100", String.class);
        List<String> res = query.getResultList();
        em.close();
        return res;
    }
}
