public class BinaryTree {
    public NodeSite root;

    public void tampilanSoal(){
        System.out.println(findKarakter().pertanyaan);
    }

    public void tampilanSiteVisit(){//konsep aja, kalau sempet tambahin

    }

    public void cekFuture(){
        NodeSite current = findKarakter();
        if(current.left==null) System.out.println("Jalan ke kiri adalah zonk");
        else if(current.left!=null) System.out.println("jalan ke kiri adalah "+current.left.name+" site");
        if(current.right==null) System.out.println("Jalan ke right adalah zonk");
        else if(current.right!=null) System.out.println("jalan ke kanan adalah "+current.right.name+" site");
    }

    public void showAnswer(){
        System.out.println("bocoran nich, jawaban yang bener adalah : "+findKarakter().jawaban);
    }

    public void backToRoot(){
        swap(findKarakter(), root);
    }

    public boolean cekBuku(){
        if(findKarakter().bukuThere==null){
            return false;
        }
        else{
            return true;
        }
    }

    public void inBuku(){
        NodeSite current = findKarakter();
        current.karakter.buku.push(current.bukuThere);
    }

    public boolean goRight(){
        NodeSite current = findKarakter();
        if(current.right!=null){
            swap(current, current.right);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean goLeft(){
        NodeSite current = findKarakter();
        if(current.left!=null){
            swap(current, current.left);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean cekSiteLast(){ // mengecek apakah itu node yg menuju ending atau tidak
        NodeSite current = findKarakter();
        if(current.left==current.right){
            return true;
        }
        else{
            return false;
        }
    }

    public NodeSite findKarakter (){
        NodeSite save=null, current=root;
        find(current, save);
        return save;
    }

    public void find (NodeSite current, NodeSite save){
        if(current!=null){
            if(current.karakter.name != " "){
                save=current;
                return;
            }
            if(save==null){
                find(current.left, save);
                find(current.right, save);
            }
        }   
    }

    public void swap (NodeSite current1, NodeSite current2){
        NodeKarakter temp = current1.karakter;
        current1.karakter=current2.karakter;
        current2.karakter=temp;
    }
}
