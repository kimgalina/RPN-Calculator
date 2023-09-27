
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;


public class Viewer {
    private JTextField result;
    private JTextField expression;
    private Controller controller;

    public Viewer(){
        controller = new Controller(this);
    }

    private RoundedButton createJButton(String btnText, int x, int y, int width,int height,Font font,String actionCommand,Color buttonColor,
                                    Color btnTextColor){

        int cornerRadius = 50;
        RoundedButton btn = new RoundedButton(btnText,cornerRadius);
        btn.setBounds(x,y,width,height);
        btn.setFont(font);
        btn.setBackground(buttonColor);
        btn.setForeground(btnTextColor);
        btn.setBorder(null);
        btn.setActionCommand(actionCommand);
        btn.addActionListener(controller);
        return btn;
    }

    private JTextField createJTextField(int x,int y,int width,int height,Color backgroundColor, Font font,Color txtColor){
        JTextField tField = new JTextField("0");
        tField.setBounds(x,y,width,height);
        tField.setFont(font);
        tField.setBackground(backgroundColor);
        tField.setForeground(txtColor);
        tField.setBorder(null);
        tField.setHorizontalAlignment(JTextField.RIGHT);
        return tField;
    }
    public void startApplication(){

        Font font = new Font("TimesRoman",Font.BOLD,30);
        Font resultFont = new Font("TimesRoman",Font.BOLD,40);
        Font expressionFont = new Font("TimesRoman",Font.PLAIN,30);

        Color backgroundColor = new Color(23, 24, 26);
        Color buttonColor1 = new Color(48, 49, 54);
        Color buttonColor2 = new Color(0, 93, 178);
        Color buttonColor3 = new Color(97, 97, 97);
        Color btnTextWhite = new Color(165, 165, 165);
        Color btnTextBlue = new Color(41, 168, 255);

        expression = createJTextField(20,100,430,60,backgroundColor,expressionFont,new Color(129, 129, 129));
        result = createJTextField(20,160,430,60,backgroundColor,resultFont,new Color(255,255,255));

        RoundedButton btn9 = createJButton("9",20,270,100,70,font,"9",buttonColor1,btnTextBlue);
        RoundedButton btn8 = createJButton("8",130,270,100,70,font,"8",buttonColor1,btnTextBlue);
        RoundedButton btn7 = createJButton("7",240,270,100,70,font,"7",buttonColor1,btnTextBlue);
        RoundedButton btnDel = createJButton("\u232b",350,270,100,70,font,"delete",buttonColor3,btnTextWhite);

        RoundedButton btn6 = createJButton("6",20,350,100,70,font,"6",buttonColor1,btnTextBlue);
        RoundedButton btn5 = createJButton("5",130,350,100,70,font,"5",buttonColor1,btnTextBlue);
        RoundedButton btn4 = createJButton("4",240,350,100,70,font,"4",buttonColor1,btnTextBlue);
        RoundedButton btnDot = createJButton(".",350,350,100,70,font,".",buttonColor1,btnTextBlue);


        RoundedButton btn3 = createJButton("3",20,430,100,70,font,"3",buttonColor1,btnTextBlue);
        RoundedButton btn2 = createJButton("2",130,430,100,70,font,"2",buttonColor1,btnTextBlue);
        RoundedButton btn1 = createJButton("1",240,430,100,70,font,"1",buttonColor1,btnTextBlue);
        RoundedButton btnDivide = createJButton("\u00f7",350,430,100,70,font,"divide",buttonColor2,btnTextBlue);


        RoundedButton btnBracket1 = createJButton("(",20,510,100,70,font,"bracket1",buttonColor1,btnTextBlue);
        RoundedButton btn0 = createJButton("0",130,510,100,70,font,"0",buttonColor1,btnTextBlue);
        RoundedButton btnBracket2 = createJButton(")",240,510,100,70,font,"bracket2",buttonColor1,btnTextBlue);
        RoundedButton btnMultiply = createJButton("\u00d7",350,510,100,70,font,"multiply",buttonColor2,btnTextBlue);

        RoundedButton btnC = createJButton("C",20,590,100,70,font,"clear",buttonColor3,btnTextWhite);
        RoundedButton btnPlus = createJButton("+",130,590,100,70,font,"plus",buttonColor2,btnTextBlue);
        RoundedButton btnMinus = createJButton("-",240,590,100,70,font,"minus",buttonColor2,btnTextBlue);
        RoundedButton btnEqual = createJButton("=",350,590,100,70,font,"equal",buttonColor2,btnTextBlue);





        JFrame frame = new JFrame("RPN Calculator");

        frame.add(result);
        frame.add(expression);

        frame.add(btn9);
        frame.add(btn8);
        frame.add(btn7);
        frame.add(btnDel);

        frame.add(btn6);
        frame.add(btn5);
        frame.add(btn4);
        frame.add(btnDot);

        frame.add(btn3);
        frame.add(btn2);
        frame.add(btn1);
        frame.add(btnDivide);

        frame.add(btnBracket1);
        frame.add(btn0);
        frame.add(btnBracket2);
        frame.add(btnMultiply);

        frame.add(btnPlus);
        frame.add(btnMinus);
        frame.add(btnEqual);
        frame.add(btnC);

        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setSize(490,750);
        frame.setLayout(null);
        frame.getContentPane().setBackground(backgroundColor);
        frame.setLocation(700,200);
        frame.setVisible(true);

    }




}
