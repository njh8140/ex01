package com.njh8140.controller;

import java.util.ArrayList;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.njh8140.domain.SampleDTO;
import com.njh8140.domain.SampleDTOList;
import com.njh8140.domain.TodoDTO;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/sample")
public class SampleController {

	@RequestMapping("")
	public void basic() {
		log.info("basic........");
	}
	
	@RequestMapping(value = "/basic", method={RequestMethod.GET, RequestMethod.POST})
	public void basicGet() {
		log.info("basic get");
	}
	
	@RequestMapping("/basic2")
	public String basicGet2() {
		log.info("basic2 get");
		return "yyy";
	}
	
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		log.info("@@@@ "+ dto);
		return "ex01";
	}
	
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String n, @RequestParam("age") int a) {
		log.info("####name : " + n);
		log.info("####age : " + a);
		return "ex02";
	}
	
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ids") ArrayList<String> ids) {
		log.info("$$$Array ids : " + ids);
		return "ex02List";
	}
	
	@GetMapping("/ex02Bean")
	public String ex02Bean(SampleDTOList list) {
		log.info("list dtos : " + list);
		return "ex02Bean";
	}
	
	@GetMapping("/ex03")
	public String ex03(TodoDTO todo) {
		log.info("todo : " + todo);
		return "ex03";
	}
	
	@GetMapping("/ex04")
	public String ex04(SampleDTO dto, int page, Model model) {
		log.info("dto : " + dto);
		log.info("page : " + page);
		model.addAttribute("page", page);
		return "/sample/ex04";
	}
	
	@GetMapping("/ex05")
	public @ResponseBody SampleDTO ex05() {
		log.info("/ex05.....");
		SampleDTO dto = new SampleDTO();
		dto.setName("이순신");
		dto.setAge(15);
		
		return dto;
	}
	
	@GetMapping("/ex06")
	public ResponseEntity<String> ex06(){
		log.info("/ex06.....");
		String msg = "{\"name\":\"홍길동\"}";
		
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json;charset=UTF-8");
		
		return new ResponseEntity<String>(msg, header, HttpStatus.OK);
	}
}