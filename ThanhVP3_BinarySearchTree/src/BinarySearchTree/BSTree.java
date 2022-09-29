package BinarySearchTree;

public class BSTree {
	 Node root;

	    BSTree() {
	        root = null;
	    }

	    void clear() {
	        root = null;
	    }

	    boolean isEmpty() {
	        return (root == null);
	    }

	    //(1)
	    Node search(Node p, int x) {
	        if (p == null) { //dieu kien co so
	            return null;
	        }
	        if (p.info == x) {
	            return p; //tim thays node có giá trị bằng x
	        }
	        if (x < p.info) {//giá trị cần tìm nằm ở nửa bên trái
	            //tìm ở nửa bên trái
	            return search(p.left, x);
	        } else {
	            return search(p.right, x);
	        }
	    }

	    //(2)
	    Node insert(Node p, int x) {
	        if (p == null) {
	            p = new Node(x);
	            return p;
	        }
	        if (p.info == x) {
	            System.out.println("The key " + x + " already exist, no insertion");
	            return p;
	        }
	        if (x < p.info) {//giá trị cần chèn ở bên trái p
	            //chèn vào bên trái
	            p.left = insert(p.left, x);
	        } else {
	            p.right = insert(p.right, x);
	        }
	        return p;
	    }

	    //(3) insert không sử dụng đệ quy
	    void insert(int x) {
	        root = insert(root, x);
	    }

	    //(4)
	    void insert2(int x) {
	        if (isEmpty()) {
	            root = new Node(x);
	            return;
	        }
	        Node f, p; //f là cha của p
	        f = null;
	        p = root;
	        while (p != null) {
	            if (p.info == x) {
	                System.out.println("The key " + x + " already exist, no insertion");
	                return;
	            }
	            f = p;
	            if (x < p.info) {
	                p = p.left;
	            } else {
	                p = p.right;
	            }
	        }
	        //tìm được chỗ để chèn rồi
	        if (x < f.info) {
	            f.left = new Node(x);
	        } else {
	            f.right = new Node(x);
	        }
	    }

	    //(5)
	    void insertMany(int[] a) {
	        int i;
	        for (i = 0; i < a.length; i++) {
	            insert2(a[i]);
	        }
	    }

	    //(6)
	    void visit(Node p) {
	        if (p != null) {
	            System.out.print(p.info + " ");
	        }
	    }

	    //(7) root-left-right
	    void preOrder(Node p) {
	        if (p == null) {
	            return;
	        }
	        visit(p);
	        preOrder(p.left);
	        preOrder(p.right);
	    }

	    //(8)left-root-right
	    void inOrder(Node p) {
	        if (p == null) {
	            return;
	        }
	        inOrder(p.left);
	        visit(p);
	        inOrder(p.right);
	    }

	    //(9) left-right-root
	    void postOrder(Node p) {
	        if (p == null) {
	            return;
	        }
	        postOrder(p.left);
	        postOrder(p.right);
	        visit(p);
	    }

	    //(10)
	    void breadth(Node p) {
	        if (p == null) {
	            return;
	        }
	        MyQueue q = new MyQueue();
	        q.enqueue(p);
	        Node r;
	        while (!q.isEmpty()) {
	            r = q.dequeue();

	            visit(r);//xử lý logic

	            if (r.left != null) {
	                q.enqueue(r.left);
	            }
	            if (r.right != null) {
	                q.enqueue(r.right);
	            }
	        }
	    }

	    //(11)
	    void deleByCopy(int x) {
	        if (isEmpty()) {
	            return;
	        }

	        //b1 : tìm node cần xóa
	        Node f, p;//f là cha của p
	        f = null;
	        p = root;
	        while (p != null) {
	            if (p.info == x) {//tìm thấy node có giá trị bằng x
	                break;
	            }
	            f = p;
	            if (x < p.info) {
	                p = p.left;
	            } else {
	                p = p.right;
	            }
	        }
	        if (p == null) {
	            return;//không tìm thấy giá trị x
	        }
	        //p là không có con
	        if (p.left == null && p.right == null) {
	            if (f == null) {//p là root
	                root = null;
	            } else {
	                if (p == f.left) {
	                    f.left = null;
	                } else {
	                    f.right = null;
	                }
	            }
	            return;
	        }
	        //p có 1 con(trái hoặc phải)
	        //có 2TH:
	        //th1: p có con trái
	        if (p.left != null && p.right == null) {
	            if (f == null) { //p là root
	                root = p.left;
	            } else {
	                if (p == f.left) {
	                    f.left = p.left;
	                } else {
	                    f.right = p.left;
	                }
	            }
	            return;
	        }
	        //th2: p có con phải
	        if (p.right != null && p.left == null) {
	            if (f == null) { //p là root
	                root = p.right;
	            } else {
	                if (p == f.left) {
	                    f.left = p.right;
	                } else {
	                    f.right = p.right;
	                }
	            }
	            return;
	        }

	        //p có cả hai con
	        if (p.left != null && p.right != null) {
	            Node q = p.left;
	            //tìm node bên phải nhất của nửa bên trái tính từ node q
	            Node frp, rp; //frp là cha của rp, rp là node phải nhất
	            frp = null;
	            rp = q;
	            while (rp.right != null) {
	                frp = rp;
	                rp = rp.right;
	            }

	            p.info = rp.info;

	            //xóa số 40 đi
//	            deleByCopy(rp.info);
	            if (frp == null) {
	                p.left = q.left;
	            } else {
	                frp.right = rp.left;
	            }

	        }
	    }

	    int height(Node p) {
	        if (p == null) {
	            return 0;
	        }
	        int leftHeight, rightHeight, height;
	        leftHeight = height(p.left);
	        rightHeight = height(p.right);
	        height = leftHeight > rightHeight ? leftHeight : rightHeight;
	        return height + 1;
	    }
}
