// Blue Steaks - Max Schneider, Faiyaz Rafee, David Deng
// APCS1 pd7
// HW44 -- expanding SuperArray functionality, encapsulation
// 2021-12-08w

/***************************
 * class SuperArray version 2.0
 * (SKELETON)
 * Wrapper class for array. Facilitates
 * resizing
 * expansion
 * read/write capability on elements
 * adding an element to end of array
 * adding an element at specified index
 * removing an element at specified index
 Disco:
 *Importance of .this. Code did not work otherwise.
 *JAVA VISUALIZER!!!
 *the size() method is very helpful and needs to be utitlized anytime a we chnage the number of meaning ful values in the arrays
 QCCs:
 How much less inefficient is a deep copy?
 ***************************/

public class SuperArray
{

  private int[] _data;  //underlying container
  private int _size;    //number of elements in this SuperArray


  //default constructor – initializes 10-item array
  public SuperArray()
  {
    this._data = new int[10];
    this._size = 0;
  }


  //output SuperArray in [a,b,c] format
  public String toString()
  {
    this._size=size();
    String outVal = "[";
    for (int i = 0; i < this._size ; i++) {
	    if (i == this._size-1) {
		    outVal+=this._data[i];
	    } else {
		    outVal+=(this._data[i]+", ");
	    }

    }
    outVal+="]";
    return outVal;
  }


  //double capacity of SuperArray
  private void expand()
  {
    int[] newArray = new int[this._size * 2];
    for (int i = 0;i < this._size; i++) {
      newArray[i]=this._data[i];
    }
    this._data=newArray;
    this._size *=2;
  }


  //accessor -- return value at specified index
  public int get( int index )
  {
    return this._data[index];
  }


  //mutator -- set value at index to newVal,
  //           return old value at index
  public int set( int index, int newVal )
  {
    int answer = get(index);
    this._data[index]=newVal;
    return answer;
  }


  //adds an item after the last item
  public void add( int newVal )
  {
    if (this._size == this._data.length) {
      expand();
    }
    this._data[this._size]=newVal;
    this._size=this.size();
  }


  //inserts an item at index
  public void add( int index, int newVal )
  {
    if (this._size >= this._data.length) {
      expand();
    }
    for(int i = this._size; i>index;i--) {
      this._data[i]=this._data[i-1];
    }
    this._data[index]=newVal;
    this._size=this.size();
  }


  //removes the item at index
  //shifts elements left to fill in newly-empted slot
  public void remove( int index )
  {
    for(int i = index; i<this._size-1;i++) {
      this._data[i]=this._data[i+1];
    }
    this._data[this._size-1]=0;
    this._size=this.size();
  }


  //return number of meaningful items in _data
  public int size()
  {
    int answer = this._data.length;
    for (int i = this._data.length-1; this._data[i] == 0; i--) {
      answer--;
      if (i == 0) {
        return answer;
      }
    }
    return answer;
  }



  //main method for testing
  public static void main( String[] args )
  {
    SuperArray curtis = new SuperArray();
    System.out.println( "Printing empty SuperArray curtis..." );
    System.out.println( curtis );

    for( int i = 0; i < curtis._data.length; i++ ) {
    curtis.set( i, i * 2 );
    }

    System.out.println("Printing populated SuperArray curtis...");
    System.out.println(curtis);

    for( int i = 0; i < 3; i++ ) {
    curtis.expand();
    for( int b = 0; b < curtis._size; b++ ) {
    curtis.set( b, (int)(Math.random()*100) );
    }
    System.out.println("Printing expanded SuperArray curtis...");
    System.out.println(curtis);
    }

      SuperArray mayfield = new SuperArray();
      System.out.println("Printing empty SuperArray mayfield...");
      System.out.println(mayfield);

      mayfield.add(5);
      mayfield.add(4);
      mayfield.add(3);
      mayfield.add(2);
      mayfield.add(1);

      System.out.println("Printing populated SuperArray mayfield...");
      System.out.println(mayfield);

      mayfield.remove(3);
      System.out.println("Printing SuperArray mayfield post-remove...");
      System.out.println(mayfield);
      mayfield.remove(3);
      System.out.println("Printing SuperArray mayfield post-remove...");
      System.out.println(mayfield);

      mayfield.add(3,99);
      System.out.println("Printing SuperArray mayfield post-insert...");
      System.out.println(mayfield);
      mayfield.add(2,88);
      System.out.println("Printing SuperArray mayfield post-insert...");
      System.out.println(mayfield);
      mayfield.add(1,77);
      System.out.println("Printing SuperArray mayfield post-insert...");
      System.out.println(mayfield);
  }//end main()


}//end class
