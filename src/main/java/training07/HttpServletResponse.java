package training07;

public class HttpServletResponse {
  public HttpServletResponse() {
    this.s = new ServletOutputStream();
  }
  public OutputStream getOutputStream() {
    return s;
  }
  private ServletOutputStream s;
}
