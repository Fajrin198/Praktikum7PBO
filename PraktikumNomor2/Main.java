package PraktikumNomor2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Passing Web");
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // kita mengambil contentPane nya terus memasukkannya ke dalam objek contentPane dengan tipe data container
        Container contentPane = frame.getContentPane();
        
        JPanel JPanelNorth = new JPanel(new FlowLayout());
        contentPane.add(JPanelNorth, BorderLayout.NORTH);
        
        JLabel JLabelURL = new JLabel("URL");
        
        JTextField JTextFieldURL = new JTextField();
        JTextFieldURL.setPreferredSize(new Dimension(460,28));
        
        JButton JButtonParse = new JButton("PARSE");
        JButtonParse.setBackground(Color.BLACK);
        JButtonParse.setForeground(Color.WHITE);
        
        JPanelNorth.add(JLabelURL);
        JPanelNorth.add(JTextFieldURL);
        JPanelNorth.add(JButtonParse);
        
        JPanel JPanelCenter = new JPanel(new BorderLayout());
//        JPanelCenter.setBackground(Color.GREEN);
        contentPane.add(JPanelCenter, BorderLayout.CENTER);
        JScrollPane JScrollPane = new JScrollPane();
        
        JTextPane JTextPane = new JTextPane();
        
        JScrollPane.setViewportView(JTextPane);
        JPanelCenter.add(JScrollPane, BorderLayout.CENTER);
        
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        //Aksi
        JButtonParse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // fungsinya untuk menangkap string yang dituliskan pada JTextFieldURL
                    String sURL = JTextFieldURL.getText();
                    Document doc = Jsoup.connect(sURL).get();
                    String text = doc.text();
                    JTextPane.setText(text);
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}
