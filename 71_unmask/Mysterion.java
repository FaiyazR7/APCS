import java.util.Arrays;

// Flying Sullen Actors -1: Faiyaz Rafee, Salaj Rijal, **Alif Rahman**
// APCS pd8
// HW71 -- Reading for intent, tracing for VICTORY
// 2022-03-07
// time spent: .2 hrs

/***
 * SKEELTON for
 * class Mysterion
 * tests preliminary hypotheses re: utility of mystery algo
 * 
 * <h1>It's a Bird, It's a Plane! It's.... MYSTERION</h1>
 * The Mysterion method ... <YOUR TRIO'S DESCRIPTION HERE> 
 * <p>
 * <b>Note:</b> BLAH blah blah, yakkety schmakketty...
 * @author  Trey Parker, Matt Stone
 * @version 3.1415926535897932384626433
 * @since   2022-03-07m 
 *
 * algo as pseudocode:
 * ------------------------------
 *     v = arr[c]
 *     swap arr[c], arr[b]   
 *     s = a
 *     for i in [a..b-1]
 *         if arr[i] < v
 *             swap arr[s], arr[i]
 *             s+=1
 *     swap arr[b], arr[s] 
 * 
 * DISCO:
 * v is a temporary holding variable to store what is in arr @ pos c
 * a is the starting bound, b is the end bound (inclusive)
 * s is the current swapping positoin
 *  
 * QCC:
 * why does it matter?
 * what does mysterion return?
 * 
 * 
 * q0: What does it do?
 * a0: assuming v is what was the original value on pos c, everything less than v will be on the left
 * and everything greater than v will be on the right - Faiyaz 
 * 
 * q1: O(?)
 * a1: n because for-loop - Alif
 * 
 ***/


public class Mysterion 
{    
  //--------------v  HELPER METHODS  v--------------
  //swap values at indices x, y in array o
  public static void swap( int x, int y, int[] o )
  {
    int tmp = o[x];
    o[x] = o[y];
    o[y] = tmp;
  }

  //print input array 
  public static void printArr( int[] a )
  {
    for ( int o : a )
      System.out.print( o + " " );
    System.out.println();
  }

  //shuffle elements of input array
  public static void shuffle( int[] d )
  {
    int tmp;
    int swapPos;
    for( int i = 0; i < d.length; i++ ) {
      tmp = d[i];
      swapPos = i + (int) ( (d.length - i) * Math.random() );
      swap( i, swapPos, d );
    }
  }
    
  //return int array of size s, with each element fr range [0,maxVal)
  public static int[] buildArray( int s, int maxVal )
  {
    int[] retArr = new int[s];
    for( int i = 0; i < retArr.length; i++ )
      retArr[i] = (int)( maxVal * Math.random() );
    return retArr;
  }
  //--------------^  HELPER METHODS  ^--------------


  /**
   * int mysterion(int[],int,int,int)
   * DESCRIP
   * 
   * @param arr
   * @param a
   * @param b
   * @param c
   * @return int 
   *
   */
  public static int mysterion( int[] arr, int a, int b, int c)
  {
 /*
 *     v = arr[c]
 *     swap arr[c], arr[b]   
 *     s = a
 *     for i in [a..b-1]
 *         if arr[i] < v
 *             swap arr[s], arr[i]
 *             s+=1
 *     swap arr[b], arr[s] 
 */
    int v = arr[c];
    swap(c, b , arr);
    int s = a;
    for (int i = a; i < b; i++ ) {
      System.out.println( i + Arrays.toString(arr) );
      if (arr[i] < v) {
        swap(s, i, arr);
        s+=1;
      }
    }
    swap(s, b, arr);
    return 0;
  }//end mysterion


  //main method for testing
  public static void main( String[] args )
  {
    
    //init test arrays of magic numbers
    int[] arr1 = {8,21,17,69,343};
    int[] arr3 = {1,28,33,4982,37};
    int[] arr4 = {5,4,17,9000,6};
    int[] arr5 = {3,0,16,599,1024};
    
    
    // run mysterion on each array,
    // holding a & b fixed, varying c...
    for( int testC = 0; testC < 5; testC++ ) {
      System.out.println("arr1: ");
      printArr(arr1);
      mysterion(arr1,0,4,testC);
      System.out.println("after mysterion w/ a=0,b=4,c=" 
      + testC +"...");
      printArr(arr1);
      System.out.println("-----------------------");
      /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
      
      System.out.println("arr3:");
      printArr(arr3);
      mysterion(arr3,0,4,testC);
      System.out.println("after mysterion w/ a=0,b=4,c=" 
      + testC +"...");
      printArr(arr3);
      System.out.println("-----------------------");
      
      System.out.println("arr4:");
      printArr(arr4);
      mysterion(arr4,0,4,testC);
      System.out.println("after mysterion w/ a=0,b=4,c=" 
      + testC +"...");
      printArr(arr4);
      System.out.println("-----------------------");
      
      System.out.println("arr5:");
      printArr(arr5);
      mysterion(arr5,0,4,testC);
      System.out.println("after mysterion w/ a=0,b=4,c=" 
      + testC +"...");
      printArr(arr5);
      System.out.println("-----------------------");
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }

    }//end main

  }//end class Mysterion
  
