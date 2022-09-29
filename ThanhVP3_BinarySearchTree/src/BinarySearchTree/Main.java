package BinarySearchTree;

public class Main {
	 public static void main(String[] args) {
	        BSTree t = new BSTree();

	        int[] a = {8, 3, 10, 1, 6, 14, 4, 7, 13};
	        t.insertMany(a);
	        System.out.println("1.Test pre-order traversal:");
	        t.preOrder(t.root);
	        System.out.println();

	        System.out.println("2.Test in-order traversal:");
	        t.inOrder(t.root);
	        System.out.println();

	        System.out.println("3.Test post-order traversal:");
	        t.postOrder(t.root);
	        System.out.println();

	        System.out.println("4.Test breadth-first traversal:");
	        t.breadth(t.root);
	        System.out.println();

	        //Xóa
	       
	        System.out.println("5.Test delete by copying:");
	        t.deleByCopy(10);
	        t.breadth(t.root);
	        System.out.println();
	    }
}
