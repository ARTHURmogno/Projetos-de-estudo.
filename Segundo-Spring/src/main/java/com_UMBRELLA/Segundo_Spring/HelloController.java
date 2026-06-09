package com_UMBRELLA.Segundo_Spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "Olá, Arthur!";
    }

    @GetMapping("/saudacao")
    public String saudacao() {
        return "Bem-vindo ao Spring boot!";
    }

    @GetMapping("/saudar/{nome}")
    public String saudar(@PathVariable String nome) {
        return "Olá, " + nome;
    }

    @GetMapping("/calcular/{valor01}/{valor02}")
    public String calcular(@PathVariable int valor01, @PathVariable int valor02) {
        int resultado = valor01 + valor02;

        return "A soma é: " + resultado;
    }

    @GetMapping("/somar")
    public String somar(@RequestParam int numero01, @RequestParam int numero02) {
        int resultado = numero01 + numero02;

        return "Resultodo: " + resultado;
    }

    @GetMapping("/ola")
    public String ola(@RequestParam(defaultValue = "Visitante") String nome) {

        return "Olá, " + nome + "!";
    }

    @GetMapping("/calculadora")
    public String calculadora(@RequestParam int numero01, @RequestParam int numero02) {
        int soma = numero01 + numero02;
        int subtracao = numero01 - numero02;
        int multiplicacao = numero01 * numero02;

        String divisao;

        if (numero02 == 0) {
            divisao = "Não é possivel dividir por zero";
        } else {
            divisao = String.valueOf(numero01 / numero02);
        }

        return String.format("Resultado: Soma: %d | Subtração: %d | Multiplicação: %d | Divisçao: %s \n"
        , soma, subtracao, multiplicacao, divisao);
    }
    
}
