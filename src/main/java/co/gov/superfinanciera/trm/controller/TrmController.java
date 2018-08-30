package co.gov.superfinanciera.trm.controller;

import java.rmi.RemoteException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import co.gov.superfinanciera.trm.service.TrmServiceConsumer;

@RestController
public class TrmController {

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/trm/obtenerTrm")
	public ResponseEntity<String> obtenerTrm() throws RemoteException {
		return new ResponseEntity<>(TrmServiceConsumer.obtenerTrm(), HttpStatus.OK);
	}
	
}
