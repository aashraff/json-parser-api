package controllers

import org.scalatestplus.play._
import org.scalatestplus.play.guice._
import play.api.test._
import play.api.test.Helpers._

/**
 * Testing for JSON Parser Controller.
 *
 */
class JSONParserControllerSpec extends PlaySpec with GuiceOneAppPerTest with Injecting {

  "JSONParserController POST" should {

    "return the response from a new instance of controller" in {
      val controller = new JSONParserController(stubControllerComponents())
      val parser = controller.parseit().apply(FakeRequest(POST, "/"))

      status(parser) mustBe OK
      contentType(parser) mustBe Some("application/json")
      contentAsString(parser) must include ("parsing JSON")
    }

    "return the response from the application" in {
      val controller = inject[JSONParserController]
      val parser = controller.parseit().apply(FakeRequest(POST, "/"))

      status(parser) mustBe OK
      contentType(parser) mustBe Some("application/json")
      contentAsString(parser) must include ("parsing JSON")
    }

    "return the response from the router" in {
      val request = FakeRequest(POST, "/")
      val parser = route(app, request).get

      status(parser) mustBe OK
      contentType(parser) mustBe Some("application/json")
      contentAsString(parser) must include ("parsing JSON")
    }
  }
}
