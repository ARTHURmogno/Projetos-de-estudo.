package com_UMBRELLA.Segundo_Spring;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.ArrayList;
import com_UMBRELLA.Segundo_Spring.Pessoa;

@RestController
public class Crud {

    @Autowired
     private PessoaRepository repository;

    @PostMapping("/cadastrar")
    public Pessoa cadastrar(@RequestBody Pessoa pessoa) {
         return repository.save(pessoa);
    }

    @GetMapping("/lista")
    public List<Pessoa> lista() {

        return repository.findAll();

    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Pessoa> atualizar(@PathVariable Long id, @RequestBody Pessoa pessoaAtualizada) {

        return repository.findById(id)
            .map(pessoa -> {
                pessoa.setNome(pessoaAtualizada.getNome());
                pessoa.setIdade(pessoaAtualizada.getIdade());
                pessoa.setProfissao(pessoaAtualizada.getProfissao());

                repository.save(pessoa);
                return ResponseEntity.ok(pessoa);

            })
            .orElse(ResponseEntity.notFound().build());

    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Pessoa> deletar(@PathVariable Long id) {

        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);

        return ResponseEntity.noContent().build();

    }






    @GetMapping("/quantidade")
    public String quantidade() {

        return "Quantidade: " + repository.count();

    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Pessoa> busca(@PathVariable Long id) {

        return repository.findById(id)
               .map(ResponseEntity::ok)
               .orElse(ResponseEntity.notFound().build());

    }


}
