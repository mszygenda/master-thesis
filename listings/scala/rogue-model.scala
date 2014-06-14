// Klasa reprezentująca osobę
class Person extends MongoRecord[Person] 
             with ObjectIdKey[Person] {
  def meta = Person
  object name extends StringField(this)
  object age extends LongField(this)
  object isActive extends BooleanField(this)
  object registrationDate extends DateField(this)
}

// Obiekt stowarzyszony z metainformacjami nt. kolekcji osób
object Person extends Person with MongoMetaRecord[Person] {
  override def collectionName = "persons"
}
