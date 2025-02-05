package com.ppa.ecomm.repository;

import com.ppa.ecomm.document.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {

}
