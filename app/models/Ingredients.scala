package models

import play.api.libs.json.{Json, OFormat}
import julienrf.json.derived

sealed trait Ingredient {
    val name: String
}

object Ingredient {
    implicit val format: OFormat[Ingredient] = derived.oformat[Ingredient]()
}

case class ArtificialIngredient(name: String) extends Ingredient

object ArtificialIngredient {
    implicit val format = Json.format[ArtificialIngredient]
}

case class NaturalIngredient(name: String) extends Ingredient

object NaturalIngredient {
    implicit val format = Json.format[NaturalIngredient]
}
