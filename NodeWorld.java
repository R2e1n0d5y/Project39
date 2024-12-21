public class NodeWorld {
    String nama;
    String deskripsi;
    NodeWorld next;
    
    BinaryTree tree = new BinaryTree();

    // Konstruktor
    public NodeWorld (String nama, String deskripsi) {
        this.nama = nama;
        this.deskripsi = deskripsi;
    }
}