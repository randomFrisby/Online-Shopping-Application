package com.shopezly.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.shopezly.exceptions.CategoryNotFoundException;
import com.shopezly.exceptions.ProductNotFoundException;
import com.shopezly.model.Category;
import com.shopezly.model.Product;
import com.shopezly.repository.CategoryRepository;
import com.shopezly.repository.ProductRepository;
import com.shopezly.service.IProductService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/products")
public class ProductController {
    
	@Autowired
    private IProductService productService;
	
	@Autowired
	private ProductRepository pRepo;
	
	@Autowired
	private CategoryRepository catRepo;


    @GetMapping
    public List<Product> findAllProduct() {
        return pRepo.findAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id) throws ProductNotFoundException {
        return pRepo.findById(id).orElseThrow(() -> new ProductNotFoundException(null));
    }

    @PostMapping
    public Product create(@RequestBody Product product) {
        return pRepo.save(product);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }

    @GetMapping("/category/{categoryId}")
    public List<Product> findByCategoryId(@PathVariable Long categoryId) throws CategoryNotFoundException {
        Category category =  catRepo.findById(categoryId).orElseThrow(() -> new CategoryNotFoundException("not found category"));
        
        return category.getProducts();
    }
    
//    @GetMapping("")
//    public List<Product> getAllProducts() {
//        
//    	List<Product> productList = pRepo.findAll();
//        
//        List<Product> productList = new ArrayList<>();
//
//        for (Product product : productList) {
//            ProductDTO productDTO = new ProductDTO();
//            productDTO.setId(product.getProductId());
//            productDTO.setName(product.getProductName());
//            productDTO.setDescription(product.getSpecification());
//            productDTO.setPrice(product.getPrice());
//            productDTO.setCategoryId(product.getCategory().getId());
//            
//            productDTOList.add(productDTO);
//        }
//
//        return productDTOList;
//    }

}

