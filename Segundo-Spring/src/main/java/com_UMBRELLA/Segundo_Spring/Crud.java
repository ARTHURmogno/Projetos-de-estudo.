package com_UMBRELLA.Segundo_Spring;

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

    @PutMapping("/atualizar")
    public Pessoa atualizar(@RequestBody Pessoa pessoa) {
        return pessoa;
    }

    @DeleteMapping("/deletar/{id}")
    public Pessoa deletar(@PathVariable Long id) {

        Pessoa pessoaEncontrada = null;

        for (Pessoa pessoa : pessoas) {
            if (pessoa.getId().equals(id)) {
                pessoaEncontrada = pessoa;
                break;
            }
        }

        if (pessoaEncontrada != null) {
            pessoas.remove(pessoaEncontrada);
        }

        return pessoaEncontrada;

    }






    @GetMapping("/quantidade")
    public String quantidade() {

        return "Quantidade: " + pessoas.size();

    }

    @GetMapping("/buscar/{id}")
    public Pessoa busca(@PathVariable Long id) {

        for (Pessoa pessoa : pessoas) {
            if (pessoa.getId().equals(id)) {
                return pessoa;
            }
        }

        return null;

    }


}
