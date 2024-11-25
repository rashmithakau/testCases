package com.demo.Demo.repositary;

import com.demo.Demo.entiry.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
@EnableJpaRepositories
public interface CustomerRepositary extends JpaRepository<CustomerEntity,Integer> {
    CustomerEntity getCustomerEntityByCustomerId(int customerId);

    List<CustomerEntity> findAllByActiveEquals(boolean state);
}
