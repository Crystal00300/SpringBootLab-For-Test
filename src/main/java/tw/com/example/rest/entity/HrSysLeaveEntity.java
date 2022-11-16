package tw.com.example.rest.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "HR_SYS_LEAVE")
public class HrSysLeaveEntity {

	@EmbeddedId
	private HrSysLeavePkey pk;

	@Column(name = "LEAVE_OWN_HOURS")
	private Integer ownHours;

	@Column(name = "LEAVE_APPLY_HOURS")
	private Integer applyHours;

	public HrSysLeavePkey getPk() {
		return pk;
	}

	public void setPk(HrSysLeavePkey pk) {
		this.pk = pk;
	}

	public Integer getOwnHours() {
		return ownHours;
	}

	public void setOwnHours(Integer ownHours) {
		this.ownHours = ownHours;
	}

	public Integer getApplyHours() {
		return applyHours;
	}

	public void setApplyHours(Integer applyHours) {
		this.applyHours = applyHours;
	}

}
