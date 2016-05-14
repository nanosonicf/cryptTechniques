
package crypttechniques;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.border.*;

//Algoritmalarin oldugu sinifimi import ediyorum
//import crypttechniques.EncryptionAlgorithms;
/**
 *
 * @author FurkanAkharman
 */
public class IOFrame {
    private JFrame frame1;
    private JButton caesar;
    private JButton vigenere;
    private JButton rsa;
    private JTextField intext;//orijinal metin
    private JLabel encryptedText;
    private JLabel originalText;
    private JPanel buttonPanel;
    private JPanel labelPanel;
    
   private JFormattedTextField inputText;
   
    
    private void prepareGUI(){
        //Framede kullanılacak elemanları hazırlıyoruz, henüz framee eklemiyoruz
        frame1 = new JFrame("Sifreleme algoritmalari");
        frame1.setSize(350, 200);
        frame1.setLayout(new FlowLayout());
        
        buttonPanel = new JPanel(new GridLayout(1,3));
        buttonPanel.setBorder(new LineBorder(Color.red));
        
        labelPanel = new JPanel(new GridLayout(2,1));
        labelPanel.setBorder(new LineBorder(Color.blue));
       // labelPanel.setSize(200,100);
        intext = new JTextField("Sifrelenecek metni gir");
        encryptedText = new JLabel("Sifrelenmis Metin");
        originalText = new JLabel("Orijinal Metin");
        
        caesar = new JButton("Caesar");
        vigenere = new JButton("Vigenere");
        rsa = new JButton("RSA");
        //Tum tanımlamalarımız bittikten sonra elemanlari frame ekliyoruz
        
        buttonPanel.add(rsa);
        buttonPanel.add(caesar);
        buttonPanel.add(vigenere);
        
        labelPanel.add(originalText);
        labelPanel.add(encryptedText);
        
        frame1.add(intext);
        frame1.add(buttonPanel);
        frame1.add(labelPanel);
        
        frame1.setVisible(true);
        
        //framemimiz icin window listenerlar
        frame1.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent winevt) {
                System.out.println("pencere kapatildi");//terminalden uyari
                System.exit(0);
            }
        });
        
        //text fielda tiklandiginda icini bosaltma
        intext.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mevt){
            intext.setText("");
            }
        });
        
        //Buttonlarin action listenerlari
        caesar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                EncryptionAlgorithms algObject = new EncryptionAlgorithms(intext.getText());
                encryptedText.setText(algObject.caeserAlgorithm());
                originalText.setText(intext.getText());
                System.out.println("caesar");
            }
        });
                        
         vigenere.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EncryptionAlgorithms algObject = new EncryptionAlgorithms(intext.getText());
                encryptedText.setText(algObject.vigenereAlgorithm());
                originalText.setText((intext.getText()));
                 System.out.println("vigenere");
            }
        });
         
         rsa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            EncryptionAlgorithms algObject = new EncryptionAlgorithms(intext.getText());
          encryptedText.setText(algObject.rsa()); 
          originalText.setText(intext.getText());
          System.out.println("rsa");    
            }
        });
         
               
       
    //End of prepareGUI method       
    }
    
    
    public String getText() { //Sifeleme algoritmalari clasina orijinal metnimizi göndermek icin
        return intext.toString();
    }
    
    public void setText(String encryptedText){  //algoritma cevabi gönderdiginde almak icin
        originalText.setText(this.intext.toString());
        this.encryptedText.setText(encryptedText);   
    }
    
    
    public void run(){
    
        this.prepareGUI();
    
    }
    
    
    
    
    
    
    //end of ioframe class
}
