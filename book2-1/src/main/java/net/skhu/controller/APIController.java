package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.skhu.domain.Book;
import net.skhu.domain.Category;
import net.skhu.domain.Publisher;
import net.skhu.repository.BookRepository;
import net.skhu.repository.CategoryRepository;
import net.skhu.repository.PublisherRepository;


@RestController
@RequestMapping("api")
public class APIController {
	@Autowired BookRepository bookRepository;
    @Autowired CategoryRepository categoryRepository;
    @Autowired PublisherRepository publisherRepository;

    @RequestMapping("book/{id}")
    public Book books(@PathVariable("id") int id) {
    	return bookRepository.findById(id).get();
    }

    @RequestMapping("categories")
    public List<Category> categories() {
    	return categoryRepository.findAll();
    }

    @RequestMapping("category/{id}")
    public Category category(@PathVariable("id") int id) {
    	return categoryRepository.findById(id).get();
    }

    @RequestMapping("publishers")
    public List<Publisher> publishers() {
    	return publisherRepository.findAll();
    }

    @RequestMapping("publisher/{id}")
    public Publisher publisher(@PathVariable("id") int id) {
    	return publisherRepository.findById(id).get();
    }

}
