package com.knoldus.db
import org.scalatest.flatspec.AnyFlatSpec

class UserReadDtoTest extends AnyFlatSpec {
  "User" should "exist" in {
    val userReadDto = new UserReadDto
    val result = userReadDto.getUserByName("Prince")
    assert(!result.isEmpty)
  }

  it should "not exist" in {
    val userReadDto = new UserReadDto
    val result = userReadDto.getUserByName("Rahul")
    assert(result.isEmpty)
  }

}
