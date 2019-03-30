import java.io.File ;
import java.io.IOException ;
public class FileDemo{
	public static void main(String args[]){
	File f = new File("d:"+File.separator+"test.txt") ;		// 实例化File类的对象
//	File f = new File("d://test.txt");
		if(f.exists()){	// 如果文件存在则删除
			f.delete() ;	// 删除文件
		}else{
			try{
				f.createNewFile() ;		// 创建文件，根据给定的路径创建
			}catch(IOException e){
				e.printStackTrace() ;	// 输出异常信息
			}
		}
	}
};