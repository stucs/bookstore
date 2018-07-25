package mypack;

import mypack.dao.BookDB;
import mypack.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import vo.CatagoryBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class BaseController {

    private BookDB bookDB;
    @RequestMapping("/hello")
    public ModelAndView root(HttpServletRequest request, HttpServletResponse response) {
        List<Book> books = bookDB.get();
        CatagoryBean bookList = new CatagoryBean(books);

        ModelAndView mv = new ModelAndView("catagory");
        mv.addObject("booklist", bookList);
        return mv;
    }


    @Autowired
    public void setBookDB(BookDB bookDB) {
        this.bookDB = bookDB;
    }
}
