class StackBuku {
    private NodeBuku top;

    // Method untuk menambahkan elemen ke stack
    public void push(NodeBuku buku) {
        buku.next = top;
        top = buku;
    }

    // Method untuk menghapus elemen dari stack
    public NodeBuku pop() {
        if (top == null) return null;
        NodeBuku removed = top;
        top = top.next;
        return removed;
    }

    // Method untuk menampilkan elemen-elemen di stack
    public void tampilkan() {
        if (top == null) {
            System.out.println("StackBuku kosong");
            return;
        }
        NodeBuku current = top;
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
    }
}
