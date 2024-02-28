package examen.examen.Controller;

import examen.examen.Model.Libro;
import examen.examen.Service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
@CrossOrigin(origins = "http://localhost:5173")
public class LibroController {
    @Autowired
    LibroService libroService;

    @PostMapping("/")
    public Libro addLibro(@RequestBody Libro libro) {
        return libroService.saveLibro(libro);
    }

    @GetMapping("/")
    public List<Libro> getLibros(){
        return libroService.getAll();
    }

    @PutMapping("/{id}")
    public Libro updateLibro(@PathVariable Long id, @RequestBody Libro updatedLibro) {
        return libroService.updateLibro(id, updatedLibro);
    }

    // Delete a libro by ID
    @DeleteMapping("/{id}")
    public void deleteLibro(@PathVariable Long id) {
        libroService.deleteLibro(id);
    }
}
