// NodeKarakter.java
public class NodeKarakter {
    String name;
    int age;
    String gender;
    String affiliation;
    int jumlahBuku;
    String ending;
    
    NodeKarakter next;

    StackBuku buku = new StackBuku();

    // Constructor
    public NodeKarakter(String name, int age, String gender, String affiliation, int jumlahBuku, String ending) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.affiliation = affiliation;
        this.jumlahBuku = jumlahBuku;
        this.ending = ending;
        this.next = null;
    }
}