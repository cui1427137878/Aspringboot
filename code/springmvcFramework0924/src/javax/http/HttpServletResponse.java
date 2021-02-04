package javax.http;
//服务器返回的结果
public class HttpServletResponse {
	String responseBody;//放controller执行的结果

	public String getResponseBody() {
		return responseBody;
	}

	public void setResponseBody(String responseBody) {
		this.responseBody = responseBody;
	}
	

}
