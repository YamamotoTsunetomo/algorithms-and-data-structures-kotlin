package structures.array

/*
    Kotlin array requires generic type argument
    to be `compile` time constant. wrapper class used to allow
    generic item type Array<Item<T>>, since Array<T> initialization
    is restricted.

    ex.
    - val arr: Array<T?> = arrayOfNulls(size) -> compile time error
    - val arr: Array<Item<T>?> = arrayOfNulls(size) -> allowed
 */
data class Item<T>(
    var item: T? = null
)
