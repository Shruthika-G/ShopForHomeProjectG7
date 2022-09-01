package com.c3.g7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.c3.g7.entity.ProductInOrder;

@Repository
public interface ProductInOrderRepository extends JpaRepository<ProductInOrder, Long>{

}
