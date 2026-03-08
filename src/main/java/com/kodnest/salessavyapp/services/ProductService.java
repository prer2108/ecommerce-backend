package com.kodnest.salessavyapp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.salessavyapp.entities.Category;
import com.kodnest.salessavyapp.entities.Product;
import com.kodnest.salessavyapp.entities.ProductImage;
import com.kodnest.salessavyapp.repositories.CategoryRepository;
import com.kodnest.salessavyapp.repositories.ProductImageRepository;
import com.kodnest.salessavyapp.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductImageRepository productImageRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Product> getProductsByCategory(String categoryName) {
		
		if(categoryName != null && !categoryName.isEmpty()) {
			Optional<Category> categoryOpt = categoryRepository.findByCategoryName(categoryName);
			
			if(categoryOpt.isPresent()) {
				Category category = categoryOpt.get();
				return productRepository.findByCategory_CategoryId(category.getCategoryId());
			} else {
				throw new RuntimeException("Category not found");
			}
		} else {
			return productRepository.findAll();
		}
     }
	
	public List<String> getProductimages(Integer productId) {
		List<ProductImage> productImages = productImageRepository.findByProduct_ProductId(productId);
		List<String> ImageUrls = new ArrayList<>();
		
		for(ProductImage Image : productImages) {
				ImageUrls.add(Image.getImageUrl());
		}
		
		return ImageUrls;
	}
	}
