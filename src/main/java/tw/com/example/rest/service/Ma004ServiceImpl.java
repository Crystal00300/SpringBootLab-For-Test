package tw.com.example.rest.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.example.rest.entity.HrSysCodeEntity;
import tw.com.example.rest.entity.HrSysLoginEntity;
import tw.com.example.rest.entity.HrSysStaffAddrEntity;
import tw.com.example.rest.entity.HrSysStaffEntity;
import tw.com.example.rest.repository.HrSysCodeRepository;
import tw.com.example.rest.repository.HrSysLoginRepository;
import tw.com.example.rest.repository.HrSysStaffAddrRepository;
import tw.com.example.rest.repository.HrSysStaffRepository;
import tw.com.example.rest.vo.Ma004.Ma004Request;
import tw.com.example.rest.vo.Ma004.Ma004Response;
import tw.com.example.rest.vo.Ma004.Ma004ResponseBody;
import tw.com.example.rest.vo.Ma004.Ma004ResponseData;
import tw.com.example.rest.vo.Ma004.Ma004ResponseHeader;

/*
 * MA004. 使用者資料查詢（明細）
 */
@Service
public class Ma004ServiceImpl {

	@Autowired
	HrSysCodeRepository hrSysCodeRepository;

	@Autowired
	HrSysLoginRepository hrSysLoginRepository;

	@Autowired
	HrSysStaffRepository hrSysStaffRepository;

	@Autowired
	HrSysStaffAddrRepository hrSysStaffAddrRepository;

	public Ma004Response findUserDtl(Ma004Request request) {
		System.out.println("Ma004Response Service Start");

		Ma004Response response = new Ma004Response();
		System.out.println("response:" + response);

		String token = request.getBody().getToken();
		System.out.println("token : " + token);

		// 組成 Response 的 Header
		Ma004ResponseHeader header = new Ma004ResponseHeader();
		header.setSys(request.getHeader().getSys());
		header.setApi(request.getHeader().getApi());
		header.setTime(System.currentTimeMillis());
		response.setHeader(header);

		HrSysLoginEntity findByToken = hrSysLoginRepository.findByToken(token);
		String iden = findByToken.getIden();
		HrSysStaffEntity findByIden = hrSysStaffRepository.findByIden(iden);

		LocalDate now = LocalDate.now();

		LocalDate birth = findByIden.getBirth();

		int years = birth.until(now).getYears();
		String age = Integer.toString(years);
		System.out.println("age:" + age);

		// 組成 Response 的 Body
		Ma004ResponseBody body = new Ma004ResponseBody();
		body.setIden(findByIden.getIden());
		body.setCname(findByIden.getCname());
		body.setEname(findByIden.getEname());
		body.setAge(age);
		body.setBirth(findByIden.getBirth());
		body.setSex(findByIden.getSex());
//		body.seCtAddress(findByIden.getAddress());
		System.out.println("bodyTest:" + body);

		List<Ma004ResponseData> dataList = new ArrayList<>();

		List<HrSysStaffAddrEntity> entityList = hrSysStaffAddrRepository.findByPkIden(iden);
		System.out.println("entityList:" + entityList);

		Ma004ResponseData data = new Ma004ResponseData();

		// 組成 Response 的 Body 裡的資料明細
		for (int i = 0; i < entityList.size(); i++) {
			HrSysCodeEntity codeList = hrSysCodeRepository.findByPkGpAndPkCode("ZIP", entityList.get(i).getZipCode());

			HrSysStaffAddrEntity hrSysStaffAddrEntity = entityList.get(i);

			System.out.println("test001:" + hrSysStaffAddrEntity.getPk().getType());
			if (hrSysStaffAddrEntity.getPk().getType().equals("A")) {
				data.setDomicile(hrSysStaffAddrEntity.getZipCode() + hrSysStaffAddrEntity.getAddr() + codeList.getCname());
				System.out.println("data:" + data.getDomicile());

			} else {
				data.setContact(hrSysStaffAddrEntity.getZipCode() + hrSysStaffAddrEntity.getAddr() + codeList.getCname());
				System.out.println("data:" + data.getDomicile());

			}

			dataList.add(data);
			body.setAddress(data);
			response.setBody(body);
		}

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