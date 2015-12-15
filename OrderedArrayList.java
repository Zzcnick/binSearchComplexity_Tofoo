/* Team Tofoo - Zicheng Zhen, Adam McKoy, Matthew So
   APCS1 pd10
   HW47 -- Halfling Time Trials / Time Complexity of binSearch
   2015-12-14 */

/*============================================
  class OrderedArrayList
  Wrapper class for ArrayList.
  Imposes the restriction that stored items 
  must remain sorted in ascending order
  ============================================*/

//ArrayList's implementation is in the java.util package
import java.util.ArrayList;

public class OrderedArrayList {

    // instance of class ArrayList, holding objects of type Comparable 
    // (ie, instances of a class that implements interface Comparable)
    private ArrayList<Comparable> _data;


    // default constructor initializes instance variable _data
    public OrderedArrayList() {
	_data = new ArrayList<Comparable>();
    }

    // toString : returns String representation of this ArrayList
    public String toString() {
	return _data.toString();
    }

    // remove : removes element at an index of the ArrayList
    // precond : int index - index to remove
    public Comparable remove( int index ) {
	return _data.remove(index);
    }

    // size : returns the size of the ArrayList
    public int size() {
	return _data.size();
    }

    // get : returns Comparable at an index of the ArrayList
    // precond : int index - index to return
    public Comparable get( int index ) {
	return _data.get(index);
    }

    // addLinear takes as input any comparable object 
    // (i.e., any object of a class implementing interface Comparable)
    // inserts newVal at the appropriate index
    // maintains ascending order of elements
    // uses a linear search to find appropriate index
    public void addLinear( Comparable newVal ) {
	int i = 0;
	while (i < _data.size()) {
	    if (_data.get(i).compareTo(newVal) > 0) {
		break;
	    }
	    i++;
	}
	_data.add(i, newVal);
    }

    // addBinary takes as input any comparable object
    // inserts newVal at appropriate index using binsary search
    public void addBinary( Comparable newVal ) {
	int min = 0;        // Lowest index.
	int max = size(); // Highest index.
	while (max != min) {
	    int middle = (min + max)/2;
	    boolean greater = newVal.compareTo(_data.get(middle)) > 0;
	    if (greater) {
		min = middle + 1; // +1 to prevent infinite looping
	    } else {
		max = middle;
	    }
	}
	_data.add(min, newVal);
    }
    
    // main method solely for testing purposes
    public static void main( String[] args ) {


	OrderedArrayList Franz = new OrderedArrayList();

	System.out.println("\nValues to add via addLinear() calls:");

	// testing linear search
	for( int i = 0; i < 15; i++ ) {
	    int valToAdd = (int)( 50 * Math.random() );
	    System.out.print( valToAdd );
	    Franz.addLinear( valToAdd );
	    System.out.println("\t"+Franz);
	}
	System.out.println("\nafter population via addLinear() calls:");
	System.out.println( Franz );
	System.out.println();
	// ---------------------------------------------
	System.out.println("\nValues to add via addBinary() calls:");
	OrderedArrayList Oof = new OrderedArrayList();
	// testing linear search
	for( int i = 0; i < 15; i++ ) {
	    int valToAdd = (int)( (25 * Math.random()) * (25 * Math.random()) );
	    System.out.print( valToAdd );
	    Oof.addBinary( valToAdd );
	    System.out.println("\t"+Oof);
	}
	System.out.println("\nafter population via addBinary() calls:");
	System.out.println( Oof );
	System.out.println();
	/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }

}//end class OrderedArrayList
 
