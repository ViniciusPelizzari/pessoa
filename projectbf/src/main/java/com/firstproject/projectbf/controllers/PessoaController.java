package com.firstproject.projectbf.controllers;

import com.firstproject.projectbf.entities.Pessoa;
import com.firstproject.projectbf.repositories.PessoaRepositories;
import com.firstproject.projectbf.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@Controller - se usar este, necessita colocar @ResponsyBody sobre todos os métodos
@RequestMapping(value = "/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private PessoaRepositories pessoaRepositories;

    @GetMapping("/form")
    public String exibirFormulario(Model model) {
        model.addAttribute("pessoa", new Pessoa());
        return "formulario"; // "formulario" é o nome do template (página HTML) que contém o formulário
    }

    @PostMapping("/criar-pessoa")
    public String criarPessoa(@ModelAttribute Pessoa pessoa) {
        pessoaService.criarPessoa(pessoa);
        return "redirect:/form/teste";
    }

    @PostMapping("/excluir-pessoa")
    public String excluirPessoa(@ModelAttribute Pessoa pessoa) {
        pessoaService.excluirPessoa(pessoa);
        return "redirect:/form";
    }

    @GetMapping("/todas-pessoas")
    public String buscarTodasPessoas(Pessoa pessoa, Model model) {
        String nome = pessoa.getNome();
        List<Pessoa> pessoasEncontradas = pessoaRepositories.findByNome(nome);
        model.addAttribute("pessoas", pessoasEncontradas);
        return "resultado"; // Supondo que "resultado" é o nome do arquivo HTML (template) que exibe os resultados da busca.
    }

    //daqui pra baixo da erro no postman
    @GetMapping("/pessoas-por-nome")
    public String buscarPessoasPorNome(@RequestParam String nome, Model model) {
        List<Pessoa> pessoasEncontradas = pessoaService.buscarPessoasPorNome(nome);
        model.addAttribute("pessoas", pessoasEncontradas);
        return "resultado"; // Supondo que "page" é o nome do arquivo HTML (template) que exibe os resultados da busca.
    }

    @GetMapping("/pessoas-salario")
    public String buscarPessoasComSalarioMaiorQue(@RequestParam double salario, Model model) {
        List<Pessoa> pessoasEncontradas = pessoaService.buscarPessoasComSalarioMaiorQue(salario);
        model.addAttribute("pessoas", pessoasEncontradas);
        return "resultado"; // Supondo que "page" é o nome do arquivo HTML (template) que exibe os resultados da busca.
    }

    @GetMapping("/pessoas-por-idade")
    public String buscarPessoasPorIdade(@RequestParam int idade, Model model) {
        List<Pessoa> pessoasEncontradas = pessoaService.buscarPessoasPorIdade(idade);
        model.addAttribute("pessoas", pessoasEncontradas);
        return "resultado"; // Supondo que "resultado" é o nome do arquivo HTML (template) que exibe os resultados da busca.
    }
}
