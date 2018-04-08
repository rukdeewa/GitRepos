package com.example.demo;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

public class ImageTest {
	
	public void process() throws IOException {
		String pathToImage = "";
		ImageInputStream is = null;
		try {
			is = ImageIO.createImageInputStream(new File(pathToImage));
			if (is == null || is.length() == 0){
				  // handle error
					System.out.println("Error");
				}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		Iterator<ImageReader> iterator = ImageIO.getImageReaders(is);
		if (iterator == null || !iterator.hasNext()) {
		  throw new IOException("Image file format not supported by ImageIO: " + pathToImage);
		}
		// We are just looking for the first reader compatible:
		ImageReader reader = (ImageReader) iterator.next();
		iterator = null;
		reader.setInput(is);
		
		int numberPages = reader.getNumImages(true);
		System.out.println(numberPages);
		
		
//		read pages separatly:
		reader.read(numberPages);
	}
		
}
