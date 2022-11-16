package tw.com.example.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.com.example.rest.entity.HrSysStaffAddrEntity;
import tw.com.example.rest.entity.HrSysStaffAddrPkey;

public interface HrSysStaffAddrRepository extends JpaRepository<HrSysStaffAddrEntity, HrSysStaffAddrPkey> {

	public List<HrSysStaffAddrEntity> findByPkIden(String iden);

}
