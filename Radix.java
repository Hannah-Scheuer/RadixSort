public class Radix{

  //get nth digit of an int, where 0 is the ones column, 1 is the tens column etc.
  public static int nth(int n, int col){
    return (int) (n / Math.pow(10, col)) % 10;
  }

  //return the number of digits in n.
  public static int length(int n){
    if (n<0){
      n = n*-1;
    }
    return (int)(Math.log10(n)+1);
  }

  //Merge all of the linked lists in the bucket array into your original linked list. The original may have elements, and those should be kept.
  public static void merge(SortableLinkedList original, SortableLinkedList[]buckets){
    for (int i = 0; i<10;i++){
      original.extend(buckets[i]);
    }
  }

  public static void radixSortSimple(SortableLinkedList data){
    int maxLength = 0;
    for (int i = 0; i < data.size(); i++) {
      int dataLength = Radix.length(data.get(i));
      if (dataLength > maxLength){
      maxLength = dataLength;
      }
    }

    for (int i=0;i<maxLength;i++){
      SortableLinkedList[] buckets = new SortableLinkedList[10];
      for (int y = 0; y< buckets.length; y++){
        SortableLinkedList b = new SortableLinkedList();
        buckets[y] = b;
      }
      for (int j = 0; j < data.size(); j++){
        int digit = nth(data.get(j), i);
        buckets[digit].add(j);
      }
      SortableLinkedList sorted = new SortableLinkedList();
      Radix.merge(sorted, buckets);

      SortableLinkedList temp = new SortableLinkedList();
      temp.extend(data);

      data.extend(sorted);
    }
  }


  public static void radixSort(SortableLinkedList data){

  }

}
