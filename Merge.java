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
   int pivot = ((high - low) / 2) + low; // finds center (similar to optimized quick)

   // mergesort(data, low, pivot); //mergesort left side
   //  mergesort(data, pivot, high); //mergesort right side

   int leftInd = low;
   int rightInd = pivot;

   for(int ind = 0; ind < data.length; ind++){
      if(leftInd < pivot && rightInd < high){ //there're numbers still left in each side
        if(data[leftInd] <= data[rightInd]){
          data2[ind] = data[leftInd];
          leftInd++;
        }
        else{
          data2[ind] = data[rightInd];
          rightInd++;
        }
      }
      else{
        if(leftInd < pivot){
          data2[ind] = data[leftInd];
          leftInd++;
        }
        else{
          data2[ind] = data[rightInd];
          rightInd++;
        }
      }
    }

    // Pseudo code
    /*mergesort(data,lo,hi):
    if lo >= hi :
      return
    mergesort left side
    mergesort right side
    merge */


  }

  public static void swap(int[] ary, int one, int two){
   int data2 = ary[one];
   ary[one] = ary[two];
   ary[two] = data2;
 }



}
