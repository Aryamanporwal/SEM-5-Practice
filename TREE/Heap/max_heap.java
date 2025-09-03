public class max_heap {
    int heapSize;
    int heap[];
    int capacity;
    max_heap(int arr[]){
        heap = arr;
        heapSize = arr.length;
        capacity = arr.length;
    }

    public void heapify(int i){
        int largest = i;
        int leftchildindex = 2*i+1;
        int rightchildindex = 2*i+2;

        if(leftchildindex < heapSize && heap[leftchildindex] > heap[i]){
            largest = leftchildindex;
        }
        if(rightchildindex < heapSize && heap[rightchildindex] > heap[largest]){
            largest = rightchildindex;
        } 
        if(largest != i){
            swap(i , largest);
            heapify(largest);
        }
    }

    public void swap(int i , int j){
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public int extract_Max(){
        if(heapSize == 0){
            System.out.println("Heap is Empty");
            return -1;
        }
        int max = heap[0]; //store the root
        heap[0] = heap[heapSize-1];
        heapSize--; //delete the last node
        heapify(0);
        return max;
    }

    public void increaseKey(int index , int newValue){
        if(index < 0 || index>= heapSize || heap[index] >= newValue){
            System.out.println("Wrong operation");
        }

        heap[index] = newValue;
         //parent index
        while(index > 0 && heap[index] > heap[(int)(Math.ceil(index/2.0)-1)] ){
            swap(index , (int)(Math.ceil(index/2.0)-1));
            index = (int)(Math.ceil(index/2.0)-1);
        }
    }

    public void increaseCapacity(){
        capacity *=2; //double capacity
        int newHeap[] = new int[capacity];
        for(int i = 0 ; i<heapSize; i++){
            newHeap[i] = heap[i];
        }
        heap = newHeap;
    }

    public void decreaseKey(int index , int newValue){
        if(index < 0 || index>= heapSize || heap[index] <= newValue){
            System.out.println("Wrong operation");
            return;
        }

        heap[index] = newValue;
         //parent index
        heapify(index);
    }

    public void printTree(){
        for(int i = 0 ; i<heapSize; i++){
            System.out.print(heap[i] +", ");
        }
        System.out.println();
    }
    public void buildTree(){
        //leaf node = N/2 to N-1
        //non leafnode = 0 to (N/2-1);

        for(int i = heapSize/2-1 ; i>=0 ; i--){
            heapify(i);
        }
    }

    public void insert(int newValue){
        if(heapSize+1 >= capacity){
            increaseCapacity();
        }
        heapSize+=1;
        heap[heapSize-1] = newValue;
        int index = heapSize-1;
        while(index > 0 && heap[index] > heap[(int)(Math.ceil(index/2.0)-1)] ){
            swap(index , (int)(Math.ceil(index/2.0)-1));
            index = (int)(Math.ceil(index/2.0)-1);
        }
        
    }

    public int[] heapSort(){
        buildTree();
        int size = heapSize;
        for(int i = 0 ; i < size ; i++){
            extractMaxAndStore();
        }
        return heap;
    }

    public void extractMaxAndStore(){
        if(heapSize == 0){
            System.out.println("Heap is Empty");
            return;
        }
        int max = heap[0]; //store the root
        heap[0] = heap[heapSize-1];
        heap[heapSize-1] = max; //store at end
        heapify(0);
    }


    public static void main(String []args){
        int arr[] = new int[]{1,2,3,4,5};
        max_heap heap  = new max_heap(arr);
        heap.buildTree();
        heap.printTree();
        System.out.println("Removed max element is-->"+heap.extract_Max() );
        heap.printTree();
        heap.increaseKey(4 , 15);
        heap.printTree();
        heap.decreaseKey(0, 4);
        heap.printTree();
        heap.insert(18);
        heap.printTree();
        int res[] = heap.heapSort();
        for(int i = 0 ; i<res.length ; i++){
            System.out.println(res[i]+", ");
        }
    }
}
