package com.seaway.liufuya.mvc.report;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

/**
 * This input stream deletes the given file when the InputStream is closed;
 * intended to be used with temporary files.
 * 
 */
public class DeletingFileInputStream extends FileInputStream implements
		Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected File file = null;

	public DeletingFileInputStream(File file) throws FileNotFoundException {
		super(file);
		this.file = file;
	}

	@Override
	public void close() throws IOException {
		super.close();
		file.delete();
	}
}
