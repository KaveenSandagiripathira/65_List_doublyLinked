/**
  Represent a list, implemented in a chain of nodes
 */

public class List_inChainOfNodes{
    private Node mainSentinel;

     
    /**
      Construct an empty list
     */
    public List_inChainOfNodes() {
        mainSentinel = new Node( null );
		mainSentinel.setNextNode(mainSentinel); 
		//Seperate for a reason
		mainSentinel.setPreviousNode(mainSentinel);
		}

    /**
      @return the number of elements in this list
     */
    public int size() {
        // recursive approach seems more perspicuous
        return size( mainSentinel);
    }

    // recursively-called helper
    private int size( Node startingAt) {
        Node next = startingAt.getNextNode();
        if( next == mainSentinel) return 0; //EXCEPTION IS MAIN SENTINEL
        else return 1+ size( next);
    }
	
    /**
      Demo use of links to previous Nodes.

      @return a string representation of this list,
              iterating through the list
              from tail to head.
      format, using ` as separator
          [element0`element1`element2`]
     */
    public String toString() {
        String stringRep = "tail-first [";

        for( Node node = mainSentinel.getPreviousNode()
			;node != mainSentinel
			;node = node.getPreviousNode()
           )
            stringRep += node.getCargo() + "`";
        return stringRep + "]";
    }

    /**
      Append @value to the head of this list.

      @return true, in keeping with conventions yet to be discussed
     */
     public boolean addAsHead( Object val) {
		 Node newNode = new Node (val,mainSentinel.getNextNode(),mainSentinel);
		 mainSentinel.setNextNode(newNode);
		 mainSentinel.setPreviousNode(getNode(size()-1));
		 return true;
     }


    /**
      @return a reference to the node before
              the node at @index
     */
    private Node getNodeBefore( int index) {
        /* iterate through the chain, up to the node
           that holds a reference to the desired node */
           
        Node node;
        int upTo;  // comma operator precludes declaration in FOR
        for( upTo = 0   , node = mainSentinel
           ; upTo < index
           ; upTo++     , node = node.getNextNode()
           )
           ;  // null loop body since all the action is in the FOR
        return node;
    }


    /**
      @return a reference to the node @index
     */
    private Node getNode( int index) {
        return getNodeBefore( index).getNextNode();
    }

    // accessors
    /**
      @return element @index from this list
      precondition: @index is within the bounds of the array.
          (Having warned the user about this precondition,
           you should NOT complicate your code to check
           whether user violated the condition.)
     */
    public Object get( int index ) {
        return getNode( index).getCargo();
    }


    /**
      Set value at @index to @newValue

      @return old value at @index
      @precondition: @index is within the bounds of this list.
     */
    public Object set( int index, Object newValue ) {
        return getNode( index).setCargo( newValue);
    }


    /**
      Insert @value at position @index in this list.

      Shift the element currently at that position (if any)
      and any subsequent elements to the right
      (that is, increase the index associated with each).
     */
    public boolean add( int index, Object value) {
		Node before = getNodeBefore(index);
		Node after  = before.getNextNode();
		Node newNode = new Node( value, after, before);
		before.setNextNode(newNode);
		after.setPreviousNode(newNode);
        return true;
    }


     /**
      Remove the element at position @index in this list.

      Shift any subsequent elements to the left (that is,
      decrease the index associated with each).

      @return the value that was removed from the list
     */
    public Object remove( int index) {
        Node before = getNodeBefore( index);
        Node ax = before.getNextNode();
		Node after = ax.getNextNode();
        Object saveForReturn = ax.getCargo();
		before.setNextNode(after);
		after.setPreviousNode(before);
        return saveForReturn;
    }
}