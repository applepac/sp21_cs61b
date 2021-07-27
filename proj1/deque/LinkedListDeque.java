package deque;

public class LinkedListDeque<Item> {
    private class StuffNode {
        public StuffNode prev;
        public Item item;
        public StuffNode next;

        public StuffNode(StuffNode p, Item i, StuffNode n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    private StuffNode sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new StuffNode(null, (Item) "123", null);
        sentinel.prev = sentinel.next = sentinel;
        size = 0;
    }

    public LinkedListDeque(Item i) {
        sentinel = new StuffNode(null, (Item) "123", null);
        sentinel.next = sentinel.prev = new StuffNode(sentinel, i, sentinel);
        size = 1;
    }

    public void addFirst(Item i) {
        StuffNode p = sentinel.next;
        p.prev = new StuffNode(sentinel, i, p);
        sentinel.next = p.prev;
        size++;
    }

    public Item removeFirst() {
        StuffNode p = sentinel.next;
        Item temp = (Item) p.item;
        sentinel.next = p.next;
        p.next.prev = sentinel;
        size--;
        return temp;
    }

    public Item getFirst() {
        return (Item) sentinel.next.item;
    }

    public Item getIndex(int i) {
        StuffNode p = sentinel.next;
        while (i > 0) {
            p = p.next;
            i--;
        }
        return (Item) p.item;
    }

    public void addLast(Item i) {
        StuffNode p = sentinel.prev;
        p.next = new StuffNode(p, i, sentinel);
        sentinel.prev = p.next;
        size++;
    }

    public Item getLast() {
        return (Item) sentinel.prev.item;
    }


    public Item removeLast() {
        StuffNode p = sentinel.prev;
        Item temp = (Item) p.item;
        sentinel.prev = p.prev;
        p.prev.next = sentinel;
        size--;
        return temp;
    }



    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public void printDeque() {
        System.out.println("The linked list is: ");
        StuffNode p = sentinel.next;
        for (int i=0; i<size; i++) {
            System.out.println(p.item);
            p = p.next;
        }
    }


}


