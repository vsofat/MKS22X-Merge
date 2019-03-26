import java.util.*;
import java.io.*;

public class Merge{

  public static void mergesort(int[] data){
  int[] array = new int[data.length];
  for(int ind = 0; ind < array.length; ind++){
    array[ind]= data[ind];
  }
  if( array.length < 50){
    insertionSort(array);
  }
  else{
    mergesort(data, array, 0, data.length - 1);

  }
  }

  public static void mergesort(int[]data, int[] data2, int low, int high){
  if(low >= high){
     return;
   }
   int pivot = ((high - low) / 2) + low; // finds center (similar to optimized quick)

   new int[] leftSide = mergesort(data2, data, low, pivot); //mergesort left side
   new int[] rightSide = mergesort(data2, data, pivot+1, high); //mergesort right side

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
    }}

    // Pseudo code
    /*mergesort(data,lo,hi):
    if lo >= hi :
      return
    mergesort left side
    mergesort right side
    merge */

    public static void insertionSort(int[] data){
    for (int x = 1; x < data.length; x++){
      int current = data[x];
      int counter = x;
      while(counter > 0 && data[counter - 1] > current){
        data[counter] = data[counter - 1];
        counter --;
      }
      data[counter] = current;
    }
  }

  public static void swap(int[] ary, int one, int two){
   int data2 = ary[one];
   ary[one] = ary[two];
   ary[two] = data2;
 }



}
