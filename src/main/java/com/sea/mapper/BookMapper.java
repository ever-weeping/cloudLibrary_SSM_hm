package com.sea.mapper;

import com.github.pagehelper.Page;
import com.sea.domain.Book;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/*
图书接口
 */
public interface BookMapper {
    @Select("select * from book where book_status != '3' order by book_uploadtime DESC")
    @Results(id = "bookMap", value = {
            // id 字段默认为false，表示不是主键
            // column 表示数据库表字段，property表示实体类属性名
            @Result(id = true,column = "book_id",property = "id"),
            @Result(column = "book_name",property = "name"),
            @Result(column = "book_isbn",property = "isbn"),
            @Result(column = "book_press",property = "press"),
            @Result(column = "book_author",property = "author"),
            @Result(column = "book_pagination",property = "pagination"),
            @Result(column = "book_price",property = "price"),
            @Result(column = "book_uploadtime",property = "uploadTime"),
            @Result(column = "book_status",property = "status"),
            @Result(column = "book_borrower",property = "borrower"),
            @Result(column = "book_borrowTime",property = "borrowTime"),
            @Result(column = "book_returntime",property = "returnTime"),
    })
    Page<Book> selectNewBooks();

    @Select("select * from book where book_id=#{id}")
    @ResultMap("bookMap")
    Book findById(String id); // 根据id查询图书信息

    Integer editBook(Book book); // 编辑图书信息

    @Select({
            "<script> select * from book " +
                    "where book_status != 3" +
                    "<if test=\"name != null\"> and book_name like concat('%',#{name},'%')</if>" +
                    "<if test=\"author != null\"> and book_press like concat('%',#{press},'%')</if>" +
                    "<if test=\"name != null\"> and book_author like concat('%',#{author},'%')</if>" +
                    "order by book_status </script>"
    })
    @ResultMap("bookMap")
    Page<Book> searchBooks(Book book); // 查询图书

    Integer addBook(Book book); // 新增图书

    @Select(
            {
                    "<script> select * from book " +
                            "where book_borrower=#{borrower} " +
                            "and book_status='1' " +
                            "<if test=\"name != null\"> and book_name like concat('%',#{name},'%')</if> " +
                            "<if test=\"press != null\"> and book_press like concat('%',#{press},'%')</if> " +
                            "<if test=\"author != null\"> and book_author like concat('%',#{author},'%')</if> " +
                            "or book_status = '2' " +
                            "<if test=\"name != null\"> and book_name like concat('%',#{name},'%')</if> " +
                            "<if test=\"press != null\"> and book_press like concat('%',#{press},'%')</if> " +
                            "<if test=\"author != null\"> and book_author like concat('%',#{author},'%')</if> " +
                            "</script>"
            }
    )
    @ResultMap("bookMap")
    Page<Book> selectBorrowed(Book book); // 查询借阅但未归还的图书和所有待确认归还的图书

    @Select(
            {
                    "<script> select * from book " +
                            "where book_borrower=#{borrower} " +
                            "and book_status in ('1','2')" +
                            "<if test=\"name != null\"> and book_name like concat('%',#{name},'%')</if> " +
                            "<if test=\"press != null\"> and book_press like concat('%',#{press},'%')</if> " +
                            "<if test=\"author != null\"> and book_author like concat('%',#{author},'%')</if> " +
                            "</script>"
            }
    )
    @ResultMap("bookMap")
    Page<Book> selectMyBorrowed(Book book); // 查询借阅但未归还的图书
}
