//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;

public class Board extends JFrame {
    public int guesses;
    public Character character;
    public int iterations = 0;
    public int count;
    public String word = new String();

    public Board() {
        WordReader fiveletter = new WordReader();
        this.word = fiveletter.WordReader(5);
        this.setDefaultCloseOperation(3);
        this.setSize(500, 800);
        final JButton five = new JButton("5");
        final JButton seven = new JButton("7");
        final JButton submit = new JButton("submit");
        final JTextField answer = new JTextField();
        final JTextField values = new JTextField("_ _ _ _ _");
        final JTextField guess = new JTextField();
        values.setEditable(false);
        this.setLayout(new GridLayout(1, 4));
        this.add(five);
        this.add(seven);
        this.setVisible(true);
        this.guesses = 5;
        guess.setFont(new Font("Serif", 1, 30));
        answer.setFont(new Font("Serif", 1, 30));
        values.setFont(new Font("Serif", 1, 30));
        guess.setText("Guesses left: " + String.valueOf(this.guesses));
        guess.setEditable(false);
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                DefaultHighlighter highlighter = (DefaultHighlighter)values.getHighlighter();
                highlighter.setDrawsLayeredHighlights(false);
                HighlightPainter greenpainter = new DefaultHighlighter.DefaultHighlightPainter(Color.GREEN); // Create a HighlightPainter with the desired color
                HighlightPainter yellowpainter = new DefaultHighlighter.DefaultHighlightPainter(Color.YELLOW);
                HighlightPainter redpainter = new DefaultHighlighter.DefaultHighlightPainter(Color.RED);
                new DefaultHighlighter.DefaultHighlightPainter(Color.YELLOW);
                new DefaultHighlighter.DefaultHighlightPainter(Color.RED);

                --Board.this.guesses;
                StringBuilder result = new StringBuilder();
                guess.setText("Guesses left: " + String.valueOf(Board.this.guesses));
                values.setText(answer.getText());
                highlighter.removeAllHighlights();
                for(int amount = 0; amount < 5; ++amount) {
                    for (int iterations = 0; iterations < 5; ++iterations) {
                        character = word.charAt(iterations);
                        if (answer.getText().charAt(amount) == word.charAt(amount)) {
                            try {
                                highlighter.addHighlight(amount, amount + 1, greenpainter);
                            } catch (BadLocationException ex) {
                                throw new RuntimeException(ex);
                            }
                            break;
                        }
                      else if (answer.getText().charAt(amount) == word.charAt(iterations)) {
                            try {

                                highlighter.addHighlight(iterations, iterations + 1, yellowpainter);
                            } catch (BadLocationException ex) {
                                throw new RuntimeException(ex);
                            }
                            break;
                        }
                      else  {
                            try {
                                highlighter.addHighlight(amount, amount + 1, redpainter);
                            } catch (BadLocationException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                    }

                    }


            }
        });
        five.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Board.this.remove(five);
                Board.this.remove(seven);
                Board.this.setVisible(false);
                Board.this.setVisible(true);
                Board.this.setLayout(new GridLayout(4, 1));
                Board.this.add(guess);
                Board.this.add(values);
                Board.this.add(answer);
                Board.this.add(submit);
                Board.this.setVisible(true);
            }
        });
    }
}
