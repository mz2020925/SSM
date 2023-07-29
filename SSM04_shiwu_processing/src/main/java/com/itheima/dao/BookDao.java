package com.itheima.dao;

import com.itheima.domain.Book;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

public interface BookDao {
    // @Insert("insert into tbl_book values(null, #{type}, #{name}, #{description})")  // 这里的#{type}是Book类的属性，不是表里面的列名
    @Insert("insert into tbl_book (type, name, description) values(#{type}, #{name}, #{description})")  // 前面的(type, name, description)是表里面的列名，后面的的#{type}是Book类的属性，不是表里面的列名
    void save(Book book);

    @Update("update tbl_book set type=#{type}, name=#{name}, description=#{description} where id=#{id}")
    void update(Book book);

    @Delete("delete from tbl_book where id=#{id}")
    void delete(Integer id);

    @Select("select * from tbl_book where id=#{id}")
    Book getById(Integer id);

    @Select("select * from tbl_book")
    List<Book> getAll();
}
