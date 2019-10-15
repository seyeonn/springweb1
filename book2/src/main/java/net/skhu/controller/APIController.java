package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.skhu.domain.Book;
import net.skhu.domain.Category;
import net.skhu.repository.BookRepository;
import net.skhu.repository.CategoryRepository;
import net.skhu.repository.PublisherRepository;

@RestController
@RequestMapping("api")
public class APIController {

    @Autowired BookRepository bookRepository;
    @Autowired CategoryRepository categoryRepository;
    @Autowired PublisherRepository publisherRepository;

    @RequestMapping("books")
    public List<Book> books() {
        return bookRepository.findAll();
    }

    @RequestMapping("category/{id}/books")
    public List<Book> categoryBooks(@PathVariable("id") int id) {
        Category category = categoryRepository.findById(id).get();
        return category.getBooks();
    }


}
