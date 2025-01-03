public class BinaryTree {
    public NodeSite root;
    public NodeSite save;

    public void tampilanSoal(){
        System.out.println(findSiteKarakter().pertanyaan);
    }

    public String cekJawaban(){
        return findSiteKarakter().jawaban;
    }

    public void cekFuture(){
        NodeSite current = findSiteKarakter();
        if(current.left==null) System.out.println("Jalan ke kiri adalah zonk");
        else if(current.left!=null) System.out.println("jalan ke kiri adalah "+current.left.name+" site");
        if(current.right==null) System.out.println("Jalan ke right adalah zonk");
        else if(current.right!=null) System.out.println("jalan ke kanan adalah "+current.right.name+" site");
    }

    public void showAnswer(){
        System.out.println("bocoran nich, jawaban yang bener adalah : "+findSiteKarakter().jawaban);
    }

    public void backToRoot(){
        swap(findSiteKarakter(), root);
    }

    public void tampilanEnding(){
        System.out.println(findSiteKarakter().karakter.ending);
    }

    public boolean cekBuku(){
        if(findSiteKarakter().bukuThere==null){
            return false;
        }
        else{
            return true;
        }
    }

    public void inBuku(){
        NodeSite current = findSiteKarakter();
        current.karakter.buku.push(current.bukuThere);
        current.karakter.jumlahBuku++;
        current.bukuThere=null;
    }

    public NodeBuku outBuku(){
        NodeSite current = findSiteKarakter();
        current.karakter.jumlahBuku--;
        return current.karakter.buku.pop();
    }

    public int totalBuku(){
        return findSiteKarakter().karakter.jumlahBuku;
    }

    public void goRight(){
        NodeSite current = findSiteKarakter();
        swap(current, current.right);
    }

    public void goLeft(){
        NodeSite current = findSiteKarakter();
        swap(current, current.left);
    }

    public boolean cekSiteLast(){ // mengecek apakah itu node yg menuju ending atau tidak
        NodeSite current = findSiteKarakter();
        if(current.left==current.right&current.left!=null&&current.right!=null){
            return true;
        }
        else{
            return false;
        }
    }

    public NodeSite findSiteKarakter (){
        find(root);
        return save;
    }

    public void find (NodeSite current){
        if(current!=null){
            if(current.karakter.name != " "){
                save=current;
                return;
            }
            find(current.left);
            find(current.right);
        }   
    }

    public void swap (NodeSite current1, NodeSite current2){
        NodeKarakter temp = current1.karakter;
        current1.karakter=current2.karakter;
        current2.karakter=temp;
    }
}
