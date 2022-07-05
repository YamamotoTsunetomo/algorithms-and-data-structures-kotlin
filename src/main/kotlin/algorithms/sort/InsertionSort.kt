package algorithms.sort

import structures.array.Item

fun <T : Comparable<T>> insertionSort(arr: Array<Item<T>>) {
    val n = arr.size
    for(i in 1 until n) {
        val key = arr[i]
        var j = i - 1
        while (j >= 0 && arr[j].item!! > key.item!!) {
            arr[j + 1] = arr[j]
            j--
        }
        arr[j + 1] = key
    }
}