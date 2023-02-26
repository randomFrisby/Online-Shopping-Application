package com.shopezly.dto;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.shopezly.model.Product;
import com.shopezly.repository.ProductRepo;

public class DTOTesting {
		
//		@Autowired
//		ProductRepo productRepo;
//
//		@Override
//		public Product getProductById(Integer id) {
//			
//			Optional<Product> opt = productRepo.findById(id);
//			
//			if (opt.isPresent()) {
//				Product myProduct = opt.get();
//				return myProduct;
//			} else 
//				throw new ProductException("Product not found with Id: " + id);
//}
//
//@Override
//public List<Product> getAllProducts() {
//	
//	List<Product> myProducts = productRepo.getAllProducts();
//	
//	if (!myProducts.isEmpty())
//		return myProducts;
//	else
//		throw new ProductException("No product found!");
//}
//
//@Override
//public Product createProduct(Product product) {
//	
//	Product savedProduct = productRepo.save(product);
//	
//	return savedProduct;
//}
//
//@Override
//public List<Product> getAllProductBetweenRange(Integer start, Integer end) {
//	
//	List<Product> myProducts = productRepo.getAllProductBetweenRange(start, end);
//	
//	if (!myProducts.isEmpty())
//		return myProducts;
//	else
//		throw new ProductException("No product with price between " + start + " and " + end);
//	
//}
//
//
//@Override
//public List<ProductDTO> getNameAndBrandAndPriceAndManufacturere_Date() {
//	List<ProductDTO> dto = productRepo.getNameAndBrandAndPriceAndManufacturere_Date();
//	
//	if (dto.isEmpty())
//		throw new ProductException("No product in db");
//
//	return dto;
//}
//
//
//@Override
//public Product updateProductBrand(String brand, Integer id) {
//
//	Optional<Product> opt = productRepo.findById(id);
//	
//	if (opt.isPresent()) {
//		Product product = opt.get();
//		product.setBrand(brand);
//		return productRepo.save(product);
//	}
//	else
//		throw new ProductException("No product for update with id " + id);
//		
//}
//
//@Override
//public Product deleteProductById(Integer id) {
//	Optional<Product> opt = productRepo.findById(id);
//	
//	if (opt.isPresent()) {
//		
//		Product product = opt.get();
//		
//		productRepo.deleteById(id);
//		
//		return product;
//		
//	} else 
//		throw new ProductException("product not found for deleting with id " + id);
//	}

}

	
	
