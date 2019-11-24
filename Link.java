public class Link {
    int data;
    Link next;
    Link head;

    public Link(int value) {
        data = value;
    }

    public boolean addAtFront(Link link, int data) {
        Link newNode = new Link(data);
        newNode.next = head;
        return false;
    }
}
