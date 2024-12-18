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
}
