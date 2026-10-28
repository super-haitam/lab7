package problem4;

public class MyLinkedList implements NodeList {
    private ListItem root;

    public MyLinkedList(ListItem li) {
        root = li;
    }

    @Override
    public ListItem getRoot() {
        return root;
    }

    @Override
    public boolean addItem(ListItem li) {
        if (this.root == null) {
            this.root = li;
            return true;
        }

        ListItem curr = this.root;
        while (curr.next() != null && li.compareTo(curr) > 0) {
            curr = curr.next();
        }

        if (curr.next() == null) {
            curr.setNext(li);
            li.setPrevious(curr);
            return true;
        }

        if (li.compareTo(curr) == 0) {
            return false;
        }

        if (li.compareTo(curr) < 0) {
            ListItem prev = curr.previous();
            if (prev != null) { prev.setNext(li); }
            else { this.root = li; }

            li.setPrevious(prev);
            li.setNext(curr);
            curr.setPrevious(li);
        }

        return true;
    }

    @Override
    public boolean removeItem(ListItem li) {
        if (this.root.compareTo(li) == 0) {
            this.root = this.root.next();
            this.root.setPrevious(null);
            return true;
        }

        ListItem curr = this.root;

        while (curr != null) {
            if (curr.compareTo(li) == 0) {
                if (curr.next() != null) { curr.next().setPrevious(curr.previous()); }
                if (curr.previous() != null) { curr.previous().setNext(curr.next()); }
                return true;
            }

            curr = curr.next();
        }

        return false;
    }

    @Override
    public void traverse(ListItem r) {
        if (r == null) {
            System.out.println("The list is empty.");
            return;
        }

        ListItem curr = r;
        while (curr != null) {
            System.out.println(curr.getValue());
            curr = curr.next();
        }
    }
}
