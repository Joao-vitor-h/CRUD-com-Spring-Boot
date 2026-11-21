package ufes.crudSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ufes.crudSpring.model.Produto;

@Repository
public interface IProdutoRepository extends JpaRepository<Produto, Integer> {
}
