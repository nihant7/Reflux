package Lists;

public class LinkedList {

static class Link {
    Link next;
    int data;

    Link(int data) {
        this.data = data;
    }
}

    public Link reverse(Link head) {

        Link curr = head;
        Link prev = null, next = null;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }

    public static void main(String[] args) {
    LinkedList ll = new LinkedList();

        Link link = new Link(1);
        link.next = new Link(2);
        link.next.next = new Link(3);

        ll.reverse(link);

        while(link != null ) {
            System.out.println(link.data);
            link = link.next;

        }

    }
}
