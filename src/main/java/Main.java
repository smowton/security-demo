public class Main {
  public static void stringFoo() {
    String s = "hello";
    s = s+"world";
  }

  public static void  someMethodCaller() {
    Other ptr = new Other();
    Other.someMethodCaller(ptr);
  }

  public static void branches(int x) {
    if (x > 100)
      --x;
    else
      ++x;
    
    while (x > 0)
      if (x < 50)
       --x;
      else
        x = x - 2;
  }

/*These methods are replaced be same methods are in Other class. Uncomment these, if you want to use them instead.
  public static void XX() {
    int xx = GG;
    GG = xx;
  }

  public static void YY() {
    int yy = GG;
    GG = yy;
  }
*/  

  public static void test_stuff() {
    Node n = new Node();
    n.value = 100;
    n.next = n;
    int a = 1;
    int b = 2;

    /* next lines show how complex our instructions can be (they are not decomposed! :-( ) */

    int c = 5 * (8 * a + 9 * b) * n.next.next.next.value * 6;
    
    n.next.next.next.next.next.next = n.next.next.next.next.next.next.next.next;

    branches(n.value);
  }
  

  public static void foo() {
    int x1 = Main.taint_source_X1_retval();
    x1 = Main.taint_sanitiser_X1_retval(x1);
    Other.XX();
    GG = x1;
    Other.YY();
    Main.taint_sink_X1_arg_0(x1);
  }

  public static int bar() {
    int x1 = Main.taint_source_X1_retval();
    x1 = Other.baz0(x1);
    Other.branches(x1);
    Main.bug(x1);
    return x1;
  }
/*These methods are replaced be same methods are in Other class. Uncomment these, if you want to use them instead.
  public static int baz0(int a0) {
    return baz1(a0);
  }

  public static int baz1(int a0) {
    return a0;
  }
*/

  public static void XYZ(int a0) { }
  

  public static void bug(int a0) {
    Main.taint_sink_X1_arg_0(a0);
    XYZ(a0);
  }
  
  static int GG;

  public static int taint_source_X1_retval() { return 0; }
  public static int taint_sanitiser_X1_retval(int a0) { return 0; }
  public static void taint_sink_X1_arg_0(int a0) { }
}

