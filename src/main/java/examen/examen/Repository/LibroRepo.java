package examen.examen.Repository;

import examen.examen.Model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepo extends JpaRepository<Libro, Long> {

}
