package Basic;

//快速排序
//思想：找一个枢轴变量，一般是第一个
//左右两个指针,往中间移动，最后low=high时候，左边的数都比枢轴变量小，右边都比他大，然后递归左右，最后得到排序好的
public class QuickSort {

    public static int getMiddle(int [] arr,int low,int high){
          int temp=arr[low];
          while(low<high){
              while(low<high&&arr[high]>temp){
                  high--;
              }
              arr[low]=arr[high];
              while(low<high && arr[low]<=temp){
                  low++;
              }
              arr[high]=arr[low];
          }
          arr[low]=temp;
          return low;
    }
    public static void quickSort(int [] arr,int low,int high) {
        if (low <high) {
            int middle = getMiddle (arr, low, high);
            quickSort (arr, low, middle - 1);
            quickSort (arr, middle + 1, high);
        }
    }

}
class Client{
    public static void main(String[] args) {
        int arr[]=new int[]{1,4,2,5,7,-1,2,-1};
        QuickSort.quickSort (arr,0,arr.length-1);
        for(int i=0;i<arr.length;i++)
            System.out.print (arr[i]+" ");
    }
}
