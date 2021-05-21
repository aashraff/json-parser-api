package models

import play.api.libs.json.Json

case class Candy(price: Double, ingredients: Set[Ingredient])

object Candy {
}