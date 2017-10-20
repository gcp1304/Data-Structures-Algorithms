package com.jayplabs.sorting


/* This function takes last element as pivot, places the pivot element at its correct position in sorted
array, and places all smaller (smaller than pivot) to left of pivot and all greater elements to right
of pivot */

private fun partition(array: IntArray, low: Int, high: Int) : Int {
    val pivot = array[high]
    var start = low - 1

    // loop through first to last-1 element
    (low until high)
            // If current element is smaller than or
            // equal to pivot
            .filter { array[it] <= pivot }
            .forEach { swap(array, ++start, it) }
    swap(array, start+1, high)
    return start+1
}

private fun quickSort(array: IntArray, low: Int, high: Int) {

    if (low < high) {
        val pi = partition(array, low, high)

        quickSort(array, low, pi-1)
        quickSort(array, pi+1, high)
    }
}

fun main(args: Array<String>) {
    val arr = intArrayOf(1, -5, 7, 3, -2, 4, 6)

    println("Given Array")
    arr.forEach { number: Int -> print("$number ") }

    quickSort(arr, 0, arr.size-1)

    println("\nSorted array")
    arr.forEach { number: Int -> print("$number ") }
}