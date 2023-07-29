package com.itheima.controller;

import com.itheima.domain.Book;
import com.itheima.exception.BusinessException;
import com.itheima.exception.SystemException;
import com.itheima.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public Result save(@RequestBody Book book) {
        boolean data = bookService.save(book);
        return new Result(data ? Code.SAVE_OK : Code.SAVE_ERR, data);
    }

    @PutMapping
    public Result update(@RequestBody Book book) {
        boolean data = bookService.update(book);
        return new Result(data ? Code.UPDATE_OK : Code.UPDATE_ERR, data);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean data = bookService.delete(id);
        return new Result(data ? Code.DELETE_OK : Code.DELETE_ERR, data);
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        Book data = bookService.getById(id);
        Integer code = data != null ? Code.GET_OK : Code.GET_ERR;
        String msg = data != null ? "" : "数据查询失败，请重试";
        return new Result(code, data, msg);
    }

    @GetMapping
    public Result getAll() {
        List<Book> data = bookService.getAll();
        Integer code = data != null ? Code.GET_OK : Code.GET_ERR;
        String msg = data != null ? "" : "数据查询失败，请重试";
        return new Result(code, data, msg);
    }
}
