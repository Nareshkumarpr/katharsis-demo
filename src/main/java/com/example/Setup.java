package com.example;

import com.example.domain.dao.AddressRepository;
import com.example.domain.dao.CustomerRepository;
import com.example.domain.model.Address;
import com.example.domain.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 1388162
 */
@Component
public class Setup {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @PostConstruct
    private void setUp(){

        List<Customer> customerList = new ArrayList<Customer>();
        Customer customer = new Customer();
        List<Address> addressList = new ArrayList<Address>();
        Address address1 = new Address();
        Address address2 = new Address();

        address1.setCountry("IN");
        address1.setCity("CH");
        address1.setState("TN");
        address2.setCountry("IN");
        address2.setCity("CB");
        address2.setState("TN");
        addressList.add(address1);
        addressList.add(address2);
        customer.setAddress(addressList);
        customer.setName("Test");
        customerList.add(customer);

        addressRepository.save(address1);
        addressRepository.save(address2);
        customerRepository.save(customer);

    }
}
