public class Radix{

  //get nth digit of an int, where 0 is the ones column, 1 is the tens column etc.
  public static int nth(int n, int col){
    return n - n%((col+1)*10);
  }

  //return the number of digits in n.
  public static int length(int n){}

  //Merge all of the linked lists in the bucket array into your original linked list. The original may have elements, and those should be kept.
  public static void merge(MyLinkedList original,MyLinkedList[]buckets){}
}
