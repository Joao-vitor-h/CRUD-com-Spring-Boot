package ufes.crudSpring.model;

import jakarta.persistence.*;

@Entity(name = "produto") // serve para mostrar que essa classe é do tipo model.
@Table(name = "produto") // serve para sinalizar que existe uma tabela para essa no banco de dados
public class Produto {

    @Id // serve para mostrar que o atributo logo abaixo é um ID no nosso banco.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define uma forma de geração automática para ID.
    private Integer id;
    private String nome;
    private Long preco;

    public Produto(Integer id, String nome, Long preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public Produto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getPreco() {
        return preco;
    }

    public void setPreco(Long preco) {
        this.preco = preco;
    }
}