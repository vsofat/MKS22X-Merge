import java.util.*;
import java.io.*;

public class Merge{

  public static void mergesort(int[] data){
  int[] info = data;
  mergesort(data, info, 0, data.length); // merge both arrays from start to end
  }

  public static void mergesort(int[]data, int[] data2, int low, int high){
  if(low >= high){
     return;
   }
   int pivot = ((high - low) / 2) ; // finds center (similar to optimized quick)
   mergesort(data, low, pivot); //mergesort left side
   mergesort(data, pivot, high); //mergesort right side

   // missing merge part

    // Pseudo code
    /*mergesort(data,lo,hi):
    if lo >= hi :
      return
    mergesort left side
    mergesort right side
    merge */


  }

  public static void swap(int[] ary, int one, int two){
   int temp = ary[one];
   ary[one] = ary[two];
   ary[two] = temp;
 }



}
