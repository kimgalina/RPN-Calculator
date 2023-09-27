
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

    private JButton createJButton(String btnText, int x, int y, int width,int height,Font font,String actionCommand,Color buttonColor,
                                    Color btnTextColor){

        JButton btn = new JButton(btnText);
        btn.setBounds(x,y,width,height);
        btn.setFont(font);
        btn.setBackground(buttonColor);
        btn.setForeground(btnTextColor);
        btn.setBorder(null);
        btn.setActionCommand(actionCommand);
        btn.addActionListener(controller);
        return btn;
    }

    private JTextField createJTextField(int x,int y,int width,int height,Color backgroundColor, Font font){
        JTextField tField = new JTextField("0");
        tField.setBounds(x,y,width,height);
        tField.setFont(font);
        tField.setBackground(backgroundColor);
        tField.setForeground(Color.WHITE);
        tField.setBorder(null);
        tField.setHorizontalAlignment(JTextField.RIGHT);
        return tField;
    }
    public void startApplication(){

        Font font = new Font("TimesRoman",Font.BOLD,30);
        Color backgroundColor = new Color(23, 24, 26);
        Color buttonColor1 = new Color(48, 49, 54);
        Color buttonColor2 = new Color(0, 93, 178);
        Color buttonColor3 = new Color(97, 97, 97);
        Color btnTextWhite = new Color(165, 165, 165);
        Color btnTextBlue = new Color(41, 168, 255);

        result = createJTextField(50,50,430,60,backgroundColor,font);
        expression = createJTextField(50,110,430,60,backgroundColor,font);


        JButton btn9 = createJButton("9",50,220,100,70,font,"9",buttonColor1,btnTextBlue);
        JButton btn8 = createJButton("8",160,220,100,70,font,"8",buttonColor1,btnTextBlue);
        JButton btn7 = createJButton("7",270,220,100,70,font,"7",buttonColor1,btnTextBlue);
        JButton btnDel = createJButton("\u232b",380,220,100,70,font,"delete",buttonColor3,btnTextWhite);

        JButton btn6 = createJButton("6",50,300,100,70,font,"6",buttonColor1,btnTextBlue);
        JButton btn5 = createJButton("5",160,300,100,70,font,"5",buttonColor1,btnTextBlue);
        JButton btn4 = createJButton("4",270,300,100,70,font,"4",buttonColor1,btnTextBlue);
        JButton btnDot = createJButton(".",380,300,100,70,font,".",buttonColor1,btnTextBlue);


        JButton btn3 = createJButton("3",50,380,100,70,font,"3",buttonColor1,btnTextBlue);
        JButton btn2 = createJButton("2",160,380,100,70,font,"2",buttonColor1,btnTextBlue);
        JButton btn1 = createJButton("1",270,380,100,70,font,"1",buttonColor1,btnTextBlue);
        JButton btnDivide = createJButton("\u00f7",380,380,100,70,font,"divide",buttonColor2,btnTextBlue);


        JButton btnBracket1 = createJButton("(",50,460,100,70,font,"bracket1",buttonColor1,btnTextBlue);
        JButton btn0 = createJButton("0",160,460,100,70,font,"0",buttonColor1,btnTextBlue);
        JButton btnBracket2 = createJButton(")",270,460,100,70,font,"bracket2",buttonColor1,btnTextBlue);
        JButton btnMultiply = createJButton("\u00d7",380,460,100,70,font,"multiply",buttonColor2,btnTextBlue);

        JButton btnC = createJButton("C",50,540,100,70,font,"clear",buttonColor3,btnTextWhite);
        JButton btnPlus = createJButton("+",160,540,100,70,font,"plus",buttonColor2,btnTextBlue);
        JButton btnMinus = createJButton("-",270,540,100,70,font,"minus",buttonColor2,btnTextBlue);
        JButton btnEqual = createJButton("=",380,540,100,70,font,"equal",buttonColor2,btnTextBlue);





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
        frame.setSize(550,750);
        frame.setLayout(null);
        frame.getContentPane().setBackground(backgroundColor);
        frame.setLocation(700,200);
        frame.setVisible(true);

    }




}
