package com.facens.app_biblioteca_api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.facens.app_biblioteca_api.model.Livro;
import com.facens.app_biblioteca_api.service.LivroService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController //é a combinação do controller com o responseBody,
//indicaque os metodos retoram diretamente no corpo da respota
// com esse recurso criamos nossa API restful
@RequestMapping("/livros") // é utilizado para mapear as URL's para metodos especificos
// será acessivel no navegador atraves da url base "/livros"


public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService){
        this.livroService = livroService;

    }
  
@GetMapping
public List<livro> listaLivros(){
    return livroService.listarTodos;
}
@GetMapping("/teste")
public String testeAPI(){
    return "API funcionando corretamente";
}
@GetMapping("/{id}")// o {id} é utilizado para mapear uma requisição GET que inclui um parameto
public Livro buscaPorId(@PathVariable Long id){
    return livroService.buscaPorId(id);
}

@PostMapping
@ResponseStatus(HttpStatus.CREATED)
public Livro criarLivro(@RequestBody Livro livro){
    return livroService.criar(livro);
}

@PutMapping("/{id}")
public Livro atualizaLivro(@PathVariable Long id, @RequestBody
Livro livro){
    return livroService.atualizar(id, livro);
}

@DeleteMapping
@ResponseStatus(HttpStatus.NO_CONTENT)
public void  removerLivro(@PathVariable Long id){
    return livroService.deletar(id);
}
  
@PutMapping("/{id}/emprestar")
public Livro emprestaLivro(@PathVariable Long id){
    return livroService.emprestar(id);
}

@PutMapping("/{id}/devolver")
public Livro devolverLivro(@PathVariable Long id){
    return livroService.devolver(id);
}

}



