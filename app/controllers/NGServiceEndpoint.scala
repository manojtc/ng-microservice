package controllers

import javax.inject.Inject
import play.api.mvc._
import play.api.libs.json._
import services._

class NGServiceEndpoint @Inject()(service: NGContract) extends Controller {
    def double = Action {
        Ok(service.generateDouble.toString())
    }

    def doubles(n: Int) = Action {
        val json = Json.toJson(service.generateDoubleBatch(n))
        Ok(json)
    }
}
