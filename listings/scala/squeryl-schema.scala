import org.squeryl.PrimitiveTypeMode._
 
class Song(val id: Long,
           val title: String,
           val artistId: Long,
           val filePath: Option[String],
           val year: Int)
 
object SongSchema {
  val songs = table[Song]
}
