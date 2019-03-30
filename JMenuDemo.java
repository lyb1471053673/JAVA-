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
      fileMenu = new JMenu( "文件(F)");
      fileMenu.setMnemonic( 'F' );        
      newItem = new JMenuItem( "新建" );
      newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
      newItem.addActionListener(this);                  
      fileMenu.add( newItem );                        
      exitItem = new JMenuItem( "退出" );
      exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
      exitItem.addActionListener(this);   
      fileMenu.add( exitItem );                    
      bar = new JMenuBar();                     
      setJMenuBar( bar );                                
      bar.add( fileMenu );                               
      formatMenu = new JMenu( "格式(O)" ); 
      formatMenu.setMnemonic( 'O' );           
      String colors[] = { "黑色", "蓝色", "红色"};
      colorMenu = new JMenu( "颜色" );       
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
      fontMenu = new JMenu( "字型" );
      String styleNames[] = { "粗体", "斜体" };
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
	  	JOptionPane.showMessageDialog(null,"你选了"+newItem.getText()+"菜单项");}
	 if(event.getSource()==exitItem){ 
		System.exit(0);}		
	}
    public static void main( String args[] ){
      new JMenuDemo();  
    }
  } 
