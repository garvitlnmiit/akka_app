/**
 * A simple web service in Scala/Akka_HTTP
 **/

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer
import scala.io.StdIn

object WebServer {
	def main(args: Array[String]) {

		implicit val system = ActorSystem("my-system")
		implicit val materializer = ActorMaterializer()

		//// needed for the future flatMap/onComplete in the end
		implicit val executionContext = system.dispatcher

		val route =
			path("hello") {
				get {
					println("Hit received!!");
					complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, "<h1>Say hello to akka-http</h1>"))
				}
			}

		val bindingFuture = Http().bindAndHandle(route, "localhost", 8080)

		println("Server online at http://127.0.0.1:8080/\nPress return to stop")

		/*StdIn.readLine()

		bindingFuture
		.flatMap(_.unbind())
		.onComplete(_ => system.terminate())*/
	}
}