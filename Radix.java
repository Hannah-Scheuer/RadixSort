public class Radix{

  //get nth digit of an int, where 0 is the ones column, 1 is the tens column etc.
  public static int nth(int n, int col){
    return n - n%((col+1)*10);
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
      if (data.get(i).length() > maxLength){
      maxLength = data.get(i).length();
      }
    }

    for (int i=0;i<maxLength;i++){
      new SortableLinkedList [] buckets = new SortableLinkedList[10];
      for (int i = 0; i< buckets.length; i++){
        new SortableLinkedList b = new SortableLinkedList();
        buckets[i] = b;
      }
      for (int j = 0; j < data.size(); j++){
        int digit = nth(data.get(j), i);
        buckets[digit].add(j);
      }
      new SortableLinkedList sorted = new SortableLinkedList();
      Radix.merge(sorted, buckets);

      new SortableLinkedList temp = new SortableLinkedList();
      temp.extend(data);

      data.extend(sorted);
    }
  }

}
