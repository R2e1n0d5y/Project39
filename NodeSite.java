// NodeKarakter.java
public class NodeSite {
    String name;
    String pertanyaan;
    String jawaban;
    NodeBuku bukuThere;
    NodeKarakter karakter;

    NodeSite right;
    NodeSite left;

    // Constructor
    public NodeSite(String name, String pertanyaan, String jawaban, NodeBuku bukuThere) {
        this.name = name;
        this.pertanyaan = pertanyaan;
        this.jawaban = jawaban;
        this.bukuThere = bukuThere;
        this.karakter= new NodeKarakter(" ", 0, " ", " ", 0, " ");
    }
}
