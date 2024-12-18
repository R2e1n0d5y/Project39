import java.util.Scanner;

public class Main {
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

        while(true){//tempet finish blm dibuat
            System.out.println(garis);
            System.out.println(spasi);
            textCenter(queue.first.nama);
            System.out.println(spasi);
            System.out.println(garis);
            textCenter(karakter.name);
            System.out.println(spasi);
            textRight(karakter.name);
            textRight(" "+karakter.age);
            textRight(karakter.gender);
            textRight("Jumlah Buku");
            textRight("["+karakter.jumlahBuku+"]");
            textRight("\\");

            if(queue.first.tree.cekBuku()){
                System.out.println(garis);
                textLeft("Anda mendapatkan buku : "+queue.first.tree.findSiteKarakter().bukuThere.nama);
                textLeft("at : "+queue.first.nama+"."+queue.first.tree.findSiteKarakter().name);
                textLeft("ability : ........");
                System.out.println(garis);
                queue.first.tree.inBuku();
            }

            boolean menjawab = true;
            if(queue.first.tree.totalBuku()!=0){
                while (true) {  
                    textLeft("Apakah anda ingin menggunakan buku? (y/t)");
                    System.out.print("|=| ");
                    char pilih  = inputUser.next().charAt(0);
                    if(pilih=='y'){
                        NodeBuku buku = queue.first.tree.outBuku();
                        textLeft("buku yang digunakan : "+buku.nama);
                        textLeft("didapatkan pada : "+buku.world+"."+buku.site);
                        textLeft("dengan ability : "+buku.ability);
                        System.out.println(garis);
                        if(buku.ability=="Kembali ke site pertama dunia ini"){
                            queue.first.tree.backToRoot();
                            menjawab = false;
                        }
                        else if(buku.ability=="Menuju ke ending"){
                            System.out.println();
                            System.out.println(garis);
                            textCenter("Selamat Anda Berhasil Menuju Ending");
                            textCenter("Dan Memenangkan Game Ini");
                            System.out.println(garis);
                            System.out.println("\nPress ENTER to continue...");
                            inputUser.nextLine();
                            return;
                        }
                        else if(buku.ability=="Menuju ke dunia berikutnya"){
                            queue.pindahDunia();
                            menjawab = false;
                        }
                        else if(buku.ability=="Mendapatkan petunjuk jawaban yang benar"){
                            queue.first.tree.cekJawaban();
                        }
                        else if(buku.ability=="Anda dapat mengetahui jalan berikutnya jadi site ini"){
                            queue.first.tree.cekFuture();
                        }
                        break;
                    }
                    else if(pilih=='t'){
                        break;
                    }
                    else{
                        textLeft("format jabawan yang anda masukkan salah");
                        textLeft("Silahkan masukkan ulang dengan format y/t");
                    }   
                }
            }

            if(menjawab == true){
                System.out.println(spasi);
                System.out.println(garis);
                textLeft("Pertanyaan");
                System.out.println(garis);
                System.out.println();
                queue.first.tree.tampilanSoal();
                System.out.println();
                System.out.println(garis);

                while (true) {
                    textLeft("Masukkan jawaban anda (a/b/c/d)");
                    System.out.print("|=| ");
                    char pilihJawaban  = inputUser.next().charAt(0);
                    if(pilihJawaban=='a'||pilihJawaban=='b'||pilihJawaban=='c'||pilihJawaban=='d'){
                        if(pilihJawaban==queue.first.tree.cekJawaban().charAt(0)){
                            System.out.println(garis);
                            textCenter("Jawaban anda benar");
                            System.out.println(garis);

                            if(queue.first.tree.cekSiteLast()){
                                System.out.println("\nPress ENTER to continue...");
                                inputUser.nextLine();
                                System.out.println();
                                System.out.println(garis);
                                textCenter("Selamat Anda Berhasil Menuju Ending");
                                textCenter("Dan Memenangkan Game Ini");
                                System.out.println(garis);
                                System.out.println("\nPress ENTER to continue...");
                                inputUser.nextLine();
                                return;
                            }

                            textLeft("Silahkan memilih jalan kiri atau kanan !");
                            textLeft("<===o");
                            textRight("o===>");
                            System.out.println(garis);

                            while (true) {
                                textLeft("Masukkan pilihan anda (l/r)");
                                System.out.print("|=| ");
                                char pilihJalur  = inputUser.next().charAt(0);
                                if(pilihJalur=='l'){
                                    System.out.println(garis);
                                    textLeft("<===<===<");
                                    System.out.println(garis);
                                    queue.first.tree.goLeft();
                                    break;
                                }
                                else if(pilihJalur=='r'){
                                    System.out.println(garis);
                                    textRight(">===>===>");
                                    System.out.println(garis);
                                    queue.first.tree.goRight();
                                    break;
                                }
                                else{
                                    System.out.println(garis);
                                    textLeft("format jabawan yang anda masukkan salah");
                                    textLeft("Silahkan masukkan ulang dengan format l/r");
                                    System.out.println(garis);
                                }
                            }  
                        }
                        else{
                            System.out.println(garis);
                            textCenter("Jawaban anda salah");
                            textLeft("Anda akan pindahkan ke dunia lain");
                            System.out.println(garis);
                            queue.pindahDunia();
                        }
                        break;
                    }
                    else{
                        System.out.println(garis);
                        textLeft("format jabawan yang anda masukkan salah");
                        textLeft("Silahkan masukkan ulang dengan format a/b/c/d");
                        System.out.println(garis);
                    }
                }   
            }

            System.out.println("Press ENTER to continue...");
            inputUser.nextLine();
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        inputUser.close();
        }
    }
}
