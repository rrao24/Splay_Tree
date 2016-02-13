import java.util.Random;
import java.util.Scanner;

	public class SplayTreeNode {
		
		/*************************************
		 * 									 *
		 * 	  MAIN DRIVER AND TEST CODE      *
		 * 									 *
		 *************************************/
		
		public static void main(String[] args)
		{
			SplayTreeNode BST = new SplayTreeNode(); 
			Scanner kbReader = new Scanner(System.in);
			String choice;
			int randomFill = 0;
			int j = 0;
			String rndm = "";
			while (true)
			{
				System.out.println("Options:");
				System.out.println("Quit (Q)");
				System.out.println("Make a New Tree (New)");
				System.out.println("Insert a String (I)");
				System.out.println("Remove a String (R)");
				System.out.println("Contains a String (C)");
				System.out.println("Print the Current BST (P)");
				System.out.println("Get a node (G)");
				System.out.println("Find max (X)");
				System.out.println("Find min (N)");
				System.out.println("Get root value (V)");
				System.out.println("Get size (S)");
				System.out.println("See if BST is empty (E)");
				System.out.println("Random Fill (F)");
				System.out.println("***********************");
				choice = kbReader.next();
				if (choice.equalsIgnoreCase("G"))
				{
					System.out.println("Enter the data of the node you would like to find:");
					choice = kbReader.next();
					System.out.println(BST.get(choice));
				}
				else if (choice.equalsIgnoreCase("X"))
				{
					System.out.println(BST.findMax());
				}
				else if (choice.equalsIgnoreCase("N"))
				{
					System.out.println(BST.findMin());
				}
				else if (choice.equalsIgnoreCase("V"))
				{
					System.out.println(BST.val());
				}
				else if (choice.equalsIgnoreCase("S"))
				{
					System.out.println(BST.getSize());
				}
				else if (choice.equalsIgnoreCase("E"))
				{
					System.out.println(BST.empty());
				}
				else if (choice.equalsIgnoreCase("Q"))
				{
					break;
				}
				else if (choice.equalsIgnoreCase("New"))
				{
					BST = new SplayTreeNode();
				}
				else if (choice.equalsIgnoreCase("I"))
				{
					System.out.println("Enter the String you would like to insert:");
					choice = kbReader.next();
					BST.insert(choice);
				}
				else if (choice.equalsIgnoreCase("R"))
				{
					System.out.println("Enter the String you would like to remove:");
					choice = kbReader.next();
					BST.remove(choice);
				}
				else if (choice.equalsIgnoreCase("C"))
				{
					System.out.println("Enter the String you would like to find:");
					choice = kbReader.next();
					System.out.println(BST.contains(choice));
				}
				else if (choice.equalsIgnoreCase("P"))
				{
					BST.print("");
				}
				else if (choice.equalsIgnoreCase("F"))
				{
					System.out.println("How many strings to input?");
					randomFill = kbReader.nextInt();
					
					while (j < randomFill)
					{
						rndm = MyRandom.nextString(6,10);
						if (BST.contains(rndm))
						{
							continue;
						}
						BST.insert(rndm);
						j++;
					}
					j = 0;
				}
				else if (choice.equalsIgnoreCase("H"))
				{
					System.out.println(BST.height());
				}
				else
				{
					System.out.println("Not a valid choice.");
				}
				System.out.println("***********************");
			}
		}
		
		
		
		/******************************************
		 * 									      *
		 * 	    SPLAYTREENODE IMPLEMENTATION      *
		 * 									      *
		 ******************************************/
		
		/* Instance Fields */
		private String data;
		private SplayTreeNode rSubtree;
		private SplayTreeNode lSubtree;
		private SplayTreeNode parent;
		private int size;
		
		/*  Constructors */
		public SplayTreeNode()
		{
			this(null,null,null,null);
		}
		
		public SplayTreeNode(String data)
		{
			this(data,null,null,null);
		}
		
		public SplayTreeNode(String data, SplayTreeNode rSubtree, SplayTreeNode lSubtree, SplayTreeNode parent)
		{
			this.data = data;
			this.rSubtree = rSubtree;
			this.lSubtree = lSubtree;
			this.parent = parent;
			this.size = 1;
		}
		
		/* Methods */
		
		/*
		 * Input: None
		 * Output: Return the data field associated with the SplayTreeNode.
		 */
		public String getData()
		{
			return data;
		}
		
		/*
		 * Input: String parameter
		 * Output: None
		 * Function: Sets the data field associated with the SplayTreeNode
		 * to the string which the user passes in.
		 */
		public void setData(String data)
		{
			this.data = data;
		}
		
		/*
		 * Input: None
		 * Output: Returns the right subtree of the given SplayTreeNode.
		 */
		public SplayTreeNode getRSubtree()
		{
			return rSubtree;
		}
		
		/*
		 * Input: None
		 * Output: Returns the left subtree of the given SplayTreeNode.
		 */
		public SplayTreeNode getLSubtree()
		{
			return lSubtree;
		}
		
		/*
		 * Input: None
		 * Output: Returns the parent subtree of the given SplayTreeNode.
		 */
		public SplayTreeNode getParent()
		{
			return parent;
		}
		
		/*
		 * Input: SplayTreeNode parameter
		 * Output: None
		 * Function: Sets the right subtree field associated with the SplayTreeNode
		 * to the SplayTreeNode field which the user passes in.
		 */
		public void setRSubtree(SplayTreeNode rSubtree)
		{
			this.rSubtree = rSubtree;
		}
		
		/*
		 * Input: SplayTreeNode parameter
		 * Output: None
		 * Function: Sets the left subtree field associated with the SplayTreeNode
		 * to the SplayTreeNode field which the user passes in.
		 */
		public void setLSubtree(SplayTreeNode lSubtree)
		{
			this.lSubtree = lSubtree;
		}
		
		/*
		 * Input: SplayTreeNode parameter
		 * Output: None
		 * Function: Sets the parent subtree field associated with the SplayTreeNode
		 * to the SplayTreeNode field which the user passes in.
		 */
		public void setParent(SplayTreeNode parent)
		{
			this.parent = parent;
		}
		
		/*
		 * Input: None
		 * Output: Returns the size associated with the given SplayTreeNode.
		 */
		 public int getSize()
		{
			return size;
		}
		
		/*
		 * Input: Integer value
		 * Function: Sets the size field associated with the SplayTreeNode
		 * to the int field which the user passes in.
		 */
		public void setSize(int size)
		{
			this.size = size;
		} 
		
		/*
		 * Input: String parameter
		 * Output: Returns a boolean indicating whether or not the 
		 * given String is in the given SplayTree. If found, the element
		 * is splayed to the top of the tree.
		 */
		public boolean contains(String str) //reports if given string is in bst
		{

			try {
				if (getData().equals(str))
				{
					splay(); //splay the element to the top of the tree
					return true;
				}
				//Find where the element is in the tree, if it is in the tree
				else if (getData().compareToIgnoreCase(str) < 0) 
				{
					return rSubtree.contains(str);
				}
				else 
				{
					return lSubtree.contains(str);
				}
			}
			//The element is not in the tree
			catch (NullPointerException e) 
			{
				return false;
			} 
		}
		
		/*
		 * Input: String parameter
		 * Output: Returns a boolean indicating whether or not the 
		 * given String is in the given SplayTree without splaying
		 * the element to the top, if found. This method is necessary
		 * for the remove operation. 
		 */
		public boolean containsNoSplay(String str) 
		{

			try {
				if (getData().equals(str))
				{
					return true;
				}
				else if (getData().compareToIgnoreCase(str) < 0)
				{
					return rSubtree.containsNoSplay(str);
				}
				else 
				{
					return lSubtree.containsNoSplay(str);
				}
			}
			catch (NullPointerException e)
			{
				return false;
			} 
		}
		
		/*
		 * Input: String parameter
		 * Output: None
		 * Function: Inserts the given String into the Splay Tree,
		 * the item is then splayed to the top of the tree.
		 */
		public void insert(String str) 
		{
			SplayTreeNode tempNode = null;
				if (getData() == null) //The tree is empty
				{
					setData(str);
					System.out.println("Element added: " + getData());
				}
				else if (getData().compareToIgnoreCase(str) < 0)
				{
					try { //Recursively insert the element to the right subtree
						size++; 
						tempNode = getRSubtree();
						tempNode.insert(str);
					}
					catch (NullPointerException e) //Find where the element will be inserted
					{
						rSubtree = new SplayTreeNode(str);
						rSubtree.setParent(this);
						System.out.println("Element added: " + rSubtree.getData());
						rSubtree.splay(); //Element is splayed to top of tree
					}
				}
				else //Recursively insert the element to the left subtree
				{
					try {
						size++; 
						tempNode = getLSubtree();
						tempNode.insert(str);
					}
					catch (NullPointerException e) //Find where the element will be inserted
					{
						lSubtree = new SplayTreeNode(str);
						lSubtree.setParent(this);
						System.out.println("Element added: " + lSubtree.getData());
						lSubtree.splay(); //Element is splayed to top of tree
					}
				}	
			}
		/*
		 * Input: None
		 * Output: Returns the minimum String value in the given BST.
		 * Splay the value to the top of the tree, if found.
		 */
		public String findMin() 
		{
			
			if (lSubtree == null) //We have found the leftmost element
			{
				splay(); //Splay the minimum value to the top of tree
				return val();
			}
			return lSubtree.findMin();
		}
		
		/*
		 * Input: None
		 * Output: Returns the minimum String value in the given BST
		 * without splaying the element to the top of the tree. Necessary
		 * for the remove method.
		 */
		public String findMinNoSplay()
		{
			if (lSubtree == null)
			{
				return(getData());
			}
			return lSubtree.findMinNoSplay();
		}
		
		/*
		 * Input: None
		 * Output: Returns the maximum String value in the given BST.
		 * Splay the value to the top of the tree, if found.
		 */
		public String findMax() 
		{
			if (rSubtree == null)
			{
				splay(); //splay the maximum value to the top of the tree
				return val();
			}
			return rSubtree.findMax();
		}
		
		/*
		 * Input: String parameter
		 * Output: None
		 * Function: Removes the SplayTreeNode containing the given paramater,
		 * if it exists. Splays the parent node of the deleted node to the
		 * top of the tree.
		 */
		public void remove(String str) 
		{
			if (containsNoSplay(str)) //check to see if the String is in the tree
			{
				size--; //decrement size of tree
				if (getData().equals(str)) //Check current node to see if it contains the given String value
				{
					if (lSubtree == null && rSubtree == null) //The current node is a leaf
					{
						if (parent != null)
						{
							if (parent.getLSubtree() == this) 
							{
								parent.setLSubtree(null);
								parent.splay(); //splay parent node to top of tree
							}
							else
							{
								parent.setRSubtree(null);
								parent.splay(); //splay parent node to top of tree
							}
						}
						else //This is the root value
						{
							setData(null);
						}
					}
					else if (lSubtree == null && rSubtree != null) //The node we want to delete has a child
					{
						if (parent != null)
						{
							if (parent.getRSubtree() == this)
							{
								parent.setRSubtree(rSubtree); 
								parent.getRSubtree().setParent(parent);
								parent.splay(); //splay parent to top of tree
							}
							else
							{
								parent.setLSubtree(rSubtree);
								parent.getLSubtree().setParent(parent);
								parent.splay(); //splay parent to top of tree
							}
						}
						else //This is the root element
						{
							setData(rSubtree.getData());
							rSubtree.remove(getData());
							//note: not splaying if root is deleted
						}
					}
					else if (lSubtree != null && rSubtree == null) //The node we want to delete has a child, similar to code above
					{
						if (parent != null)
						{
							if (parent.getRSubtree() == this)
							{
								parent.setRSubtree(lSubtree);
								parent.getRSubtree().setParent(parent);
								parent.splay();
							}
							else
							{
								parent.setLSubtree(lSubtree);
								parent.getLSubtree().setParent(parent);
								parent.splay();
							}
						}
						else
						{
							setData(lSubtree.getData());
							lSubtree.remove(getData());
							//note: not splaying if root is deleted
						}
					}
					else //The element we want to delete has 2 children
					{
							setData(rSubtree.findMinNoSplay()); //Maintains tree structure property
							rSubtree.remove(rSubtree.findMinNoSplay());
							//this will splay the parent of the deleted note recursively
					}
				}
				else if (getData().compareToIgnoreCase(str) < 0) //Find where the element should be located in the tree
				{
					rSubtree.remove(str);
				}
				else
				{
					lSubtree.remove(str);
				}
			}
		}
		
		/*
		 * Input: None
		 * Output: Prints the given Splay Tree for inspection; In-Order
		 * Traversal
		 */
		public void print(String str) 
		{
			if (rSubtree != null)
			{
				rSubtree.print(str+" * ");
			}
			System.out.println(str+getData());
			if(lSubtree != null)
			{
				lSubtree.print(str+" * ");
			}
		}

		/*
		 * Input: String parameter
		 * Output: Returns the SplayTreeNode associated with the given
		 * String parameter, if it exists.
		 */
		public SplayTreeNode get(String str) //note: similar traversal of tree to contains method
		{
			try {
				if (getData().equals(str))
				{
					return this;
				}
				else if (getData().compareToIgnoreCase(str) < 0)
				{
					return rSubtree.get(str);
				}
				else 
				{
					return lSubtree.get(str);
				}
			}
			catch (NullPointerException e)
			{
				return null;
			}	 
		}
		
		/*
		 * Input: None
		 * Output: Returns the root value of the Splay Tree.
		 */
		public String val() 
		{
			SplayTreeNode root = this;
			while (root.getParent() != null) //Traverse the tree upwards
			{
				root = root.getParent();
			}
			return root.getData();
		}
		
		/*
		 * Input: None
		 * Output: Returns a boolean indicating whether or not the
		 * given Splay Tree is empty.
		 */
		public boolean empty()
		{
			return getData() == null;
		}
		
		/*
		 * Input: None
		 * Output: None
		 * Function: A node in the Splay Tree will be moved up to the top
		 * of the tree while still maintaining Tree-structure property.
		 */
		private void splay()
		{
			int zigzigl = 0;
			int zigzigr = 0;
			int zigzagr = 0;
			SplayTreeNode tempNode = null;
			if (this.getParent() != null)
			{
				//CASE 1: ZIG
				if (this.getParent().getParent() == null)
				{
					//CASE 1A: ZIG L
					if (this == getParent().getLSubtree())
					{
						zigL();
					}
					//CASE 1B: ZIG R
					else
					{
						zigR();
					}
				}
				//CASE 2: ZIG-ZIG
				else 
				{
					//CASE 2A: ZIG-ZIG L
					//Setting the integer values for zigzigl, zigzigr, and zigzagr
					//indicates that there was an error when trying to access them
					//i.e. they do not exist in the tree. We handle the errors
					//appropriately.
					try {
						tempNode = getParent().getParent().getLSubtree().getLSubtree();
					}
					catch (NullPointerException e)
					{
						zigzigl = 1;
					}
					try {
						tempNode = getParent().getParent().getRSubtree().getRSubtree();
					}
					catch (NullPointerException e)
					{
						zigzigr = 1;
					}
					try {
						tempNode = getParent().getParent().getLSubtree().getRSubtree();
					}
					catch (NullPointerException e)
					{
						zigzagr = 1;
					}

					if (zigzigl == 0 && this == getParent().getParent().getLSubtree().getLSubtree())
					{
						zigZigL();
						getParent().getParent().splay(); //Recursive call to splay
					}
					//CASE 2B: ZIG-ZIG R
					else if (zigzigr == 0 && this == getParent().getParent().getRSubtree().getRSubtree())
					{
						zigZigR();
						getParent().getParent().splay(); //Recursive call to splay
					} 
					//CASE 3: ZIG-ZAG
					//CASE 3A: ZIG-ZAG R
					else if (zigzagr == 0 && this == getParent().getParent().getLSubtree().getRSubtree())
					{
						zigZagR();
						try {
							getParent().splay(); //Recursive call to splay
						}
						catch (NullPointerException e)
						{
							
						}
					}
					//CASE 3B: ZIG-ZAG L
					else 
					{
						zigZagL();
						try {
							getParent().splay(); //Recursive call to splay
						}
						catch (NullPointerException e)
						{
							
						}
					}
				}
			}
		}
		/* The rotations zigZagL, zigZagR, zigZigL, and zigZigR can all be made using a composition of the zigL and zigR functions.*/
		private void zigZagL()
		{
			zigL();
			getParent().zigR();
		}
		private void zigZagR()
		{
			zigR();
			getParent().zigL();
		}
		
		private void zigZigL()
		{
			zigL();
			getParent().zigL();
			zigL();
		}

		private void zigZigR()
		{
			zigR();
			getParent().zigR();
			zigR();
		}
		
		//Single AVL rotation
		private void zigL()
		{
			//Switch pointers of Splay Tree around, maintaining Tree structure property
			String tempString = getParent().getData();
			getParent().setData(getData());
			setData(tempString);
			SplayTreeNode tempNode = this;
			getParent().setLSubtree(getParent().getRSubtree());
			getParent().setRSubtree(tempNode);
			SplayTreeNode tempNode2 = getLSubtree();
			setLSubtree(getParent().getLSubtree());
			try { 
			getLSubtree().setParent(this); 
			}
			catch (NullPointerException e)
			{
				
			}
			getParent().setLSubtree(tempNode2);
			try {
			tempNode2.setParent(getParent());
			}
			catch (NullPointerException e)
			{
				
			}
			SplayTreeNode tempNode3 = getRSubtree();
			setRSubtree(getLSubtree());
			setLSubtree(tempNode3);
		}
		
		//Single AVL Rotation
		private void zigR()
		{
			//Switch pointers of Splay Tree around, maintaining Tree structure property
			String tempString = getParent().getData();
			getParent().setData(getData());
			setData(tempString);
			SplayTreeNode tempNode = this;
			getParent().setRSubtree(getParent().getLSubtree());
			getParent().setLSubtree(tempNode);
			SplayTreeNode tempNode2 = getRSubtree();
			setRSubtree(getParent().getRSubtree());
			try {
			getRSubtree().setParent(this); 
			}
			catch (NullPointerException e)
			{
				
			}
			getParent().setRSubtree(tempNode2);
			try {
			tempNode2.setParent(getParent()); 
			}
			catch (NullPointerException e)
			{
				
			}
			SplayTreeNode tempNode3 = getLSubtree();
			setLSubtree(getRSubtree());
			setRSubtree(tempNode3);
		}
		
		/*
		 * Input: None
		 * Output: Returns the height of the given Splay Tree
		 */
		public int height()
		{
			int rSubHeight;
			int lSubHeight;
			
			try {
				rSubHeight = getRSubtree().height(); //Recursively calculate the height of the tree
			}
			catch (NullPointerException e) //Node has no right subtree
			{
				rSubHeight = -1;
			}
			
			try {
				lSubHeight = getLSubtree().height(); //Recursively calculate the height of the tree
			}
			catch (NullPointerException e) //Node has no left subtree
			{
				lSubHeight = -1;
			}
			
			if (getData() == null) //Tree is empty
			{
				return -1;
			}
			else if (getRSubtree() == null && getLSubtree() == null) //Node is a leaf
			{
				return 0;
			}
			else if (rSubHeight <= lSubHeight) //Select the larger of the heights of the subtrees.
			{
				return lSubHeight + 1;
				//return getLSubtree().height() + 1;
			}
			else
			{
				return rSubHeight + 1;
				//return getRSubtree().height() + 1;
			} 
		}
	}	
	
	/* Class for generating random numbers and Strings */
	
	class MyRandom {

		  private static Random rn = new Random();

		  private MyRandom(){ }

		  public static int rand(int lo, int hi) {
		     int n = hi - lo + 1;
		     int i = rn.nextInt() % n;
		     if (i < 0) i = -i;
		     return lo + i;
		  }

		  public static String nextString(int lo, int hi) {
		     int n = rand(lo, hi);
		     byte b[] = new byte[n];
		     for (int i = 0; i < n; i++)
		     b[i] = (byte)rand('a', 'z');
		     return new String(b, 0);
		  }

		  public static String nextString() {
		     return nextString(5, 25);
		  }
		  
		} 