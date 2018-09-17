import java.util.HashMap;
import java.util.Map;

public class ImageHotelStore2 {

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    ImageHotelStore2 store = new ImageHotelStore2();

    byte[] imgA = new byte[10];

    byte[] imgB = new byte[10];
    //
    // System.out.println("imgA " + imgA);
    //
    // System.out.println("imgB " + imgB);
    //
    // store.storeImage("Hotel_A", imgA);
    // System.out.println("after first insert:");
    // System.out.println(store.imgMap);
    // System.out.println(store.lblMap);
    //
    // store.storeImage("Hotel a", imgA);
    // System.out.println("after second insert:");
    // System.out.println(store.imgMap);
    // System.out.println(store.lblMap);
    //
    // store.storeImage("Hotel_A", imgB);
    // System.out.println("after third insert:");
    // System.out.println(store.imgMap);
    // System.out.println(store.lblMap);
    //
    // store.storeImage("Hotel a", imgB);
    // System.out.println("after fourth insert:");
    // System.out.println(store.imgMap);
    // System.out.println(store.lblMap);
    //
    // System.out.println(store.size());
    //
    // System.out.println(store.fetchImage("Hotel a"));

    System.out.println("------------------------------------");

    System.out.println("imgA " + imgA);

    System.out.println("imgB " + imgB);

    store.storeImage("Hotel_A", imgA);
    System.out.println("after first insert:");
    System.out.println(store.imgMap);
    System.out.println(store.lblMap);

    store.storeImage("Hotel a", imgA);
    System.out.println("after second insert:");
    System.out.println(store.imgMap);
    System.out.println(store.lblMap);

    store.storeImage("Hotel B", imgB);
    System.out.println("after third insert:");
    System.out.println(store.imgMap);
    System.out.println(store.lblMap);

    System.out.println(store.size());

    System.out.println(store.fetchImage("Hotel_A"));
    System.out.println(store.fetchImage("Hotel a"));
    System.out.println(store.fetchImage("Hotel B"));

    System.out.println(store.imgMap);

  }

  private Map<byte[], Integer> imgMap = new HashMap<byte[], Integer>();

  private Map<String, byte[]> lblMap = new HashMap<String, byte[]>();

  public void storeImage(String id, byte[] img) {

    Integer count = imgMap.get(img);

    // the img is new
    if (count == null) {

      count = 1;

      byte[] ref = lblMap.get(id);
      // the id is also new
      if (ref == null) {

        imgMap.put(img, count);

        lblMap.put(id, img);
        // the img doesn't exist, but there's already an id pointing to another img
      } else {

        Integer oldImgCount = imgMap.get(ref);

        oldImgCount = oldImgCount - 1;
        // the img previous pointed by this id now is not referred by any id. Need to be deleted
        if (oldImgCount == 0) {

          imgMap.remove(ref);

        } else {
          // the update the amount of ids still pointing to the img previously referred by this id
          imgMap.put(ref, oldImgCount);

        }

        imgMap.put(img, count);

        lblMap.put(id, img);

      }

    } else {
      // the img is already referred by other labels
      count = count + 1;

      imgMap.put(img, count);

      byte[] ref = lblMap.get(id);

      if (ref == null) {

        lblMap.put(id, img);

      } else {

        Integer oldImgCount = imgMap.get(ref);

        oldImgCount = oldImgCount - 1;

        // the img previous pointed by this id now is not referred by any id. Need to be deleted
        if (oldImgCount == 0) {

          imgMap.remove(ref);

        } else {
          // the update the amount of ids still pointing to the img previously referred by this id
          imgMap.put(ref, oldImgCount);

        }

        lblMap.put(id, img);

      }

    }

  }

  public byte[] fetchImage(String id) {
    return lblMap.get(id);
  }

  public int size() {
    return imgMap.size();
  }

  class ImgRef {
    String label;
    byte[] ref;
  }

}
