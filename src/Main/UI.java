package Main; // Déclaration du package dans lequel se trouve la classe UI

import javax.swing.*; // Importation de classes Swing pour les composants graphiques
import java.awt.*; // Importation de classes AWT pour les éléments de base de l'interface graphique

public class UI { // Déclaration de la classe UI

    GameManager gm; // Déclaration de la variable gm pour stocker l'instance de GameManager
    JFrame window; // Déclaration de la variable window pour représenter la fenêtre principale de l'interface utilisateur
    public JTextArea messageText; // Déclaration d'un composant JTextArea pour afficher des messages
    public JPanel bgPanel[] = new JPanel[10]; // Déclaration d'un tableau de panneaux pour le fond
    public JLabel bgLabel[] = new JLabel[10]; // Déclaration d'un tableau d'étiquettes pour le fond

    // Constructeur de la classe UI
    public UI(GameManager gm){ // Définition du constructeur prenant une instance de GameManager en argument
        this.gm = gm; // Initialisation de la variable gm avec l'instance de GameManager passée en argument
        createMainFeild(); // Appel à la méthode pour créer le champ principal de l'interface utilisateur
        createBackgound(); // Appel à la méthode pour créer le fond de l'interface utilisateur
        window.setVisible(true); // Rend la fenêtre visible
    }

    // Méthode pour créer le champ principal de l'interface utilisateur
    public void createMainFeild(){ // Définition de la méthode pour créer le champ principal
        window = new JFrame(); // Crée une nouvelle instance de JFrame pour représenter la fenêtre principale
        window.setSize(800,600); // Définit la taille de la fenêtre à 800 pixels de largeur sur 600 pixels de hauteur
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Définit l'action par défaut lorsque la fenêtre est fermée
        window.getContentPane().setBackground(Color.black); // Définit la couleur de fond du contenu de la fenêtre en noir
        window.setLayout(null); // Définit le gestionnaire de disposition comme null pour permettre un positionnement manuel des composants

        // Création et configuration d'un composant JTextArea pour afficher des messages
        messageText = new JTextArea("HI THI IS MY FIRST GAME");
        messageText.setBounds(50,410,700,150);
        messageText.setBackground(Color.black);
        messageText.setForeground(Color.white);
        messageText.setEditable(false);
        messageText.setLineWrap(true);
        messageText.setWrapStyleWord(true);
        messageText.setFont(new Font("Book Antiqua" , Font.PLAIN, 26));
        window.add(messageText); // Ajout du composant à la fenêtre
    }

    public void createBackgound(){ // Définition de la méthode pour créer le fond de l'interface utilisateur
        bgPanel[1]= new JPanel(); // Création d'un nouveau panneau pour le fond
        bgPanel[1].setBounds(50,50,700,350); // Définition de la position et de la taille du panneau
        bgPanel[1].setBackground(Color.ORANGE); // Définit la couleur de fond du panneau
        bgPanel[1].setLayout(null); // Définit le gestionnaire de disposition comme null pour permettre un positionnement manuel des composants
        window.add(bgPanel[1]); // Ajout du panneau à la fenêtre

        bgLabel[1]= new JLabel(); // Création d'une nouvelle étiquette pour le fond
        bgLabel[1].setBounds(0,0,700,350); // Définition de la position et de la taille de l'étiquette

        // Chargement de l'image de fond et configuration de l'étiquette
        ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource("backgrounds/bg.png"));
        bgLabel[1].setIcon(bgIcon);

        bgPanel[1].add(bgLabel[1]); // Ajout de l'étiquette au panneau
    }
}
