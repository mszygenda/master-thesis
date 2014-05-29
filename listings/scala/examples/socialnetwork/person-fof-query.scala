def fof(person: Person): Seq[Person] = {
  val fof = p[Person]
  val q = { person knows { some[Person] knows fof } } select(fof)

  q.exec(p => p)
}
