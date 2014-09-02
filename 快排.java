public class QuickSort{
     public int partition(int A[],int begin,int end){
          int key = A[begin];
          while(begin < end){
             while(begin < end && A[end] >= key) end --;
             A[end] = A[begin];
             while(begin < end && A[begin] <= key) begin ++;
             A[begin] = A[end];
          }
          A[begin] = key;
          return begin;
     }
     
     public void quickSort(int A[],int begin,int end){
         if(begin < end){
            int pivoloc = partition(A,begin,end);
            quickSort(A,begin,pivoloc-1);
            quickSort(A,pivoloc+1,end);
         }
     }
     public static void main(String[] args){
         int A[] = {1,3,5,7,9,2,4,6,8,10};
         QuickSort qs = new Quicksort();
         qs.quickSort(A,0,A.length-1);
     }
}
