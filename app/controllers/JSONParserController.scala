package controllers

import javax.inject._
import play.api._
import play.api.mvc._

@Singleton
class JSONParserController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  def parseit(): Action[AnyContent] = Action {
    Ok("Parse request received")
  }

}

