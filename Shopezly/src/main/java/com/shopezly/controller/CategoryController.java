//package com.shopezly.controller;
//
//import java.util.List;
//
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.shopezly.model.Category;
//import com.shopezly.service.ICategoryService;
//
//import io.swagger.v3.oas.annotations.parameters.RequestBody;
//
//@RestController
//@RequestMapping("/categories")
//public class CategoryController {
//    
//    private ICategoryService categoryService;
//
//    public CategoryController(ICategoryService categoryService) {
//        this.categoryService = categoryService;
//    }
//
//    @GetMapping
//    public List<Category> findAll() {
//        return categoryService.findAll();
//    }
//
//    @GetMapping("/{id}")
//    public Category findById(@PathVariable Long id) {
//        return categoryService.findById(id);
//    }
//
//    @PostMapping
//    public Category create(@RequestBody Category categoryDTO) {
//        return categoryService.create(categoryDTO);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteById(@PathVariable Long id) {
//        categoryService.deleteById(id);
//    }
//}
