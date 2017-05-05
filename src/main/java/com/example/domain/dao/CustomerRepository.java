package com.example.domain.dao;

import com.example.domain.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 1388162
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
