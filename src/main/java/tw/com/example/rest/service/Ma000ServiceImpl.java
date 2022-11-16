package tw.com.example.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.example.rest.entity.HrSysCodeEntity;
import tw.com.example.rest.repository.HrSysCodeRepository;
import tw.com.example.rest.vo.Ma000.Ma000Request;
import tw.com.example.rest.vo.Ma000.Ma000Response;
import tw.com.example.rest.vo.Ma000.Ma000ResponseBody;
import tw.com.example.rest.vo.Ma000.Ma000ResponseData;
import tw.com.example.rest.vo.Ma000.Ma000ResponseHeader;

@Service
public class Ma000ServiceImpl {

	@Autowired
	HrSysCodeRepository hrSysCodeRepository;

	public Ma000Response query(Ma000Request request) {

		Ma000Response response = new Ma000Response();

		String gp = request.getBody().getGp();
		System.out.println("GP : " + gp);

		// 組成 Response 的 Header
		Ma000ResponseHeader header = new Ma000ResponseHeader();
		header.setSys(request.getHeader().getSys());
		header.setApi(request.getHeader().getApi());
		header.setTime(System.currentTimeMillis());
		response.setHeader(header);

		// 組成 Response 的 Body
		Ma000ResponseBody body = new Ma000ResponseBody();
		body.setGp(request.getBody().getGp());

		List<Ma000ResponseData> dataList = new ArrayList<>();

		List<HrSysCodeEntity> entityList = hrSysCodeRepository.findByPkGp(gp);

		// 組成 Response 的 Body 裡的資料明細
		for (int i = 0; i < entityList.size(); i++) {
			System.out.println(entityList.get(i));
			Ma000ResponseData data = new Ma000ResponseData();
			data.setCode(entityList.get(i).getPk().getCode());
			data.setCname(entityList.get(i).getCname());
			dataList.add(data);
		}

		body.setData(dataList);
		response.setBody(body);

		if (dataList.isEmpty()) {
			header.setCode("0001");
			header.setDesc("查無資料");
		} else {
			header.setCode("0000");
			header.setDesc("查詢成功");
		}
		return response;
	}
}