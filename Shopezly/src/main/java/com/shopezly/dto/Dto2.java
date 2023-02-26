//package com.shopezly.dto;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//import com.shopezly.model.Product;
//
//public class testing2 implements JpaRepository<Proudct, Integer> {
//		
//		@Query("from Product")
//		public List<Product> getAllProducts();
//		
//		@Query("select p from Product p where p.price >= :start and p.price <= :end")
//		public List<Product> getAllProductBetweenRange(@Param(value = "start") Integer start, @Param(value = "end") Integer end);
//		
//		
//		@Query("select new com.masai.model.ProductDTO(p.name, p.brand, p.price, p.manufacturer_date) from Product p")
//		public List<ProductDTO> getNameAndBrandAndPriceAndManufacturere_Date();
//	}
//
//	
//}
