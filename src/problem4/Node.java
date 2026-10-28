package problem4;

public class Node extends ListItem {
    public Node(Object o) {
        super(o);
    }

    @Override
    ListItem next() {
        return this.rightLink;
    }

    @Override
    ListItem setNext(ListItem rl) {
        return this.rightLink = rl;
    }

    @Override
    ListItem previous() {
        return this.leftLink;
    }

    @Override
    ListItem setPrevious(ListItem ll) {
        return this.leftLink = ll;
    }

    @Override
    int compareTo(ListItem li) {
        if (super.getValue() != null && li != null) {
            Comparable<Object> currentVal = (Comparable<Object>) super.getValue();
            return currentVal.compareTo(li.getValue());
        }

        return -1;
    }
}
