package algorithms.sort

import structures.array.Item

fun <T : Comparable<T>> bubbleSort(arr: Array<Item<T>>) {
    for (i in 0 until arr.size - 1)
        for (j in 0 until arr.size - 1 - i)
            if (arr[j].item!! > arr[j + 1].item!!) {
                val tmp = arr[j]
                arr[j] = arr[j + 1]
                arr[j + 1] = tmp
            }
}