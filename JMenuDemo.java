import java.awt.event.*;
import javax.swing.*; 
public class JMenuDemo extends JFrame implements ActionListener{
   private  JMenuBar  bar; 
   private JMenu fileMenu,formatMenu,colorMenu,fontMenu ;
   private JMenuItem newItem,exitItem;
   private JRadioButtonMenuItem colorItems[];
   private JCheckBoxMenuItem styleItems[];
   private ButtonGroup colorGroup;
   public JMenuDemo(){
      super( "JMenu  Demo" );     
      fileMenu = new JMenu( "�ļ�(F)");
      fileMenu.setMnemonic( 'F' );        
      newItem = new JMenuItem( "�½�" );
      newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
      newItem.addActionListener(this);                  
      fileMenu.add( newItem );                        
      exitItem = new JMenuItem( "�˳�" );
      exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
      exitItem.addActionListener(this);   
      fileMenu.add( exitItem );                    
      bar = new JMenuBar();                     
      setJMenuBar( bar );                                
      bar.add( fileMenu );                               
      formatMenu = new JMenu( "��ʽ(O)" ); 
      formatMenu.setMnemonic( 'O' );           
      String colors[] = { "��ɫ", "��ɫ", "��ɫ"};
      colorMenu = new JMenu( "��ɫ" );       
      colorItems = new JRadioButtonMenuItem[ colors.length ];
      colorGroup = new ButtonGroup();                        
      for ( int count = 0; count < colors.length; count++ ) {
         colorItems[ count ]=new JRadioButtonMenuItem( colors[ count ] );
         colorMenu.add( colorItems[ count ] );          
         colorGroup.add( colorItems[ count ] );         
      }
      colorItems[0].setSelected( true );  
      formatMenu.add( colorMenu );
      formatMenu.addSeparator();  
      fontMenu = new JMenu( "����" );
      String styleNames[] = { "����", "б��" };
      styleItems = new JCheckBoxMenuItem[ styleNames.length ];
      for ( int count = 0; count < styleNames.length; count++ ) {
         styleItems[ count ]=new JCheckBoxMenuItem( styleNames[ count ] );
         fontMenu.add( styleItems[ count ] );            
      }
      formatMenu.add( fontMenu );
      bar.add( formatMenu );  
      setSize( 300, 200 );
      setVisible( true );
   } 
   public void actionPerformed(ActionEvent event){
	 if(event.getSource()==newItem){
	  	JOptionPane.showMessageDialog(null,"��ѡ��"+newItem.getText()+"�˵���");}
	 if(event.getSource()==exitItem){ 
		System.exit(0);}		
	}
    public static void main( String args[] ){
      new JMenuDemo();  
    }
  } 
