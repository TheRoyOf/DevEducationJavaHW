import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {

    public static String value = "";

    public static JFrame frame = new JFrame("Calculator");

    public static JTextField label = new JTextField(16);

    public static void main(String[]args)
    {
        init();
    }

    public static void init()
    {
        Calculator c = new Calculator();

        label.setEditable(false);

        JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, ba, bs, bd, bm, be, beq, beq1;

        b0 = new JButton("0");
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");

        beq1 = new JButton("=");

        ba = new JButton("+");
        bs = new JButton("-");
        bd = new JButton("/");
        bm = new JButton("*");
        beq = new JButton("C");

        be = new JButton(".");

        JPanel p = new JPanel();

        bm.addActionListener(c);
        bd.addActionListener(c);
        bs.addActionListener(c);
        ba.addActionListener(c);
        b9.addActionListener(c);
        b8.addActionListener(c);
        b7.addActionListener(c);
        b6.addActionListener(c);
        b5.addActionListener(c);
        b4.addActionListener(c);
        b3.addActionListener(c);
        b2.addActionListener(c);
        b1.addActionListener(c);
        b0.addActionListener(c);
        be.addActionListener(c);
        beq.addActionListener(c);
        beq1.addActionListener(c);

        p.add(label);
        p.add(ba);
        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(bs);
        p.add(b4);
        p.add(b5);
        p.add(b6);
        p.add(bm);
        p.add(b7);
        p.add(b8);
        p.add(b9);
        p.add(bd);
        p.add(be);
        p.add(b0);
        p.add(beq);
        p.add(beq1);

        p.setBackground(Color.gray);

        frame.add(p);

        frame.setSize(200, 220);
        frame.show();

    }

    public static boolean isNumeric(String str) {
        if (str == null)
        {
            return false;
        }
        try {
            int val = Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static Value ParseValue(String enterValue)
    {
        enterValue = enterValue.replaceAll(" ","");
        String[] valueArr = enterValue.split("");

        Value value = new Value("");
        boolean first_val = true;

        for(int i = 0; i < valueArr.length; ++i)
        {
            if (first_val)
            {
                if (isNumeric(valueArr[i]) || valueArr[i].equals("."))
                {
                    value.val_A = value.val_A + valueArr[i];
                }
                else if (valueArr[i].equals("+") || valueArr[i].equals("-") || valueArr[i].equals("*") || valueArr[i].equals("/"))
                {
                    if (value.action.equals(""))
                    {
                        value.action = valueArr[i];
                        first_val = false;
                    }
                    else
                    {
                        return (new Value("Invalid string"));
                    }
                }
                else
                {
                    return (new Value("Invalid string"));
                }
            }
            else
            {
                if (isNumeric(valueArr[i]))
                {
                    value.val_B = value.val_B + valueArr[i];
                }
                else if (valueArr[i].equals("+") || valueArr[i].equals("-") || valueArr[i].equals("*") || valueArr[i].equals("/"))
                {
                    return (new Value("Invalid string"));
                }
                else
                {
                    return (new Value("Invalid string"));
                }
            }
        }
        return value;
    }

    public static String Calc(Value val)
    {
        double rez = 0;

        if (!val.val_A.equals("Invalid string") && !val.val_A.equals("") && !val.val_B.equals("") && !val.action.equals(""))
        {
            if (val.action.equals("+"))
            {
                rez = Double.parseDouble(val.val_A) + Double.parseDouble(val.val_B);
            }
            else if (val.action.equals("-"))
            {
                rez = Double.parseDouble(val.val_A) - Double.parseDouble(val.val_B);
            }
            else if (val.action.equals("*"))
            {
                rez = Double.parseDouble(val.val_A) * Double.parseDouble(val.val_B);
            }
            else if (val.action.equals("/"))
            {
                if (val.val_A.equals("0") || val.val_B.equals("0"))
                {
                    return ("Division by zero!!!");
                }
                rez = Double.parseDouble(val.val_A) / Double.parseDouble(val.val_B);
            }
        }
        else
        {
            System.out.println("Invalid string");
        }
        return Double.toString(rez);
    }


    public void actionPerformed(ActionEvent e)
    {
        String eventCommand = e.getActionCommand();

        if (eventCommand.equals("="))
            label.setText(value=Calc(ParseValue(value)));
        else if (eventCommand.equals("C") && value.length()>0)
            label.setText(value=value.substring(0,value.length()-1));
        else if (eventCommand.equals("C") && value.length()==0)
            label.setText(value);
        else
            label.setText(value+=eventCommand);
    }
}
