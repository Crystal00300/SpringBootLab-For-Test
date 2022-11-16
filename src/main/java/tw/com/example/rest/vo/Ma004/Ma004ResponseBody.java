package tw.com.example.rest.vo.Ma004;

import java.time.LocalDate;

public class Ma004ResponseBody {

	private String iden;

	private String cname;

	private String ename;

	private String age;

	private LocalDate birth;

	private String sex;

	private Ma004ResponseData address;

	public String getIden() {
		return iden;
	}

	public void setIden(String iden) {
		this.iden = iden;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public LocalDate getBirth() {
		return birth;
	}

	public void setBirth(LocalDate birth) {
		this.birth = birth;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Ma004ResponseData getAddress() {
		return address;
	}

	public void setAddress(Ma004ResponseData address) {
		this.address = address;
	}

}
