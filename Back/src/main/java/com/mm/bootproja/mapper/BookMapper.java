package com.mm.bootproja.mapper;

import com.mm.bootproja.entity.Book;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface BookMapper {
    @Select("select * from t_book")
    List<Book> selectBooks();
    @Select("select * from t_book where bookid=#{id}")
    Book selectBookById(int id);
    @Insert("insert into t_book values(null,#{title},#{price},#{desc})")
    void insertBook(Book book);
    @Delete("delete from t_book where bookid=#{id}")
    int deleteBookById(int id);

    int updateBook(Book book);
}
