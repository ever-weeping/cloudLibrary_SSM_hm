import com.sea.config.SpringConfig;
import com.sea.domain.Book;
import com.sea.entity.PageResult;
import com.sea.entity.Result;
import com.sea.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// 1. 让 JUnit 使用 Spring 的测试运行器
@RunWith(SpringJUnit4ClassRunner.class)
// 2. 告诉 Spring 你的核心配置类在哪里（注意替换成你实际的 SpringConfig 类名和包路径）
@ContextConfiguration(classes = SpringConfig.class)
public class BookTest {
    @Autowired
    private BookService bookService;
    @Test
    public void selectNewBooks(){
        int pageNum = 1;
        int pageSize = 5;
        PageResult pageResult = bookService.selectNewBooks(pageNum, pageSize);
        System.out.println(pageResult.getRows());
    }

    @Test
    public void findById(){
        Book book = bookService.findById("1");
        if (book == null){
            System.out.println("查询失败");
        }
        System.out.println("查询成功:"+book.toString());
    }
}
