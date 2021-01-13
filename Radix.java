public class Radix{

  //get nth digit of an int, where 0 is the ones column, 1 is the tens column etc.
  public static int nth(int n, int col){
    if (n<0){
      n = n*-1;
    }
    return (int) (n / Math.pow(10, col)) % 10;
  }

  //return the number of digits in n.
  public static int length(int n){
    if (n<0){
      n = n*-1;
    }
    String out = String.valueOf(n);
    return out.length();
  }

  //Merge all of the linked lists in the bucket array into your original linked list. The original may have elements, and those should be kept.
  public static void merge(SortableLinkedList original, SortableLinkedList[]buckets){
    for (int i = 0; i<10;i++){
      original.extend(buckets[i]);
    }
  }

  public static void radixSortSimple(SortableLinkedList data){
    int maxLength = 0;
    SortableLinkedList temp = new SortableLinkedList();
    while (data.size() != 0) {
      int curr = data.remove(0);
      int dataLength = Radix.length(curr);
      temp.add(curr);
      if (dataLength > maxLength){
        maxLength = dataLength;
      }
    }
    data.extend(temp);

    for (int i=0;i<maxLength;i++){
      SortableLinkedList[] buckets = new SortableLinkedList[10];
      for (int y = 0; y< buckets.length; y++){
        SortableLinkedList b = new SortableLinkedList();
        buckets[y] = b;
      }

      while (data.size() != 0){
        int curr = data.remove(0);
        int digit = nth(curr, i);
        buckets[digit].add(curr);
      }
      SortableLinkedList sorted = new SortableLinkedList();
      Radix.merge(sorted, buckets);

      //SortableLinkedList temp = new SortableLinkedList();
      //temp.extend(data);

      data.extend(sorted);
    }
  }


  public static void radixSort(SortableLinkedList data){
    SortableLinkedList pos = new SortableLinkedList();
    SortableLinkedList neg = new SortableLinkedList();
    SortableLinkedList zeros = new SortableLinkedList();

  }

}
