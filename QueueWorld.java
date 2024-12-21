class QueueWorld {
    public NodeWorld first;
    public NodeWorld last;

    // Method untuk menambahkan elemen ke queue
    public void enqueue(NodeWorld world) {
        if (first == null) {
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

    }

    public boolean cekPindahDunia(){
        if(first==last){
            return false;
        }
        else{
            return true;
        }
    }

    public void pindahDunia(){
        first.tree.swap(first.tree.findSiteKarakter(), first.next.tree.root);
        dequeue();
    }
}
