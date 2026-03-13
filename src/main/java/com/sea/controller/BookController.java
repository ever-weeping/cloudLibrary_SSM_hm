package com.sea.controller;

import com.sea.domain.Book;
import com.sea.domain.User;
import com.sea.entity.PageResult;
import com.sea.entity.Result;
import com.sea.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/*
图书信息Controller
 */
@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;
    /*
    查询最新上架的图书
     */
    @RequestMapping("/selectNewBooks")
    public ModelAndView selectNewBooks(){
        // 查询最新上架的五个图书信息
        int pageNum = 1;
        int pageSize = 5;
        PageResult pageResult = bookService.selectNewBooks(pageNum, pageSize);
//        System.out.println(pageResult.getRows());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("books_new");
        modelAndView.addObject("pageResult",pageResult);
        return modelAndView;
    }

    // 查询图书
    @ResponseBody
    @RequestMapping("/findById")
    public Result<Book> findById(String id){
//        System.out.println("走到了findById控制器");
        try {
            Book book = bookService.findById(id);
            if (book == null){
                return new Result<>(false,"查询图书是失败");
            }
            return new Result<>(true,"查询图书成功",book);
        }catch (Exception e){
            e.printStackTrace();
            return new Result<>(false,"查询图书失败");
        }
    }

    // 借阅图书
    @ResponseBody
    @RequestMapping("/borrowBook")
    public Result<Book> borrowBook(Book book, HttpSession session){
        // 获取当前登录的用户姓名
        String pname = ((User)session.getAttribute("USER_SESSION")).getName();
        book.setBorrower(pname);
        try{
            Integer count = bookService.borrowBook(book);
            if (count != 1){
                return new Result<>(false,"借阅图书失败！");
            }
            return new Result<>(true,"借阅成功，请到行政中心取书");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result<>(false,"借阅图书失败！");
        }
    }

    /**
     * 分页查询符合条件，，且未下架的图书信息
     * @param book 查询的条件封装到 book 中
     * @param pageNum 数据列表的·当前页码
     * @param pageSize 数据列表一页展示多少数据
     */
    @RequestMapping("/search")
    public ModelAndView search(Book book, Integer pageNum, Integer pageSize, HttpServletRequest request){
        if (pageNum == null){
            pageNum = 1;
        }
        if (pageSize == null){
            pageSize = 10;
        }
        PageResult pageResult = bookService.search(book, pageNum, pageSize);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("books");
        modelAndView.addObject("pageResult",pageResult);
        modelAndView.addObject("search",book);
        modelAndView.addObject("pageNum",pageNum);
        modelAndView.addObject("gourl",request.getRequestURI());
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/addBook")
    public Result addBook(Book book){
        try{
            Integer count = bookService.addBook(book);
            if (count != 1){
                return new Result(false,"新增图书失败！");
            }
            return new Result(true,"新增图书成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"新增图书失败！");
        }
    }

    @ResponseBody
    @RequestMapping("/editBook")
    public Result editBook(Book book){
        try{
            Integer count = bookService.editBook(book);
            if (count != 1){
                return new Result(false, "编辑失败！");
            }
            return new Result(true,"编辑成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "编辑失败！");
        }
    }

    // 分页查询当前被借阅且未被归还的图书信息
    @RequestMapping("/searchBorrowed")
    public ModelAndView searchBorrowed(Book book, Integer pageNum, Integer pageSize, HttpServletRequest request){
        if (pageNum == null){
            pageNum = 1;
        }
        if (pageSize == null){
            pageSize = 10;
        }
        // 获取当前登录的用户
        User user = (User) request.getSession().getAttribute("USER_SESSION");
        PageResult pageResult = bookService.searchBorrowed(book, user, pageNum, pageSize);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("book_borrowed");
        modelAndView.addObject("pageResult",pageResult);
        modelAndView.addObject("search",book);
        modelAndView.addObject("pageNum",pageNum);
        modelAndView.addObject("gourl",request.getRequestURI());
        return modelAndView;
    }

    // 归还图书
    @ResponseBody
    @RequestMapping("/returnBook")
    public Result returnBook(String id, HttpSession session){
        // 获取当前登录的用户信息
        User user = (User) session.getAttribute("USER_SESSION");
        try{
            boolean flag = bookService.returnBook(id, user);
            if(!flag){
                return new Result(false,"还书失败！");
            }
            return new Result(true,"还书确认中，请先到行政中心还书！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"还书失败！");
        }
    }

    //图书归还确认
    @ResponseBody
    @RequestMapping("/returnConfirm")
    public Result returnConfirm(String id){
        try {
            Integer count = bookService.returnConfirm(id);
            if (count != 1){
                return new Result(false,"确认失败！");
            }
            return new Result(true,"确认成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"确认失败！");
        }
    }
}
