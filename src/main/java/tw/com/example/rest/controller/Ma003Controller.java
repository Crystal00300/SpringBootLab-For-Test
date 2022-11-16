package tw.com.example.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tw.com.example.rest.service.Ma003ServiceImpl;
import tw.com.example.rest.vo.Ma003.Ma003Request;
/*
 * MA003. 使用者變更密碼
 */
@RestController
public class Ma003Controller {
	
	@Autowired
	Ma003ServiceImpl ma003ServiceImpl;

	@PostMapping("/changepwd")
	public Object changepwd(@RequestBody Ma003Request request) {
		System.out.println("Ma003Controller Start！");
		System.out.println("request:" + request);
		return ma003ServiceImpl.changepwd(request);
	}
}
