package tw.com.example.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tw.com.example.rest.service.Ma000ServiceImpl;
import tw.com.example.rest.vo.Ma000.Ma000Request;
import tw.com.example.rest.vo.Ma000.Ma000Response;

@RestController
public class Ma000Controller {

	@Autowired
	Ma000ServiceImpl ma000ServiceImpl ;
	
	@PostMapping("/syscode")
	public Ma000Response query(@RequestBody Ma000Request request) {
		System.out.println("ma000#start");
		System.out.println("request : " + request.getHeader().getSys());
		return ma000ServiceImpl.query(request);
	}
	
}
