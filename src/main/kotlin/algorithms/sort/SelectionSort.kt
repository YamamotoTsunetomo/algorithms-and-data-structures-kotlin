package algorithms.sort

import structures.array.Item

fun <T : Comparable<T>> selectionSort(arr: Array<Item<T>>) {
    for (i in 0 until arr.size - 1) {
        var min = i
        for (j in i + 1 until arr.size)
            if (arr[j].item!! < arr[min].item!!)
                min = j
        val tmp = arr[min]
        arr[min] = arr[i]
        arr[i] = tmp
    }
}