package models

import play.api.libs.json.Json

case class Candy(price: Double, ingredients: Set[Ingredient])

object Candy {
    implicit val formatIngredient = Json.format[Ingredient]
    implicit val formatCandy = Json.format[Candy]
}