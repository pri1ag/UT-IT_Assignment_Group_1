package com.knoldus.db

import org.scalatest.flatspec.AnyFlatSpec

class EmployeeReadDtoTest extends AnyFlatSpec {
  "Employee" should "exist" in {
    val employeeReadDto = new EmployeeReadDto
    val result = employeeReadDto.getEmployeeByName("Prince")
    assert(!result.isEmpty)
  }

  it should "not exist" in {
    val employeeReadDto = new EmployeeReadDto
    val result = employeeReadDto.getEmployeeByName("Sachin")
    assert(result.isEmpty)
  }

}
