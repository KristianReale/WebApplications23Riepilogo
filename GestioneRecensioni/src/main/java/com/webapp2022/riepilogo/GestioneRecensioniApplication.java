package com.webapp2022.riepilogo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class GestioneRecensioniApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestioneRecensioniApplication.class, args);
	}

}
