package Lab07;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUITrie extends JFrame {
    private final int ALTO = 600;
    private final int ANCHO = 600;

    public GUITrie() {
        this.setTitle("Trie");
        this.setSize(ANCHO, ALTO);
        this.setLayout(new BorderLayout(ALLBITS, ABORT));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.BLUE);
        this.createContents();
        this.setVisible(true);
    }

    public void createContents() {
        Trie trie = new Trie();
        getContentPane().setBackground(Color.LIGHT_GRAY);
        JMenuBar mb = new JMenuBar();
        JMenu replace = new JMenu("REEMPLAZAR");
        mb.add(replace);

        JTextArea areaTexto = new JTextArea();

        JPanel panel = new JPanel();
        JLabel label = new JLabel("Introducir texto");
        JTextField tf = new JTextField(10);
        JButton insertWord = new JButton("Insertar palabra");
        JButton insertText = new JButton("Insertar texto");
        JButton buscar = new JButton("Buscar");
        panel.add(label);
        panel.add(tf);
        panel.add(insertWord);
        panel.add(insertText);
        panel.add(buscar);

        // Agregar componentes al marco.
        this.add(BorderLayout.NORTH, mb);
        this.add(BorderLayout.CENTER, areaTexto);
        this.add(BorderLayout.SOUTH, panel);

        insertWord.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                trie.insert(tf.getText());
                System.out.println("Palabra " + tf.getText() + "insertada en el Trie");
                areaTexto.setText(trie.toString());
                tf.setText("");
            }
        });
        insertText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                trie.insertText(tf.getText());
                System.out.println("Texto " + tf.getText() + " insertado en el Trie");
                areaTexto.setText(trie.toString());
                tf.setText("");
            }
        });
    }

    public static void main(String[] args) {
        new GUITrie();
    }
}
