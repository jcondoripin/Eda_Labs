
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUITrie extends JFrame {
    private final int ALTO = 600;
    private final int ANCHO = 1000;

    public GUITrie() {
        this.setTitle("INSERTAR - BUSCAR - REEMPLAZAR");
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
        JButton replace = new JButton("MODO REPLACE");
        JButton home = new JButton("FIND AND INSERT");
        mb.add(replace);
        mb.add(home);
        JPanel contentTrie = new JPanel();
        JTextArea areaTexto = new JTextArea();

        JPanel panel = new JPanel();
        JLabel label = new JLabel("Introducir texto");
        JLabel label2 = new JLabel("Palabra a reemplazar");
        label2.setVisible(false);
        JTextField tf = new JTextField(10);
        JTextField tf2 = new JTextField(10);
        tf2.setVisible(false);
        JButton insertWord = new JButton("Insertar palabra");
        JButton insertText = new JButton("Insertar texto");
        JButton buscar = new JButton("Buscar");
        JLabel searchLabel = new JLabel("");
        JButton reemplazar = new JButton("Reemplazar");
        reemplazar.setVisible(false);
        panel.add(label);
        panel.add(tf);
        panel.add(insertWord);
        panel.add(insertText);
        panel.add(buscar);
        panel.add(label2);
        panel.add(tf2);
        panel.add(reemplazar);
        panel.add(searchLabel);

        JLabel subt = new JLabel("Contenido del Trie: \n");
        contentTrie.add(subt);
        contentTrie.add(areaTexto);
        // Agregar componentes al marco.
        this.add(BorderLayout.NORTH, mb);
        this.add(BorderLayout.CENTER, contentTrie);
        this.add(BorderLayout.SOUTH, panel);
        buscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (trie.search(tf.getText())) {
                    searchLabel.setText("La palabra \' " + tf.getText() + "\' está presente");
                    tf.setText("");
                } else {
                    searchLabel.setText("La palabra \' " + tf.getText() + "\' NO está presente");
                    tf.setText("");
                }
            }
        });

        replace.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText("Palabra nueva: ");
                label2.setVisible(true);
                tf2.setVisible(true);
                reemplazar.setVisible(true);
                insertWord.setVisible(false);
                insertText.setVisible(false);
                buscar.setVisible(false);
            }
        });
        home.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText("Introducir texto ");
                label2.setVisible(false);
                tf2.setVisible(false);
                reemplazar.setVisible(false);
                insertWord.setVisible(true);
                insertText.setVisible(true);
                buscar.setVisible(true);
            }
        });

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
        reemplazar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                trie.replace(tf2.getText(), tf.getText());
                areaTexto.setText(trie.toString());
                tf.setText("");
                tf2.setText("");
            }
        });
    }

    public static void main(String[] args) {
        new GUITrie();
    }
}
