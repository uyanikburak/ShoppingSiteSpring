package com.godoro.spring.shop.business.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.godoro.spring.shop.data.entity.CartProduct;
import com.godoro.spring.shop.data.repository.CartProductRepository;
import com.godoro.spring.shop.layer.business.dto.CartProductDto;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CartProductServiceImpl implements CartProductService {

	private CartProductRepository cartProductRepository;

	public CartProductServiceImpl(CartProductRepository cartProductRepository) {
		this.cartProductRepository = cartProductRepository;
	}

	@Override
	public CartProductDto add(long cartId, long productId) {

		CartProduct cartProduct = cartProductRepository.findByCartIdAndProductId(cartId, productId);
		if (cartProduct == null) {
			CartProduct cartProductNew = new CartProduct();
			cartProductNew.setCartId(cartId);
			cartProductNew.setProductId(productId);
			cartProductNew.setSalesQuantity(1);
			cartProductRepository.save(cartProductNew);
			return toCartProductDto(cartProductNew);
		} else {
			cartProduct.setSalesQuantity(cartProduct.getSalesQuantity() + 1);
			cartProductRepository.save(cartProduct);
			return toCartProductDto(cartProduct);
		}

	}

	@Override
	public void remove(long cartId, long productId) {

		CartProduct cartProduct = cartProductRepository.findByCartIdAndProductId(cartId, productId);
		if (cartProduct != null) {
			if (cartProduct.getSalesQuantity() == 1) {
				cartProductRepository.deleteByCartProductId(cartProduct.getCartProductId());
			} else {
				cartProduct.setSalesQuantity(cartProduct.getSalesQuantity() - 1);
				cartProductRepository.save(cartProduct);
			}
		}
	}

	@Override
	public List<CartProductDto> list(long cartId) {
		List<CartProduct> cartProductDtoList = cartProductRepository.findByCartId(cartId);
		List<CartProductDto> cartProductDtos = new ArrayList<>();
		for (CartProduct cartProduct : cartProductDtoList) {
			CartProduct tempProduct = new CartProduct();
			tempProduct.setCartId(cartProduct.getCartId());
			tempProduct.setCartProductId(cartProduct.getCartProductId());
			tempProduct.setProductId(cartProduct.getProductId());
			tempProduct.setSalesQuantity(cartProduct.getSalesQuantity());
			cartProductDtos.add(toCartProductDto(cartProduct));
		}

		return cartProductDtos;
	}

	public CartProduct toCartProduct(CartProductDto cartProductDto) {
		CartProduct cartProduct = new CartProduct();
		cartProduct.setCartId(cartProductDto.getCartId());
		cartProduct.setCartProductId(cartProduct.getCartProductId());
		cartProduct.setProductId(cartProductDto.getProductId());
		cartProduct.setSalesQuantity(cartProductDto.getSalesQuantity());
		return cartProduct;
	}

	public CartProductDto toCartProductDto(CartProduct cartProduct) {
		CartProductDto cartProductDto = new CartProductDto();
		cartProductDto.setCartId(cartProduct.getCartId());
		cartProductDto.setCartProductId(cartProduct.getCartProductId());
		cartProductDto.setProductId(cartProduct.getProductId());
		cartProductDto.setSalesQuantity(cartProduct.getSalesQuantity());
		return cartProductDto;
	}

}
