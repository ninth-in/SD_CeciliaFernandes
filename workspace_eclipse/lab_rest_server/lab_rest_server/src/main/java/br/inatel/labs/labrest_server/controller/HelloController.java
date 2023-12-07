package br.inatel.labs.labrest_server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {

	@GetMapping
	public MyMessager processarGetHello() {
		MyMessager msg = new MyMessager();
		msg.setInfo("Olá mundo REST");
		return msg;
	}
}
