package copyandmove;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class CopyAndMove {

    public static void write(byte[] bs, String outPath) {
    	try {RandomAccessFile f = new RandomAccessFile(outPath, "rw");
    	f.write(bs);
    	f.close();
    	} catch (FileNotFoundException ex) {System.out.println("the file cannot be found.");
    	} catch (IOException ex) { System.out.println("there was an IO Exception");
    	}
    }
    public static void main(String[] args) {
    	
    	byte[] myData = new byte[] {5, 6, 7, 8, 127, 65, 5, 6, 7, 8, 127, 65,5, 6, 7, 8, 127, 65};
//    	String outPath = "example.txt";
    	CopyAndMove.write(myData,"friday.txt");
        String input = "example.txt";
        byte[] buf = new byte[100];
        byte[] data = null;
        int dataIdx = 0;
        try {
            RandomAccessFile f = new RandomAccessFile(input, "r");
            data = new byte[(int) f.length()];
            while (true) {
                int nBytes = f.read(buf);
                if (nBytes == -1) {
                    break;
                }
                for (int i = 0; i < nBytes; i++) {
                    data[dataIdx] = buf[i];
                    dataIdx++;
                }
            }
            f.close();
        } catch (FileNotFoundException ex) {
            System.out.println("the file to be read cannot be found");
            return;
        } catch (IOException ex) {
			System.out.println("there is an IO exception.");
		}
//        Charset cs = Charset.forName("UTF-8");
        Charset cs = StandardCharsets.UTF_8;
        String s = new String(data, cs);
//        System.out.println(s);
    }

}