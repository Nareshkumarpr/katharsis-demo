package com.example.domain.dao;

import com.example.domain.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 1388162
 */
public interface AddressRepository extends JpaRepository<Address, Long> {

}