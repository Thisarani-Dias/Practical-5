package q1
import scala.io.StdIn.readLine

object inventoryManagement {

    def getProductList(): List[String] = {
      var products: List[String] = List()
      var input = ""
      while (input != "done") {
        input = readLine("Enter product name (or type 'done' to finish): ")
        if (input != "done") {
          products = products :+ input
        }
      }
      products
    }

    def printProductList(products: List[String]): Unit = {
      products.zipWithIndex.foreach {
        case (product, index) => println(s"${index + 1}. $product")
      }
    }

    def getTotalProducts(products: List[String]): Int = {
      products.length
    }

    def main(args: Array[String]): Unit = {
      val products = getProductList()
      println("Product List:")
      printProductList(products)
      println(s"Total number of products: ${getTotalProducts(products)}")
    }

}
