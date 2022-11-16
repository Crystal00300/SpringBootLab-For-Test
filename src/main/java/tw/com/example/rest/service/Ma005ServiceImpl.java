package tw.com.example.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.example.rest.entity.HrSysCodeEntity;
import tw.com.example.rest.entity.HrSysLeaveEntity;
import tw.com.example.rest.entity.HrSysLoginEntity;
import tw.com.example.rest.entity.HrSysStaffAddrEntity;
import tw.com.example.rest.entity.HrSysStaffEntity;
import tw.com.example.rest.repository.HrSysCodeRepository;
import tw.com.example.rest.repository.HrSysLeaveRepository;
import tw.com.example.rest.repository.HrSysLoginRepository;
import tw.com.example.rest.repository.HrSysStaffAddrRepository;
import tw.com.example.rest.repository.HrSysStaffRepository;
import tw.com.example.rest.vo.Ma004.Ma004ResponseBody;
import tw.com.example.rest.vo.Ma004.Ma004ResponseData;
import tw.com.example.rest.vo.Ma005.Ma005Request;
import tw.com.example.rest.vo.Ma005.Ma005Response;
import tw.com.example.rest.vo.Ma005.Ma005ResponseBody;
import tw.com.example.rest.vo.Ma005.Ma005ResponseData;
import tw.com.example.rest.vo.Ma005.Ma005ResponseHeader;

@Service
public class Ma005ServiceImpl {

	@Autowired
	HrSysCodeRepository hrSysCodeRepository;

	@Autowired
	HrSysLoginRepository hrSysLoginRepository;

	@Autowired
	HrSysStaffRepository hrSysStaffRepository;

	@Autowired
	HrSysStaffAddrRepository hrSysStaffAddrRepository;

	@Autowired
	HrSysLeaveRepository hrSysLeaveRepository;

	public Ma005Response findUserLeave(Ma005Request request) {
		System.out.println("Ma005Response Service Start");

		Ma005Response response = new Ma005Response();
		System.out.println("response:" + response);

		String token = request.getBody().getToken();
		System.out.println("token : " + token);

		// 組成 Response 的 Header
		Ma005ResponseHeader header = new Ma005ResponseHeader();
		header.setSys(request.getHeader().getSys());
		header.setApi(request.getHeader().getApi());
		header.setTime(System.currentTimeMillis());
		response.setHeader(header);

		HrSysLoginEntity findByToken = hrSysLoginRepository.findByToken(token);

		// 帶著token找到iden
		String iden = findByToken.getIden();

		HrSysStaffEntity findByIden = hrSysStaffRepository.findByIden(iden);

		List<Ma005ResponseData> dataList = new ArrayList<>();

		List<HrSysLeaveEntity> entityList = hrSysLeaveRepository.findByPkIden(iden);

		// 組成 Response 的 Body 裡的資料明細
		for (int i = 0; i < entityList.size(); i++) {
			// HR_SYS_LEAVE
			Ma005ResponseData data = new Ma005ResponseData();
			HrSysCodeEntity code = hrSysCodeRepository.findByPkGpAndPkCode("LEAVE_TYPE",
					entityList.get(i).getPk().getLeaveType());

			data.setType(entityList.get(i).getPk().getLeaveType());
			data.setTypeDesc(code.getCname());
			data.setOwnHours(entityList.get(i).getOwnHours());
			data.setApplyHours(entityList.get(i).getApplyHours());
			data.setTotalHours(entityList.get(i).getOwnHours() - entityList.get(i).getApplyHours());
			dataList.add(data);

		}
		
		// 組成 Response 的 Body
		Ma005ResponseBody body = new Ma005ResponseBody();
		body.setIden(findByIden.getIden());
		body.setCname(findByIden.getCname());
		body.setYear(request.getBody().getYear());
		body.setLeaves(dataList);
		
		

		if (dataList.isEmpty()) {
			header.setCode("0001");
			header.setDesc("查無資料");
		} else {
			
			response.setBody(body);
			header.setCode("0000");
			header.setDesc("查詢成功");
		}

		return response;
	}

}