package com.example.domain.repository;

import com.example.domain.dao.AddressRepository;
import com.example.domain.model.Address;
import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.ResourceRepositoryBase;
import io.katharsis.resource.list.ResourceList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 1388162
 */
@Component
public class AddressResourceRepository extends ResourceRepositoryBase<Address, Long> {

    @Autowired
    private AddressRepository addressRepository;

    protected AddressResourceRepository() {
        super(Address.class);
    }

    @Override
    public ResourceList<Address> findAll(QuerySpec querySpec) {
        return querySpec.apply(addressRepository.findAll());
    }
}
