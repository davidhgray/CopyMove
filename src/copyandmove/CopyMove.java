package copyandmove;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyMoveThur {
	public static void main(String[] args) {
		if (args.length != 3) {
			System.out.println("please pass three arguments");
		} else {
			String opType = null;
			String fileIn = null;
			String fileOut = null;
			opType = args[0];
			fileIn = args[1];
			fileOut = args[2];
			InputStream inStream = null;
			OutputStream outStream = null;

			try {
				File afile = new File(fileIn);
				File bfile = new File(fileOut);

				inStream = new FileInputStream(afile);
				outStream = new FileOutputStream(bfile);

				byte[] buffer = new byte[1024];

				int length;
				// read the contents into the file in bytes
				while ((length = inStream.read(buffer)) > 0) {

					outStream.write(buffer, 0, length);
//					System.out.println(buffer);
//					System.out.println(length);
				}

				inStream.close();
				outStream.close();

				// delete the original file if the opType is "mv"
				if (opType.equals("mv")) {
					afile.delete();
				}

				System.out.println("Operation successful.");
				
			} catch (FileNotFoundException e) {
				System.out.println("one of your paths is invalid. please correct and retry.");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}