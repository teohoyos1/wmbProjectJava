package com.wmb.project.persistence.crud;

import com.wmb.project.persistence.entity.Payment_category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PaymentCategoryCrudRepository extends CrudRepository<Payment_category, Integer> {

}
