package com.tadiche.springboot.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.Deflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tadiche.springboot.model.ImageModel;
import com.tadiche.springboot.repo.DeliveryImageRepository;

//@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
@RestController
@RequestMapping(path = "/image")
public class ImageUploadController {

	@Autowired
	DeliveryImageRepository imageRepository;

	@PostMapping("/upload")
	public HttpStatus uploadDeliveredImage(@RequestParam("barcode") String barcode,
			@RequestParam("barcodeType") String barcodeType,
			@RequestParam("imageFileName") String fileName,
			@RequestParam("imageFile") MultipartFile file) throws IOException {
		System.out.println("Original Image Byte Size - " + file.getBytes().length);

		ImageModel img = new ImageModel(barcode,barcodeType,fileName);
				//compressBytes(file.getBytes()));

		ImageModel model = imageRepository.save(img);
		//return ResponseEntity.status(HttpStatus.OK);
		return model != null ? HttpStatus.OK:HttpStatus.INTERNAL_SERVER_ERROR;
	}

	// compress the image bytes before storing it in the database
	public static byte[] compressBytes(byte[] bytes) {
		// TODO Auto-generated method stub
		Deflater deflater = new Deflater();
		deflater.setInput(bytes);
		deflater.finish();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(bytes.length);

		byte[] buffer = new byte[1024];

		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}

		try {
			outputStream.close();
		} catch (IOException e) {
		}

		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

		return outputStream.toByteArray();
	}
}
