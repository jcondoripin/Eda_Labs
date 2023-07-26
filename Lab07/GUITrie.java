
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUITrie extends JFrame {
    private final int ALTO = 600;
    private final int ANCHO = 1000;

    public GUITrie() {
        this.setTitle("INSERTAR - BUSCAR - REEMPLAZAR");
        this.setSize(ANCHO, ALTO);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.getContentPane().setBackground(new Color(230, 230, 230));

        this.createContents();
        this.setVisible(true);
    }

    public void createContents() {
        Trie trie = new Trie();

        JMenuBar mb = new JMenuBar();
        JButton replace = new JButton("MODO - REEMPLAZAR");
        JButton home = new JButton("MODO - ENCONTRAR E INSERTAR");
        replace.setBackground(Color.orange);
        home.setBackground(Color.orange);
        mb.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        mb.add(replace);
        mb.add(home);

        JPanel contentTrie = new JPanel();
        contentTrie.setBackground(Color.white);
        contentTrie.setLayout(new BorderLayout());

        JTextArea areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaTexto);
        contentTrie.add(BorderLayout.CENTER, scrollPane);

        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel label = new JLabel("Introducir texto:");
        panel.add(label, gbc);

        gbc.gridy++;
        JTextField tf = new JTextField(20);
        panel.add(tf, gbc);

        gbc.gridy++;
        JButton insertWord = new JButton("Insertar palabra");
        panel.add(insertWord, gbc);

        gbc.gridy++;
        JButton insertText = new JButton("Insertar texto");
        panel.add(insertText, gbc);

        gbc.gridy++;
        JButton buscar = new JButton("Buscar");
        panel.add(buscar, gbc);

        gbc.gridy++;
        JLabel searchLabel = new JLabel("");
        panel.add(searchLabel, gbc);

        gbc.gridy++;
        JLabel label2 = new JLabel("Palabra a reemplazar:");
        label2.setVisible(false);
        panel.add(label2, gbc);

        gbc.gridy++;
        JTextField tf2 = new JTextField(20);
        tf2.setVisible(false);
        panel.add(tf2, gbc);

        gbc.gridy++;
        JButton reemplazar = new JButton("Reemplazar");
        reemplazar.setVisible(false);
        panel.add(reemplazar, gbc);

        this.add(BorderLayout.NORTH, mb);
        this.add(BorderLayout.WEST, panel);
        this.add(BorderLayout.CENTER, contentTrie);

        buscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (trie.search(tf.getText())) {
                    searchLabel.setText("La palabra '" + tf.getText() + "' está presente");
                    tf.setText("");
                } else {
                    searchLabel.setText("La palabra '" + tf.getText() + "' NO está presente");
                    tf.setText("");
                }
            }
        });

        replace.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText("Palabra nueva:");
                label2.setVisible(true);
                tf2.setVisible(true);
                reemplazar.setVisible(true);
                insertWord.setVisible(false);
                insertText.setVisible(false);
                buscar.setVisible(false);
                searchLabel.setVisible(false);
            }
        });

        reemplazar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                trie.replace(tf2.getText(), tf.getText());
                areaTexto.setText(trie.toString());

            }
        });

        home.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText("Introducir texto:");
                label2.setVisible(false);
                tf2.setVisible(false);
                reemplazar.setVisible(false);
                insertWord.setVisible(true);
                insertText.setVisible(true);
                buscar.setVisible(true);
                searchLabel.setVisible(true);

            }
        });

        insertWord.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                trie.insert(tf.getText());
                areaTexto.setText(trie.toString());
                tf.setText("");
            }
        });

        insertText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                trie.insertText(tf.getText());
                areaTexto.setText(trie.toString());
                tf.setText("");
            }
        });
    }

    public static void main(String[] args) {
        new GUITrie();
    }
}

