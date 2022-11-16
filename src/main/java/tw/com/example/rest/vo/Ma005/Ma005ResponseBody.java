package tw.com.example.rest.vo.Ma005;

import java.util.List;

public class Ma005ResponseBody {

	private String iden;

	private String cname;

	private String year;

	private List<Ma005ResponseData> leaves;

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

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public List<Ma005ResponseData> getLeaves() {
		return leaves;
	}

	public void setLeaves(List<Ma005ResponseData> leaves) {
		this.leaves = leaves;
	}

}
