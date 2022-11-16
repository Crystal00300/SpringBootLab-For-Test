package tw.com.example.rest.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tw.com.example.rest.entity.HrSysCodeEntity;
import tw.com.example.rest.entity.HrSysCodePkey;

@Repository
public interface HrSysCodeRepository extends CrudRepository<HrSysCodeEntity, HrSysCodePkey> {

	public List<HrSysCodeEntity> findByPkGp(String gp);

	public HrSysCodeEntity findByPkGpAndPkCode(String gp, String code);

}
