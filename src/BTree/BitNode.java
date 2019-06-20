package BTree;


import org.hamcrest.core.Is;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BitNode {
       protected int data;
       BitNode lchild,rchild;
       public static BitNode init(int[] arr,int start,int end){
           BitNode root=null;
           if(end>=start){
               root=new BitNode ();
               int mid=(start+end)/2;
               root.data=arr[mid];
               root.lchild=init (arr,start,mid-1);
               root.rchild=init (arr,mid+1, end);
           }else{
               return null;
           }
           return root;
       }
       //先序遍历
       public static void preTravel(BitNode root){
           if(root==null)
               return;
           System.out.print(root.data+" ");
           preTravel (root.lchild);
           preTravel (root.rchild);
       }
       //先序遍历非递归(思路：利用一个栈，先进右孩子，再进左孩子)
      public static void NonDiguiPreTravel(BitNode root){
          Stack<BitNode> stack=new Stack<> ();
          stack.push (root);
          while(!stack.isEmpty ()){
              BitNode pop = stack.pop ();
              System.out.print (pop.data+" ");
              if(pop.rchild!=null)
                  stack.push (pop.rchild);
              if(pop.lchild!=null)
                  stack.push (pop.lchild);
          }
      }

       public static void midTravel(BitNode root){
        if(root==null)
            return;
        preTravel (root.lchild);
        System.out.print (root.data+" ");
        preTravel (root.rchild);
    }
    // //中序非递归（思路：用栈，一直左遍历把中途经历的节点入栈，左孩子遍历为空的话，出站，右孩子入站并访问其一直访问左孩子，中间节点入站）
    public static void NonDiguiMidTravel(BitNode root){
       if(root!=null){
           Stack<BitNode> stack=new Stack<> ();
           BitNode p=root;
           while(!stack.isEmpty ()||p!=null){
               while(p!=null){
                   stack.push (p);
                   p=p.lchild;
               }
               if(!stack.isEmpty ()){
                   p=stack.pop ();
                   System.out.print (p.data+" ");
                   p=p.rchild;
               }
           }
       }
    }
    //层次遍历(利用队列保存) 空间复杂度为O(N)
    public static  void cengci(BitNode root){
           if(root==null)
               return;
        Queue<BitNode> queue=new LinkedList<> ();
        queue.offer (root);
        //如果队列不为空的话
        while(!queue.isEmpty ()){
            BitNode bitNode = queue.poll ();
            System.out.println (bitNode.data+" ");
            if(bitNode.lchild!=null)
                queue.offer (bitNode.lchild);
            if(bitNode.rchild!=null)
                queue.offer (bitNode.rchild);
        }
    }
    //查找最小子树（和最大的最小子树，返回最小子树根节点的值）
    //思路：利用后序遍历
    public static int max=Integer.MIN_VALUE;
    public static  int SumMaxtree(BitNode  root,BitNode maxRoot){
        if(root ==null)
            return 0;
        int lmax=SumMaxtree (root.lchild, maxRoot);
        int rmax=SumMaxtree (root.rchild, maxRoot);
        int sum=lmax+rmax+root.data;
        if(sum>max){
            max=sum;
            maxRoot.data=root.data;
        }
        return max;
    }
    //求二叉树的深度
    public static int Depth(BitNode root){
        if(root==null)
            return 0;
        int ldepth=Depth (root.lchild);
        int rdepth=Depth (root.rchild);
        return  ldepth>rdepth?(ldepth+1):(rdepth+1);
    }
    //后续排序非递归
    //思路：先序非递归是先右孩子入栈，后左孩子入栈；次序变换，先左孩子后右孩子入栈（相当于交换了左右子树）
    //这样遍历得到逆后续，然后再反转就得到后续
    public static void NonDiguiPostTravle(BitNode root) {
        if (root != null) {
            Stack<BitNode> s1 = new Stack<> ();
            Stack<BitNode> s2 = new Stack<> ();
            s1.push (root);
            while (!s1.isEmpty ()) {
                BitNode pop = s1.pop ();
                s2.push (pop);
                if (pop.lchild != null)
                    s1.push (pop.lchild);
                if (pop.rchild != null)
                    s1.push (pop.rchild);
            }
            while (!s2.isEmpty ()) {
                BitNode pop = s2.pop ();
                System.out.print (pop.data + " ");
            }
        }
    }
    //判断两棵树是否想等（递归判断）
    public boolean IsSimilary(BitNode root1,BitNode root2){
        if(root1==null&&root2==null)
            return true;
        if(root1==null||root2==null)
            return false;
        if(root1.data==root2.data)
            return IsSimilary (root1.lchild, root2.lchild)&&IsSimilary (root1.rchild, root2.rchild);
      return false;
    }


}


