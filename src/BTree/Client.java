package BTree;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class Client {
    BitNode root=null;
    int arr[];
    BitNode root2=null;
    @Before
    public void init(){
      arr=new int[]{1,2,3,4,5,6,7};

      root2=new BitNode ();
      root2.data=4;
      BitNode root3=new BitNode ();
      root3.data=3;
      BitNode root4=new BitNode ();
      root4.data=2;
      BitNode root5=new BitNode ();
      root5.data=1;
      BitNode root6=new BitNode ();
      root6.data=-1;
      BitNode root7=new BitNode ();
      root7.data=5;
      root2.lchild=root3;
      root2.rchild=root7;
      root3.lchild=root4;
      root3.rchild=root5;
      root4.lchild=root4.rchild=null;
      root5.lchild=root6;
      root5.rchild=null;
      root6.lchild=root6.rchild=null;
      root7.lchild=root7.rchild=null;
    }
    @Test
    public void testinit(){
        root=BitNode.init (arr,0,arr.length-1);
        //BitNode.preTravel (root2);
        //BitNode.midTravel (root);
//        BitNode.NonDiguiPreTravel (root2);
        BitNode.NonDiguiMidTravel (root2);
    }
    @Test
    public void testCengci(){
        BitNode.cengci (root2);
    }
    @Test
    public void testSumMaxTree(){
        BitNode maxRoot=new BitNode ();
        System.out.println (BitNode.SumMaxtree (root,maxRoot));
        System.out.println (maxRoot.data);
    }
    @Test
    public void testDepth(){
        System.out.println (BitNode.Depth (root2));
    }
    @Test
    public void testNonDiguiPostTravle(){
        BitNode.NonDiguiPostTravle (root2);
    }
    @Test
    public void testIsSimilary(){
        BitNode root3=root;
        //System.out.println (BitNode.IsSimilary (root,root3));
        System.out.println (BitNode.IsSimilary (root,root2));
    }
}
