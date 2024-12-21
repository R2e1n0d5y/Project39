// LLKarakter.java
public class LLKarakter {
    public NodeKarakter head;
    public NodeKarakter tail;

    public void add (String nama, int age, String gender, String affiliation, int totalBuku, String ending) {
        NodeKarakter newNode = new NodeKarakter(nama, age, gender, affiliation, totalBuku, ending);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void bubbleSort(){
        boolean swapped;
        do {
            swapped=false;
            NodeKarakter current = head;
            while (current.next != null) {
                if (current.name.charAt(0) > current.next.name.charAt(0)) {

                    String temp1 = current.name;
                    int temp2 = current.age;
                    String temp3 = current.gender;
                    String temp4 = current.affiliation;
                    String temp5 = current.ending;
                    int temp6 = current.jumlahBuku;

                    current.name=current.next.name;
                    current.age=current.next.age;
                    current.gender=current.next.gender;
                    current.affiliation=current.next.affiliation;
                    current.ending=current.next.ending;
                    current.jumlahBuku=current.next.jumlahBuku;

                    current.next.name=temp1;
                    current.next.age=temp2;
                    current.next.gender=temp3;
                    current.next.affiliation=temp4;
                    current.next.ending=temp5;
                    current.next.jumlahBuku=temp6;

                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);   
    }

    public NodeKarakter getKarakter(int nomor) {
        NodeKarakter current = head;
        int counter = 1;
        while (counter != nomor) {
            current = current.next;
            counter++;
        }
        return current;
    }

    public void display() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        NodeKarakter current = head;
        int counter = 1;
        while (current != null) {
            System.out.println("|"+counter+"| Nama   : "+current.name);
            System.out.println("| | Usia   : "+current.age);
            System.out.println("| | Gender : "+current.gender);
            System.out.println("| | Asal   : "+current.affiliation);
            counter++;
            current = current.next;
        }
    }
}