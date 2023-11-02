package onlineTest;
/*Online Test Ne Java*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings({ "serial", "unused" })
class OnlineTest extends JFrame implements ActionListener
{
	JLabel l;
	JRadioButton jb[]=new JRadioButton[5];
	JButton b1,b2;
	ButtonGroup bg;
	int count=0,current=0,x=1,y=1,now=0;
	int m[]=new int[10];
	
	OnlineTest(String s)//konstruktori
	{
		super(s);
		l=new JLabel();
		add(l);
		bg=new ButtonGroup();
		
		for(int i=0;i<5;i++)
		{
			jb[i]=new JRadioButton();	
			add(jb[i]);
			bg.add(jb[i]);
		}
		
		b1=new JButton("Next");
		b2=new JButton("Bookmark");
		b1.addActionListener(this);
		b2.addActionListener(this);
		add(b1);
		add(b2);
		set();
		l.setBounds(30,40,450,20);
		jb[0].setBounds(50,80,100,20);
		jb[1].setBounds(50,110,100,20);
		jb[2].setBounds(50,140,100,20);
		jb[3].setBounds(50,170,100,20);
		b1.setBounds(100,240,100,30);
		b2.setBounds(270,240,100,30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(500,200);
		setVisible(true);
		setSize(600,350);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			if(check())
				count=count+1;
			current++;
			set();	
			if(current==9)
			{
				b1.setEnabled(false);
				b2.setText("Rezultati");
			}
		}
		if(e.getActionCommand().equals("Bookmark"))
		{
			JButton bk=new JButton("Bookmark"+x);
			bk.setBounds(480,20+30*x,100,30);
			add(bk);
			bk.addActionListener(this);
			m[x]=current;
			x++;
			current++;
			set();	
			
			if(current==9)
				b2.setText("Rezultati");
			
			setVisible(false);
			setVisible(true);
		}
		
		for(int i=0,y=1;i<x;i++,y++)
		{
			if(e.getActionCommand().equals("Bookmark"+y))
			{
			if(check())
				count=count+1;
			now=current;
			current=m[y];
			set();
			((JButton)e.getSource()).setEnabled(false);
			current=now;
			}
		}
	
		if(e.getActionCommand().equals("Rezultati"))
		{
			if(check())
				count=count+1;
			current++;
			//System.out.println("correct ans="+count);
			JOptionPane.showMessageDialog(this,"Numri i pergjigjeve te sakta = "+count);
			System.exit(0);
		}
	}
	
	void set()
	{
		jb[4].setSelected(true);
		
		if(current==0)
		{
			l.setText("Pyetje1: Kush nga opsionet e meposhtme nuk perfshihet te tipet e te dhenave?");
			jb[0].setText("int");
			jb[1].setText("Float");//*
			jb[2].setText("boolean");
			jb[3].setText("char");	
		}
		
		if(current==1)
		{
			l.setText("Pyetje2: Cila klase eshte e gatshme per t'u perdorur automatikisht?");
			jb[0].setText("Swing");
			jb[1].setText("Applet");
			jb[2].setText("Object");//*
			jb[3].setText("ActionEvent");
		}
		
		if(current==2)
		{
			l.setText("P3:Metoda me numer/tip te ndryshem parametrash me te njejtin tip kthimi quhet:");
			jb[0].setText("Method Overloading");//*
			jb[1].setText("Method Overriding");
		}
		
		if(current==3)
		{
			l.setText("Pyetje4: Fshehja e informacionit njihet ndryshe si:");
			jb[0].setText("Enkapsulim");//*
			jb[1].setText("Data hiding");
			jb[2].setText("Trashegimi");
			jb[3].setText("Polimorfizem");
		}
		
		if(current==4)
		{
			l.setText("Pyetje5: Cfare funksioni ka mbyllja e nje skedari?");
			jb[0].setText("Perfundon procesimi i tij.");
			jb[1].setText("Flush output.");
			jb[2].setText("2 alternativat e para.");//*
			jb[3].setText("E ben skedarin read-only.");
		}
		
		if(current==5)
		{
			l.setText("P6: Cfare exception shfaqet me: float numri = 7/0; ?");
			jb[0].setText("Divisions must be in a try block.");
			jb[1].setText("DivideByZeroException");
			jb[2].setText("Runtime Exception");//*
			jb[3].setText("Asnje error.");
		}
		
		if(current==6)
		{
			l.setText("Pyetje7: Cila prej alternativave te meposhtme nuk eshte klase? ");
			jb[0].setText("Swing");
			jb[1].setText("Actionperformed");//*
			jb[2].setText("ActionEvent");
			jb[3].setText("Button");
		}
		
		if(current==7)
		{
			l.setText("Pyetje8: Cila prej alternativave nuk eshte pjese e klases Object?");
			jb[0].setText("toString");
			jb[1].setText("finalize");
			jb[2].setText("equals");
			jb[3].setText("getDocumentBase");//*	
		}
		
		if(current==8)
		{
			l.setText("Pyetje9: Cili funksion nuk eshte prezent ne klasen Applet?");
			jb[0].setText("init");
			jb[1].setText("main");//*
			jb[2].setText("start");
			jb[3].setText("destroy");
		}
		
		if(current==9)
		{
			l.setText("P10: Cili nga opsionet eshte i nevojshem per krijimin e nje frame? ");
			jb[0].setText("import java.awt.*;");
			jb[1].setText("import java.awt.event.*;");
			jb[2].setText("Te gjitha alternativat");//*
			jb[3].setText("import java.awt.frame;");
		}
		
		l.setBounds(30,40,450,20);
		
		for(int i=0,j=0;i<=90;i+=30,j++)
			jb[j].setBounds(50,80+i,200,20);
	}//fundi i metodes set
	
	boolean check()
	{
		if(current==0)
			return(jb[1].isSelected());
		if(current==1)
			return(jb[2].isSelected());
		if(current==2)
			return(jb[0].isSelected());
		if(current==3)
			return(jb[0].isSelected());
		if(current==4)
			return(jb[2].isSelected());
		if(current==5)
			return(jb[2].isSelected());
		if(current==6)
			return(jb[1].isSelected());
		if(current==7)
			return(jb[3].isSelected());
		if(current==8)
			return(jb[1].isSelected());
		if(current==9)
			return(jb[2].isSelected());
		return false;
	}//fundi i metodes check
	
	public static void main(String s[])
	{
		new OnlineTest("Online Test ne Java");
	}


}


