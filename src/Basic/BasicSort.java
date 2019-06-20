package Basic;
//冒泡和选择
public class BasicSort {
    public static  void maopao(int [] arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-i-1;j++){
                int temp;
                if(arr[j]<arr[j+1]){
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
    public static void  choose(int arr[]){
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                int temp;
                if(arr[i]>arr[j]){
                    temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
    }
}
class test{
    public static void main(String[] args) {
        int [] arr=new int[]{2,3,-1,5,0,7};
//        BasicSort.maopao (arr);
        BasicSort.choose (arr);
        for(int i=0;i<arr.length;i++){
            System.out.print (arr[i]+" ");
        }

    }
}