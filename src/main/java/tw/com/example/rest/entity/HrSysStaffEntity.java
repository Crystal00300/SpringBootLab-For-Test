package tw.com.example.rest.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HR_SYS_STAFF")
public class HrSysStaffEntity {

	@Id
	@Column(name = "IDEN")
	private String iden;

	@Column(name = "PWD")
	private String pwd;

	@Column(name = "CNAME")
	private String cname;

	@Column(name = "ENAME")
	private String ename;

	@Column(name = "BIRTH")
	private LocalDate birth;

	@Column(name = "SEX")
	private String sex;
	
	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}


	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getIden() {
		return iden;
	}

	public void setIden(String iden) {
		this.iden = iden;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public LocalDate getBirth() {
		return birth;
	}

	public void setBirth(LocalDate birth) {
		this.birth = birth;
	}

}