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
import java.util.List;
import java.util.ArrayList;
import com_UMBRELLA.Segundo_Spring.Pessoa;

@RestController
public class Crud {
    private List<Pessoa> pessoas = new ArrayList<>(); 
    private Long proximoId = 1L;

    @GetMapping("/lista")
    public List<Pessoa> lista() {

        return pessoas;
    }

    @PostMapping("/cadastrar")
    public Pessoa cadastrar(@RequestBody Pessoa pessoa) {

        pessoa.setId(proximoId);
        proximoId++;

        pessoas.add(pessoa);

        return pessoa;
    }

    @PutMapping("/atualizar/{id}")
    public Pessoa atualizar(@PathVariable Long id, @RequestBody Pessoa pessoaAtualizada) {

        for (Pessoa pessoa : pessoas) {
            if (pessoa.getId().equals(id)) {
            pessoa.setNome(pessoaAtualizada.getNome());
            pessoa.setIdade(pessoaAtualizada.getIdade());
            pessoa.setProfissao(pessoaAtualizada.getProfissao());

            return pessoa;

            }
        }

        return null;

    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Pessoa> deletar(@PathVariable Long id) {

        Pessoa pessoaEncontrada = null;

        for (Pessoa pessoa : pessoas) {
            if (pessoa.getId().equals(id)) {
                pessoaEncontrada = pessoa;
                break;
            }
        }

        if (pessoaEncontrada == null) {
            ResponseEntity.notFound().build();
        }

         pessoas.remove(pessoaEncontrada);

        return ResponseEntity.ok(pessoaEncontrada);

    }






    @GetMapping("/quantidade")
    public String quantidade() {

        return "Quantidade: " + pessoas.size();

    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Pessoa> busca(@PathVariable Long id) {

        for (Pessoa pessoa : pessoas) {
            if (pessoa.getId().equals(id)) {
                return ResponseEntity.ok(pessoa);
            }
        }

        return ResponseEntity.notFound().build();

    }


}
