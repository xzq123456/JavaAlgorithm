package DigitalCompute;
/*
* 1.题目：计算1024！后面有多少个0
* 0的产生是由偶数和5相乘得到的，偶数的个数肯定大于5的个数，所以偶数的个数决定了0的个数
* 5的倍数：1024/5=205
* 25的个数:(25=5*5 里面也藏了一个5，同理还有125 625)
*          1024/25=40
* 125的个数：1024/125=8
* 625的个数：1024/625=1
* 所以0个个数等于205+40+8+1=253
* */
public class ZeroOfFactorial {
    public static int calzeros(int num){
        int count=0;
        while(num!=0){
            num=num/5;
            count+=num;
        }
        return count;
    }

    public static void main(String[] args) {
        int count = calzeros (1024);
        System.out.println (count);
    }
}
