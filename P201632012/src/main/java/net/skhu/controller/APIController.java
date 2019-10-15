package net.skhu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.skhu.domain.Category;
import net.skhu.domain.Dealer;
import net.skhu.domain.Product;
import net.skhu.domain.Supply;
import net.skhu.repository.CategoryRepository;
import net.skhu.repository.DealerRepository;
import net.skhu.repository.ProductRepository;
import net.skhu.repository.SupplyRepository;

@RestController
@RequestMapping("api")
public class APIController {
	@Autowired DealerRepository dealerRepository;
    @Autowired SupplyRepository supplyRepository;
    @Autowired ProductRepository productRepository;
    @Autowired CategoryRepository categoryRepository;

    @RequestMapping("products")
    public List<Product> products() {
        return productRepository.findAll();
    }

    @RequestMapping("product/{id}")
    public Product product(@PathVariable("id") int id) {
        return productRepository.findById(id).get();
    }

    @RequestMapping("category/{id}")
    public Category category(@PathVariable("id") int id) {
        return categoryRepository.findById(id).get();
    }

    @RequestMapping("category/{id}/products")
    public List<Product> categoryProducts(@PathVariable("id") int id) {
        Category category = categoryRepository.findById(id).get();
        return category.getProducts();
    }

    @RequestMapping("product/{id}/supplies")
    public List<Supply> productSupplies(@PathVariable("id") int id) {
        Product product = productRepository.findById(id).get();
        return product.getSupplies();
    }

    @RequestMapping("product/{id}/dealers")
    public List<Dealer> productDelaers(@PathVariable("id") int id) {
        Product product = productRepository.findById(id).get();
        List<Dealer> list = new ArrayList<Dealer>();
        for (Supply s : product.getSupplies())
            list.add(s.getDealer());
        return list;
    }



}
