package mypack;

public class ShowCartItem {
    private Book mBook;
    private int mCount;

    public ShowCartItem(Book book) {
        mCount = 1;
        mBook = book;
    }

    public void increase() {
        mCount++;
    }

    public void decrease() {
        mCount--;
    }

    public Book getmBook() {
        return mBook;
    }

    public void setmBook(Book mBook) {
        this.mBook = mBook;
    }

    public Book getItem() {
        return mBook;
    }


}
