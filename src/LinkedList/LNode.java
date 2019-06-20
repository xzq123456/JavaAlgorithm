package LinkedList;

import java.util.ArrayList;
import java.util.List;

public class LNode {
    public Integer data;
    public LNode next;
    //利用头插法重新构造一条新的链表
    public static void reverse(LNode head){
        LNode cur=head;
        LNode tmp;
        int i=0;
        for(cur=head.next;cur!=null;cur=cur.next){
           tmp=new LNode ();
           tmp.data=cur.data;
           if(i!=0){
           tmp.next=head.next;}
           else{
               tmp.next=null;
           }
           head.next=tmp;
           i++;
        }
    }
    public static void traver(LNode head){
        LNode cur=head;
        for(cur=head.next;cur!=null;cur=cur.next){
            System.out.print (cur.data+"  ");
        }
    }
    //删除链表对应的数字
    public static LNode delete(LNode head,int num){
      LNode cur=head;
      LNode tmp;
      for(cur=head.next;cur.next!=null;cur=cur.next){
          if(cur.next.data==5){
           tmp=cur.next;
           cur.next=tmp.next;
          }

      }
      return head;
    }
    public static void init(LNode head, ArrayList<Integer> list){
        LNode cur=head;
        LNode tmp;
        for(int i=0;i<list.size ();i++){
          tmp=new LNode ();
          tmp.data=list.get (i);
          tmp.next=null;;
          cur.next=tmp;
          cur=cur.next;
        }

    }
    //从无序链表中移除重复项(传入的head即使是重新的一个引用，但也是指向链表，修改了他链表也会改变，所以不必返回应用)
    public static void removesame(LNode head){
        LNode cur=head;
        LNode p;
        LNode pre;
        for(cur=head.next;cur!=null;cur=cur.next){
            for(p=cur.next,pre=cur;p!=null;){
                if(p.data==cur.data){
                 pre.next=p.next;
                 p=p.next;
                 continue;
                }
                if(p.next==null){
                    pre.next=null;
                }
                p=p.next;
                pre=pre.next;
            }
        }
    }
    public static int length(LNode head){
        LNode cur=head;
        int length=0;
        for(cur=head.next;cur!=null;cur=cur.next){
            length++;
        }
        return length;
    }
    public static void sum(LNode head1,LNode head2){
       if(LNode.length (head1)>LNode.length (head2)){
           LNode cur1=head1;
           LNode cur2=head2;
           for(cur1 = head1.next,cur2=head2.next;cur1!=null||cur2!=null;cur1=cur1.next){
               if(cur2!=null){
                   cur1.data+=cur2.data;
                   cur2=cur2.next;
               }else{
                   //输出结果
//                   2  3  5  10  2  10
//                   1  2  3  4  5
//                   3  5  8  14  7  10

               }
           }
       }
    }
    public static void sort(LNode head){
        LNode cur=head;
        LNode post;
        int temp;
        for(cur=head.next;cur!=null;cur=cur.next){
            for(post=cur.next;post!=null;post=post.next)
            {
                if(post.data<cur.data){
                    temp = post.data;
                    post.data=cur.data;
                    cur.data=temp;
                }
            }
        }
    }
    //单链表倒数第K个元素
    public static LNode DaoshuK(LNode head,int k){
        //整数第n-k个数
        LNode cur=head;
        int i=0;
        int length=LNode.length (head);
        for(i=0,cur=head.next;i<length-k-1;cur=cur.next,i++){

        }
        return cur;
    }
}
class test{

//    public static void main(String[] args) {
//        LNode head=new LNode ();
//        LNode cur=head;//指向头节点的引用（指针）
//        LNode tmp;
//        //构造链表
//        for(int i=1;i<=8;i++){
//            tmp=new LNode ();
//            tmp.data=i;
//            //尾插法(正序输出)
//            tmp.next=null;
//            cur.next=tmp;
//            cur=cur.next;
//            //头插法（逆序输出）  构造的过程是逆序的
////            tmp.next=head.next;
////            head.next=tmp;
//
//        }
//
////        for(cur=head.next;cur!=null;cur=cur.next){
////            System.out.println (cur.data);
////        }
////        LNode.reverse (head);
////        for(cur=head.next;cur!=null;cur=cur.next){
////            System.out.println (cur.data);
////        }
//
//         //删除操作
//         LNode.traver (  LNode.delete (head,5));
//
//    }

    public static void main(String[] args) {
    LNode head=new LNode ();
    LNode head2=new LNode ();
    ArrayList<Integer> list=new ArrayList<> ();
    list.add (2);
    list.add (3);
    list.add (5);
    list.add (10);
    list.add (2);
    list.add (10);
//    ArrayList<Integer> list2=new ArrayList<> ();
//    list2.add (1);
//    list2.add (2);
//    list2.add (3);
//    list2.add (4);
//    list2.add (5);
    LNode.init (head,list);
//    LNode.init (head2,list2);
    LNode.traver (head);
    LNode.removesame (head);
        System.out.println ();
    LNode.traver (head);
//    System.out.println ();
//    LNode.traver (head2);
//    LNode.sum (head,head2);
//    System.out.println ();
//    LNode.traver (head);
        //排序
//        LNode.sort (head);
//        LNode.traver (head);
        //倒数第k个数
//        System.out.println (LNode.DaoshuK (head, 1).next.data);



    }


}

