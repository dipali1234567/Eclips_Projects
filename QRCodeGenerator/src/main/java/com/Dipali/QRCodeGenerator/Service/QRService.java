package com.Dipali.QRCodeGenerator.Service;
import java.net.URL;
import org.springframework.stereotype.Service;

@Service
public class QRService {

	public boolean checkValidURL(String url) {
		
		
		 try {
	            new URL(url).toURI();
	            return true;
	        }
	          
	        // If there was an Exception
	        // while creating URL object
	        catch (Exception e) {
	            return false;
	        }
		
	}
	  
}


