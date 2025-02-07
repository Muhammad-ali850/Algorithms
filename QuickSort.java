/*public class LinearSearch {
    public static int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
     }
        public static void main(String[] args) {
        // Sample array and target value
        int[] array = { 34, 7, 23, 32, 5, 62 };
        int target = 5;
        // Calling linearSearch method
        int result = linearSearch(array, target); //giving our function the array and target value
        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found in the array.");
        }
    }
}*/


//    Benefits: Easy Algorithm to uderstand, Array can be in any order,,, Disadvantage: Inefficient(slow)

/* Time Complexity:
best O(1)
average O((n+1)/2)
worst O(n)
*/


/*public class BinarySearch {
    public static int binarySearch(int array[], int target) {
        int left = 0;               // Start index of the array
        int right = array.length - 1;   // End index of the array

        while (left <= right) {
            // Find the middle index
            int mid = (left + right)/ 2;
            // Check if the target is at the middle
            if (array[mid] == target) {
                return mid;  // Target found, return the index
            }
            // If target is smaller than mid, search in the left half
            else if (array[mid] > target) {
                right = mid - 1;
            }
            // Otherwise, search in the right half
            else {
                left = mid + 1;
            }
        }
        // If we reach here, the element was not found
        return -1;
    }

    public static void main(String[] args) {
        // Sample sorted array and target value
        int[] array = { 2, 5, 7, 10, 13, 18, 22, 35, 50, 63 };   //should be sorted
        int target = 5;
        // Calling the binarySearch method
        int result = binarySearch(array, target);
        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found in the array.");
        }
    }
}*/

// Divide and conquer strategy. The array must be a sorted array. Time complexity: O(log(n)) (worst).
// It is extremely fast as compared to an algorithm that tries all array elements.


/*import java.util.Arrays;
// jo bara hoga wo end ma jata rahega
public class BubbleSort {
   public static void bubbleSort (int a[]){
    for (int  i = 0; i < a.length-1; i++ ){
		for (int j = 0; j < a.length - i-1; j++ ){   // performs adjacent comparisons 
			if ( a[ j ] > a[ j+1 ] ){   // determines if a swap should occur 
				int temp = a[ j ];       // swap is performed 
				a[ j ] = a[ j + 1 ];
				a[ j+1 ] = temp;
			}
		}
	}
}
public static void main(String[] args){
    int a[]={8,5,9,4,2};
    bubbleSort(a);
    System.out.println(Arrays.toString(a));
}
}*/

/*Each element is compared with its adjacent element. 
Time Complexity:
best O(n)
worst O(n^2)
 */


/*import java.util.Arrays;
// smallest dhoond ker shuru me dega
public class SelectionSort{
	public void selectionSort(int arr[]){
		for (int i = 0; i < arr.length-1; i++){
			// Find the minimum element in unsorted array
			int min_idx = i;
			for (int j = i+1; j < arr.length; j++){
				if (arr[min_idx] > arr[j]){
					min_idx = j;    //udating minimum index
                }
            }
			// Swap the found minimum element with the first element
			int temp = arr[min_idx];
			arr[min_idx] = arr[i];
			arr[i] = temp;
		}
	}

	public static void main(String args[])
	{
		SelectionSort ob = new SelectionSort();
		int arr[] = {64,25,12,22,11};
		ob.selectionSort(arr);
		System.out.println("Sorted array:");
        System.out.println(Arrays.toString(arr));
	}
}*/

/*It finds the smallest element of the array and interchanges it with the element
 in first position of the array. And so on. The best case,worst case,average case of
selection sort algorithm are same. All of them are O(n^2).Selection sort algorithm is appropriate only for small n.
*/


/*import java.util.Arrays;
//apne pichhle walon se compare kerega or apni sahi jaga chale jaiga
public class InsertionSort {
    public static void insertionSort(int arr[]){
        for (int i = 1; i < arr.length; i++){
            int element = arr[i];
            int j = i - 1;
        while (j>=0 && arr[j] > element){
            arr[j + 1] = arr[j];
            j --;
        }
        arr[j + 1] = element;
    }
 }
 public static void main(String args[])
 {
     int arr[] = {64,25,12,22,11};
     insertionSort(arr);
     System.out.println("Sorted array:");
     System.out.println(Arrays.toString(arr));
 }
}*/

/*As the single element A [1] by itself is sorted array.Compare the second element with first, if the first
 element is greater than second, place it before the first one.Compare the third value with
 second and then with first and so on.
Time Complexity:
best O(n)
worst O(n^2)*/


/*import java.util.Arrays;
//bubble ma element ko travel karate the end tak,isme direct swap kara rahe hain
public class ExchangeSort {      //same as bubble sort but it sorts in decending order
   public static void exchangeSort (int a[]){
    for (int  i = 0; i < a.length-1; i++ ){   
		for (int j = i+1; j < a.length; j++ ){   
			if ( a[ i ] < a[ j ] ){   
				int temp = a[ i ];       
				a[ i ] = a[ j ];
				a[ j ] = temp;
			}
		}
	}
}
public static void main(String[] args){
    int a[]={8,5,9,4,2};
    exchangeSort(a);
    System.out.println(Arrays.toString(a));
}
}*/


import java.util.Arrays;

public class QuickSort { 
public int partition(int arr[], int low, int high){
    int pivot = arr[high];     //we are making the last element our pivot
    int count = low-1;
    for(int j=low; j<high; j++){ //we are traversing till second last becuase last is pivot
        if(arr[j] < pivot){
            count++;
            //swap
            int tmp = arr[count];
            arr[count] = arr[j];
            arr[j] = tmp;
        }    
    }

    count=count+1; // pivot right position
    int tmp = arr[count];
    arr[count] = pivot;
    arr[high] = tmp;
    return count;    //pivot index
}

public void quickSort(int arr[], int low, int high){
    if(low < high){
       int pivotindex = partition(arr, low, high);  //returns right position(index) of the pivot 
       quickSort(arr, low, pivotindex - 1);   //traversing elements before pivot
       quickSort(arr, pivotindex+1, high);   //elements after pivot
    }
}
public static void main(String[] args){
    QuickSort obj = new QuickSort();
    int a[]={8,5,9,4,2};
    obj.quickSort(a,0, a.length-1);
    System.out.println(Arrays.toString(a));
}
}

 
/*import java.util.Arrays;

public class RadixSort { //bucket sort
    // A utility function to get maximum value in arr[]
    public static int getMax(int[] arr){
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    // A function to do counting sort of arr[] according to the digit represented by exp
    public static void countSort(int[] arr, int exp){
        int n = arr.length;
        int[] output = new int[n]; // output array
        int[] tempcount = new int[10]; // 0 to 9

        // Store count of occurrences in tempcount[]
        for (int i = 0; i < n; i++){
            tempcount[(arr[i] / exp) % 10]++;
        }

        // Change count[i] so that count[i] now contains actual position of this digit in output[]
        for (int i = 1; i < 10; i++){
            tempcount[i] = tempcount[i] + tempcount[i - 1];
        }

        // Build the output array
        for (int i = n - 1; i >= 0; i--){
            output[tempcount[(arr[i] / exp) % 10] - 1] = arr[i];
            tempcount[(arr[i] / exp) % 10]--;
        }

// Copy the output array to arr[], so that arr[] now contains sorted numbers according to the current digit
        for(int i=0;i<n;i++){
            arr[i]=output[i];
        }

    }
    public static void radixSort(int[] arr){
        // Find the maximum number to know number of digits
        int max = getMax(arr);
        for (int exp = 1; max / exp > 0; exp *= 10) {//for 100's it will run 3 times, for 1000's 4 times
            countSort(arr, exp);//ye pahle 1's, phir 10's,phir 100's sort kerega
        }
    }
    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        System.out.println("Original array: " + Arrays.toString(arr));
        radixSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}*/


 
/*public class MergeSort{
        static void mergeSort(int[] array){
		int length = array.length;
		if (length <= 1){
            return; //base case
        }
		int middle = length / 2;
		int[] leftArray = new int[middle];
		int[] rightArray = new int[length - middle]; //ye islie agr odd ho
		int count = 0;
		for(int i =0; i < length; i++) {
			if(i < middle) {
				leftArray[i] = array[i];
			}
			else {
				rightArray[count] = array[i];
				count++;
			}
		}
		mergeSort(leftArray);//pahle ye jaiga end tak
		mergeSort(rightArray);//phir ye jaiga end tak
		merge(leftArray, rightArray, array);//pahle ooper ke dono mergeSort farigh honge to phir ye merge call hoga
	}
	    static void merge(int[] leftArray, int[] rightArray, int[] array){//ye merge kare ga sub elements ko sorted way ma 
		int leftSize = array.length / 2;
		int rightSize = array.length - leftSize;
	 	int i = 0; //original array
        int l = 0; //left array      indexes
        int r = 0; //right array
		//check the conditions for merging
		while(l < leftSize && r < rightSize) {
			if(leftArray[l] < rightArray[r]) {
				array[i] = leftArray[l];
				i++;
				l++;
			}
			else {
                array[i] = rightArray[r];
				i++;
				r++;
			}
		}
		while(l < leftSize){   //agr akhir ma koi elemnt reh jai leftarray ke
            array[i] = leftArray[l];
			i++;
			l++;
		}
		while(r < rightSize){   //agr akhir ma koi elemnt reh jai rightarray ke
            array[i] = rightArray[r];
			i++;
			r++;
		}
	}
    public static void main(String args[]){	
        int array[] = {8, 5, 3, 4, 6, 1};
        mergeSort(array);
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i]+ " ");
        }
    }
}*/