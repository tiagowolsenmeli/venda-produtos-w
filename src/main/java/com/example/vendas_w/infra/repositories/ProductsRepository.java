package com.example.vendas_w.infra.repositories;

import com.example.vendas_w.domain.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Product, Long> {

    public List<Product> findByName(String name);

    public List<Product> findByFiscalCode(String fiscalCode);

    public List<Product> findByNameAndFiscalCode(String name, String fiscalCode);
}