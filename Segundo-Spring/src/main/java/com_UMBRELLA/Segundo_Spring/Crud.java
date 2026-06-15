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
    public List<Pessoa> pessoas = new ArrayList<>(); 

    @GetMapping("/lista")
    public List<Pessoa> lista() {

        return pessoas;
    }

    @PostMapping("/cadastrar")
    public Pessoa cadastrar(@RequestBody Pessoa pessoa) {

        pessoas.add(pessoa);

        return pessoa;
    }

    @PutMapping("/atualizar")
    public Pessoa atualizar(@RequestBody Pessoa pessoa) {
        return pessoa;
    }

    @DeleteMapping("/deletar/{indice}")
    public String deletar(@PathVariable int indice) {

        if (indice < 0 || indice >= pessoas.size()) {
            return "Pessoa não encontrada. ";
        }

        pessoas.remove(indice);

        return "Usuário deletado com sucesso.";
    }


    @GetMapping("/quantidade")
    public String quantidade() {

        return "Quantidade: " + pessoas.size();

    }

    @GetMapping("/buscar/{indice}")
    public Pessoa busca(@PathVariable int indice) {

        return pessoas.get(indice);

    }


}
