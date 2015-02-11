import akka.actor.ActorSystem
import akka.event.Logging
import akka.http.Http
import akka.http.model.StatusCodes._
import akka.http.server.Directives._
import akka.stream.ActorFlowMaterializer

object PlacesManager extends App {
  implicit val system = ActorSystem()
  implicit val executor = system.dispatcher
  implicit val materializer = ActorFlowMaterializer()
  val logger = Logging(system, getClass)

  val route = logRequestResult("places-manager") {
    (post & pathEndOrSingleSlash) {
      complete {
        OK -> "new place :)"
      }
    } ~
      (get & pathEndOrSingleSlash) {
        complete {
          OK -> "places list :)"
        }
      } ~
      path(Segment) { id =>
        (put & pathEndOrSingleSlash) {
          complete {
            OK -> s"update place :${id}"
          }
        } ~ (get & pathEndOrSingleSlash) {
          complete {
            OK -> s"get place :${id}"
          }
        }
      }
  }

  Http().bind(interface = "0.0.0.0", port = 8080).startHandlingWith(route)
}