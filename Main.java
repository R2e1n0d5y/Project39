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
        NodeWorld world1 = new NodeWorld("FEAR", "A dark realm where fears twist reality into endless nightmares");
        NodeWorld world2 = new NodeWorld("ENVY", "A realm where jealousy and longing twist hearts and distort reality");
        NodeWorld world3 = new NodeWorld("ANXIETY", "A realm where worry and fear dominate, clouding every thought and action");

        ll.add("Subaru", 17, "Male", "Fear", 0, "Determined to save everyone despite endless suffering.");
        ll.add("Reinhard", 22, "Male", "Fear", 0, "Upholds justice with the strength of the Sword Saint.");
        ll.add("Emilia", 100, "Female", "Anxiety", 0, "Hopes to become queen and prove her worth.");
        ll.add("Rem", 19, "Female", "Envy", 0, "Loves Subaru unconditionally, even from the shadows.");
        ll.add("Petelgeuse Romanee-Conti", 130, "Male", "Anxiety", 0, "Obsessed with fulfilling the Witch's twisted desires.");

        NodeBuku BukuRoot1 = new NodeBuku("Fate Loop", "Kembali ke site pertama dunia ini", "Fear", "Lake of Jealousy");
        NodeBuku BukuRoot2 = new NodeBuku("Return by Death", "Kembali ke site pertama dunia ini", "Envy", "Everlasting Mist Forest");
        NodeBuku BukuPetunjuk1 = new NodeBuku("Roswaals Secrets", "Mendapatkan petunjuk jawaban yang benar", "Fear", "Shadow Corridor");
        NodeBuku BukuPetunjuk2 = new NodeBuku("Emilias Journey", "Mendapatkan petunjuk jawaban yang benar", "Envy", "Broken Bridge");
        NodeBuku BukuPetunjuk3 = new NodeBuku("Beatrices Solitude", "Mendapatkan petunjuk jawaban yang benar", "Anxiety", "Hill of Regret");
        NodeBuku BukuFuture1 = new NodeBuku("Satellas Origins", "Anda dapat mengetahui jalan berikutnya jadi site ini", "Fear", "Valley of Silence");
        NodeBuku BukuFuture2 = new NodeBuku("The Sword Saint", "Anda dapat mengetahui jalan berikutnya jadi site ini", "Envy", "Cliff of Dread");
        NodeBuku BukuNDunia1 = new NodeBuku("Witchs Labyrinth", "Menuju ke dunia berikutnya", "Fear", "Temple of Reflection");
        NodeBuku BukuNDunia2 = new NodeBuku("Rems Devotion", "Menuju ke dunia berikutnya", "Envy", "Hill of Regret");
        NodeBuku BukuEnding = new NodeBuku("Beyond the Mist", "Menuju ke ending", "Envy", "Lake of Jealousy");  
        
       //Fear
       world1.tree.root  = new NodeSite("Shadow Corridor", "Apa yang biasanya paling ditakuti oleh tokoh utama di dalam sebuah cerita?"+
       "\na.Sosok Bayangan\nb.Kehilangan barang berharga\nc.Kehilangan arah\nd.Kegagalan dalam misi", "a", BukuPetunjuk1);
       world1.tree.root.left  = new NodeSite("Hill of Regret", "Kenapa tokoh utama tidak langsung menghadapi ketakutannya?"+
       "\na.Ia takut gagal\nb.Ia merasa tidak cukup kuat\nc.Ia ingin mencari bantuan terlebih dahulu\nd.Ketakutannya bukanlah ancaman serius", "b", null);
       world1.tree.root.right = new NodeSite("Broken Bridge", "Apa simbol ketakutan terbesar yang muncul dalam cerita?"+
       "\na.Bayangan di dinding\nb.Pintu terkunci\nc. Cermin retak\nd.Langit merah", "b", null);
       world1.tree.root.left.left  = new NodeSite("Valley of Silence", "Siapa yang membantu tokoh utama mengatasi ketakutannya?"+
       "\na.Temannya\nb.Musuhnya\nc.Orang asing\nd.Dirinya sendiri", "a", BukuFuture1);
       world1.tree.root.left.right  = new NodeSite("Gate of False Hope", "Lingkungan seperti apa yang menggambarkan ketakutan tokoh utama?"+
       "\na.Gelap dan penuh suara misterius\nb.Terang dan penuh warna\nc.Sepi dan tenang\nd.Ramai dengan banyak orang", "a", null);
       world1.tree.root.right.right  = new NodeSite("Temple of Reflection", "Apa momen puncak yang menunjukkan keberanian tokoh utama?"+
       "\na.Ketika ia meminta bantuan\nb.Ketika ia membuka pintu terkunci\nc.Ketika ia mengabaikan rasa takutnya\nd. Ketika ia melarikan diri", "c", BukuNDunia1);
       world1.tree.root.left.right.left  = new NodeSite("Everlasting Mist Forest", "Apa keputusan tokoh utama dalam menghadapi ketakutannya?"+
       "\na.Melarikan diri ke tempat aman\nb.Meminta orang lain menyelesaikan masalahnya\nc.Menghadapinya langsung dengan keberanian\nd.Mengabaikannya", "c", null);
       world1.tree.root.left.right.right  = new NodeSite("Lake of Jealousy", "Apa yang menyadarkan tokoh utama bahwa ketakutannya hanyalah ilusi?"+
       "\na. Bantuan dari temannya\nb. Ia melihat kenyataan yang berbeda dari apa yang ia bayangkan\nc. Petunjuk dari musuhnya\nd. Penjelasan dari seorang mentor", "b", BukuRoot1);
       world1.tree.root.right.right.left  = new NodeSite("Dead-End Road", "Apa pelajaran yang didapatkan tokoh utama setelah melewati ketakutannya?"+
       "\na. Ketakutan adalah emosi yang tidak berguna\nb. Rasa takut tidak pernah bisa diatasi\nc. Keberanian adalah menghadapi rasa takut, bukan menghindarinya\nd. Ketakutan bisa diabaikan tanpa konsekuensi", "c", null);
       world1.tree.root.right.right.right  = new NodeSite("Cliff of Dread", "Apa simbol yang melambangkan akhir dari ketakutan tokoh utama?"+
       "\na. Cahaya terang di ujung lorong\nb. Suara yang hilang\nc. Hutan yang berubah menjadi taman\nd. Jembatan yang telah diperbaikii", "a", null);
       //envy
       world2.tree.root  = new NodeSite("Whispering Market", "Apa yang menjadi sumber rasa iri tokoh utama?"+
       "\na. Kekayaan temannya\nb. Kesuksesan temannya\nc. Hubungan romantis temannya\nd. Kehidupan keluarga temannya", "b", null);
       world2.tree.root.left  = new NodeSite("Labyrinth of Worry", "Apa dampak dari rasa iri terhadap hubungan tokoh utama dengan orang lain?"+
       "\na. Hubungannya menjadi lebih kuat\nb. Hubungannya menjadi tegang dan penuh konflik\nc. Tidak ada dampak apa pun\nd. Ia memutuskan hubungan dengan semua orang", "b", BukuNDunia2);
       world2.tree.root.right  = new NodeSite("Lake of Jealousy", "Apa tindakan negatif yang dilakukan tokoh utama karena rasa iri?"+
       "\na. Menyebarkan rumor buruk\nb. Membantu temannya dengan niat tersembunyi\nc. Memutuskan hubungan tanpa alasan\nd. Mengkritik diri sendiri secara berlebihan", "d", BukuEnding);
       world2.tree.root.left.left  = new NodeSite("Gate of False Hope", "Apa simbol yang mencerminkan rasa iri dalam cerita?"+
       "\na. Cermin yang memantulkan bayangan buruk\nb. Pintu yang tertutup rapat\nc. Air hijau di danau yang tenang\nd. Gunung yang terlalu tinggi untuk didaki", "a", null);
       world2.tree.root.left.right  = new NodeSite("Hill of Regret", "Bagaimana tokoh utama menyadari bahwa rasa irinya salah?"+
       "\na. Ia melihat temannya mengalami kesulitan yang tidak ia ketahui sebelumnya\nb. Ia menerima nasihat dari seorang mentor\nc. Ia gagal dalam usahanya menjatuhkan temannya\nd. Ia menghadapi akibat buruk dari tindakannya", "a", null);
       world2.tree.root.right.left  = new NodeSite("Shadow Corridor", "Apa pelajaran utama yang dipetik tokoh utama dari pengalamannya dengan rasa iri?"+
       "\na. Fokus pada pencapaian diri sendiri lebih penting daripada membandingkan diri dengan orang lain\nb. Rasa iri dapat memotivasi seseorang untuk sukses\nc. Tidak ada gunanya berkompetisi dengan teman\nd. Hidup tidak adil, dan rasa iri adalah hal normal", "a", null);
       world2.tree.root.right.right  = new NodeSite("Everlasting Mist Forest", "Apa konflik utama yang muncul akibat rasa iri?"+
       "\na. Ketegangan dalam hubungan dengan teman\nb. Kehilangan pekerjaan\nc. Ketidakharmonisan dalam keluarga\nd. Kegagalan dalam perjalanan misi", "a", BukuRoot2);
       world2.tree.root.left.left.left  = new NodeSite("SCliff of Dread", "Apa tindakan positif pertama yang dilakukan tokoh utama setelah mengatasi rasa iri?"+
       "\na. Meminta maaf kepada temannya\nb. Membantu temannya dengan tulus\nc. Fokus pada proyek pribadi tanpa melibatkan temannya\nd. Meninggalkan lingkaran sosialnya", "b", null);
       world2.tree.root.left.left.right  = new NodeSite("Temple of Reflection", "Bagaimana rasa iri memengaruhi pilihan tokoh utama?"+
       "\na. Ia membuat keputusan berdasarkan perasaan negatifnya\nb. Ia mengambil jalan pintas untuk mengungguli temannya\nc. Ia menghindari proyek yang dapat membantunya berkembang\nd. Semua di atas", "d", null);
       world2.tree.root.right.left.right  = new NodeSite("Broken Bridge", "Apa perubahan terbesar pada tokoh utama setelah mengatasi rasa iri?"+
       "\na. Ia menjadi lebih percaya diri dan suportif\nb. Ia memutuskan hubungan dengan teman-temannya\nc. Ia berhenti peduli tentang pencapaian apa pun\nd. Ia memilih untuk menyendiri sepenuhnya", "a", BukuPetunjuk2);
       world2.tree.root.right.right.left  = new NodeSite("Shadow Corridor", "Apa yang mengakhiri konflik dalam cerita?"+
       "\na. Diskusi terbuka dengan temannya\nb. Temannya memaafkan tindakan tokoh utama\nc. Tokoh utama belajar untuk fokus pada kebahagiaannya sendiri\nd. Semua di atas", "d", null);
       world2.tree.root.right.right.right  = new NodeSite("Gate of False Hope", "Apa momen puncak yang menyadarkan tokoh utama bahwa rasa iri tidak membawa manfaat?"+
       "\na. Ketika ia melihat sisi lemah temannya\nb. Ketika ia gagal dalam tindakannya\nc. Ketika ia dihadapkan pada mentor yang bijaksana\nd. Ketika ia menghadapi situasi yang sama dengan temannya", "a", null);
       world2.tree.root.left.left.right.left  = new NodeSite("Everlasting Mist Forest", "Apa yang biasanya paling ditakuti oleh tokoh utama di dalam sebuah cerita?"+
       "\na.Sosok Bayangan\nb.Kehilangan barang berharga\nc.Kehilangan arah\nd.Kegagalan dalam misi", "a", null);
       world2.tree.root.right.left.right.left  = new NodeSite("Whispering Market", "Kenapa tokoh utama tidak langsung menghadapi ketakutannya?"+
       "\na.Ia takut gagal\nb.Ia merasa tidak cukup kuat\nc.Ia ingin mencari bantuan terlebih dahulu\nd.Ketakutannya bukanlah ancaman serius", "b", null);
       world2.tree.root.right.left.right.right = new NodeSite("Labyrinth of Worry", "Apa simbol ketakutan terbesar yang muncul dalam cerita?"+
       "\na.Bayangan di dinding\nb.Pintu terkunci\nc. Cermin retak\nd.Langit merah", "b", null);
       world2.tree.root.right.right.right.right = new NodeSite("Shadow Corridor", "Siapa yang membantu tokoh utama mengatasi ketakutannya?"+
       "\na.Temannya\nb.Musuhnya\nc.Orang asing\nd.Dirinya sendiri", "a", null);
       world2.tree.root.right.left.right.left.left  = new NodeSite("Shadow Corridor", "Lingkungan seperti apa yang menggambarkan ketakutan tokoh utama?"+
       "\na.Gelap dan penuh suara misterius\nb.Terang dan penuh warna\nc.Sepi dan tenang\nd.Ramai dengan banyak orang", "a", null);
       world2.tree.root.right.left.right.left.right  = new NodeSite("Shadow Corridor", "Apa momen puncak yang menunjukkan keberanian tokoh utama?"+
       "\na.Ketika ia meminta bantuan\nb.Ketika ia membuka pintu terkunci\nc.Ketika ia mengabaikan rasa takutnya\nd. Ketika ia melarikan diri", "c", null);
       world2.tree.root.right.left.right.right.right = new NodeSite("Dead-End Road", "Apa keputusan tokoh utama dalam menghadapi ketakutannya?"+
       "\na.Melarikan diri ke tempat aman\nb.Meminta orang lain menyelesaikan masalahnya\nc.Menghadapinya langsung dengan keberanian\nd.Mengabaikannya", "c", null);
       world2.tree.root.right.right.right.right.left = new NodeSite("Cliff of Dread", "Apa yang menyadarkan tokoh utama bahwa ketakutannya hanyalah ilusi?"+
       "\na. Bantuan dari temannya\nb. Ia melihat kenyataan yang berbeda dari apa yang ia bayangkan\nc. Petunjuk dari musuhnya\nd. Penjelasan dari seorang mentor", "b", BukuFuture2);
       world2.tree.root.right.right.right.right.right  = new NodeSite("Shadow Corridor", "Apa pelajaran yang didapatkan tokoh utama setelah melewati ketakutannya?"+
       "\na. Ketakutan adalah emosi yang tidak berguna\nb. Rasa takut tidak pernah bisa diatasi\nc. Keberanian adalah menghadapi rasa takut, bukan menghindarinya\nd. Ketakutan bisa diabaikan tanpa konsekuensi", "c", null);
       world2.tree.root.right.right.right.right.right.right = new NodeSite("Hill of Regret", "Apa simbol yang melambangkan akhir dari ketakutan tokoh utama?"+
       "\na. Cahaya terang di ujung lorong\nb. Suara yang hilang\nc. Hutan yang berubah menjadi taman\nd. Jembatan yang telah diperbaikii", "a", null);
       //anxiety
       world3.tree.root  = new NodeSite("Hill of Regret", "Apa yang memicu kecemasan pada tokoh utama?"+
       "\na. Ketidakpastian masa depan\nb. Kehilangan seseorang yang dicintai\nc. Konflik dengan teman\nd. Ketakutan terhadap gelap", "a", BukuPetunjuk3);
       world3.tree.root.left  = new NodeSite("Shadow Corridor", "Bagaimana kecemasan tokoh utama memengaruhi pilihannya?"+
       "\na. Ia terus-menerus menunda keputusan penting\nb. Ia bertindak tergesa-gesa tanpa memikirkan akibatnya\nc. Ia menghindari orang-orang di sekitarnya\nd. Ia menjadi sangat fokus pada tugasnya", "a", null);
       world3.tree.root.right = new NodeSite("Valley of Silence", "Apa yang membantu tokoh utama mengatasi kecemasannya?"+
       "\na. Belajar menerima ketidakpastian\nb. Melarikan diri dari masalahnya\nc. Menyendiri untuk waktu yang lama\nd. Meminta orang lain mengambil alih tanggung jawabnya", "a", null);
       world3.tree.root.left.left  = new NodeSite("Gate of False Hope", "Apa yang biasanya paling ditakuti oleh tokoh utama di dalam sebuah cerita?"+
       "\na.Sosok Bayangan\nb.Kehilangan barang berharga\nc.Kehilangan arah\nd.Kegagalan dalam misi", "a", null);
       world3.tree.root.left.right  = new NodeSite("Everlasting Mist Forest", "Kenapa tokoh utama tidak langsung menghadapi ketakutannya?"+
       "\na.Ia takut gagal\nb.Ia merasa tidak cukup kuat\nc.Ia ingin mencari bantuan terlebih dahulu\nd.Ketakutannya bukanlah ancaman serius", "b", null);
       world3.tree.root.right.left  = new NodeSite("Dead-End Road", "Apa simbol ketakutan terbesar yang muncul dalam cerita?"+
       "\na.Bayangan di dinding\nb.Pintu terkunci\nc. Cermin retak\nd.Langit merah", "b", null);
       world3.tree.root.right.right  = new NodeSite("Labyrinth of Worry", "Siapa yang membantu tokoh utama mengatasi ketakutannya?"+
       "\na.Temannya\nb.Musuhnya\nc.Orang asing\nd.Dirinya sendiri", "a", null);

        queue.enqueue(world1);
        queue.enqueue(world2);
        queue.enqueue(world3);

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

        while(true){
            System.out.println(garis);
            System.out.println(spasi);
            textCenter(queue.first.nama);
            System.out.println(spasi);
            textCenter(queue.first.deskripsi);
            System.out.println(spasi);
            System.out.println(garis);
            textCenter(queue.first.tree.findSiteKarakter().name);
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
                continue;
            }

            boolean menjawab = true;
            if(queue.first.tree.totalBuku()!=0){
                while (true) {  
                    System.out.println(garis);
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
                            queue.first.tree.tampilanEnding();
                            System.out.println(garis);
                            textCenter("Selamat Anda Berhasil Menuju Ending");
                            textCenter("Dan Memenangkan Game Ini");
                            System.out.println(garis);
                            return;
                        }
                        else if(buku.ability=="Menuju ke dunia berikutnya"){
                            queue.pindahDunia();
                            menjawab = false;
                        }
                        else if(buku.ability=="Mendapatkan petunjuk jawaban yang benar"){
                            textCenter("jawaban yang benar :"+queue.first.tree.cekJawaban());
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
                                System.out.println();
                                System.out.println(garis);
                                queue.first.tree.tampilanEnding();
                                System.out.println(garis);
                                textCenter("Selamat Anda Berhasil Menuju Ending");
                                textCenter("Dan Memenangkan Game Ini");
                                System.out.println(garis);
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
                                    if(queue.first.tree.findSiteKarakter().left==null){
                                        if(queue.cekPindahDunia()==true){
                                            queue.pindahDunia();
                                            textCenter("Tempet yang terdapat dijalur yang anda pilih tidak ada");
                                            textCenter("Anda akan dipindahkan dunia");
                                        }
                                        else{
                                            textCenter("Tempet yang terdapat dijalur yang anda pilih tidak ada");
                                            textCenter("Anda telah sampai di dunia terakhir");
                                            textCenter("Kamu kalah");
                                            System.out.println(spasi);
                                            System.out.println(garis);
                                            return;
                                        }
                                    }
                                    else{
                                        textCenter("Anda akan pindah ke tempat berikutnya");
                                        queue.first.tree.goLeft();
                                    }
                                    System.out.println(garis);
                                    break;
                                }
                                else if(pilihJalur=='r'){
                                    System.out.println(garis);
                                    textRight(">===>===>");
                                    System.out.println(garis);
                                    if(queue.first.tree.findSiteKarakter().right==null){
                                        if(queue.cekPindahDunia()==true){
                                            queue.pindahDunia();
                                            textCenter("Tempet yang terdapat dijalur yang anda pilih tidak ada");
                                            textCenter("Anda akan dipindahkan dunia");
                                        }
                                        else{
                                            textCenter("Tempet yang terdapat dijalur yang anda pilih tidak ada");
                                            textCenter("Anda telah sampai di dunia terakhir");
                                            textCenter("Kamu kalah");
                                            System.out.println(spasi);
                                            System.out.println(garis);
                                            return;
                                        }
                                    }
                                    else{
                                        textCenter("Anda akan pindah ke tempat berikutnya");
                                        queue.first.tree.goRight();
                                    }
                                    System.out.println(garis);
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
                            if(queue.first.next!=null){
                                System.out.println(garis);
                                textCenter("Jawaban anda salah");
                                textLeft("Anda akan pindahkan ke dunia lain");
                                System.out.println(garis);
                                queue.pindahDunia();
                            }
                            else{
                                System.out.println(garis);
                                textCenter("Anda telah sampai di dunia terakhir");
                                textCenter("Kamu kalah");
                                System.out.println(garis);
                                return;
                            }
                            
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
            System.out.println("press any key except enter or spasi to continue and next press enter");
            inputUser.next();
        }
    }
}