import org.scalatestplus.play._
import scala.concurrent._
import scala.concurrent.duration._
import play.api.libs.ws.WSClient
import play.api.inject.guice.GuiceApplicationBuilder

class NGServiceEndpointControllerTest extends PlaySpec with OneServerPerSuite with OneBrowserPerSuite with HtmlUnitFactory {
    val injector = new GuiceApplicationBuilder().injector
    val ws:WSClient = injector.instanceOf(classOf[WSClient])
    import play.api.libs.concurrent.Execution.Implicits.defaultContext
    "NGServiceEndpointController" must {
        "return a single double" in {
            val future = ws.url(s"http://localhost:${port}/double").get().map { res => res.body }
            val response = Await.result(future, 15.seconds)
            response must not be empty
            assert( new java.lang.Double(response) >= 1)
        }
        "return a list of 3 doubles" in {
            val future = ws.url(s"http://localhost:${port}/doubles/3").get().map { res => res.body }
            val response = Await.result(future, 15.seconds)
            response must (not be empty and include ("[") and include ("]"))
        }
    }
}
