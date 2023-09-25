
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Color;


public class Viewer {
    private JTextField result;
    private JTextField expression;
    private Controller controller;

    public Viewer(){
        controller = new Controller(this);
    }
    public void startApplication(){

        result = new JTextField("0");
        //result.setForeground(Color.BLACK);
        result.setBounds(50,50,430,60);

        expression = new JTextField("0");
        expression.setBounds(50,110,430,60);

        JButton btn9 = new JButton("9");
        btn9.setBounds(50,180,100,70);

        JButton btn8 = new JButton("8");
        btn8.setBounds(160,180,100,70);

        JButton btn7 = new JButton("7");
        btn7.setBounds(270,180,100,70);

        JButton btnDel = new JButton("\u232b");
        btnDel.setBounds(380,180,100,70);



        JButton btn6 = new JButton("6");
        btn6.setBounds(50,260,100,70);

        JButton btn5 = new JButton("5");
        btn5.setBounds(160,260,100,70);

        JButton btn4 = new JButton("4");
        btn4.setBounds(270,260,100,70);

        JButton btnDot = new JButton(".");
        btnDot.setBounds(380,260,100,70);



        JButton btn3 = new JButton("3");
        btn3.setBounds(50,340,100,70);

        JButton btn2 = new JButton("2");
        btn2.setBounds(160,340,100,70);

        JButton btn1 = new JButton("1");
        btn1.setBounds(270,340,100,70);

        JButton btnDivide = new JButton("\u00f7");
        btnDivide.setBounds(380,340,100,70);


        JButton btnBracket1 = new JButton("(");
        btnBracket1.setBounds(50,420,100,70);

        JButton btn0 = new JButton("0");
        btn0.setBounds(160,420,100,70);

        JButton btnBracket2 = new JButton(")");
        btnBracket2.setBounds(270,420,100,70);

        JButton btnMultiply = new JButton("\u00d7");
        btnMultiply.setBounds(380,420,100,70);


        JButton btnC = new JButton("C");
        btnC.setBounds(50,500,100,70);

        JButton btnPlus = new JButton("+");
        btnPlus.setBounds(160,500,100,70);

        JButton btnMinus = new JButton("-");
        btnMinus.setBounds(270,500,100,70);

        JButton btnEqual = new JButton("=");
        btnEqual.setBounds(380,500,100,70);





        JFrame frame = new JFrame("RPN Calculator");
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setSize(550,750);
        frame.setLayout(null);
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



        frame.setVisible(true);

    }




}
