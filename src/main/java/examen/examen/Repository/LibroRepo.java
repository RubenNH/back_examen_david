package examen.examen.Repository;

import examen.examen.Model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LibroRepo extends JpaRepository<Libro, Long> {

    Optional<Libro> findAllByOrderByCreatedAtDesc();

    Optional<Libro> findAllByOrderByAutorDesc();

    @Query("SELECT l FROM Libro l WHERE l.imagen IS NOT NULL AND l.imagen <> '' ORDER BY l.imagen DESC")
    Optional<Libro> findAllByImagenIsNotNullOrderByImagenDesc();
}
