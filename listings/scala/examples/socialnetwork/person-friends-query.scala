object Person extends DomainCompanionObject[Person] {
  def friends(person: Person): Seq[Person] = {
    // Deklaracja "placeholdera" pojawiającego się w zapytaniu
    val friend = p[Person]

    // Zapytanie
    val q = person knows friend select(friend)

    // Wykonanie i transformacja wyników zapytania
    // W tym przypadku funkcja identycznościowa
    q.exec(p => p)
  }
}
