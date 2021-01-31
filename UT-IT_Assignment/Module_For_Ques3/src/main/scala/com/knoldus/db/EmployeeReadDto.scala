package com.knoldus.db

import com.knoldus.models.Employee
import scala.collection.immutable.HashMap

class EmployeeReadDto {
  val priyaEmployee: Employee = Employee("Prince","Agrahari",24,12000,"Intern","knoldus","Prince.agrahari@knoldus.com")
  val alkaEmployee: Employee = Employee("Virat","Kohli",23,1200,"Intern","knoldus","virat.kohli@knoldus.com")


  val employees: HashMap[String, Employee] = HashMap("Prince" -> priyaEmployee, "Virat" -> alkaEmployee)
  def getEmployeeByName(name: String): Option[Employee] = employees.get(name)
}
