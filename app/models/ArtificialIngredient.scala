package models

import play.api.libs.json.Json

case class ArtificialIngredient(name: String) extends Ingredient

object ArtificialIngredient {
    implicit val format = Json.format[ArtificialIngredient]
}