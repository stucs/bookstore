package mypack;

public class Book {
    private String mBookId;
    private String mBookName;
    private String mWriter;
    private float mPrice;


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
