package com.knoldus.db

import com.knoldus.models.User
import scala.collection.immutable.HashMap

class UserReadDto {
  val user1: User = User("Prince","Agrahari","prince.agrahari@gmail.com","knoldus")
  val user2: User = User("Virat","Kohli","pavan.negi@knoldus.com","knoldus")


  val users: HashMap[String, User] = HashMap("Prince" -> user1, "Virat" -> user2)
  def getUserByName(name: String): Option[User] = users.get(name)
}
