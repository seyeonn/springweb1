package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import net.skhu.dto.Book;
import net.skhu.model.Pagination;

@Mapper
public interface BookMapper {

    List<Book> findAll(Pagination pagination);
    int count();
    Book findOne(int id);
    void insert(Book book);
    void update(Book book);
    void delete(int id);

}

