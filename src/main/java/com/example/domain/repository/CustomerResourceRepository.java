package com.example.domain.repository;

import com.example.domain.dao.CustomerRepository;
import com.example.domain.model.Customer;
import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.ResourceRepositoryBase;
import io.katharsis.resource.list.ResourceList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 1388162
 */
@Component
public class CustomerResourceRepository extends ResourceRepositoryBase<Customer, Long> {

    @Autowired
    private CustomerRepository customerRepository;

    protected CustomerResourceRepository() {
        super(Customer.class);
    }

    @Override
    public ResourceList<Customer> findAll(QuerySpec querySpec) {
        return querySpec.apply(customerRepository.findAll());
    }

    @Override
    public <S extends Customer> S save(S customer) {
        return customerRepository.save(customer);
    }
}
