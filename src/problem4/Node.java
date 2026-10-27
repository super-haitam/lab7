package problem4;

public class Node extends ListItem {
    public Node(Object o) {
        super(o);
        // TODO: It has a constructor that takes an Object,
        //  then calls its parent constructor with the parameter that was passed in.
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
    void compareTo(ListItem li) {
        // TODO: compareTo(), takes a ListItem and compares it to the ListItem that called this method. Use value from ListItem for comparison.
        // TODO: Use value from ListItem for comparison. If this value is greater than the value that was passed in, then it should return a
        //  number greater than zero. If vice versa, then it should return a number less than zero, and zero if equal.
    }
}
