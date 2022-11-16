package tw.com.example.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tw.com.example.rest.entity.HrSysLeaveEntity;
import tw.com.example.rest.entity.HrSysLeavePkey;

@Repository
public interface HrSysLeaveRepository extends JpaRepository<HrSysLeaveEntity, HrSysLeavePkey> {

	public List<HrSysLeaveEntity> findByPkIden(String iden);
}
