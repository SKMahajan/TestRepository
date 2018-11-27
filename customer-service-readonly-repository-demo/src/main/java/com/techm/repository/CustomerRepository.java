package com.techm.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.techm.entity.Customer;

@Repository
//public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
public interface CustomerRepository extends Repository {
	List<Customer> findAll();
	public Optional<Customer> findById(Long id);
}
