package com.firstproject.projectbf.controllers;

import com.firstproject.projectbf.entities.Pessoa;
import com.firstproject.projectbf.repositories.PessoaRepositories;
import com.firstproject.projectbf.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//Controlador responsável por lidar com as requisições relacionadas a pessoas.
@Controller
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private PessoaRepositories pessoaRepositories;

    /**
     * Exibe o formulário para cadastro de uma nova pessoa.
     *
     * @param model É utilizado para enviar atributos para a page.
     * @return A página do formulário.
     */
    @RequestMapping("/form")
    public String exibirFormulario(Model model) {
        model.addAttribute("pessoa", new Pessoa());
        return "formulario";
    }

    /**
     * Cria uma nova pessoa com os dados fornecidos e redireciona para a página de sucesso.
     *
     * @param pessoa Passa os dados da pessoa a serem cadastrados.
     * @return A página de sucesso.
     */
    @PostMapping("/criar-pessoa")
    public String criarPessoa(@ModelAttribute Pessoa pessoa) {
        pessoaService.criarPessoa(pessoa);
        return "redirect:/sucesso";
    }

    /**
     * Exibe a página de sucesso.
     *
     * @return A página de sucesso.
     */
    @GetMapping("/sucesso")
    public String paginaSucesso() {
        return "sucesso";
    }

    /**
     * Exclui a pessoa com o ID fornecido e redireciona para a página de todas as pessoas.
     *
     * @param id O ID da pessoa a ser excluída.
     * @return A página de resultado exibindo todas as pessoas.
     */
    @RequestMapping(value = "/excluir-pessoa", method = RequestMethod.POST)
    public String excluirPessoa(@RequestParam Pessoa id) {
        pessoaService.excluirPessoa(id);
        return "redirect:/todas-pessoas";
    }

    /**
     * Busca todas as pessoas e as exibe na página.
     *
     * @param model é utilizado para enviar atributos para a page.
     * @return A página de resultado exibindo todas as pessoas.
     */
    @RequestMapping("/todas-pessoas")
    public String buscarTodasPessoas(Model model) {
        List<Pessoa> todasPessoas = pessoaRepositories.findAll();
        model.addAttribute("pessoas", todasPessoas);
        return "resultado";
    }

    /**
     * Busca pessoas por nome e as exibe na página.
     *
     * @param nome  Nome a ser pesquisado.
     * @param model É utilizado para enviar atributos para a page.
     * @return A página de resultado da busca por nome.
     */
    @GetMapping("/pessoas-por-nome")
    public String buscarPessoasPorNome(@RequestParam("nome") String nome, Model model) {
        List<Pessoa> pessoasEncontradas = pessoaService.buscarPessoasPorNome(nome);
        model.addAttribute("pessoas", pessoasEncontradas);
        return "resultado";
    }

    /**
     * Exibe a página inicial.
     * Não está sendo usado.
     *
     * @return O nome da página inicial.
     */
    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }
}
