package mypack;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class ShowCart {

    private HashMap map = new HashMap();
    private int mCount = 0;

    public synchronized void addCart(String id, Book book) {
        if (!map.containsKey(id)) {
            map.put(id, new ShowCartItem(book));
        } else {
            ShowCartItem item = (ShowCartItem) map.get(id);
            item.increase();
        }
        mCount++;
    }

    public synchronized void remove(String id) {
        if (!map.containsKey(id)) {
            return ;
        } else {
            ShowCartItem item = (ShowCartItem)map.get(id);
            item.decrease();
        }
    }

    public int getCount() {
        return mCount;
    }

    public Collection getItems() {
        return map.values();
    }
}
