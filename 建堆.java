代码如下：(别人的，比较好理解就搬过来了，网址：http://blog.csdn.net/fengzhe0411/article/details/7101006)
//最大堆排序  
public class HeapSort {  
  
    public static void main(String[] args) {  
        int a[] = new int[]{4,1,3,2,16,9,10,14,8,7};  
        buildHeap(a);  
        System.out.println("构建好的最大堆是:");  
        for(int x:a)  
            System.out.print(x+" ");  
        System.out.println();  
        System.out.println("排序的结果是:");  
        heapMain(a);  
        for(int x:a)  
            System.out.print(x+" ");  
    }  
      
    public static void buildHeap(int a[]){  
        int n = a.length;  
        for(int i=n/2-1;i>=0;i--) {//i从第一个非叶子结点开始  
            maxHeapify(a, i,a.length);  
        }  
    }  
      
    public static void maxHeapify(int a[],int i,int heapSize){  
        int maxIndex = i;  
        if(2*i+1<=heapSize-1&&a[2*i+1]>a[i])  
            maxIndex = 2*i+1;  
        if(2*i+2<=heapSize-1&&a[i*2+2]>a[maxIndex])  
            maxIndex = 2*i+2;  
        if(maxIndex !=i){  
            int tmp = a[maxIndex];  
            a[maxIndex] = a[i];  
            a[i]=tmp;  
            maxHeapify(a, maxIndex,heapSize);  
        }  
    }  
      
    public static void heapMain(int a[]){  
        int heapSize = a.length;  
        for(int i=a.length-1;i>0;i--){  
            int tmp=a[0];  
            a[0]=a[i];  
            a[i]=tmp;  
            heapSize-=1;  
            maxHeapify(a, 0, heapSize);   //在heapSize范围内根结点的左右子树都已经是最大堆  
        }  
    }  
  
}  
运行结果：
构建好的最大堆是:
16 14 10 8 7 9 3 2 4 1
 排序的结果是:
1 2 3 4 7 8 9 10 14 16

其实核心思想就是maxHeapify(int a[],int i,int heapSize)函数就是以下标为i的结点作为根的树构造堆，
这是一个递归的算法，要求i的左子树和右子树已经是最大堆了，这时候比较i和它左右直接结点的大小，
如果a[i]还是最大，那么它已经是最大堆。如果进行了交换，那么被交换的那个直接结点（左或者右的大
的那一个）所领导的子树就不再是最大堆了，所以要继续递归执行下去。这也解释了在bulidHeap方法中，
为什么i是从后往前走的，从一个非叶子往上面构造（叶子结点本来就是最大堆了），才能保证每一个结点
的左右子树都已经是最大堆。
