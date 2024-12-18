// LLKarakter.java
public class LLKarakter {
    private NodeKarakter head;

    // Constructor
    public LLKarakter() {
        this.head = null;
    }

    // Add a new node to the list
    public void add(int age, String gender, String affiliation, int totalBuku) {
        NodeKarakter newNode = new NodeKarakter(null, age, gender, affiliation, totalBuku);
        if (head == null) {
            head = newNode;
        } else {
            NodeKarakter current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Display the list
    public void display() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        NodeKarakter current = head;
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        LLKarakter linkedList = new LLKarakter();
        linkedList.add(25, "Female", "Writers Guild", 10);
        linkedList.add(30, "Male", "Historians Circle", 7);
        linkedList.add(22, "Female", "Science Society", 5);

        linkedList.display();
    }
}