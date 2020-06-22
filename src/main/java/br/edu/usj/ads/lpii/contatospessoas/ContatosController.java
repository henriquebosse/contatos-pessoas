package br.edu.usj.ads.lpii.contatospessoas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ContatosController {
    
    @Autowired
    ContatosRepository contatosRepository;

    @GetMapping(value="/")
    public ModelAndView getListar() {
        //Irá listar todos os contatos
        List<Contatos> lista = contatosRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("lista", lista);
        return modelAndView;
    }

    @GetMapping(value="/exibir/{id}")
    public ModelAndView getExibir(@PathVariable long id) {
        // Irá exibir os contatos de determinado ID
        Contatos contatos = contatosRepository.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("exibir");
        modelAndView.addObject("contatos", contatos);
        return modelAndView;
    }
    
    @GetMapping(value="/cadastrar")
    public ModelAndView getCadastrar() {
        // Retorna o Formulário para o Usuário Preencher
        Contatos contatos = new Contatos();
        ModelAndView modelAndView = new ModelAndView("cadastrar");
        modelAndView.addObject("contatos", contatos);
        return modelAndView;
    }

    @PostMapping(value="/cadastrar")
    public ModelAndView postCadastrar(Contatos contatos) {
        //recebe as informações do contato preenchido no formulário e grava no Banco
        contatosRepository.save(contatos);
        ModelAndView modelAndView = new ModelAndView("exibir");
        modelAndView.addObject("contatos", contatos);

        return modelAndView;
    }
    
    @GetMapping(value="/deletar/{id}")
    public ModelAndView getDeletar(@PathVariable long id) {
        // Remove o Contato selecionado
        contatosRepository.deleteById(id);

        List<Contatos> lista = contatosRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("index");        
        modelAndView.addObject("lista", lista);
        return modelAndView;
    }
    
    @GetMapping(value="/editar/{id}")
    public ModelAndView getEditar(@PathVariable long id) {
        // Retorna o Formulário de Cadastro com as informações preenchidas referentes ao ID
        Contatos contatos = contatosRepository.findById(id).get();

        ModelAndView modelAndView = new ModelAndView("cadastrar");        
        modelAndView.addObject("contatos", contatos);

        return modelAndView;
    }
    

}