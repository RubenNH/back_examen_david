package examen.examen.Repository;

import examen.examen.Model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LibroRepo extends JpaRepository<Libro, Long> {

    Optional<Libro> findAllByOrderByCreatedAtDesc();

    Optional<Libro> findAllByOrderByAutorDesc();


}
