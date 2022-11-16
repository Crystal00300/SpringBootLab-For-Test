package tw.com.example.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tw.com.example.rest.service.Ma004ServiceImpl;
import tw.com.example.rest.service.Ma005ServiceImpl;
import tw.com.example.rest.vo.Ma004.Ma004Request;
import tw.com.example.rest.vo.Ma005.Ma005Request;

@RestController
public class Ma005Controller {

	@Autowired
	Ma005ServiceImpl ma005ServiceImpl;

	@PostMapping("/user/leave")
	public Object findUserLeave(@RequestBody Ma005Request request) {
		System.out.println("Ma005Controller Start！");
		System.out.println("request:" + request.getHeader().getSys());
		return ma005ServiceImpl.findUserLeave(request);
	}
}
