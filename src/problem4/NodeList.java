package problem4;

public interface NodeList {
    abstract ListItem getRoot();
    abstract boolean addItem(ListItem li);
    abstract boolean removeItem(ListItem li);
    abstract void traverse(ListItem r);
}
