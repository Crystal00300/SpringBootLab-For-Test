package tw.com.example.rest.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="HR_SYS_CODE")
public class HrSysCodeEntity {
	
	@EmbeddedId
	private HrSysCodePkey pk ;

	private String cname ;

	public HrSysCodePkey getPk() {
		return pk;
	}

	public void setPk(HrSysCodePkey pk) {
		this.pk = pk;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}
	
}
