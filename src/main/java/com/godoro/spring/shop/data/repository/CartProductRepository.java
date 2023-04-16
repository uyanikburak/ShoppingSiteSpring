package com.godoro.spring.shop.data.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.godoro.spring.shop.data.entity.CartProduct;

public interface CartProductRepository extends CrudRepository<CartProduct, Long>{

@Query("SELECT cp from CartProduct cp where cp.cartId = :cartId and cp.productId = :productId")
CartProduct findByCartIdAndProductId(@Param("cartId") Long cartId, @Param("productId")Long productId);

Long deleteByCartProductId(Long productId);

List<CartProduct> findByCartId(long cartId);



}
