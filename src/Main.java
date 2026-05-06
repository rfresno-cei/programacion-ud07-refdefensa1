import dao.LibroDAO;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import modelo.Libro;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pruebas.odb");
        LibroDAO dao = new LibroDAO(emf);
        //dao.insertarLibro(new Libro("Kpi y la luna de chocolate", "Java F", "192731987", 2027, "Terror", 69.67, 0, true));
        //dao.borrarLibro(11);
        System.out.println(dao.obtenerLibro(10));
        System.out.println(dao.obtenerLibros());
        System.out.println(dao.obtenerLibrosGenero("Infantil"));
        System.out.println(dao.obtenerLibrosMenos3());
        System.out.println(dao.obtenerLibrosAPartir2000());
        System.out.println(dao.obtenerLibrosAutor("in"));
        System.out.println(dao.obtenerLibrosMasCaros());
        System.out.println(dao.obtenerTotalLibros());
        System.out.println(dao.obtenerMediaPrecio());
        System.out.println(dao.obtenerMasAntiguo());
        System.out.println(dao.obtenerGruposGeneros());
        System.out.println(dao.obtenerPreciosGeneros());
        System.out.println(dao.obtenerGenerosMuchos());
        emf.close();
    }
}