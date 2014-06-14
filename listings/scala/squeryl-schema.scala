class Song(val id: Long,
           val title: String,
           val artistId: Long,
           val filePath: Option[String],
           val year: Int)
 
// Obiekt reprezentujący schemat bazy danych. 
// Powinien on w sobie skupiać definicje 
// wszystkich tabel przechowywanych w bazie
object SongSchema extends Schema {
  val songs = table[Song]
}
