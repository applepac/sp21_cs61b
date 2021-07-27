package deque;

public class ArrayDeque<Item> {
    private Item[] items;
    private int size;
    private int refactor = 2;
    private double usageRatio = 0.25;

    public ArrayDeque(){
        items = (Item[]) new Object[8];
        size = 0;
    }

    public void addFirst(Item i) {
        resizeCheck();
        Item[] temp = (Item[]) new Object[items.length];
        System.arraycopy(items, 0, temp, 1, size);
        temp[0] = i;
        items = temp;
        size++;
    }

    public Item removeFirst() {
        usageCheck();
        Item[] temp = (Item[]) new Object[items.length];
        System.arraycopy(items, 1, temp, 0, size-1);
        Item removed = items[0];
        items = temp;
        size--;
        return removed;
    }

    public void addLast(Item i) {
        resizeCheck();
        items[size] = i;
        size++;
    }
    public Item removeLast() {
        usageCheck();
        Item temp = items[size-1];
        items[size-1] = null;
        size--;
        return temp;
    }

    private void resize(int capacity) {
        Item[] a = (Item[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    private void resizeCheck() {
        if (size == items.length) {
            resize(size*refactor);
        }
    }

    private void usageCheck() {
        if (items.length > 16 & (double) size / items.length < usageRatio) {
            resize((int) (items.length * usageRatio));
        }
    }

    public int size() {
        return size;
    }

}
