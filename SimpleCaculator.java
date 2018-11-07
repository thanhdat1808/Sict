package giao_dien;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SimpleCaculator extends Frame implements ActionListener {
private TextField display;
private double arg=0;
private String op = "=";
private boolean start = true;
public SimpleCaculator() {
	setTitle("Caculator");
	setSize(300, 400);
	setLayout(new BorderLayout());
	display = new TextField("0");
	display.setEditable(false);
	add(display,"North");
	Panel p = new Panel();
	p.setLayout(new GridLayout(4, 4));
	String buttons[] = {"7","8","9","/","4","5","6","*","1","2","3","-","0",".","=","+"};
	for(int i=0;i<buttons.length;i++) {
		Button button = new Button(buttons[i]);
		p.add(button);
		button.addActionListener(this);
		button.setBackground(Color.gray);
	}
	add(p,"Center");
	addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	});
	display.setBackground(Color.CYAN);
	p.setBackground(Color.red);
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	String s = e.getActionCommand();
	
	if('0'<= s.charAt(0) && s.charAt(0) <='9' || s.equals("."))
	{
		if (start) {
			display.setText(s);
			}
		else {
			display.setText(display.getText()+s);
		}
	start=false;
	}
	else 
	{
		if(start)
		{
			if(s.equals("-"))
			{
				display.setText(s);
				start=false;
			}
			else op=s;
		}
		else 
		{
			double x = Double.parseDouble(display.getText());
			caculator(x);
			op = s;
			start = true;
		}
	}
}
public void caculator(double n)
{
	if(op.equals("+")) arg += n;
	else if (op.equals("-")) arg -= n;
	else if (op.equals("*")) arg *= n;
	else if (op.equals("/")) arg /= n;
	else if (op.equals("=")) arg = n;
	display.setText(""+arg);
}
public static void main(String[] args)
{
	SimpleCaculator frame = new SimpleCaculator();
	frame.show();
}
}
