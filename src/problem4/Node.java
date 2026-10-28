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
    void setNext(ListItem rl) {
        this.rightLink = rl;
    }

    @Override
    ListItem previous() {
        return this.leftLink;
    }

    @Override
    void setPrevious(ListItem ll) {
        this.leftLink = ll;
    }

    @Override
    int compareTo(ListItem li) {
        if (super.getValue() != null && li != null) {
            Comparable<Object> currentVal = (Comparable<Object>) super.getValue();
            return currentVal.compareTo(li.getValue());
        }

        return 0;
    }
}
