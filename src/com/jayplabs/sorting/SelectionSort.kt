package com.jayplabs.sorting

private fun selectionSort(arr: IntArray) {
    val size = arr.size

    // One by one move boundary of unsorted subarray
    for (i in 0 until size) {
        // Find the minimum element in unsorted array
        var minIndex = i
        for (j in i+1 until size) {
            if (arr[j] < arr[minIndex]) minIndex = j
        }
        // Swap the found minimum element with the first element
        swap(arr, i, minIndex)
    }
}

fun swap(arr: IntArray, s: Int, e: Int) {
    val temp = arr[s]
    arr[s] = arr[e]
    arr[e] = temp
}


fun main(args: Array<String>) {
    val arr = intArrayOf(1, -5, 7, 3, -2, 4, 6)

    println("Given Array")
    arr.forEach { number: Int -> print("$number ") }

    selectionSort(arr)

    println("\nSorted array")
    arr.forEach { number: Int -> print("$number ") }
}