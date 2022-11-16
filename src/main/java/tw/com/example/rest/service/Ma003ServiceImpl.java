package tw.com.example.rest.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.example.rest.entity.HrSysLoginEntity;
import tw.com.example.rest.entity.HrSysStaffEntity;
import tw.com.example.rest.repository.HrSysLoginRepository;
import tw.com.example.rest.repository.HrSysStaffRepository;
import tw.com.example.rest.vo.Ma003.Ma003Request;
import tw.com.example.rest.vo.Ma003.Ma003Response;
import tw.com.example.rest.vo.Ma003.Ma003ResponseHeader;

/*
 * MA003. 使用者變更密碼
 */
@Service
public class Ma003ServiceImpl {

	@Autowired
	HrSysStaffRepository staffRepository;

	@Autowired
	HrSysLoginRepository loginRepository;

	public Ma003Response changepwd(Ma003Request request) {

		Ma003Response response = new Ma003Response();
		Ma003ResponseHeader header = new Ma003ResponseHeader();

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
				
				// 是否大於 有效期間(30min)
				if (now > effectivetime) {
					header.setCode("0002");
					header.setDesc("登入時間逾期");
				}
				// 密碼變更成功
				else {
					String iden = findByToken.getIden();
//					HrSysStaffEntity findByIden = staffRepository.findByIden(iden);

					HrSysStaffEntity hrSysStaffEntity = new HrSysStaffEntity();

					String pwd = request.getBody().getPwd();

					hrSysStaffEntity.setIden(iden);
					hrSysStaffEntity.setPwd(pwd);
					staffRepository.save(hrSysStaffEntity);
					header.setCode("0000");
					header.setDesc("變更密碼成功");
					
					if(staffRepository == null) {
						header.setCode("0003");
						header.setDesc("變更密失敗");
					}
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