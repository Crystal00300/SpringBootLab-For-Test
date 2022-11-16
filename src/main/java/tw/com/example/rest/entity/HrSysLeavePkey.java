package tw.com.example.rest.entity;

import java.io.Serializable;

public class HrSysLeavePkey implements Serializable {

	private String year;

	private String iden;

	private String leaveType;

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getIden() {
		return iden;
	}

	public void setIden(String iden) {
		this.iden = iden;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

}
