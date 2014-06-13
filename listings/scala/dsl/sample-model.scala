case class Person(name: String, surname: String) extends DomainObject[Person] {
  val knows = -->[Person]("KNOWS")
  val wrote = -->[Comment]("WROTE")
}

case class Comment(content: String) extends DomainObject[Comment] {
  val writtenBy = <--[Person]("WROTE")
}
