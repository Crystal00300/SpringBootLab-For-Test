package tw.com.example.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tw.com.example.rest.service.Ma001ServiceImpl;
import tw.com.example.rest.vo.Ma001.Ma001Request;

/*
 * MA001. 使用者登入
 */
@RestController
public class Ma001Controller {

	@Autowired
	Ma001ServiceImpl ma001ServiceImpl;

	@PostMapping("/login")
	public Object login(@RequestBody Ma001Request request) {
		System.out.println("Ma001Controller Start！");
		System.out.println("request:" + request.getHeader().getSys());
		return ma001ServiceImpl.login(request);
	}
}