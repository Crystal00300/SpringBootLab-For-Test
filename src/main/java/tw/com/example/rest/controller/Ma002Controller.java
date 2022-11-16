package tw.com.example.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tw.com.example.rest.service.Ma002ServiceImpl;
import tw.com.example.rest.vo.Ma002.Ma002Request;

/*
 * MA002. 使用者資料查詢
 */
@RestController
public class Ma002Controller {

	@Autowired
	Ma002ServiceImpl ma002ServiceImpl;
	
	@PostMapping("/user")
	public Object findUser(@RequestBody Ma002Request request) {
		System.out.println("Ma002Controller Start！");
		System.out.println("request:" + request);
		return ma002ServiceImpl.findUser(request);
	}
}