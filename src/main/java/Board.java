//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;


public class Board extends JFrame {





    public int usage =0;
    public String fiveword;

    public Board() {
        WordReader fiveletter = new WordReader();
       fiveword = fiveletter.WordReader(5);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       setSize(500, 1000);
        final JButton five = new JButton("5");
        final JButton seven = new JButton("7");
        final JButton submit = new JButton("submit");
       JTextField answer = new JTextField("");

        final JTextField guess = new JTextField();

       setLayout(new GridLayout(2, 6));
        add(five);
        add(seven);
        setVisible(true);



            answer.setFont(new Font("Serif", Font.BOLD, 30));



        submit.addActionListener(new ActionListener() {
            final JTextField[] values = new JTextField[5];

            public void actionPerformed(ActionEvent e) {
                JTextField currentguess = new JTextField(answer.getText());
                System.out.println(answer.getText());
                values[usage] =currentguess;
                values[usage].setFont(new Font("Serif", Font.BOLD, 30));
                Board.this.add(values[usage]);
                Board.this.setVisible(false);
                Board.this.setVisible(true);


                Highlighter highlighter = values[usage].getHighlighter();
                        Highlighter.HighlightPainter greenpainter = new DefaultHighlighter.DefaultHighlightPainter(Color.GREEN);
                        Highlighter.HighlightPainter yellowpainter = new DefaultHighlighter.DefaultHighlightPainter(Color.YELLOW);
                        Highlighter.HighlightPainter redpainter = new DefaultHighlighter.DefaultHighlightPainter(Color.RED);
                        for (int i = 0; i < 5; i++) {
                            if (values[usage].getText().charAt(i) == fiveword.charAt(i)) {
                                try {
                                    highlighter.addHighlight(i, i + 1, greenpainter);
                                } catch (BadLocationException ex) {
                                    throw new RuntimeException(ex);
                                }
                            }
                            for (int k = 0; k < 5; k++) {
                                if (values[usage].getText().charAt(i) == fiveword.charAt(k) && i != k) {
                                    try {
                                        highlighter.addHighlight(i, i + 1, yellowpainter);
                                    } catch (BadLocationException ex) {
                                        throw new RuntimeException(ex);
                                    }

                                }
                                else{
                                    try {
                                        highlighter.addHighlight(i, i + 1, redpainter);

                                    } catch (BadLocationException ex) {
                                        throw new RuntimeException(ex);
                                    }
                                }
                            }
                            }
                        }
        });
        five.addActionListener(e -> {

            Board.this.remove(five);
            Board.this.remove(seven);
            Board.this.setVisible(false);
            Board.this.setVisible(true);
            Board.this.setLayout(new GridLayout(9, 1));

            Board.this.add(answer);

            Board.this.add(guess);
            Board.this.add(submit);
            Board.this.setVisible(true);
        });
    }
}
