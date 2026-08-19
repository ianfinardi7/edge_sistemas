package br.com.ianfinardi.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ianfinardi.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}

