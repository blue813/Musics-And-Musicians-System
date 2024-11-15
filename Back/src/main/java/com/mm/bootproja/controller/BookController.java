package com.mm.bootproja.controller;

import com.mm.bootproja.biz.BookBiz;
import com.mm.bootproja.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BookController {
    @Autowired
    private BookBiz biz;

    @RequestMapping("/book/list")
    public Map findBooks(int pn){
        List<Book> list = biz.findAll();
        System.out.println("i can");
        if((pn*10)< list.size()){
            Map result = new HashMap<>();
            result.put("isOk",true);
            result.put("msg","查询成功");
            result.put("books",list.subList((pn-1)*10, pn*10));
            return result;
        }
        else if(((pn-1)*10) < list.size()){
            Map result = new HashMap<>();
            result.put("isOk",true);
            result.put("msg","查询成功");
            result.put("books",list.subList((pn-1)*10, list.size()));
            return result;
        }
        else{
            Map result = new HashMap<>();
            result.put("isOk",true);
            result.put("msg","我们只有"+list.size()+"条数据");
            return result;
        }

    }
    @RequestMapping("/book/add")
    public Map add(Book book){
        this.biz.addBook(book);
        Map result = new HashMap<>();
        result.put("isOk",true);
        result.put("msg","添加");
        return result;
    }
    @RequestMapping("/book/del")
    public Map del(int id){

        Map result = new HashMap<>();
        if(this.biz.delBook(id)){
            result.put("isOk",true);
            result.put("msg","删除成功");
        }else{
            result.put("isOk",false);
            result.put("msg","删除失败");
        }

        return result;
    }


    public void setBiz(BookBiz biz) {
        this.biz = biz;
    }
}
