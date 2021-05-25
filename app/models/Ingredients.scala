package models

import play.api.libs.json.Json

sealed trait Ingredient {
    val name: String
}

case class ArtificialIngredient(name: String) extends Ingredient

object ArtificialIngredient {
    implicit val format = Json.format[ArtificialIngredient]
}

case class NaturalIngredient(name: String) extends Ingredient

object NaturalIngredient {
    implicit val format = Json.format[NaturalIngredient]
}