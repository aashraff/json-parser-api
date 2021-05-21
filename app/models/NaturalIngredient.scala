package models

import play.api.libs.json.Json

case class NaturalIngredient(name: String) extends Ingredient

object NaturalIngredient {
    implicit val format = Json.format[NaturalIngredient]
}