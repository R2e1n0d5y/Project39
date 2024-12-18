// NodeKarakter.java
public class NodeKarakter {
    String name;
    int age;
    String gender;
    String affiliation;
    int totalBuku;
    NodeKarakter next;

    // Constructor
    public NodeKarakter(String name, int age, String gender, String affiliation, int totalBuku) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.affiliation = affiliation;
        this.totalBuku = totalBuku;
        this.next = null;
    }

    // String representation of a node
    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Gender: " + gender + ", " +
               "Affiliation: " + affiliation + ", Total Buku: " + totalBuku;
    }
}