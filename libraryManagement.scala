package q2
case class Book(title: String, author: String, isbn: String)

object libraryManagement {
  var library: Set[Book] = Set(
    Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565"),
    Book("1984", "George Orwell", "9780451524935"),
    Book("To Kill a Mockingbird", "Harper Lee", "9780060935467")
  )

  def addBook(book: Book): Unit = {
    library += book
  }

  def removeBook(isbn: String): Unit = {
    library = library.filterNot(_.isbn == isbn)  //returns a new collection containing others except the isbn
  }

  def isBookInLibrary(isbn: String): Boolean = {
    library.exists(_.isbn == isbn)
  }

  def displayLibrary(): Unit = {
    println("Library Collection:")
    library.foreach { book =>
      println(s"Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}")
    }
  }

  def searchByTitle(title: String): Option[Book] = {
    library.find(_.title.equalsIgnoreCase(title))
  }

  def displayBooksByAuthor(author: String): Unit = {
    val booksByAuthor = library.filter(_.author.equalsIgnoreCase(author))
    if (booksByAuthor.nonEmpty) {
      println(s"Books by $author:")
      booksByAuthor.foreach { book =>
        println(s"Title: ${book.title}, ISBN: ${book.isbn}")
      }
    } else {
      println(s"No books found by $author.")
    }
  }

  def main(args: Array[String]): Unit = {
    displayLibrary()

    println("\nAdding a new book...")
    addBook(Book("Brave New World", "Aldous Huxley", "9780060850524"))
    displayLibrary()

    println("\nRemoving a book by ISBN...")
    removeBook("9780451524935")
    displayLibrary()

    println("\nChecking if a book is in the library by ISBN...")
    println(isBookInLibrary("9780743273565")) // true
    println(isBookInLibrary("9780451524935")) // false

    println("\nSearching for a book by title...")
    searchByTitle("1985") match {
      case Some(book) => println(s"Book found: Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}")
      case None => println("Book not found.")
    }

    println("\nDisplaying books by a specific author...")
    displayBooksByAuthor("Harper Lee")
  }
}
