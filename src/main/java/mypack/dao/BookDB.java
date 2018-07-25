package mypack.dao;

import mypack.pojo.Book;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class BookDB {

    @PersistenceContext
    private EntityManager em;



    private JdbcOperations jdbcOperations;
    private String dbUrl = "jdbc:mysql://localhost:3306/bookdb";
    private String dbUser = "root";
    private String dbPass = "123456";
    private DataSource mDataSource = null;
    private SessionFactory sessionFactory;

//    @Autowired
    public BookDB() throws Exception {
//        Context ctx = new InitialContext();
//        if (ctx == null) {
//            throw new Exception("No Context");
//        }
//        mDataSource = (DataSource)ctx.lookup("java:comp/env/jdbc/BookDB");
//        jdbcOperations = template;
//        this.sessionFactory = sessionFactory;
//        em = manager;
    }

    public List<Book> getAll() {
        List<Book> list =  (List<Book>)sessionFactory.getCurrentSession().createCriteria(Book.class).list();
        return list;
    }

    public List<Book> get() {
        Book b =  em.find(Book.class, "1");
        List<Book> list = new ArrayList<Book>();
        list.add(b);
        return list;
    }

    public Connection getConnection() throws Exception{
//        return java.sql.DriverManager.getConnection(dbUrl, dbUser, dbPass);
        return mDataSource.getConnection();
    }

    private void closeConnection(Connection con) throws Exception {
        if (con != null)
            con.close();
    }

    private void closePrep(PreparedStatement prep) throws Exception {
        if (prep != null)
            prep.close();
    }

    private void closeRes(ResultSet res) throws Exception {
        if (res != null)
        res.close();
    }


    public Book getBookById(String id) throws Exception{
        Connection con = null;
        PreparedStatement prep = null;
        ResultSet res = null;

        try {
            String sq = "select * from book where id=?";
            con = getConnection();
            prep = con.prepareStatement(sq);
            prep.setString(1, id);
            res = prep.executeQuery();
            if (res.next()) {
                Book bk = new Book(res.getString(1), res.getString(2), res.getFloat(3), res.getString(4));
                return bk;
            } else {
                return null;
            }
        } finally {
            closeRes(res);
            closePrep(prep);
            closeConnection(con);
        }
    }


    public List<Book> getBooks() {
        List<Book> list =  jdbcOperations.query("select * from book", new BookRowMapper());
        return list;
    }

    private static final class BookRowMapper implements RowMapper<Book> {

        public Book mapRow(ResultSet res, int rowNum) throws SQLException {
            return new Book(res.getString(1), res.getString(2), res.getFloat(3), res.getString(4));
        }
    }

//    public List<Book> getBooks() throws Exception{
//        Connection con = null;
//        PreparedStatement perp = null;
//        ResultSet res = null;
//
//        ArrayList<Book> arrs = new ArrayList<Book>();
//        String select = "select * from book";
//        try {
//            con  = getConnection();
//            perp = con.prepareStatement(select);
//            res = perp.executeQuery();
//
//            while (res.next()) {
//                Book bk = new Book(res.getString(1), res.getString(2), res.getFloat(3), res.getString(4));
//                arrs.add(bk);
//            }
//
//            return arrs;
//        } finally {
//            closeRes(res);
//            closePrep(perp);
//            closeConnection(con);
//        }
//    }

    public int getNumberOfBooks() throws Exception {
        Connection con=null;
        PreparedStatement prepStmt=null;
        ResultSet rs=null;
        int count=0;

        try {
            con=getConnection();
            String selectStatement = "select count(*) " + "from book";
            prepStmt = con.prepareStatement(selectStatement);
            rs = prepStmt.executeQuery();

            if (rs.next())
                count = rs.getInt(1);

        }finally{
            closeRes(rs);
            closePrep(prepStmt);
            closeConnection(con);
        }
        return count;
    }
}
