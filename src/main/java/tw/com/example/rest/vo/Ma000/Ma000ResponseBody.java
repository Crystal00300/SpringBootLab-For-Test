package tw.com.example.rest.vo.Ma000;

import java.util.List;

public class Ma000ResponseBody {
	
	private String gp ;
	
	private List<Ma000ResponseData> data ;

	public String getGp() {
		return gp;
	}

	public void setGp(String gp) {
		this.gp = gp;
	}

	public List<Ma000ResponseData> getData() {
		return data;
	}

	public void setData(List<Ma000ResponseData> data) {
		this.data = data;
	}

}
