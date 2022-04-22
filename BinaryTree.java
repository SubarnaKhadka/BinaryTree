   /*
   Binary Tree in Data Structures 
   Given int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1}; 
       ➀     
      ╱  ╲
     ➁   ➂
    ╱ ╲    ╲
   ➃  ➄    ➅
  ╱ ╲        ╲
 ➆  ➇        ➈

*/

import java.util.*;

public class BinaryTree{

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
        this.data = data;
        this.right = null;
        this.left = null;

        }
    }

   static class Binarytree{
       static int indx = -1;
       public static Node buildTree(int nodes[]){
           indx++;
           if(nodes[indx] == -1){
               return null;
           }
           Node newNode = new Node(nodes[indx]);
           newNode.left = buildTree(nodes);
           newNode.right = buildTree(nodes);

           return newNode;
       }
   }

   /* Preorder Traversal 
  -   Root 
  - Left Subtree 
  - Right Subtree  
   */

   public static void preorder(Node root){
          if(root == null){
            System.out.print(-1+" ");
              return;
          }
          System.out.print(root.data + "");
          preorder(root.left);
          preorder(root.right);
   }

 /*
 Inorder Traversal 
 - Left Subtree
 - Root
 - Right Subtree
 */

   public static void inorder(Node root){
       if(root == null){
        System.out.print(-1+" ");
           return;
       }
       inorder(root.left);
       System.out.print(root.data + " ");
       inorder(root.right);
   }

    /*
 Postorder Traversal 
 - Left Subtree
 - Right Subtree
 - Root
 */

   public static void postorder(Node root){
       if(root == null){
        System.out.print( -1+" ");
           return;
       }
       inorder(root.left);
       inorder(root.right);
       System.out.print(root.data + " ");
   }
   
 //  ----------- LevelOrder of node ---------------------
   public static void levelorder(Node root){
       Queue<Node> q = new LinkedList<>();
       q.add(root);
       q.add(null);

       while(!q.isEmpty()){
           if(root ==null){
               return;
           }
           Node currNode = q.remove();
           if(currNode == null){
          System.out.println();
          if(q.isEmpty()){
              break;
          }else{
              q.add(null);
          }
           }else{
              System.out.print(currNode.data + " ");
              if(currNode.left !=null ){
                    q.add(currNode.left);
              }
              if(currNode.right !=null){
                  q.add(currNode.right);
              }
           }
       }
   }

   //---------------- count of Nodes------------------

   public static int countOfNodes(Node root){
     if(root ==null){
         return 0;
     }
     int leftNodes = countOfNodes(root.left);
     int rightNodes = countOfNodes(root.right);

     return leftNodes + rightNodes + 1;
   }

  // --------------------- sum of Nodes--------------

   public static int sumOfNodes(Node root){
    if(root ==null){
        return 0;
    }
    int leftSum = sumOfNodes(root.left);
    int rightSum = sumOfNodes(root.right);

    return leftSum + rightSum + root.data;
  }

   // ----------------- height of node-----------------------

    public static int height(Node root){
        if(root == null){
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int myHeight = Math.max(leftHeight, rightHeight) + 1;

        return myHeight;
    }

//------------------diameter by approach2-----------------
   /* 
   - Time Complexity : O(N)  
   */

    static class TreeInfo{
        int ht;
        int diam;

        TreeInfo(int ht, int diam){
            this.ht = ht;
            this.diam = diam;
        }      
    }
    public static TreeInfo diameter2(Node root){

        if(root == null){
            return new TreeInfo(0, 0);
        }
     TreeInfo left = diameter2(root.left);
     TreeInfo right = diameter2(root.right);

     int myHeight = Math.max(left.ht,right.ht ) + 1;
     int diam1 = left.diam;
     int diam2 = right.diam;
     int diam3 = left.ht + right.ht + 1;

     int mydiam = Math.max(Math.max(diam1, diam2), diam3);

     TreeInfo myInfo = new TreeInfo(myHeight, mydiam);

     return myInfo;
    }

//------------ diameter by approach1-------------
   /* 
   - Time Complexity : O(N^2)    
   */

    public static int diameter(Node root){

        if(root == null){
            return 0;
        }
        int diam1 = diameter(root.left);
        int diam2 = diameter(root.right);
        int diam3 = height(root.left) + height(root.right) + 1;

        return Math.max(diam3, Math.max(diam1, diam2));
    }
    public static void main(String args[]){
    int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1}; 
    Binarytree tree = new Binarytree();
    Node  root = tree.buildTree(nodes);

     System.out.println(root.data);
     System.out.println("preorder");
     preorder(root);
     System.out.println();
    System.out.println("Inorder ");
     inorder(root);
     System.out.println();
    System.out.println("postorder");
     postorder(root);
     System.out.println();
    System.out.println("levelorder");
     levelorder(root);
     System.out.println();
    System.out.println("countOfNodes");
     System.out.println(countOfNodes(root));
    System.out.println("sumOfNodes");
     System.out.println(sumOfNodes(root));
    System.out.println("heightOfNodes");
     System.out.println(height(root));
    System.out.println("heightOfNodes by Approach1");
     System.out.println(diameter(root));
    System.out.println("heightOfNodes by Approach2");
    System.out.println(diameter2(root).diam);
    }
}