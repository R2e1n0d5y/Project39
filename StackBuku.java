class StackBuku {
    public NodeBuku top;

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
}
