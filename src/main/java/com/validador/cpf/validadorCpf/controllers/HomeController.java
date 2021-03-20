package com.validador.cpf.validadorCpf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.validador.cpf.validadorCpf.models.Cliente;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "home/index";
    }

    @GetMapping("/valida-cpf")
    public String validaCpf(Cliente cliente, Model model) { // injeção de dependência
        boolean verdade = cliente.validaCPF();
        model.addAttribute("verdade", verdade);
        return "home/cpfValidado";
    }
}
