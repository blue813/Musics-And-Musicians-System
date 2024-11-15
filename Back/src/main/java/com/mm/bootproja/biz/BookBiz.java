package com.mm.bootproja.biz;

import com.mm.bootproja.entity.Book;
import com.mm.bootproja.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service//标识成业务类
public class BookBiz {
    @Autowired//spring通过setter给这个属性注入一个对象，
    // 如果属性是接口或抽象类行的，spring会自己去匹配其实现类或子类
    private BookMapper bookMapper;

    public List<Book> findAll(){
        return bookMapper.selectBooks();
    }

    public void addBook(Book book){
        this.bookMapper.insertBook(book);
    }

    public boolean delBook(int bookId){
        return this.bookMapper.deleteBookById(bookId)>0;
    }

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

}
