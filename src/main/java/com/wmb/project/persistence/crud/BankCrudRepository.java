package com.wmb.project.persistence.crud;

import com.wmb.project.persistence.entity.Bank;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BankCrudRepository extends CrudRepository<Bank, Integer> {
    //List<Product> findByIdCategoriOrderByNomAsc(int idCategoria);
    //Optional<List<Product>> findByCanStockLessThanAndEsta(int cantiStock, boolean esta);
}
