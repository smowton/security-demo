package training07;

class String {
  public String() {
    this.bytes = new byte[1];
    this.bytes[0] = 0;
  }
  public String(byte[] data, int shift, int count) {
    this.bytes = new byte[count];
    for (int i = 0; i != count; ++i)
      this.bytes[i] = data[shift + i];
  }
  public byte[] getBytes() {
    byte[] result = new byte[this.bytes.length];
    for (int i = 0; i != result.length; ++i)
      result[i] = this.bytes[i];
    return result;
  }
  private byte[] bytes;
}

class InputStream {
  public InputStream(String init) {
    this.s = init.getBytes();
  }
  int read(byte[] data, int shift, int count) {
    for (int i = 0; i != count; ++i) {
      if (i == this.s.length)
        return i;
      data[shift + i] = this.s[i];
    }
    return count;
  }
  private byte[] s;
  int a1;
  int a2;
  int a3;
  int a4;
  int a5;
  int a6;
  int a7;
  int a8;
  int a9;
}

class OutputStream {
  public OutputStream() {
    this.s = new byte[100];
  }
  public void write(byte[] data, int shift, int count) {
    for (int i = 0; i != count; ++i) {
      if (i == this.s.length)
        return;
      this.s[i] = data[i];
    }
  }
  public void write(byte[] data) {
    write(data,0,data.length);
  }
  private byte[] s;
}

class ServletInputStream extends InputStream {
  public ServletInputStream() {
    super(new String());
  }
}

class ServletOutputStream extends OutputStream {
}

public class test extends javax.servlet.http.HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) {
    InputStream in0 = getInStream(request);
    InputStream in = in0;
    byte[] data = new byte[2048];
    int size = getBytes(data,in);
    String str0 = new String(data, 0, size);
    String str = str0;
    str = sanitise(str);
    OutputStream out0 = getOutStream(response);
    OutputStream out = out0;
    out.write(data,0,size);
    out.write(str.getBytes());
  }

  private InputStream getInStream(HttpServletRequest request) {
    return request.getInputStream();
  }

  private int getBytes(byte[] data, InputStream in) {
    return in.read(data, 0, data.length);
  }

  private String sanitise(String str) {
      //str = str.replace("<","&lt;");
      //str = str.replace(">","&gt;");
      //return str;
      return new String();
  }

  private OutputStream getOutStream(HttpServletResponse response) {
    return response.getOutputStream();
  }
}

