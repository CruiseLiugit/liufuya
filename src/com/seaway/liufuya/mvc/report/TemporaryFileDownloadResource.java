package com.seaway.liufuya.mvc.report;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Serializable;

import com.vaadin.server.DownloadStream;
import com.vaadin.server.StreamResource;


public class TemporaryFileDownloadResource extends StreamResource implements Serializable{

	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final String filename;
	  private String contentType;

	  public TemporaryFileDownloadResource(String fileName, String contentType, File tempFile) throws FileNotFoundException {
	    super(new FileStreamResource(tempFile), fileName);
	    this.filename = fileName;
	    this.contentType = contentType;
	  }

	  public DownloadStream getStream() {
	    DownloadStream stream = new DownloadStream(getStreamSource().getStream(), contentType, filename);
	    stream.setParameter("Content-Disposition", "attachment;filename=" + filename);
	    // This magic incantation should prevent anyone from caching the data
	    stream.setParameter("Cache-Control", "private,no-cache,no-store");    
	    // In theory <=0 disables caching. In practice Chrome, Safari (and, apparently, IE) all ignore <=0. Set to 1s 
	    stream.setCacheTime(1000);
	    return stream;
	  }

	  private static class FileStreamResource implements
	      StreamResource.StreamSource {

	    private final InputStream inputStream;

	    public FileStreamResource(File fileToDownload)
	        throws FileNotFoundException {
	      inputStream = new DeletingFileInputStream(fileToDownload);
	    }

	    public InputStream getStream() {
	      return inputStream;
	    }
	  }

}