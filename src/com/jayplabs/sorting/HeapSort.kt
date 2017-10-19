package com.jayplabs.sorting

private fun sort(arr: IntArray) {
    val len = arr.size

    // start with first internal node = len/2-1
    // Build heap (rearrange array)
    for (i in len/2-1 downTo 0) {
        heapify(arr, len, i)
    }

    // One by one extract an element from heap
    for (i in len-1 downTo 0) {
        // Move current root to end
        swap(arr, 0, i)
        // One by one extract an element from heap
        heapify(arr, i, 0)
    }
}

// To heapify a subtree rooted with node start which is
// an index in arr[]. size is size of heap
fun heapify(arr: IntArray, size: Int, start: Int) {

    var largest = start         // Initialize largest as root
    val left = 2 * start + 1
    val right = 2 * start + 2

    // If left child is larger than root
    if (left < size && arr[left] > arr[largest]) largest = left
    // If right child is larger than largest so far
    if (right < size && arr[right] > arr[largest]) largest = right

    // If largest is not root
    if (largest != start) {
        swap(arr, start, largest)
        // Recursively heapify the affected sub-tree
        heapify(arr, size, largest)
    }
}

private fun swap(arr: IntArray, s: Int, e: Int) {
    val temp = arr[s]
    arr[s] = arr[e]
    arr[e] = temp
}

fun main(args: Array<String>) {
    val arr = intArrayOf(1, -5, 7, 3, -2, 4, 6)

    println("Given Array")
    arr.forEach { number: Int -> print("$number ") }

    sort(arr)

    println("\nSorted array")
    arr.forEach { number: Int -> print("$number ") }
}