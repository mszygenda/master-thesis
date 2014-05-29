case class Person(name: String) extends DomainObject[Person] {
  val knows = --[Person]("KNOWS")
  val likes = -->[Likeable]("LIKES")
  val wrote = -->[Comment]("WROTE")
}

trait Likeable extends TypedNode[Likeable]

case class Comment(content: String) extends DomainObject[Comment] with Likeable {
  val writtenBy = <--[Person]("WROTE")
}
