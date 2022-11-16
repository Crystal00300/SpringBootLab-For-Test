package tw.com.example.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tw.com.example.rest.entity.HrSysLoginEntity;

@Repository
public interface HrSysLoginRepository extends JpaRepository<HrSysLoginEntity, String> {

	public HrSysLoginEntity findByToken (String token);
}
