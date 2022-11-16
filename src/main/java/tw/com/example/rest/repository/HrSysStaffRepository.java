package tw.com.example.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tw.com.example.rest.entity.HrSysStaffEntity;

@Repository
public interface HrSysStaffRepository extends JpaRepository<HrSysStaffEntity, String> {

	public HrSysStaffEntity findByIden(String iden);
	
}
