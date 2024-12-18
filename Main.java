import java.util.Scanner;
public class MainAdit__i {
        public static void textCenter(String text){
        String spasiKiri = " ".repeat((75-text.length())/2);
        String spasiKanan = " ".repeat(75-((75-text.length())/2)-text.length());
        System.out.println("| |"+spasiKiri+text+spasiKanan+"| |");
    }

    public static void textLeft(String text){
        String spasiKanan = " ".repeat(74-text.length());
        System.out.println("| | "+text+spasiKanan+"| |");
    }

    public static void textRight(String text){
        String spasiKiri = " ".repeat(74-text.length());
        System.out.println("| |"+spasiKiri+text+" | |");
    }

    public static void main(String[] args) {
        QueueWorld queue = new QueueWorld();
        LLKarakter ll = new LLKarakter();
        Scanner inputUser = new Scanner(System.in);

        String garis = "|+|"+ "=".repeat(75)+"|+|";
        String spasi = "| |"+ " ".repeat(75)+"| |";

        // Memasukkann emelen dalam game
        NodeWorld world1 = new NodeWorld("anxiety", "cemas");
        queue.enqueue(world1);
        NodeKarakter karakter1 = new NodeKarakter(" ", 0, " ", " ", 0);
        world1.tree.root  = new NodeSite("Shadow Corridor", "Apa yang biasanya paling ditakuti oleh tokoh utama di dalam sebuah cerita?"+
        "\na.Sosok Bayangan\nb.Kehilangan barang berharga\nc.Kehilangan arah\nd.Kegagalan dalam misi", "a", null, karakter1);

        ll.add("Subaru", 17, "Male", "Fear", 0);
        ll.add("Reinhard", 22, "Male", "Fear", 0);
        ll.add("Emilia", 100, "Female", "Anxiety", 0);
        ll.add("Rem", 19, "Female", "Envy", 0);
        ll.add("Petelgeuse Romanee-Conti", 130, "Male", "Anxiety", 0);

        NodeKarakter karakter;
        ll.bubbleSort();
        System.out.println(garis);
        System.out.println(spasi);
        textCenter("Pilih Karakter Anda");
        System.out.println(spasi);
        System.out.println(garis);
        ll.display();
        System.out.println(garis);
        while (true) {
            textLeft("Masukkan nomor karakter yang anda pilih : ");
            System.out.print("|=| ");
            int memilih  = inputUser.nextInt();
            if(memilih>0 && memilih <6){
                karakter=ll.getKarakter(memilih); 
                queue.first.tree.root.karakter=karakter;
                break;
            }
            else{
                textLeft("format jabawan yang anda masukkan salah");
                textLeft("Silahkan masukkan ulang dengan format 1/2/3/4/5");
            }
        }
        inputUser.close();
    }
}
