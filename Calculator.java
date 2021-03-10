package awt_example_package;

import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Calculator extends Frame implements ActionListener  {

	TextField tfInput;
	Panel panel;
	String btnString[] ={"7","8","9","+",
			              "4","5","6","-",
			              "1","2","3","*",
			              "C","0","=","/"
			
	};
	
	Button btn[]=new Button[16];
	int num1=0,num2=0,result=0;
	char op;
	
	public Calculator()
	{
		Font f=new Font("cambria",Font.BOLD,18);
		
		tfInput =new TextField(10);
		tfInput.setFont(f);
		
		panel=new Panel();
		
		add(tfInput,"North");
		add(panel,"Center");
		
		panel.setLayout(new GridLayout(4,4));
		
		for(int i=0;i<16;i++)
		{
			btn[i]=new Button(btnString[i]);
			btn[i].setFont(f);
			btn[i].addActionListener(this);
			panel.add(btn[i]);
			
		}
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we){
				System.exit(0);
			}
		});
		
	}
	

	

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		
		String str=ae.getActionCommand();
		if(str.equals("+"))
		{
			op='+';
			num1=Integer.parseInt(tfInput.getText());
			tfInput.setText("");
		}
		else if(str.equals("-"))
		{
			op='-';
			num1=Integer.parseInt(tfInput.getText());
			tfInput.setText("");
		}
		else if(str.equals("*"))
		{
			op='*';
			num1=Integer.parseInt(tfInput.getText());
			tfInput.setText("");
		}
		else if(str.equals("/"))
		{
			op='/';
			num1=Integer.parseInt(tfInput.getText());
			tfInput.setText("");
		}
		else  if(str.equals("="))
		{
			
			num2=Integer.parseInt(tfInput.getText());
			System.out.println(num2);
			
			switch(op)
			{
			case '+':result=num1+num2;
			break;
			case '-':result=num1-num2;
			break;
			case '*':result=num1*num2;
			break;
			case '/':result=num1/num2;
			break;
			
			}
			tfInput.setText(result +"");
			result=0;
			
		}
		else if(str.equals("C"))
		{
			tfInput.setText("");
			num1=num2=result=0;
		}
		else
		{
			tfInput.setText(tfInput.getText() +str);
			
		}
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Calculator m=new Calculator();
		m.setTitle("my calculator");
		m.setSize(250, 300);
		m.setVisible(true);

	}


	

}
