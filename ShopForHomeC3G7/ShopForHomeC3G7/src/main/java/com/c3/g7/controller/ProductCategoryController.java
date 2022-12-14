package com.c3.g7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import com.c3.g7.entity.ProductCategory;
import com.c3.g7.entity.ProductInfo;
import com.c3.g7.response.CategoryPage;
import com.c3.g7.service.ProductCategoryService;
import com.c3.g7.service.ProductService;

@RestController
@CrossOrigin
public class ProductCategoryController {
	
	@Autowired
    ProductCategoryService ProductCategoryService;
	
    @Autowired
    ProductService productService;

    @GetMapping("/category/{type}")
    public CategoryPage showOne(@PathVariable("type") Integer categoryType,
                                @RequestParam(value = "page", defaultValue = "1") Integer page,
                                @RequestParam(value = "size", defaultValue = "3") Integer size) {

        ProductCategory cat = ProductCategoryService.findByCategoryType(categoryType);
        PageRequest request = PageRequest.of(page - 1, size);
        Page<ProductInfo> productInCategory = productService.findAllInCategory(categoryType, request);
        var tmp = new CategoryPage("", productInCategory);
        tmp.setCategory(cat.getCategoryName());
        return tmp;
    }
}
