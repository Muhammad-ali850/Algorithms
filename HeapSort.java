class HeapSort{//max heap
    // Main function to do heap sort
    static void heapSort(int arr[]) {
    int n = arr.length;

    // Build heap (rearrange array)
    for (int i = n / 2 - 1; i >= 0; i--){//tamam non-leaf nodes ke lie,suppose agr 10 elements hain to 4 se 0(root)
        heapify(arr, n, i);
    }
    // One by one extract an element from heap
    for (int i = n - 1; i > 0; i--) {//....................>0.....................
        // Move current root to end
        int temp = arr[0];// akhri wale element ko root se swap
        arr[0] = arr[i];
        arr[i] = temp;
        
        // Call max heapify on the reduced heap
        heapify(arr, i, 0);
    }
}
// To heapify a subtree rooted with node I  which is an index in arr[]. 
static void heapify(int arr[], int n, int i) {
  int largest = i; //index of Largest element to make parent or root
  int l = 2 * i + 1; // left child index
  int r = 2 * i + 2; // right child index

  if (l < n && arr[l] > arr[largest]) {// If left child is larger than parent
      largest = l;
  }
  if (r < n && arr[r] > arr[largest]) {// If right child is larger than parent
      largest = r;
  }
  // If largest is not i
  if (largest != i) {
      int temp = arr[i];
      arr[i] = arr[largest];
      arr[largest] = temp;
      // Recursively heapify the affected sub-tree
      heapify(arr, n, largest);
  }
}
// A utility function to print array of size n
 static void printArray(int arr[]) {
    for (int i = 0; i < arr.length; i++) {
        System.out.print(arr[i] + " ");
    }
}
public static void main(String args[]) {
    int arr[] = {9, 4, 3, 8, 10, 2, 5}; 
    heapSort(arr);
    System.out.println("Sorted array is ");
    printArray(arr);
}
}