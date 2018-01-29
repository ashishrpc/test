package com.myExecutor.forkJoin;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

class QuickSort<T extends Comparable> extends RecursiveAction {
	 
    private List<T> data;
    private int left;
    private int right;
 
    public QuickSort(List<T> data){
        this.data=data;
        this.left = 0;
        this.right = data.size() - 1;
    }
 
    public QuickSort(List<T> data, int left, int right){
        this.data = data;
        this.left = left;
        this.right = right;
    }
 
    @Override
    protected void compute() {//The main computation performed by this task.
        if (left < right){
            int pivotIndex = left + ((right - left)/2);
 
            pivotIndex = partition(pivotIndex);
 /*
  * Forks the given tasks, returning when isDone holds for each task or an (unchecked) exception is encountered, in which case 
  * the exception is rethrown. If more than one task encounters an exception, then this method throws any one of these exceptions. 
  * If any task encounters an exception, the other may be cancelled. However, the execution status of individual tasks is not 
  * guaranteed upon exceptional return. The status of each task may be obtained using getException() and related methods to check 
  * if they have been cancelled, completed normally or exceptionally, or left unprocessed.
  */
            invokeAll(new QuickSort(data, left, pivotIndex-1),
                      new QuickSort(data, pivotIndex+1, right));
        }
 
    }
 
    private int partition(int pivotIndex){
        T pivotValue = data.get(pivotIndex);
 
        swap(pivotIndex, right);
 
        int storeIndex = left;
        for (int i=left; i<right; i++){
            if (data.get(i).compareTo(pivotValue) < 0){
                swap(i, storeIndex);
                storeIndex++;
            }
        }
 
        swap(storeIndex, right);
 
        return storeIndex;
    }
 
    private void swap(int i, int j){
        if (i != j){
            T iValue = data.get(i);
 
            data.set(i, data.get(j));
            data.set(j, iValue);
        }
    }
}

public class QuickSortForkJoin {
    public static void main(String[] args) {
        final int SIZE = 10000;
 
        List<Integer> myList = new ArrayList<Integer>(SIZE);
        Random random=new Random();
        for (int i=0; i<SIZE; i++){
            int value = (int) (random.nextInt() * 100);
            myList.add(value);
        }
 
        System.out.println(myList);
        QuickSort<Integer> quickSort = new QuickSort<Integer>(myList);
 
        ForkJoinPool pool = new ForkJoinPool();
        /*
         * Performs the given task, returning its result upon completion. If the computation encounters an unchecked Exception or Error, 
         * it is rethrown as the outcome of this invocation. Rethrown exceptions behave in the same way as regular exceptions, 
         * but, when possible, contain stack traces (as displayed for example using ex.printStackTrace()) of both the current thread 
         * as well as the thread actually encountering the exception; minimally only the latter.
         */
        pool.invoke(quickSort);
        System.out.println("Sorted: "+myList);
    }
}