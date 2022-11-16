package tw.com.example.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tw.com.example.rest.service.Ma004ServiceImpl;
import tw.com.example.rest.vo.Ma004.Ma004Request;

/*
 * MA004. 使用者資料查詢（明細）
 */
@RestController
public class Ma004Controller {

	@Autowired
	Ma004ServiceImpl ma004ServiceImpl;

	@PostMapping("/user/all")
	public Object findUserDtl(@RequestBody Ma004Request request) {
		System.out.println("Ma004Controller Start！");
		System.out.println("request:" + request.getHeader().getSys());
		return ma004ServiceImpl.findUserDtl(request);
	}
}
