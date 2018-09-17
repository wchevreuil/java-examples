import java.util.regex.Pattern;

public class RegexTest {

  public static void main(String[] args) {

    // String input = "/test1 myKey \n\n /user/wchevreuil/.Trash/Current/test2 myKey \n\n ";
    //
    // System.out.println(
    // Pattern.matches("(/test1)\\s*(myKey)\\s*(/user/).*(.Trash/Current/test2)\\s*(myKey)\\s*",
    // input));
    //
    // System.out.println(
    // Pattern.compile(".*(/test1)\\s*(myKey).*(\n)*.*(Trash/Current/test2).*(\n)*")
    // .matcher(
    // "/test1 myKey \n\n /user/wchevreuil/.Trash/Current/test2 myKey \n\n ")
    // .matches());

    // String input = "CallQueueLength";
    //
    // System.out.println(
    // Pattern.matches("CallQueueLength*|Rpc*", input));
    //
    // System.out.println(Pattern.matches("CallQueueLength*|Rpc*", "rpc"));
    //
    // System.out.println(Pattern.matches("CallQueueLength*|Rpc*", "Rpc"));

    
    // System.out.println(Pattern.matches("[0-9x]*", "12121z"));

//    System.out
//        .println("\\/user\\/root\\/snapshottest2\\/.snapshot\\/testweb05".replaceAll("\\\\", ""));
//
//    System.out.println(Pattern.matches(
//            "(\\{\\\"Path\\\"\\:\\\"/tmp/tmp-snap-test/.snapshot/s)(\\d{8})(-)(\\d{6})(\\.)(\\d{3})(\\\"\\})",
//            "{\"Path\":\"/tmp/tmp-snap-test/.snapshot/s20130412-151029.033\"}"));

//    String regex = ".*AsyncProcess.*attempt=\\d*/35.*succeeded.*";
//
//    System.out.println(Pattern.matches(regex,
//        "18/05/10 17:53:38 INFO client.AsyncProcess: #27421, table=tcon:tc_message_raw, attempt=14/35 succeeded on bdgtr016d05h2p.nam.nsroot.net,60020,1524960215836, tracking started Thu May 10 17:52:09 EDT 2018"));

    System.out.println("6521282401SA20150602000005/Stmt_txn:TXN_VAL_DT/1470423729334/Put/vlen=8/seqid=310058106".split("/")[0]);


  }

}
