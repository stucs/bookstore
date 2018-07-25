package mypack.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @Column(name = "id")
    private String mBookId;
    @Column(name = "name")
    private String mBookName;
    @Column(name = "price")
    private float mPrice;
    @Column(name = "writer")
    private String mWriter;


    public Book() {}
    public Book(String id, String name, float price, String writer) {
        mBookId = id;
        mBookName = name;
        mWriter = writer;
        mPrice = price;
    }

    public String getmBookId() {
        return mBookId;
    }

    public void setmBookId(String mBookId) {
        this.mBookId = mBookId;
    }

    public String getmBookName() {
        return mBookName;
    }

    public void setmBookName(String mBookName) {
        this.mBookName = mBookName;
    }

    public String getmWriter() {
        return mWriter;
    }

    public void setmWriter(String mWriter) {
        this.mWriter = mWriter;
    }

    public float getmPrice() {
        return mPrice;
    }

    public void setmPrice(float mPrice) {
        this.mPrice = mPrice;
    }
}
