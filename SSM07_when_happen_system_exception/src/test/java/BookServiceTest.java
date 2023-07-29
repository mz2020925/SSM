import com.itheima.config.SpringConfig;
import com.itheima.domain.Book;
import com.itheima.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class BookServiceTest {
    @Autowired
    private BookService bookService;

    @Test
    public void getById(){
        Book book = bookService.getById(1);
        System.out.println(book);  // 正规测试中需要用assert作断言匹配测试，这里只是打印一下
    }

    @Test
    public void getAll(){
        List<Book> bookList = bookService.getAll();
        System.out.println(bookList);
    }
}
