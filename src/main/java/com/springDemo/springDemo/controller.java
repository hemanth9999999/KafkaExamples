package com.springDemo.springDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import config.ProducerKafka;

@RestController
public class controller {
	@Autowired
	Environment Env ;
	
	@Autowired
	ProducerKafka producer;
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String helloWorld(@RequestParam("input") String value)
	{
		System.out.println("inside get method");
		producer.sendMessage(value);
		return "Hello world " + Env.getProperty("Message") ; 
	}

}
