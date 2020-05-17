public class Heap {

    int[] Heap;
    int MAX_SIZE;

    public Heap(int MAX_SIZE) {
        this.MAX_SIZE = MAX_SIZE;
    }

    private static void swap(int[] array,int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }



    public void buildMaxHeap(int[] arr, int k) {
        for(int i = 1; i < k; i++) {
            if (arr[(i - 1 )/ 2] < arr[i]) {
                int j = i;
                while (arr[(j - 1)/2] < arr[j]) {
                    swap(arr, j, (j - 1)/2);
                    j = (j - 1) / 2;
                }
            }
        }
    }

    public void HeapSort(int[] arr) {
        buildMaxHeap(arr,arr.length);

        for(int i = arr.length - 1; i >= 0; i--) {
            swap(arr,i,0);
            buildMaxHeap(arr, i);
        }
    }

    public void MaxHeapify(int[] arr, int i) {
        while( i < arr.length/2) {
            int max = i;
            int l = 2*i + 1;
            int r = l + 1;
            if(max < arr[l]) {
                max = arr[l];
            }

            else if(max < arr[r]) {
                max = arr[r];
            }

            if(max != i) {
                swap(arr, max, i);
            }
        }

    }



    public void display(int[] Heap) {
        for(int j = 0; j < Heap.length; j++) {
            System.out.print(Heap[j] + ", ");
        }
    }

    public static int KthLargestElement(int[] Heap, int K) {
        int KthLargest = Heap[Heap.length - 4];
        return KthLargest;
    }

    public static void main(String[] args) {
        Heap h = new Heap(10);
        int[] heap = {4,2,6,3,5,0,1};
        h.display(heap);
     //   h.MaxHeapify(heap,10,0);
       // h.HeapSort(heap);
        System.out.println();
        h.HeapSort(heap);
        h.display(heap);

        System.out.println();

      //  System.out.println(KthLargestElement(heap,2));
    }
}
