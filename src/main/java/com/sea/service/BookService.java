package com.sea.service;

import com.sea.domain.Book;
import com.sea.domain.User;
import com.sea.entity.PageResult;

/*
图书接口
 */
public interface BookService {
    // 查询最新上架的图书
    PageResult selectNewBooks(Integer pageNum, Integer pageSize);
    // 根据 ID 查询图书信息
    Book findById(String id);
    // 借阅图书
    Integer borrowBook(Book book);
    // 分页查询图书
    PageResult search(Book book, Integer pageNum, Integer pageSize);
    // 新增图书
    Integer addBook(Book book);
    // 编辑图书信息
    Integer editBook(Book book);
    // 查询当前借阅的图书
    PageResult searchBorrowed(Book book, User user, Integer pageNum, Integer pageSize);
    // 归还图书
    boolean returnBook(String id, User user);
    // 确认归还
    Integer returnConfirm(String id);
}
