/*
Flying SUllen Actors: Faiyaz Rafee, Salaj Rijal, Alif Rahman
APCS
HW 97 - BST - REMOVE????
2022-05-11
*/

import java.util.LinkedList;

public class BST
{

  //instance variables / attributes of a BST:
  TreeNode _root;

  /**
   * default constructor
   */
  BST()
  {
    _root = null;
  }


  /**
   * void insert( int )
   * Adds a new data element to tree.
   */
  public void insert( int newVal )
  {
    TreeNode newNode = new TreeNode( newVal );

    if ( _root == null ) {
      _root = newNode;
      return;
    }
    insert( _root, newNode );
  }
  //recursive helper for insert(int)
  public void insert( TreeNode stRoot, TreeNode newNode )
  {
    if ( newNode.getValue() < stRoot.getValue() ) {
      //if no left child, make newNode the left child
      if ( stRoot.getLeft() == null )
        stRoot.setLeft( newNode );
      else //recurse down left subtree
        insert( stRoot.getLeft(), newNode );
      return;
    }
    else { // new val >= curr, so look down right subtree
      //if no right child, make newNode the right child
      if ( stRoot.getRight() == null )
        stRoot.setRight( newNode );
      else //recurse down right subtree
        insert( stRoot.getRight(), newNode );
      return;
    }
  }//end insert()


  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //~~~~~~~~~~~~~v~~TRAVERSALS~~v~~~~~~~~~~~~~~~~~~~~~
  // each traversal should simply print to standard out
  // the nodes visited, in order

  //process root, recurse left, recurse right
  public void preOrderTrav()
  {
    preOrderTrav( _root );
  }
  public void preOrderTrav( TreeNode currNode )
  {
    if ( currNode == null )
      return;
    System.out.print( currNode.getValue() + " " );
    preOrderTrav( currNode.getLeft() );
    preOrderTrav( currNode.getRight() );
  }

  //recurse left, process root, recurse right
  public void inOrderTrav()
  {
    inOrderTrav( _root );
  }
  public void inOrderTrav( TreeNode currNode )
  {
    if ( currNode == null )
      return;
    inOrderTrav( currNode.getLeft() );
    System.out.print( currNode.getValue() + " " );
    inOrderTrav( currNode.getRight() );
  }

  //recurse left, recurse right, process root
  public void postOrderTrav()
  {
    postOrderTrav( _root );
  }
  public void postOrderTrav( TreeNode currNode )
  {
    if ( currNode == null )
      return;
    postOrderTrav( currNode.getLeft() );
    postOrderTrav( currNode.getRight() );
    System.out.print( currNode.getValue() + " "  );
  }

  public String inOrderTravStr( TreeNode currNode ) {
    String retStr = "";
    if ( currNode == null )
      return retStr;
    retStr += inOrderTravStr( currNode.getLeft() );
    retStr += " " + currNode.getValue();
    retStr += inOrderTravStr( currNode.getRight() );
    return retStr;
  }
  public String preOrderTravStr( TreeNode currNode ) {
    String retStr = "";
    if ( currNode == null )
      return retStr;
    retStr += " " + currNode.getValue();
    retStr += preOrderTravStr( currNode.getLeft() );
    retStr += preOrderTravStr( currNode.getRight() );
    return retStr;
  }
  public String postOrderTravStr( TreeNode currNode ) {
    String retStr = "";
    if ( currNode == null )
      return retStr;
    retStr += postOrderTravStr( currNode.getLeft() );
    retStr += postOrderTravStr( currNode.getRight() );
    retStr += " " + currNode.getValue();
    return retStr;
  }

  //~~~~~~~~~~~~~^~~TRAVERSALS~~^~~~~~~~~~~~~~~~~~~~~~
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  //~~~~~~~~~~~~~v~~MISC.HELPERS~~v~~~~~~~~~~~~~~~~~~~
  public boolean isLeaf( TreeNode node )
  {
    return ( node.getLeft() == null
             &&
             node.getRight() == null );
  }
  //~~~~~~~~~~~~~^~~MISC.HELPERS~~^~~~~~~~~~~~~~~~~~~~

  /**
   * TreeNode search(int)
   * returns pointer to node containing target,
   * or null if target not found
   */
  TreeNode search( int target )
  {
    return search( target, _root );
  }
  TreeNode search( int target, TreeNode currNode )
  {
    if ( currNode==null || currNode.getValue()==target )
      return currNode;
    else if ( target < currNode.getValue() )
      return search( target, currNode.getLeft() );
    else if ( target > currNode.getValue() )
      return search( target, currNode.getRight() );
    else
      return null; //to get past compiler
  }


  /**
   * int height()
   * returns height of this tree (length of longest leaf-to-root path)
   * eg: a 1-node tree has height 0
   */
  public int height()
  {
    return height( _root );
  }
  //recursive helper for height()
  public int height( TreeNode currNode )
  {
    if ( currNode==null ) //Q: Why cannot use .equals() ?
      return 0;
    if ( isLeaf(currNode) )
      return 0;
    else //height is 1 for this node + height of deepest subtree
      return 1 + Math.max( height(currNode.getLeft()),
                           height(currNode.getRight()) );
  }


  /**
   * int numLeaves()
   * returns number of leaves in tree
   */
  public int numLeaves()
  {
    return numLeaves( _root );
  }
  public int numLeaves( TreeNode currNode ) {
    int foo = 0;
    if ( currNode == null )
      return 0;
    foo += numLeaves( currNode.getLeft() );
    if ( isLeaf(currNode) )
      foo++;
    foo += numLeaves( currNode.getRight() );
    return foo;
  }

  public int numNodes(){
    return numNodes(_root);
  }

  public int numNodes( TreeNode cur ){

    if ( cur == null ){
      return 0;
    }
    return 1 + numNodes( cur.getLeft() ) + numNodes( cur.getRight() );

  }


  //taken from library temprrarily.... will be making my own soon
  public String toString(){
    LinkedList<TreeNode> q = new LinkedList<TreeNode>();
    q.add(_root);
    // +1 is needed if height method meets FDA requirements
    return toString(q,1,this.height() + 1);
}


String toString(LinkedList<TreeNode> printQueue,int layerNum,int height){
  if (height==0){return "";}
  int printLen = printQueue.size();
  int initialSpace = (int) Math.pow(2,height-layerNum)-1;
  String thisLayer = "";
  for (int sp = 0;sp<initialSpace;sp++)
      thisLayer+=" ";
  for (int i = 0; i<printLen;i++){
      TreeNode item = printQueue.removeFirst();
      if (item ==null){
          thisLayer+=" ";
          printQueue.addLast(null);
          printQueue.addLast(null);
      } else {
          thisLayer+=item.getValue();
          printQueue.addLast(item.getLeft());
          printQueue.addLast(item.getRight());
      }
      for (int sp = 0;sp<2*initialSpace+1;sp++)
          thisLayer+=" ";
  }
  if (layerNum==height){return thisLayer;}
  else {
      return thisLayer+"\n"+toString(printQueue,layerNum+1,height);
  }
}

  /*
  public String toString(){
    String result = "";
    ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
    //add all nodes to queue in level order
    queue.add( _root );
    int tracker = 0; //keeps track of how many nodes childrens we have noted down
    while( queue.size() - tracker > 0 ){
      int tmp = queue.size();
      for( ; tracker < tmp; tracker++ ){
        //get the current node
        System.out.println( queue );
        TreeNode cur = queue.get(tracker);
        //add its string representation
        result += nodeToString( cur );
        //add its children to the queue
        if( cur.getLeft() != null ) queue.add( cur.getLeft() );
        if( cur.getRight() != null ) queue.add( cur.getRight() );
      }
      //add a newline
      result+="\n";
    }
    return result;
  }
  //adds a node and how much spacing it needs
  public String nodeToString( TreeNode node ){
    String result = "";
    //add spaces for right
    int nodesLeftTree = numNodes( node.getLeft() );
    for( int i = 0; i < nodesLeftTree; i++) result += "xxx";
    //add current node
    result += "x" + node.getValue() + "x";  //String.format("%5x", node.getValue() );
    //add spaces for left
    int nodesRightTree = numNodes( node.getRight() );
    for( int i = 0; i < nodesRightTree; i++ ) result+= "xxx";
    return result;
  }*/


  //precondition, the thnig you want to remove is in the tree?
  public void remove( int num ){
    //root is unique case
    _root = remove( num, _root );
  }


  //if num is in tree then removes it else 
  public TreeNode remove( int num, TreeNode curr){
    // to account for reaching leaf
    if( curr == null ){
      return null;
    }
    //if we need to remove current node
    if( num == curr.getValue() ){
      //no child
      if( isLeaf( curr ) ){
        curr = null;
      } 
      //one child
      else if( curr.getLeft() == null ){
        curr = curr.getRight();
      }
      else if( curr.getRight() == null ){
        curr = curr.getLeft();
      }
      //two child
      //always use left for now, but later make an optimization
      else{
        int leftValue = curr.getLeft().getValue();
        curr.setValue( leftValue );
        curr.setLeft( remove( leftValue, curr.getLeft() ) );
      }
    }
    //we havent found needed node yet
    else{
      //if we havent found yet maybe its deeper
      curr.setLeft( remove( num, curr.getLeft() ) );
      curr.setRight( remove( num, curr.getRight() ) );
    }
    //always return curr
    return curr;
  }



  //main method for testing
  public static void main( String[] args )
  {
    BST arbol = new BST();

    System.out.println( "tree init'd: " + arbol );
  
    //inserting in this order will build a perfect tree
    arbol.insert( 3 );
    arbol.insert( 1 );
    arbol.insert( 0 );
    arbol.insert( 2 );
    arbol.insert( 5 );
    arbol.insert( 4 );
    arbol.insert( 6 );
    /*
    */
  
    //insering in this order will build a linked list to left
    /*
    arbol.insert( 6 );
    arbol.insert( 5 );
    arbol.insert( 3 );
    arbol.insert( 4 );
    arbol.insert( 2 );
    arbol.insert( 1 );
    arbol.insert( 0 );
    */
  
    System.out.println( "tree after insertions:\n" + arbol );
    System.out.println();
  
    System.out.println();
    for( int i=-1; i<8; i++ ) {
        System.out.println(" searching for "+i+": " + arbol.search(i) );    
    }
  
    System.out.println();
    System.out.println( arbol );
  
    arbol.remove(6);
    System.out.println();
    System.out.println( arbol );
    
    arbol.remove(5);
    System.out.println();
    System.out.println( arbol );
    
    arbol.remove(4);
    System.out.println();
    System.out.println( arbol );
    
    arbol.remove(3);
    System.out.println();
    System.out.println( arbol );
    /*
  
    arbol.remove(2);
    System.out.println();
    System.out.println( arbol );
  
    arbol.remove(1);
    System.out.println();
    System.out.println( arbol );
  
    arbol.remove(0);
    System.out.println();
    System.out.println( arbol );
    */
  }

}//end class        
