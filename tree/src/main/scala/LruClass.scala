import scala.collection.mutable

class LruClass(capacity: Int) {
  val  hashSet =mutable.LinkedHashSet.empty[String]
  def addOrRemove(page: String): mutable.LinkedHashSet[String] = {
    if (hashSet contains page) {
      hashSet.remove(page)
      hashSet.addOne(page)
      hashSet
    } else { if (hashSet.size == capacity) {
      hashSet.remove(hashSet.head)
      hashSet.add(page)
      hashSet
    } else {
      hashSet.add(page)
      hashSet
    }
    }
  }
}

object Lru extends App {
  var cache = new LruClass(2)
  println(cache.addOrRemove("1"))
  println(cache.addOrRemove("2"))
  println(cache.addOrRemove("3"))
  println(cache.addOrRemove("1"))
  println(cache.addOrRemove("3"))
}
