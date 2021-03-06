import java.util.*;
import java.io.*;

public class Merge{

// got help from geena, oliver and alex during open house

  public static void main(String[]args){
    System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
    int[]MAX_LIST = {1000000000,500,10};
    for(int MAX : MAX_LIST){
      for(int size = 31250; size < 2000001; size*=2){
        long qtime=0;
        long btime=0;
        //average of 5 sorts.
        for(int trial = 0 ; trial <=5; trial++){
          int []data1 = new int[size];
          int []data2 = new int[size];
          for(int i = 0; i < data1.length; i++){
            data1[i] = (int)(Math.random()*MAX);
            data2[i] = data1[i];
          }
          long t1,t2;
          t1 = System.currentTimeMillis();
          mergesort(data2);
          t2 = System.currentTimeMillis();
          qtime += t2 - t1;
          t1 = System.currentTimeMillis();
          Arrays.sort(data1);
          t2 = System.currentTimeMillis();
          btime+= t2 - t1;
          if(!Arrays.equals(data1,data2)){
            System.out.println("FAIL TO SORT!");
            System.exit(0);
          }
        }
        System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
      }
      System.out.println();
    }
  }

  public static void mergesort(int[] data){
    int[] array = new int[data.length];
    for(int ind = 0; ind < array.length; ind++){
      array[ind]= data[ind];
    }
    if( array.length < 50){ // range that works well 45-55
      insertionSort(data);
    }
    else{
      mergesort(data, array, 0, data.length - 1);
    }
  }

  public static void mergesort(int[]data, int[] data2, int low, int high){
    if(low >= high){
      return;
    }
    int pivot = ((high - low) / 2) + low;// add low to shift // finds center (similar to optimized quick)

    mergesort(data2, data, low, pivot); //mergesort left side

    mergesort(data2, data, pivot+1, high); //mergesort right side

    glue(data, data2, pivot, low, high); //combine both merges
  }

  public static void glue (int[] data, int[] data2, int pivot, int low, int high){
    int leftInd = 0;
    int rightInd = 0;
    while(leftInd < pivot - low + 1 && rightInd < high - pivot){
      int index = leftInd + low;
      if(data2[index] < data2[rightInd + pivot + 1]){
        data[index + rightInd] = data2[index];
        leftInd++;
      }
      else{
        data[index + rightInd] = data2[rightInd + pivot + 1];
        rightInd++;
      }
    }
    while(leftInd < pivot - low + 1){
      data[low + leftInd + rightInd] = data2[low + leftInd];
      leftInd++;
      }
    while(rightInd < high - pivot){
      data[low + leftInd + rightInd] = data2[rightInd + pivot + 1];
      rightInd++;
    }
}

public static String toString(int[] sorted) {
   String result = "";
   for (int x = 0; x < sorted.length; x++) {
     result += x + " ";
   }
   return result;
 }

// Pseudo code
/*mergesort(data,lo,high):
if lo >= high :
return
mergesort left side
mergesort right side
merge */

public static void insertionSort(int[] data){
  for (int ind = 1; ind < data.length; ind++){
    int current = data[ind];
    int counter = ind;
    while(counter > 0 && data[counter - 1] > current){
      data[counter] = data[counter - 1];
      counter --;
    }
    data[counter] = current;
  }
}

}
