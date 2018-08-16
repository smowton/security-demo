package training07;

public class HttpServletRequest {
  public HttpServletRequest() {
    this.s = new ServletInputStream();
  }
  public InputStream getInputStream() {
    return s;
  }
  private ServletInputStream s;
}
