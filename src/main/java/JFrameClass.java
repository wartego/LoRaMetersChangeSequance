import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;


public class JFrameClass extends javax.swing.JFrame implements ActionListener, KeyListener {
    private int counter = 1;
    String getTextFromBefore;

    JButton generate, buttonExit, buttonClear;
    JLabel textDisplay, pictureLabel, textHistory;
    JTextField fieldBefore, fieldAfter ;
    JTextArea textHistoryKey;
    StringBuilder stringBuilder = new StringBuilder();
    public JFrameClass(){
        setSize(850,500);
        setTitle("Key changing sequance");
        setLayout(null);

        // Buttons
        generate = new JButton("Generate Key");
        generate.setBounds(120,400,150,30);
        generate.setBorderPainted(true);
        generate.setBorder(new LineBorder(Color.BLACK, 1));
        add(generate);
        generate.addActionListener(this);

        buttonExit = new JButton("Exit");
        buttonExit.setBounds(300,400,80,30);
        buttonExit.setBackground(new Color(243, 154, 154));
        buttonExit.setBorder(new LineBorder(Color.BLACK, 1));
        buttonExit.setBorderPainted(true);
        add(buttonExit);
        buttonExit.addActionListener(this);

        buttonClear = new JButton("Clear history");
        buttonClear.setBounds(400,400,120,30);
        buttonClear.setBorderPainted(true);
        buttonClear.setBorder(new LineBorder(Color.BLACK, 1));
        add(buttonClear);
        buttonClear.addActionListener(this);
        //

        /// labels
        textDisplay = new JLabel("Key before: ");
        textDisplay.setBounds(20,120,80,50);
        add(textDisplay);

        textDisplay = new JLabel("LoRa Key: ");
        textDisplay.setBounds(20,200,80,50);
        add(textDisplay);

        pictureLabel = new JLabel("Brunata");
        pictureLabel.setIcon(new ImageIcon("C:\\Users\\user\\IdeaProjects\\LoRametersChangeSequance\\d_56e5f2a7e27de.jpg"));
        pictureLabel.setBounds(10,10,127,86);
        add(pictureLabel);

        textHistory = new JLabel("History: ");
        textHistory.setBounds(430,50,200,30);
        textHistory.setFont(new Font("Times New Roman", Font.PLAIN,12));
        add(textHistory);

        //textArea

        textHistoryKey = new JTextArea("");
        textHistoryKey.setBounds(430,80,390,300);
        textHistoryKey.setFont(new Font("Arial",Font.CENTER_BASELINE,9));
        textHistoryKey.setMargin( new Insets(3,3,3,3));
        add(textHistoryKey);




        // textFields
        fieldBefore = new JTextField("");
        fieldBefore.setBounds(110,120,300,60);
        fieldBefore.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                super.keyPressed(e);
                if(e.getKeyChar() == KeyEvent.VK_ENTER){
                    System.out.println("Hello");
                    MethodWhenGenerateButton();
                }
            }
        });
        add(fieldBefore);

        fieldAfter = new JTextField("");
        fieldAfter.setBounds(110,200,300,60);
        fieldAfter.setFont(new Font("Times New Roman", Font.ITALIC,14));
        add(fieldAfter);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object incomingButton = e.getSource();
        if (incomingButton == generate) {

            MethodWhenGenerateButton();

        } else if (incomingButton == buttonExit) {
            dispose();
        } else if (incomingButton == buttonClear) {
            stringBuilder = new StringBuilder();
            textHistoryKey.setText(String.valueOf(stringBuilder));
            fieldBefore.setText("");
            fieldAfter.setText("");
            counter = 1;
        }
    }

    private void MethodWhenGenerateButton() {
        getTextFromBefore = fieldBefore.getText();
        MethodKeyChange methodKeyChange = new MethodKeyChange(getTextFromBefore);
        fieldAfter.setText(String.valueOf(methodKeyChange.getStringKeyAfter()));


        if (counter < 25) {
            textHistoryKey.setText(String.valueOf(stringBuilder
                    .append(String.format("[%-2s]",counter))
                    .append(getTextFromBefore + "  -->   ")
                    .append(methodKeyChange.getStringKeyAfter()).append("\n")));
        } else {
            counter = 0;
            stringBuilder = new StringBuilder();

        }
        counter++;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
