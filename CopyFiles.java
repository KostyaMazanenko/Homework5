package com.gmail.kostamazanenko;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyFiles {
	
	public static File[] selection(File folderFrom) {
		MyFileFilter mff = new MyFileFilter("doc");
		return folderFrom.listFiles(mff);
	}
	
	public static void copyFile(InputStream is, OutputStream os) throws IOException{
		byte[] buffer = new byte[1024*1024];
		int amountBytes;
		for(;(amountBytes = is.read(buffer)) > 0;) {
			os.write(buffer, 0, amountBytes);
		}
	}
	
	public static void copyFolderContent(File folderFrom, File folderTo) throws IOException {
		if(folderFrom == null || folderTo == null) {
			throw new IllegalArgumentException("Null file pointer");
		}
		
		File[] files = selection(folderFrom);
		for (int i = 0; i < files.length; i++) {
			File copiedFile = new File(folderTo.getAbsolutePath() + "//" + files[i].getName());
			try(InputStream is = new FileInputStream(files[i]);
					OutputStream os = new FileOutputStream(copiedFile)){
				copyFile(is, os);
			} catch(IOException e) {
				throw e;
			}
		}
		
	}

}
