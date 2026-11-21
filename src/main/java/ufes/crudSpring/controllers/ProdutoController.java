package ufes.crudSpring.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ufes.crudSpring.dto.ProdutoDTO;
import ufes.crudSpring.model.Produto;
import ufes.crudSpring.repositories.IProdutoRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired // Faz injeção de dependência. Pesquisar melhor como funciona.
    IProdutoRepository repository;

    @GetMapping
    public ResponseEntity hello() {
        List<Produto> produtos = repository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable(value = "id") Integer id) {
        Optional<Produto> produtoOpt = repository.findById(id);
        if (produtoOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(produtoOpt.get());
    }

    @PostMapping
    public ResponseEntity save(@RequestBody ProdutoDTO dto) {
        var produto = new Produto();
        BeanUtils.copyProperties(dto, produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Integer id) {
        Optional<Produto> produtoOpt = repository.findById(id);
        if (produtoOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado.");
        }
        repository.delete(produtoOpt.get());
        return ResponseEntity.status(HttpStatus.OK).body("Produto deletado com sucesso.");
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable(value = "id") Integer id, @RequestBody ProdutoDTO dto) {
        Optional<Produto> produtoOpt = repository.findById(id);
        if (produtoOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
        }
        var produtoModel = produtoOpt.get();
        BeanUtils.copyProperties(dto, produtoModel);
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(produtoModel));
    }
}