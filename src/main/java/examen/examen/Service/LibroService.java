package examen.examen.Service;

import examen.examen.Model.Libro;
import examen.examen.Repository.LibroRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    @Autowired
    LibroRepo libroRepo;

    public List<Libro> getAll(){
        return libroRepo.findAll();
    }

    public Libro saveLibro(Libro libro){
        return libroRepo.save(libro);
    }
    public Libro updateLibro(Long id, Libro updatedLibro) {
        // Check if the libro with the given id exists
        Libro existingLibro = libroRepo.findById(id).orElse(null);

        if (existingLibro != null) {
            // Update the existingLibro with the new values
            existingLibro.setNombre(updatedLibro.getNombre());
            existingLibro.setAutor(updatedLibro.getAutor());
            // ... other properties ...

            // Save the updatedLibro
            return libroRepo.save(existingLibro);
        } else {
            // Handle the case where the libro with the given id is not found
            // You can throw an exception or return null, depending on your use case
            return null;
        }
    }
    public void deleteLibro(Long id) {
        // Check if the libro with the given id exists
        Libro existingLibro = libroRepo.findById(id).orElse(null);

        if (existingLibro != null) {
            // Delete the libro if it exists
            libroRepo.deleteById(id);
        }
    }

    public Optional<Libro> getLibrosOrderedByPublishDate() {
        return libroRepo.findAllByOrderByCreatedAtDesc();
    }


}
