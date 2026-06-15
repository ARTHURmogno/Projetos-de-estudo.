package com_UMBRELLA.Segundo_Spring;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com_UMBRELLA.Segundo_Spring.Pessoa;

@RestController
public class Crud {

    @GetMapping("/crud")
    public String crud() {
        return "Olá," + "Arthur";
    }

    @PostMapping("/cadastrar")
    public Pessoa pessoa(@RequestBody Pessoa pessoa) {
        return pessoa;
    }

    @PutMapping("/atualizar")
    public Pessoa atualizar(@RequestBody Pessoa pessoa) {
        return pessoa;
    }

    @DeleteMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        return "Usuário: " + id + "removido.";
    }

    @GetMapping("/deleta/{id}")
    public String deleta(@PathVariable Long id) {
        return "Usuário: " + id + "removido.";
    }

}
