class Venue extends MongoRecord[Venue] with ObjectIdKey[Venue] with IndexedRecord[Venue] {
  def meta = Venue
  object legacyid extends LongField(this) { override def name = "legid" }
  object userid extends LongField(this)
  object venuename extends StringField(this, 255)
  object mayor extends LongField(this)
  object mayor_count extends LongField(this)
  object closed extends BooleanField(this)
  object tags extends MongoListField[Venue, String](this)
  object popularity extends MongoListField[Venue, Long](this)
  object categories extends MongoListField[Venue, ObjectId](this)
  object geolatlng extends MongoCaseClassField[Venue, LatLong](this) { override def name = "latlng" }
  object last_updated extends DateField(this)
  object status extends EnumNameField(this, VenueStatus) { override def name = "status" }
  object claims extends BsonRecordListField(this, VenueClaimBson)
  object lastClaim extends BsonRecordField(this, VenueClaimBson)
}
object Venue extends Venue with MongoMetaRecord[Venue] {
  override def collectionName = "venues"
  override def mongoIdentifier = RogueTestMongo

  object CustomIndex extends IndexModifier("custom")
  val idIdx = Venue.index(_._id, Asc)
  val mayorIdIdx = Venue.index(_.mayor, Asc, _._id, Asc)
  val mayorIdClosedIdx = Venue.index(_.mayor, Asc, _._id, Asc, _.closed, Asc)
  val legIdx = Venue.index(_.legacyid, Desc)
  val geoIdx = Venue.index(_.geolatlng, TwoD)
  val geoCustomIdx = Venue.index(_.geolatlng, CustomIndex, _.tags, Asc)
  override val mongoIndexList = List(idIdx, mayorIdIdx, mayorIdClosedIdx, legIdx, geoIdx, geoCustomIdx)

  trait FK[T <: FK[T]] extends MongoRecord[T] {
    self: T=>
    object venueid extends ObjectIdField[T](this) with HasMongoForeignObjectId[Venue] {
      override def name = "vid"
    }
  }
}
