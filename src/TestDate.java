import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class TestDate {

  public static void main(String[] args) throws UnknownHostException, ParseException {
		
    // Long dtMillis = Long.parseLong(args[0]);

    // BigInteger bigInt = new BigInteger("22778251");
    //
    // Date dt = new Date(bigInt.longValue());
    //
    // System.out.println(dt);
    //
    // Timestamp ts = new Timestamp(bigInt.longValue());
    //
    // System.out.println(ts);
    //
    //

    // for (int i = 0; i < 5; i++) {
    // if ((i % 2) == 0) continue;
    // System.out.println(i);
    // }

    // Integer[] ints = { 15, 16, 22, 26, 27, 28, 29, 50, 51, 52 };
    //
    // List<Integer> list = Arrays.asList(ints);
    //
    // try {
    // FileInputStream fis = new FileInputStream("/Users/wchevreuil/Downloads/cust");
    // BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
    // String line = reader.readLine();
    // reader.close();
    // String[] columns = line.split("\\|");
    // for (int i = 0; i < columns.length; i++) {
    // if (list.contains(Integer.valueOf(i))) {
    // System.out.println(i + " :" + columns[i]);
    // if (!columns[i].equals("\\N")) {
    // Date date = Date.valueOf(columns[i]);
    // System.out.println(date);
    // }
    // }
    // }
    // } catch (Exception e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }

    // Date dt = new Date(1429604954641L + 579065045);
    // System.out.println(dt);
    // InetAddress addr = InetAddress.getLocalHost();
    // System.out.println(String.format("IP:%s hostname:%s canonicalName:%s", addr.getHostAddress(),
    // // The
    // // "default"
    // // IP
    // // address
    // addr.getHostName(), // The hostname (from gethostname())
    // addr.getCanonicalHostName() // The canonicalized hostname (from resolver)
    // ));
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS Z");
     Date dt = sdf.parse("2018-01-01 00:00:00,000 EST");
     System.out.println("Date: " + dt + " , millis: " + dt.getTime());

     dt = new Date(1535364960641L);
     System.out.println(dt);
     dt = new Date(1535364921356L);
     System.out.println(dt);
    //
    // dt = new Date(1443240860662L);
    // System.out.println(dt);
    // dt = new Date(1443602299913L);
    // System.out.println(dt);
    //
//    Date dt = new Date(1511832783723L);
//    System.out.println("parent assignment replica 0: " + dt);
//    dt = new Date(1511832786060L);
//    System.out.println("parent assignment replica 1: " + dt);
//    dt = new Date(1509380186570L);
//    System.out.println("slipt time for daughter A: " + dt);
//    dt = new Date(1509380186570L);
//    System.out.println("split time for daughter B: " + dt);
//    dt = new Date(1512063978349L);
//    System.out.println("assignment time for daughter A replica 0: " + dt);
//    dt = new Date(1511832785251L);
//    System.out.println("assignment time for daughter A replica 1: " + dt);
//    dt = new Date(1511832782928L);
//    System.out.println("assignment time for daughter B replica 0: " + dt);
//    dt = new Date(1511832791881L);
//    System.out.println("assignment time for daughter B replica 1: " + dt);
//
//
//    dt = new Date(1518892944551L);
//    System.out.println(dt);

//    try{
//      throw new IllegalAccessException("test");
//    }catch(Exception e){
//      System.out.println(e.toString());
//    }
//
    // System.out.println(07 ^ 07);

    // String strDate = "Fri Feb 24 16:30:11 PHT 2017";
    // sdf = new SimpleDateFormat("EEE MMM dd hh:mm:ss z yyyy");
    //
    // System.out.println(sdf.parse(strDate));
    //
    // System.out.println((new SimpleDateFormat("dd/MM/yyyy hh:mm:ss")).parse("25/02/2017
    // 00:00:00"));

//    String stdt = "2017-08-29T08:25:43.000Z";
//
//    sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
//    System.out.println(sdf.parse(stdt));

    System.out.println(TestDate.class);
    System.out.println(TestDate.HConnectionImplementation.class);

  }


  private static class HConnectionImplementation {

  }


}
