import javax.swing.*;

class MyFrame extends JFrame {
  MyFrame(String title, int x, int y, int h, int w) {
    super(title);
    this.setLocation(x, y);
    this.setSize(h, w);
    this.setResizable(true);
    this.setVisible(true);
  }
}

public class JFrameDemo2 {
  public static void main(String args[]) {
    new MyFrame("一个简单窗口", 300, 300, 300, 200);
  }
}
