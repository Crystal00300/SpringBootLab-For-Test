package tw.com.example.rest.entity;
/*
 * MA001. 使用者登入
 */
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HR_SYS_LOGIN")
public class HrSysLoginEntity {

	@Id
	@Column(name = "IDEN")
	private String iden;

	@Column(name = "TOKEN")
	private String token;

	@Column(name = "CRE_TIME")
	private Date creTime;

	@Column(name = "EFFECTIVE_TIME")
	private Date effectiveTime;

	public String getIden() {
		return iden;
	}

	public void setIden(String iden) {
		this.iden = iden;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getCreTime() {
		return creTime;
	}

	public void setCreTime(Date creTime) {
		this.creTime = creTime;
	}

	public Date getEffectiveTime() {
		return effectiveTime;
	}

	public void setEffectiveTime(Date effectiveTime) {
		this.effectiveTime = effectiveTime;
	}

}