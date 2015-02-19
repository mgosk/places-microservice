import MyPostgresDriver.simple._
import com.vividsolutions.jts.geom.Point


case class Place(id: Long,
                 name: String,
                 location: Point,
                 imageUrl: Option[String])

class Places(tag: Tag) extends Table[Place](tag, "Test") {
  def id = column[Long]("id", O.AutoInc, O.PrimaryKey)

  def name = column[String]("name", O.AutoInc, O.PrimaryKey)

  def location = column[Point]("location")

  def imageUrl = column[Option[String]]("image_url", O.AutoInc, O.PrimaryKey)

  def * = (id,name, location,imageUrl) <>(Place.tupled, Place.unapply)

}

object PlacesRepository {
  val tq = TableQuery[Places]

  def byDistance(point: Point, distance: Double) =
    tq.filter(r => r.location.dWithin(point.bind, distance.bind)).map(t => t)

}
