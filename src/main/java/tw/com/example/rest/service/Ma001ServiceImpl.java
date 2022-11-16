package tw.com.example.rest.service;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.example.rest.entity.HrSysLoginEntity;
import tw.com.example.rest.entity.HrSysStaffEntity;
import tw.com.example.rest.repository.HrSysLoginRepository;
import tw.com.example.rest.repository.HrSysStaffRepository;
import tw.com.example.rest.vo.Ma001.Ma001Request;
import tw.com.example.rest.vo.Ma001.Ma001Response;
import tw.com.example.rest.vo.Ma001.Ma001ResponseBody;
import tw.com.example.rest.vo.Ma001.Ma001ResponseHeader;

/*
 * MA001. 使用者登入
 */
@Service
public class Ma001ServiceImpl {

	@Autowired
	HrSysStaffRepository staffRepository;

	@Autowired
	HrSysLoginRepository loginRepository;

	public Ma001Response login(Ma001Request request) {

		Ma001Response response = new Ma001Response();
		Ma001ResponseHeader header = new Ma001ResponseHeader();
		Ma001ResponseBody body = new Ma001ResponseBody();

		try {
			String iden = request.getBody().getIden();
			System.out.println("TestSrevice01:" + iden);

			String pwd = request.getBody().getPwd();
			System.out.println("TestSrevice02:" + pwd);

			// response - Header
			header.setSys(request.getHeader().getSys());
			header.setApi(request.getHeader().getApi());
			header.setTime(System.currentTimeMillis());// 時間戳記
			response.setHeader(header);

			HrSysStaffEntity user = staffRepository.findByIden(iden);

			// 判斷
			if (user == null) {
				header.setCode("0001");
				header.setDesc("查無資料");
			} else if (!pwd.equals(user.getPwd())) {
				header.setCode("0002");
				header.setDesc("密碼錯誤");
			} else {
				// create - token
				String token = UUID.randomUUID().toString();
				System.out.println("body:" + body);

				// token 時間
				Date currenDate = new Date();
				// 取得現在時間
				Calendar instance = Calendar.getInstance();
				instance.setTime(currenDate);

				// token 設為 30mins
				instance.add(Calendar.MINUTE, 30);
				Date afterTime = instance.getTime();
				HrSysLoginEntity loginEntity = new HrSysLoginEntity();

				loginEntity.setIden(iden);
				loginEntity.setToken(token);
				loginEntity.setCreTime(currenDate);

				loginEntity.setEffectiveTime(afterTime);
				System.out.println("token時間：" + loginEntity.getEffectiveTime());

				header.setCode("0000");
				header.setDesc("查詢成功");
				body.setToken(token);
				loginRepository.save(loginEntity);
				response.setBody(body);
			}

		} catch (Exception e) {
			e.printStackTrace();
			header.setCode("9999");
			header.setDesc("系統發生異常，請聯絡系統管理員");
		}

		return response;
	}
}