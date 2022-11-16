package tw.com.example.rest.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.example.rest.entity.HrSysLoginEntity;
import tw.com.example.rest.entity.HrSysStaffEntity;
import tw.com.example.rest.repository.HrSysLoginRepository;
import tw.com.example.rest.repository.HrSysStaffRepository;
import tw.com.example.rest.vo.Ma002.Ma002Request;
import tw.com.example.rest.vo.Ma002.Ma002Response;
import tw.com.example.rest.vo.Ma002.Ma002ResponseBody;
import tw.com.example.rest.vo.Ma002.Ma002ResponseHeader;

/*
 * MA002. 使用者資料查詢
 */
@Service
public class Ma002ServiceImpl {

	@Autowired
	HrSysStaffRepository staffRepository;

	@Autowired
	HrSysLoginRepository loginRepository;

	public Ma002Response findUser(Ma002Request request) {

		Ma002Response response = new Ma002Response();
		Ma002ResponseHeader header = new Ma002ResponseHeader();
		Ma002ResponseBody body = new Ma002ResponseBody();

		try {
			// response - Header
			header.setSys(request.getHeader().getSys());
			header.setApi(request.getHeader().getApi());
			header.setTime(System.currentTimeMillis());// 時間戳記
			response.setHeader(header);

			String token = request.getBody().getToken();

			// 帶token去資料庫裡找有沒有相對應的資料
			HrSysLoginEntity findByToken = loginRepository.findByToken(token);
			System.out.println("findByToken:" + findByToken);

			if (findByToken == null) {
				header.setCode("0001");
				header.setDesc("查無登入資訊");

			} else if (findByToken != null) {
				Date currenDate = new Date();
				// 轉long比較時間
				long now = currenDate.getTime();
				long effectivetime = findByToken.getEffectiveTime().getTime();
				header.setCode("0000");
				header.setDesc("查詢成功");
				
				// 是否大於 有效期間(30min)
				if (now > effectivetime) {
					header.setCode("0002");
					header.setDesc("登入時間逾期");
				}
				// 有token而且沒過期，撈需要的table和資料
				else {
					String iden = findByToken.getIden();
					HrSysStaffEntity findByIden = staffRepository.findByIden(iden);

					body.setIden(findByIden.getIden());
					body.setCname(findByIden.getCname());
					body.setEname(findByIden.getEname());
					body.setSex(findByIden.getSex());
					
					response.setBody(body);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			header.setCode("9999");
			header.setDesc("系統發生異常，請聯絡系統管理員");
		}

		return response;
	}
}