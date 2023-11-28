package PendahuluanNomor4;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class ParsingHalamanWeb {
    
    public static void main(String[] args) {
        
        try {
            String sURL = "https://en.wikipedia.org/";
            Document doc = Jsoup.connect(sURL).get();
            String title = doc.title();
            System.out.println("TITLE:"+title);
            
            String teks = doc.text();
            System.out.println("Teks:"+teks);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
