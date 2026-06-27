package main.java.com.UMBRELLA.inforHub_API.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class controllerTeste {
    @GetMapping("/teste")
    public String teste() {
        return "Funcionou!";
    }
}
