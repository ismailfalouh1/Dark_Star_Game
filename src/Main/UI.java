package Main; // Déclaration du package dans lequel se trouve la classe UI

import javax.swing.*; // Importation de classes Swing pour les composants graphiques
import java.awt.*; // Importation de classes AWT pour les éléments de base de l'interface graphique
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
        generateScereen();
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

    public void createBackgound( int bgNum , String bgFileName){ // Définition de la méthode pour créer le fond de l'interface utilisateur
        bgPanel[bgNum]= new JPanel(); // Création d'un nouveau panneau pour le fond
        bgPanel[bgNum].setBounds(50,50,700,350); // Définition de la position et de la taille du panneau
        bgPanel[bgNum].setBackground(Color.ORANGE); // Définit la couleur de fond du panneau
        bgPanel[bgNum].setLayout(null); // Définit le gestionnaire de disposition comme null pour permettre un positionnement manuel des composants
        window.add(bgPanel[bgNum]); // Ajout du panneau à la fenêtre

        bgLabel[bgNum]= new JLabel(); // Création d'une nouvelle étiquette pour le fond
        bgLabel[bgNum].setBounds(0,0,700,350); // Définition de la position et de la taille de l'étiquette

        // Chargement de l'image de fond et configuration de l'étiquette
        ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource(bgFileName));
        bgLabel[bgNum].setIcon(bgIcon);



    }
    public  void createObject(int bgNum, int objx, int objy , int objWidth , int objHeight, String objFileName ,
                              String choice1Name ,    String choice2Name ,    String choice3Name){

         //  CREATE PUP MENU

        JPopupMenu popMenu = new JPopupMenu();

        //  CREATE PUP MENU ITEMS

        JMenuItem menuItem[] = new JMenuItem[4];

        menuItem[1] = new JMenuItem(choice1Name);
        popMenu.add(menuItem[1]);

        menuItem[2] = new JMenuItem(choice2Name);
        popMenu.add(menuItem[2]);

        menuItem[3] = new JMenuItem(choice3Name);
        popMenu.add(menuItem[3]);


       // CREATE OBJECTS
        JLabel objectLabel = new JLabel();
        objectLabel.setBounds(objx,objy,objWidth,objHeight);

        ImageIcon objectIcon = new ImageIcon(getClass().getClassLoader().getResource(objFileName));
        objectLabel.setIcon(objectIcon);

        objectLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
            @Override
            public void mousePressed(MouseEvent e) {
                if ( SwingUtilities.isRightMouseButton(e)) {
                    popMenu.show(objectLabel, e.getX(),e.getY());
                }
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        bgPanel[bgNum].add(objectLabel);
        bgPanel[bgNum].add(bgLabel[bgNum]);




    }
    public  void generateScereen(){

        createBackgound(1, "backgrounds/bg.png");
        createObject(1,440,140,200,200,"castle.png","","","");
        createObject(1,78,180,150,150,"character.png","Look","Talk","Rest");
        createObject(1,310,280,70,70,"monster.png","","","");

    }
}
