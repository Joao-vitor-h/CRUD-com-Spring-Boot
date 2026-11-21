package ufes.crudSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ufes.crudSpring.model.Produto;

@Repository
public interface IProdutoRepositoy extends JpaRepository<Produto, Integer> {
}
