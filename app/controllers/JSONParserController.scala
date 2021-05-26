package controllers

import javax.inject.{Inject, Singleton}
import play.api.mvc.{Action, BaseController, ControllerComponents}
import play.api.libs.json._
import play.api.Logger
import models._

/**
 * This controller handles HTTP requests to the
 * application's JSON Parsing APIs.
 */
@Singleton
class JSONParserController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  val logger: Logger = Logger(this.getClass())

  /**
   * Create an Action to parse JSON into an 
   * instance of Candy.
   */
  def parseit() = Action(parse.json) { implicit request => 
    val content = request.body
    val result: JsResult[Candy] = request.body.validate[Candy]
        result.fold(
        errors => {
          logger.error(errors.toString() + " when parsing JSON: " + request.body)
          BadRequest(Json.obj("Error message" -> JsError.toJson(errors)))
        },
        candy => {
          logger.debug("Successfully parsed request: " + request.body + " to " + candy.toString())
          Ok(Json.obj("message" -> ("Success, validated a candy priced '" + candy.price)))
        }
     )
  }

}
