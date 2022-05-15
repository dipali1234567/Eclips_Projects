package com.Dipali.QRCodeGenerator.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.Dipali.QRCodeGenerator.Service.QRCodeService2;
import com.Dipali.QRCodeGenerator.Service.QRService;

@RestController
public class QRController {

	@Autowired
	QRService qrservice;
	
	@Autowired
	QRCodeService2 qr2;
	
	private static final String QR_CODE_IMAGE_PATH = 
			"./src/main/resources/QRCode.png";
	
	
	
	
	@GetMapping(value = "/genrateAndDownloadQRCode/{codeText}/{width}/{height}")
	public void download(
			@PathVariable("codeText") String codeText,
			@PathVariable("width") Integer width,
			@PathVariable("height") Integer height)
		    throws Exception {
		        qr2.generateQRCodeImage(codeText, width, height, QR_CODE_IMAGE_PATH);
		    }

@GetMapping(value = "/genrateQRCode/{codeText}/{width}/{height}")
	public ResponseEntity<byte[]> generateQRCode(
			@PathVariable("codeText") String codeText,
			@PathVariable("width") Integer width,
			@PathVariable("height") Integer height)
		    throws Exception {
		        return ResponseEntity.status(HttpStatus.OK).body(qr2.getQRCodeImage(codeText, width, height));
		    }
	
	
	
	
	@GetMapping("/GenerateQRCode/{url}")
	public void Generate(@PathVariable String url)
	{
		if(qrservice.checkValidURL(url))
		{
			System.out.println("Valid");
		}
		else
			System.out.println("URL is Not Valid Please Enter valid URL");
			
		
	}
	
	
	
}
