import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.NumberFormat;
import java.util.Vector;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.JOptionPane; 
 public class Test_GUI{
   public static void main(String[]args){
     new Test_GUI("NIIT");
 }
  public Test_GUI(String name){
   TestFrame tf = new TestFrame(name);
   tf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   tf.setVisible(true);
  }
 }
 //�����
 class TestFrame extends JFrame{
   private static final long serialVersionUID = 1L;
  private Toolkit tool;
  private JMenuBar mb;
  private JMenu menutool,menuhelp,menuexit;
  private JMenuItem calculator,edition,about;
  private JDialog help;
  public TestFrame(String name){
  setTitle("ѧ�����߿���ϵͳ");
	  tool=Toolkit.getDefaultToolkit();
	  Dimension ds=tool.getScreenSize();
	  int w=ds.width;
	  int h=ds.height;
	  setBounds((w-500)/2,(h-430)/2,500,450);
	  //���ô���ͼ��	 
    image=tool.getImage(Test_GUI.class.getResource("D:\\java\\
             icon\\tubiao.jpg"));
	  ImageIcon icon=new ImageIcon("D:\\java\\icon\\tubiao.jpg");
	  Image image=icon.getImage();
	  setIconImage(image);
	 setResizable(false);
	 //------------�˵���������---------------
	 mb=new JMenuBar();
	 setJMenuBar(mb);
	 menutool=new JMenu("����(T)");
	 menuhelp=new JMenu("����(H)");
	 menuexit=new JMenu("�˳�(E)");
	 //�������Ƿ�
	 menutool.setMnemonic('T');
	 menuhelp.setMnemonic('H');
	 menuexit.setMnemonic('E');
	 mb.add(menutool);
	 mb.add(menuhelp);
	 mb.add(menuexit);
	 calculator=new JMenuItem("������(c)",'c');
	 edition=new JMenuItem("�汾(E)",'E');
	 about=new JMenuItem("����(A)",'A');
	 menutool.add(calculator);
	 menuhelp.add(edition);
	 //��ӷָ���
	menuhelp.add(about);
	//���ÿ�ݼ�
	calculator.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
                             InputEvent.CTRL_MASK));
	edition.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, 
                          InputEvent.CTRL_MASK));
	about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
                       InputEvent.CTRL_MASK));
	BorderLayout bl=new BorderLayout();
	setLayout(bl);
	TestPanel tp=new TestPanel(name);
	add(tp,BorderLayout.CENTER);
	//-----------�����ڲ�������¼�------------
	calculator.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0){
			new Calculator();
		}	
	});
	edition.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0){
			JOptionPane.showMessageDialog(null, "������", "�汾��Ϣ", 
                                    JOptionPane.PLAIN_MESSAGE);
	}		
	});
	about.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0){
			help=new JDialog(new JFrame());
			JPanel panel=new JPanel();
			JTextArea helparea=new JTextArea(14,25);
			helparea.setText("������ѧ������ϵͳ����Ŀ�����ᴩȫ��");
			helparea.setEditable(false);
			JScrollPane sp=new JScrollPane(helparea);
			panel.add(sp);
			help.setTitle("������Ϣ");
			help.add(panel,"Center");
			help.setBounds(350,200,300,300);
			help.setVisible(true);
		}		
	});
	menuexit.addMouseListener(new MouseListener(){
		public void mouseClicked(MouseEvent arg0){
			int temp=JOptionPane.showConfirmDialog(null, "��ȷ��Ҫ�˳�
             ϵͳ��","ȷ�϶Ի���",JOptionPane.YES_NO_OPTION);
			if(temp==JOptionPane.YES_OPTION){
				System.exit(0);
			}
			else if(temp==JOptionPane.NO_OPTION){
				return;
			}
		}
		public void mouseEntered(MouseEvent arg0){}
		public void mouseExited(MouseEvent arg0){}
		public void mousePressed(MouseEvent arg0){}
		public void mouseReleased(MouseEvent arg0){}
	});
	}  
   }
   //������
 class TestPanel extends JPanel implements ActionListener{
	private JLabel totaltime,lefttime,ttimeshow,ltimeshow,
              textinfo,userinfo;
	private JLabel copyright;
	private JButton starttest,back,next,commit;
	private JTextArea area;
	private JRadioButton rbtna,rbtnb,rbtnc,rbtnd;
	private String totaltimer="",lefttimer="",
              username="",select="";
	private int current=0,total=0,score=0;
	private Box box,box1,box2,box3,box4,box5;
	private Testquestion[] question;
	private ClockDisplay clock;
	private int index=0;
	private int time=0;
	private InputStreamReader read;
	private String[][]  dis;
	private File file;
	public TestPanel(String name){
		username=name;
		totaltimer="00:00:00";
		lefttimer="00:00:00";
		totaltime=new JLabel("�ܵĿ���ʱ���ǣ�");
		lefttime=new JLabel("ʣ�࿼��ʱ���ǣ�");
		ttimeshow=new JLabel(totaltimer);
		ttimeshow.setForeground(Color.RED);
		ltimeshow=new JLabel(lefttimer);
		ltimeshow.setForeground(Color.red);
		textinfo=new JLabel("��"+current+"��"+",��"+total+"��");
		userinfo=new JLabel("������ "+username);
		copyright=new JLabel();
		copyright.setHorizontalAlignment(JLabel.RIGHT);
		copyright.setFont(new Font("����",Font.PLAIN,14));
		copyright.setForeground(Color.gray);
		copyright.setText("copyright@ developed by cy");
		starttest=new JButton("��ʼ����");
		back=new JButton("��һ��");
		next=new JButton("��һ��");
		back.setEnabled(false);
		next.setEnabled(false);
		commit=new JButton("�ύ�Ծ�");
		commit.setEnabled(false);
		area=new JTextArea(10,10);
		area.setFont(new Font("����",Font.BOLD,16));
		area.setText("��������\n"+"һ������ǰ15���ӣ�ƾ׼��֤��
         ���֤���뿼�����Ժ���������׼��֤��" +"���֤�����������Ͻǣ�
         ���ڼ࿼��Ա���.\n"+"�������뿼�Կ���30���Ӻ󲻵��볡����
         ��������ύ�Ծ����������볡.\n"+"��������Ҫ��ϧ�����Ļ���
         ������豸���ϸ��չ̶��Ĳ���˵�����в�����������Ϊ�𻵣���
         ���⳥.");
		JScrollPane sp=new JScrollPane(area);
		area.setEditable(false);
		rbtna=new JRadioButton("A");
		rbtnb=new JRadioButton("B");
		rbtnc=new JRadioButton("C");
		rbtnd=new JRadioButton("D");
		rbtna.setEnabled(false);
		rbtnb.setEnabled(false);
		rbtnc.setEnabled(false);
		rbtnd.setEnabled(false);
		ButtonGroup bg=new ButtonGroup();
		bg.add(rbtna);
		bg.add(rbtnb);
		bg.add(rbtnc);
		bg.add(rbtnd);
		Border border=BorderFactory.createTitledBorder("ѡ��");
		JPanel panel=new JPanel();
		panel.add(rbtna);
		panel.add(rbtnb);
		panel.add(rbtnc);
		panel.add(rbtnd);
		panel.setBorder(border);
		box=Box.createVerticalBox();
		box1=Box.createHorizontalBox();
		box2=Box.createHorizontalBox();
		box3=Box.createHorizontalBox();
		box4=Box.createHorizontalBox();
		box5=Box.createHorizontalBox();
		new JDialog(new  JFrame());
		//ע������¼�
		starttest.addActionListener(this);
		back.addActionListener(this);
		next.addActionListener(this);
		commit.addActionListener(this);
		rbtna.addActionListener(this);
		rbtnb.addActionListener(this);
		rbtnc.addActionListener(this);
		rbtnd.addActionListener(this);
		//��������������ʽ����
		box1.add(totaltime);
		box1.add(Box.createHorizontalStrut(5));
		box1.add(ttimeshow);
		box1.add(Box.createHorizontalStrut(5));
		box1.add(lefttime);
		box1.add(Box.createHorizontalStrut(5));
		box1.add(ltimeshow);
		box1.add(Box.createHorizontalStrut(15));
		box1.add(starttest);
		box2.add(textinfo);
		box2.add(Box.createHorizontalStrut(30));
		box2.add(userinfo);
		box3.add(sp,BorderLayout.CENTER);
		box4.add(panel);
		box4.add(Box.createHorizontalStrut(5));
		box4.add(back);
		box4.add(Box.createHorizontalStrut(5));
		box4.add(next);
		box4.add(Box.createHorizontalStrut(5));
		box4.add(commit);
		box5.add(Box.createHorizontalStrut(250));
		box5.add(copyright);
		box.add(box1);
		box.add(Box.createVerticalStrut(10));
		box.add(box2);
		box.add(Box.createVerticalStrut(10));
		box.add(box3);
		box.add(Box.createVerticalStrut(10));
		box.add(box4);
		box.add(Box.createVerticalStrut(20));
		box.add(box5,BorderLayout.EAST);
		add(box);}
		public void display(){
			area.setText("");
            for(int i=0;i<5;i++)
             area.append(dis[current-1][i]+"\n");           
         }
		  //�������ļ��ж�ȡ����ʱ��
		  public void testTime(){
			FileReader fr=null;
			BufferedReader br=null;
			String s="";
			int i1,i2;			
			try{
				JFileChooser jfc=new JFileChooser();
            if(jfc.showOpenDialog(null)==
                    JFileChooser.APPROVE_OPTION){
                 file=jfc.getSelectedFile();
				fr=new FileReader(file);
				br=new BufferedReader(fr);
				s=br.readLine();
			    i1 = s.indexOf('@'); 
			    i2 = s.indexOf('��'); 
			    s = s.substring(i1+1,i2); 
				time= Integer.parseInt(s);				
				fr.close();
				br.close();}
			}catch(IOException e){
				e.printStackTrace();}
					  }
		// �������ļ��ж�ȡ����
		  public  void  ReadTestquestion( ){
			  try {
	                String encoding="GBK";
	    if(file.isFile() && file.exists()){ //�ж��ļ��Ƿ����
                    InputStreamReader read = new InputStreamReader(
                    new FileInputStream(file),encoding);//���ǵ�
                                   �����ʽ
                    BufferedReader bufferedReader = new 
                              BufferedReader(read);
                    String lineTxt = null;
                    lineTxt = bufferedReader.readLine();
                    lineTxt = bufferedReader.readLine();
                    current=1;                        
                    String[] s=lineTxt.split(" ");
                    total=s.length;
                    textinfo.setText("��"+current+"��"+",��
                                    "+total+"��");
                    question=new   Testquestion[total]; 
                    dis=new String[total][5];
                    for(int i=0;i<total;i++){
                       	question[i]=new Testquestion();
                       	question[i].setStandKey(s[i]);
                       	String temp=bufferedReader.readLine();
                       	if(temp.startsWith("*")){ 
                       		for(int j=0;j<5;j++){
                       		dis[i][j]=bufferedReader.readLine();
                       		question[i].setQuestion(dis[i][j]);
                      		                        } 
                       		                    }   
                         }
                       display();
	        }else{
	            System.out.println("�Ҳ���ָ�����ļ�");
	        }	
        } catch (Exception e) {	
     System.out.println("��ȡ�ļ����ݳ���");
	            e.printStackTrace();} 
		  }
		public void actionPerformed(ActionEvent e){
			 if(e.getSource()==starttest){
  	JOptionPane.showMessageDialog(null,"��ѡ�����ļ� ","��Ϣ��
            ",JOptionPane.PLAIN_MESSAGE);  	
			testTime();
			ttimeshow.setText(time+"����");
			ltimeshow.setText(time+"����");
			current=1;
			clock=new ClockDisplay(ltimeshow,time);
			clock.start( );
			rbtna.setEnabled(true);
			rbtnb.setEnabled(true);
			rbtnc.setEnabled(true);
			rbtnd.setEnabled(true);
		    next.setEnabled(true);
			commit.setEnabled(true);
			ReadTestquestion( );				
			 } 
            if(e.getSource()==back){
            	next.setEnabled(true);
				current=current-1;
				if(current==1)
				back.setEnabled(false);
				display();
			 }  
            if(e.getSource()==next){
            	current=current+1;
            	back.setEnabled(true);
            	display();
            	if(current==total){
            		next.setEnabled(false);
		JOptionPane.showMessageDialog(null,"���Ѿ������һ���ˣ�
         ");
    				}
			 } 
            if(e.getSource()==commit){
            	scorereport(); 
			 } 
            if(e.getSource()==rbtna)
            	question[current-1].setSelectedKey("A");            	
            if(e.getSource()==rbtnb)
				question[current-1].setSelectedKey("B");
			if(e.getSource()==rbtnc)
				question[current-1].setSelectedKey("C");
			if(e.getSource()==rbtnd)
				question[current-1].setSelectedKey("D"); 
		}
		//��ʾ��������ķ���
		public void scorereport(){
			int number=0;
			for(int i=0;i<total;i++){				
				if(question[i].checkKey())
					{score=score+2;
				     number++;}
					}
	JOptionPane.showMessageDialog(null,"��   Ŀ  ��   ��:  
       "+total+"\n�� ȷ �� �� Ŀ:   "+number+"\n��                
      ����  "+score,"���Գɼ�",JOptionPane.PLAIN_MESSAGE);  	
		}
 }
		//��ȡ������
		class Testquestion{
			private String questionText;
			private String standardKey;
			private String selectedKey;
			public Testquestion(){
				questionText="";
				standardKey="";
				selectedKey="";				
			}
			public String getQuestion(){
				return questionText;
			}
			public void setQuestion(String s){
				questionText=s;
			}
			public String getSelectedKey(){
				return selectedKey;
			}
			public void setSelectedKey(String s){
				selectedKey=s;
			}
			public void setStandKey(String s){
				standardKey=s;
			}
			public String getStandKey(){
				return standardKey;
			}
			public boolean checkKey(){
				if(standardKey.equals(selectedKey)){
					return true;
				}
				return false;
			}
		}
		//���Լ�ʱ��
		class ClockDisplay extends Thread{
			private JLabel lefttimer;
			private int testtime;	
			public ClockDisplay(JLabel lt,int time){
				  lefttimer = lt;
				  testtime = time*60;
			   }	
			public void run( ){
			      NumberFormat f = NumberFormat.getInstance();
				//������������������ʾ����С����λ��
			      f.setMinimumIntegerDigits(2);
			      int h,m,s; 
			      while (testtime >= 0) {
			         h = testtime /3600;
			         m = testtime %3600/60;
			         s = testtime %60;
			         StringBuffer sb = new StringBuffer("");
			    sb.append(f.format(h) + ": " + f.format(m)+ ": " +
                      f.format(s));
			        lefttimer.setText(sb.toString());
			        try{
				Thread.sleep(1000);	
			        }catch(Exception ex){}				
			        testtime  = testtime  - 1;
			      }
			     JOptionPane.showMessageDialog(null,"\t����ʱ�䵽,
                     �������ԣ�");
			     System.exit(0);
			   }
		}
         class Calculator extends JFrame implements ActionListener {
		    private static final long serialVersionUID = 
               -169068472193786457L;
		    private class WindowCloser extends WindowAdapter {
		       public void windowClosing(WindowEvent we) {
		           System.exit(0);
		       }
		    }		
		    int i;
		    // Strings for Digit & Operator buttons.
		    private final String[] str = { "7", "8", "9", "/", "4",
            "5", "6", "*", "1", "2", "3", "-", ".", "0", "=", "+" };
		    // Build buttons.
		    JButton[] buttons = new JButton[str.length];
		    // For cancel or reset.
		    JButton reset = new JButton("CE");
		    // Build the text field to show the result.
		    JTextField display = new JTextField("0");
		
		    public Calculator() {
		       super("Calculator");
		       // Add a panel.
		       JPanel panel1 = new JPanel(new GridLayout(4, 4));
		       // panel1.setLayout(new GridLayout(4,4));
		       for (i = 0; i < str.length; i++) {
		           buttons[i] = new JButton(str[i]);
		           panel1.add(buttons[i]);
		       }
		       JPanel panel2 = new JPanel(new BorderLayout());
		       // panel2.setLayout(new BorderLayout());
		       panel2.add("Center", display);
		       panel2.add("East", reset);
		       // JPanel panel3 = new Panel();
		       getContentPane().setLayout(new BorderLayout());
		       getContentPane().add("North", panel2);
		       getContentPane().add("Center", panel1);
		       // Add action listener for each digit & operator button.
		       for (i = 0; i < str.length; i++)
		           buttons[i].addActionListener(this);
		       // Add listener for "reset" button.
		       reset.addActionListener(this);
		       // Add listener for "display" button.
		       display.addActionListener(this);
		       // The "close" button "X".
		       addWindowListener(new WindowCloser());
		       // Initialize the window size.
		       setSize(800, 800);
		       // Show the window.
		       // show(); Using show() while JDK version is below 1.5.
		       setVisible(true);
		       // Fit the certain size.
		       pack();
		    }   
		    public void actionPerformed(ActionEvent e) {
		       Object target = e.getSource();
		       String label = e.getActionCommand();
		       if (target == reset)
		           handleReset();
		       else if ("0123456789.".indexOf(label) > 0)
		           handleNumber(label);
		       else
		           handleOperator(label);
		    }
		    // Is the first digit pressed?
		    boolean isFirstDigit = true; 
		    public void handleNumber(String key) {
		       if (isFirstDigit)
		           display.setText(key);
		       else if ((key.equals(".")) && 
                    (display.getText().indexOf(".") < 0))
		           display.setText(display.getText() + ".");
		       else if (!key.equals("."))
		           display.setText(display.getText() + key);
		       isFirstDigit = false;
		    } 
		    /**
		     * Reset the calculator.
		     */
		    public void handleReset() {
		       display.setText("0");
		       isFirstDigit = true;
		       operator = "=";
		    } 
		    double number = 0.0;
		    String operator = "="; 
		    /**
		     * Handling the operation.
		     * @param key pressed operator's key.
		     */
		    public void handleOperator(String key) {
		       if (operator.equals("+"))
		           number += Double.valueOf(display.getText());
		       else if (operator.equals("-"))
		           number -= Double.valueOf(display.getText());
		       else if (operator.equals("*"))
		           number *= Double.valueOf(display.getText());
		       else if (operator.equals("/"))
		           number /= Double.valueOf(display.getText());
		       else if (operator.equals("="))
		           number = Double.valueOf(display.getText());
		       display.setText(String.valueOf(number));
		       operator = key;
		       isFirstDigit = true;
		    }	
		}
