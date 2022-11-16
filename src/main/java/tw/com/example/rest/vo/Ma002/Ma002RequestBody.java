package tw.com.example.rest.vo.Ma002;

public class Ma002RequestBody {

	private String token;

	private String Iden;

	private String pwd;

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getIden() {
		return Iden;
	}

	public void setIden(String iden) {
		Iden = iden;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}