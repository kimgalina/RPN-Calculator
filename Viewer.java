
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

    private JButton createJButton(String btnText, int x, int y, int width,int height,Font font,String actionCommand){
        JButton btn = new JButton(btnText);
        btn.setBounds(x,y,width,height);
        btn.setFont(font);
        btn.setBackground(Color.GRAY);
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
        return tField;
    }
    public void startApplication(){

        Font font = new Font("TimesRoman",Font.BOLD,30);
        Color backgroundColor = new Color(48, 49, 54);

        result = createJTextField(50,50,430,60,backgroundColor,font);
        expression = createJTextField(50,110,430,60,backgroundColor,font);


        JButton btn9 = createJButton("9",50,180,100,70,font,"9");
        JButton btn8 = createJButton("8",160,180,100,70,font,"8");
        JButton btn7 = createJButton("7",270,180,100,70,font,"7");
        JButton btnDel = createJButton("\u232b",380,180,100,70,font,"delete");

        JButton btn6 = createJButton("6",50,260,100,70,font,"6");
        JButton btn5 = createJButton("5",160,260,100,70,font,"5");
        JButton btn4 = createJButton("4",270,260,100,70,font,"4");
        JButton btnDot = createJButton(".",380,260,100,70,font,".");


        JButton btn3 = createJButton("3",50,340,100,70,font,"3");
        JButton btn2 = createJButton("2",160,340,100,70,font,"2");
        JButton btn1 = createJButton("1",270,340,100,70,font,"1");
        JButton btnDivide = createJButton("\u00f7",380,340,100,70,font,"divide");


        JButton btnBracket1 = createJButton("(",50,420,100,70,font,"bracket1");
        JButton btn0 = createJButton("0",160,420,100,70,font,"0");
        JButton btnBracket2 = createJButton(")",270,420,100,70,font,"bracket2");
        JButton btnMultiply = createJButton("\u00d7",380,420,100,70,font,"multiply");

        JButton btnC = createJButton("C",50,500,100,70,font,"clear");
        JButton btnPlus = createJButton("+",160,500,100,70,font,"plus");
        JButton btnMinus = createJButton("-",270,500,100,70,font,"minus");
        JButton btnEqual = createJButton("=",380,500,100,70,font,"equal");





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
