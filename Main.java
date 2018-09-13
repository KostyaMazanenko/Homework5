package com.gmail.kostamazanenko;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		File folderIn = new File("D:\\folderin");
		File folderOut = new File("D:\\folderout");
		
		try {
			CopyFiles.copyFolderContent(folderIn, folderOut);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
