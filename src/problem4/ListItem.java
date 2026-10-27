package problem4;

public abstract class ListItem {
    protected ListItem rightLink;
    protected ListItem leftLink;
    protected Object value;

    public ListItem(Object value) {
        this.value = value;
    }

    // Abstract Methods
    abstract ListItem next();
    abstract void setNext(ListItem rl);
    abstract ListItem previous();
    abstract void setPrevious(ListItem ll);
    abstract void compareTo(ListItem li);

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

}
