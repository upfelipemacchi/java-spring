package com.example.demo.controllers;

import java.util.concurrent.atomic.AtomicLong;

import com.example.demo.domain.Pessoa;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CadastroController {

    @GetMapping("/listar")
	public String listar(@RequestParam(value="nome", defaultValue="Mundo") String nome) {
		return String.format("Olá %s", nome);
	}

    private final AtomicLong idGenerator = new AtomicLong();
    
    @GetMapping("/listarPessoa")
	public Pessoa listarPessoa(@RequestParam(value="nome", defaultValue="Nome não informado") String nome) {
		return new Pessoa(idGenerator.incrementAndGet(), nome);
	}

}
