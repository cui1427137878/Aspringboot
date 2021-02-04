package javax.http;

public class HttpServletResponse {
    String responseBody;//服务器返回给浏览器的响应体

    public String getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }
}
