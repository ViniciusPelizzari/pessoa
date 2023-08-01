package com.firstproject.projectbf.controllers;

import com.firstproject.projectbf.entities.Pessoa;
import com.firstproject.projectbf.repositories.PessoaRepositories;
import com.firstproject.projectbf.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
//@Controller - se usar este, necessita colocar @ResponsyBody sobre todos os métodos
//@RequestMapping(value = "/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private PessoaRepositories pessoaRepositories;

    @RequestMapping("/form") //@GetMapping("/form")
    public String exibirFormulario(Model model) {
        model.addAttribute("pessoa", new Pessoa());
        return "formulario";
    }

    @PostMapping("/criar-pessoa")
    public String criarPessoa(@ModelAttribute Pessoa pessoa) {
        pessoaService.criarPessoa(pessoa);
        return "redirect:/sucesso";
    }

    @GetMapping("/sucesso")
    public String exibirPaginaSucesso() {
        return "sucesso";
    }

    @RequestMapping(value = "/excluir-pessoa", method = RequestMethod.POST)
    public String excluirPessoa(@RequestParam Pessoa id) {
        pessoaService.excluirPessoa(id);
        return "redirect:/todas-pessoas";
    }

    @RequestMapping("/todas-pessoas")
    public String buscarTodasPessoas(Model model) {
        List<Pessoa> todasPessoas = pessoaRepositories.findAll();
        model.addAttribute("pessoas", todasPessoas);
        return "resultado";
    }

    @GetMapping("/pessoas-por-nome")
    public String buscarPessoasPorNome(@RequestParam("nome") String nome, Model model) {
        List<Pessoa> pessoasEncontradas = pessoaService.buscarPessoasPorNome(nome);
        model.addAttribute("pessoas", pessoasEncontradas);
        return "resultado";
    }

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }
}
