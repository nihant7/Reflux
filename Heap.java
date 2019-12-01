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

    public static void MaxHeapify(int[] Heap, int MAX_SIZE, int i) {
        int N = MAX_SIZE;
        int left = 2*i + 1;
        int right = left + 1;
        int largest = i;

            if(left < N && Heap[left] > Heap[largest])
                largest = left;

            if (right < N && Heap[right] > Heap[largest])
                largest = right;

            if(largest != i) {
                swap(Heap, largest, i);
                MaxHeapify(Heap, N, largest);
            }


    }

    public void HeapSort(int[] Heap) {
        int N = Heap.length;
        for(int i = 0; i < N/2 ; i++) {
            MaxHeapify(Heap, Heap.length, i);
        }

        for(int i = N-1; i >= 0; i--) {
            int temp = Heap[0];
            Heap[0] = Heap[i];
            Heap[i] = temp;
            MaxHeapify(Heap, i, 0);
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
        h.HeapSort(heap);
        System.out.println();
        h.display(heap);

        System.out.println();

        System.out.println(KthLargestElement(heap,2));
    }
}
