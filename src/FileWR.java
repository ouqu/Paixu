import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class FileWR {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		if(false){
		FileWriter fw=null;
        try{
		fw=new FileWriter("E:\\demo.txt");
		for(int i=0;i<1000;++i){
			int r=Person.ranInt(0, 100);
			fw.write(String.valueOf(r)+" ");
		}
		fw.flush();
        }catch (Exception e){
        	e.printStackTrace();
        }
        finally{
        	if(fw!=null)
        		fw.close();
        }
		}
		
		if(true){
        FileReader fr=null;
        try{
        	fr=new FileReader("E:\\demo.txt");
        	int n=0;
        	int ch=0;
        	for(;(ch=fr.read())!=-1&&n<10;){
        		System.out.print((char)ch);
        		if((char)ch==' ')  ++n;
        	}
        }catch(Exception e){
        	e.printStackTrace();
        }finally{
        	if(fr!=null)
        		fr.close();
        }
        
        }
	}

}
