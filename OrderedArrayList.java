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
    // inserts newVal at appropriate index using binary search
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

    // linSearch takes comparable object, returns first index of occurrence
    // else, if not in array, return -1
    public int linSearch( Comparable val ) {
	int size = size(); // Should be more efficient like this, I think.
	for (int i = 0; i < size; i++) {
	    if (_data.get(i).compareTo(val) == 0)
		return i;
	}
	return -1;
    }

    // binSearch takes comparable object, returns first index of occurrence
    // else, if not in array, return -1
    public int binSearch( Comparable val ) {
	int min = 0;
	int max = size();
	int smallestIndex = -1; // To track first occurrence
	while (min != max) {
	    int middle = (min + max)/2;
	    int compare = val.compareTo(_data.get(middle));
	    if (compare > 0) {
		min = middle + 1;
	    } else {
		if (compare == 0)
		    smallestIndex = middle;
		max = middle;
	    }
	}
	return smallestIndex;
    }
    
    // main method solely for testing purposes
    public static void main( String[] args ) {
	/*
	OrderedArrayList Franz = new OrderedArrayList();
	for (int i = 0; i < 20; i++) {
	    Franz.addBinary((int)(100*Math.random()));
	}
	System.out.println("Test Array:\n" + Franz);
	for (int i = 0; i < 100; i++) {
	    int linPos = Franz.linSearch(i);
	    int binPos = Franz.binSearch(i);
	    if (linPos != -1)
		System.out.println("LinSearch: " + i + " at position " + linPos);
	    if (binPos != -1)
		System.out.println("BinSearch: " + i + " at position " + binPos);
	}
	*/

	// Heavy-Duty Testing for Time Complexity
	OrderedArrayList Test = new OrderedArrayList();
	for (int i = 0; i < 5000; i++) {
	    Test.addBinary((int)(5000*Math.random())); // Autogen 5000 int array
	}
	System.out.println("Beginning of linSearch Testing: 100000 Iterations");
	long linTime_s = System.currentTimeMillis();
	for (int i = 0; i < 20; i++) {
	    for (int j = 0; j < 5000; j++) {
		Test.linSearch(j);
	    }
	}
	long linTime_e = System.currentTimeMillis();
	double linTotal = (linTime_e - linTime_s) / 1000.0;
	System.out.println("Time Taken: " + linTotal + " seconds");
	
	System.out.println("Beginning of binSearch Testing: 100000 Iterations");
	long binTime_s = System.currentTimeMillis();
	for (int i = 0; i < 20; i++) {
	    for (int j = 0; j < 5000; j++) {
		Test.binSearch(j);
	    }
	}
	long binTime_e = System.currentTimeMillis();
	double binTotal = (binTime_e - binTime_s) / 1000.0;
	System.out.println("Time Taken: " + binTotal + " seconds");
	// END */
    }

}//end class OrderedArrayList
 
