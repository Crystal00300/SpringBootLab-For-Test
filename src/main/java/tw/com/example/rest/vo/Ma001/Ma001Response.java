package tw.com.example.rest.vo.Ma001;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class Ma001Response {

	private Ma001ResponseHeader header;

	// 如果body的結果是null，就不要顯示
	@JsonInclude(content = Include.NON_NULL)
	private Ma001ResponseBody body;

	public Ma001ResponseHeader getHeader() {
		return header;
	}

	public void setHeader(Ma001ResponseHeader header) {
		this.header = header;
	}

	public Ma001ResponseBody getBody() {
		return body;
	}

	public void setBody(Ma001ResponseBody body) {
		this.body = body;
	}

}