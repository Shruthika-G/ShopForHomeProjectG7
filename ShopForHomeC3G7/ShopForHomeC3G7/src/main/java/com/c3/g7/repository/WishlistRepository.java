package com.c3.g7.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.c3.g7.entity.WishList;

@Repository
public interface WishlistRepository extends JpaRepository<WishList, Integer>{
	Page<WishList> findAllByUserId(Long id, Pageable pageable);
}
