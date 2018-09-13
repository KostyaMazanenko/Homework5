package com.gmail.kostamazanenko;

import java.io.File;
import java.io.FileFilter;

public class MyFileFilter implements FileFilter {
	
	private String extension;

	public MyFileFilter(String extension) {
		super();
		this.extension = extension;
	}

	public MyFileFilter() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean accept(File pathname) {
		String name = pathname.getName();
		int indexOfPoint = name.lastIndexOf('.');
		
		if(indexOfPoint == -1) {
			return false;
		}
		
		String extencionName = name.substring(indexOfPoint + 1);
		
		if(extencionName.equals(extension)) {
			return true;
		}
		return false;
	}
	
	

}
