package auth

import javax.inject.Inject
import pdi.jwt._
import play.api.http.HeaderNames
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}


case class CustomRequest[A](jwt: JwtClaim, token: String, request: Request[A]) extends WrappedRequest[A](request)

/**
* Custom action for authentication
*/
class AuthenticateAction @Inject()(bodyParser: BodyParsers.Default, authService: AuthenticationService)(implicit ec: ExecutionContext)
  extends ActionBuilder[CustomRequest, AnyContent] {

  override def parser: BodyParser[AnyContent] = bodyParser
  override protected def executionContext: ExecutionContext = ec

  private val headerTokenRegex = """Bearer (.+?)""".r

  // Validate the bearer token here
  override def invokeBlock[A](request: Request[A], block: CustomRequest[A] => Future[Result]): Future[Result] =
    extractBearerToken(request) map { token =>
      authService.validateJwt(token) match {
        case Success(claim) => block(CustomRequest(claim, token, request))      // token was valid - proceed!
        case Failure(t) => Future.successful(Results.Unauthorized(t.getMessage))  // token was invalid - return 401
      }
    } getOrElse Future.successful(Results.Unauthorized)     // no token was sent - return 401

  // Extract token
  private def extractBearerToken[A](request: Request[A]): Option[String] =
    request.headers.get(HeaderNames.AUTHORIZATION) collect {
      case headerTokenRegex(token) => token
    }
}
