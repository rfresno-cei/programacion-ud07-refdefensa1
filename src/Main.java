import dao.AutorDAO;
import dao.LibroDAO;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import modelo.Autor;
import modelo.Libro;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pruebas.odb");
        LibroDAO dao = new LibroDAO(emf);
        AutorDAO daoa = new AutorDAO(emf);
        //dao.insertarLibro(new Libro("Fin", 2026, "Terror", 6.7, 67));
        //daoa.insertarAutor(new Autor("Diego", "El CEI", 2002));
        //daoa.insertarAutor(new Autor("Jake", "Ohhhhh", 2000));
        //dao.asignarAutorALibro(20, 19);
        //dao.asignarAutorALibro(21, 19);
        //System.out.println(dao.obtenerAutores(19));
        System.out.println(daoa.obtenerLibros(20));
        emf.close();
    }
}