class QueueWorld {
    public NodeWorld first;
    public NodeWorld last;

    // Method untuk menambahkan elemen ke queue
    public void enqueue(NodeWorld world) {
        if (last == null) {
            first = last = world;
        } else {
            last.next = world;
            last = world;
        }
    }

    // Method untuk menghapus elemen dari queue
    public void dequeue() {
        if (first == null) return;
        first = first.next;
        if (first == null) last = null;
    }

    public void pindahDunia(){
        first.tree.swap(first.tree.findKarakter(), first.next.tree.root);
        dequeue();
    }

    // Method untuk menampilkan elemen-elemen di queue
    public void tampilkan() {
        if (first == null) {
            System.out.println("belum memasuki world");
            return;
        }
        NodeWorld current = first;
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
    }
}
