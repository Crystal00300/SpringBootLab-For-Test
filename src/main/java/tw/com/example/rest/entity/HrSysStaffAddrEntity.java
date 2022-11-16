package tw.com.example.rest.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "HR_SYS_STAFF_ADDR")
public class HrSysStaffAddrEntity {

	@EmbeddedId
	private HrSysStaffAddrPkey pk;

	private String zipCode;

	private String addr;

	public HrSysStaffAddrPkey getPk() {
		return pk;
	}

	public void setPk(HrSysStaffAddrPkey pk) {
		this.pk = pk;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipcode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

}