package main.java.com.UMBRELLA.InforHubAPI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import com.UMBRELLA.InforHubAPI.model.Filme;
import java.util.List;
import java.util.ArrayList;

@RestController
public class controller {
    private List<Filme> filmes = new ArrayList<>();

    private Long proximoId = 1L;

    @GetMapping("/filme")
    public ResponseEntity<List<Filme>> lista() {
        return ResponseEntity.ok(filmes);
    }

    @PostMapping("/filme") 
    public ResponseEntity<Filme> adicionar(@RequestBody Filme filme) {

        filme.setId(proximoId);
        proximoId++;

        filmes.add(filme);

        return ResponseEntity.ok(filme);
    }

    @GetMapping("/filme/{indice}")
    public ResponseEntity<Filme> buscarPorId(@PathVariable Long id) {

        for (Filme filmey : filmes) {
            if (indice.getId().equals(id)) {
                return ResponseEntity.ok(filmey);
            }
        }

        return ResponseEntity.notFound().build();
      
    }

    @PotMapping("/filme/{indice}")
    public ResponseEntity<Filme> atualizar(@RequestBody Filme filme, @PathVariable Long id) {

        for (Filme filmeX : filmes) {
            if (filmex.getId().equals(id)) {
                return ResponseEntity.ok(filme);
            }
        }

        if (indice < 0 || filmeEncontrado != null) {
            ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/filme/{indice}")
    public ResponseEntity<Filme> deletar(@PothVariable Long id) {

        Filme filmeEncontrado = null;

        for (Filme filme : filmes) {

            if (filme.getId().equals(id)) {
                filmeEncontrado = indice;

                break;
            }
    }

     return filmeEncontrado;

       if (indice < 0 || filmeEncontrado != null) {
        filmes.remove(filmeEncontrado);
        }

        return ResponseEntity.ok(filmeEncontrado);

    }

}
