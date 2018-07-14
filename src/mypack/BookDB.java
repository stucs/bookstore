package mypack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookDB {

    private String dbUrl = "jdbc:mysql://localhost:3306/bookdb";
    private String dbUser = "root";
    private String dbPass = "123456";

    public BookDB() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
    }

    public Connection getConnection() throws Exception{
        return java.sql.DriverManager.getConnection(dbUrl, dbUser, dbPass);
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

    public List<Book> getBooks() throws Exception{
        Connection con = null;
        PreparedStatement perp = null;
        ResultSet res = null;

        ArrayList<Book> arrs = new ArrayList<Book>();
        String select = "select * from book";
        try {
            con  = getConnection();
            perp = con.prepareStatement(select);
            res = perp.executeQuery();

            while (res.next()) {
                Book bk = new Book(res.getString(1), res.getString(2), res.getFloat(3), res.getString(4));
                arrs.add(bk);
            }

            return arrs;
        } finally {
            closeRes(res);
            closePrep(perp);
            closeConnection(con);
        }
    }

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
