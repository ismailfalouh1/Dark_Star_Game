package Main;

import javax.swing.*;
import java.awt.*;

public class UI {

    GameManager gm; // Déclaration de la variable gm pour stocker l'instance de GameManager
    JFrame window; // Déclaration de la variable window pour représenter la fenêtre principale de l'interface utilisateur
    public JTextArea messageText;
    public JPanel bgPanel[] = new JPanel[10];
    public JLabel bgLabel[] = new JLabel[10];

    // Constructeur de la classe UI
    public UI(GameManager gm){
        this.gm = gm; // Initialisation de la variable gm avec l'instance de GameManager passée en argument
        createMainFeild();// Appel à la méthode pour créer le champ principal de l'interface utilisateur
        createBackgound();
        window.setVisible(true); // Rend la fenêtre visible

    }

    // Méthode pour créer le champ principal de l'interface utilisateur
    public void createMainFeild(){

        window = new JFrame(); // Crée une nouvelle instance de JFrame pour représenter la fenêtre principale
        window.setSize(800,600); // Définit la taille de la fenêtre à 800 pixels de largeur sur 600 pixels de hauteur
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Définit l'action par défaut lorsque la fenêtre est fermée
        window.getContentPane().setBackground(Color.black); // Définit la couleur de fond du contenu de la fenêtre en noir
        window.setLayout(null); // Définit le gestionnaire de disposition comme null pour permettre un positionnement manuel des composants


        messageText = new JTextArea("HI THI IS MY FIRST GAME");
        messageText.setBounds(50,410,700,150);
        messageText.setBackground(Color.black);
        messageText.setForeground(Color.white);
        messageText.setEditable(false);
        messageText.setLineWrap(true);
        messageText.setWrapStyleWord(true);
        messageText.setFont(new Font("Book Antiqua" , Font.PLAIN, 26));
        window.add(messageText);

    }
    public void createBackgound(){

        bgPanel[1]= new JPanel();
        bgPanel[1].setBounds(50,50,700,350);
        bgPanel[1].setBackground(Color.ORANGE);
        bgPanel[1].setLayout(null);
        window.add(bgPanel[1]);


        bgLabel[1]= new JLabel();
        bgLabel[1].setBounds(0,0,700,350);

        ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource("backgrounds/bg.png"));
        bgLabel[1].setIcon(bgIcon);


        bgPanel[1].add(bgLabel[1]);
    }
}

