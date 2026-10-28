package problem4;

public class SearchTree implements NodeList {
    private ListItem root;

    public SearchTree(ListItem li) {
        this.root = li;
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
        while (curr != null) {
            if (li.compareTo(curr) == 0) return false;

            if (curr.compareTo(li) < 0) {
                if (curr.next() == null) {
                    curr.setNext(li);
                    return true;
                }

                curr = curr.next();
            }

            if (curr.compareTo(li) > 0) {
                if (curr.previous() == null) {
                    curr.setPrevious(li);
                    return true;
                }

                curr = curr.previous();
            }
        }

        return false;
    }

    @Override
    public boolean removeItem(ListItem li) {
        ListItem parent = null;
        ListItem curr = this.root;
        while (curr != null) {
            if (curr.compareTo(li) == 0) {
                performRemoval(curr, parent);
                return true;
            }

            parent = curr;
            if (curr.compareTo(li) < 0) {
                curr = curr.next();
            } else if (curr.compareTo(li) > 0) {
                curr = curr.previous();
            }
        }

        return false;
    }

    private void performRemoval(ListItem li, ListItem p) {
        ListItem left = li.previous();
        ListItem right = li.next();

        // 2 Children
        if (left != null && right != null) {
            ListItem prev = li;
            ListItem curr = right;
            while (curr.previous() != null) {
                prev = curr;
                curr = curr.previous();
            }

            performRemoval(curr, prev);

            prev.setPrevious(null);

            li.setValue(curr.getValue());

            return;
        }

        if (p == null && left == null && right == null) {
            this.root = null;
            return;
        }

        // 0 Children
        if (left == null && right == null) {
            if (li.compareTo(p.next()) == 0) p.setNext(null);
            else if (li.compareTo(p.previous()) == 0) p.setPrevious(null);

            return;
        }

        if (p == null && left != null) {
            this.root = left;
            return;
        }

        if (p == null) { // right != null
            this.root = right;
            return;
        }

        // 1 Child
        if (left != null) {
            if (li.compareTo(p.next()) == 0) p.setNext(left);
            else if (li.compareTo(p.previous()) == 0) p.setPrevious(left);
        } else { // right != null
            if (li.compareTo(p.next()) == 0) p.setNext(right);
            else if (li.compareTo(p.previous()) == 0) p.setPrevious(right);
        }

    }

    @Override
    public void traverse(ListItem r) {
        if (r == null) return;

        traverse(r.previous());
        System.out.println(r.getValue());
        traverse(r.next());
    }
}
