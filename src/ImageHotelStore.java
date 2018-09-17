import java.util.HashMap;
import java.util.Map;

public class ImageHotelStore {

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    ImageHotelStore store = new ImageHotelStore();

    byte[] imgA = new byte[10];

    byte[] imgB = new byte[10];

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

    store.storeImage("Hotel_A", imgB);
    System.out.println("after third insert:");
    System.out.println(store.imgMap);
    System.out.println(store.lblMap);

    store.storeImage("Hotel a", imgB);
    System.out.println("after fourth insert:");
    System.out.println(store.imgMap);
    System.out.println(store.lblMap);

    System.out.println(store.size());

    System.out.println(store.fetchImage("Hotel a"));
  }

  private Map<byte[], Integer> imgMap = new HashMap<byte[], Integer>();

  private Map<String, ImgRef> lblMap = new HashMap<String, ImageHotelStore.ImgRef>();

  public void storeImage(String id, byte[] img) {

    Integer count = imgMap.get(img);

    // the img is new
    if (count == null) {

      count = 1;

      ImgRef ref = lblMap.get(id);
      // the id is also new
      if (ref == null) {

        ref = new ImgRef();

        ref.label = id;

        ref.ref = img;

        imgMap.put(img, count);

        lblMap.put(id, ref);
        // the img doesn't exist, but there's already an id pointing to another img
      } else {

        Integer oldImgCount = imgMap.get(ref.ref);

        oldImgCount = oldImgCount - 1;
        // the img previous pointed by this id now is not referred by any id. Need to be deleted
        if (oldImgCount == 0) {

          imgMap.remove(ref.ref);

        } else {
          // the update the amount of ids still pointing to the img previously referred by this id
          imgMap.put(ref.ref, oldImgCount);

        }

        imgMap.put(img, count);

        ImgRef newRef = new ImgRef();

        newRef.label = id;

        newRef.ref = img;

        lblMap.put(id, newRef);

      }

    } else {
      // the img is already referred by other labels
      count = count + 1;

      imgMap.put(img, count);

      ImgRef ref = lblMap.get(id);

      if (ref == null) {

        ref = new ImgRef();

        ref.label = id;

        ref.ref = img;

        lblMap.put(id, ref);

      } else {

        Integer oldImgCount = imgMap.get(ref.ref);

        oldImgCount = oldImgCount - 1;

        // the img previous pointed by this id now is not referred by any id. Need to be deleted
        if (oldImgCount == 0) {

          imgMap.remove(ref.ref);

        } else {
          // the update the amount of ids still pointing to the img previously referred by this id
          imgMap.put(ref.ref, oldImgCount);

        }

        ImgRef newRef = new ImgRef();

        newRef.label = id;

        newRef.ref = img;

        lblMap.put(id, newRef);

      }

    }

  }

  public byte[] fetchImage(String id) {
    return lblMap.get(id).ref;
  }

  public int size() {
    return imgMap.size();
  }

  class ImgRef {
    String label;
    byte[] ref;
  }

}
