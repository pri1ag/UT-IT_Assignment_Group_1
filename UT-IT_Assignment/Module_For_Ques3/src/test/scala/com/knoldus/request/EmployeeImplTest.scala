package com.knoldus.request

import com.knoldus.db.CompanyReadDto
import com.knoldus.models.{Company, Employee}
import com.knoldus.validator.{EmailValidator, EmployeeValidator}
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.flatspec.AnyFlatSpec

class EmployeeImplTest extends AnyFlatSpec {

  // Unit Test Cases for EmployeeImpl Class:

  val mockedEmployeeValidate = mock[EmployeeValidator]
  val rachitEmployee: Employee = Employee("suraj","Sharma",23,1200,"Intern","knoldus","suraj@knoldus.com")
  val anuragEmployee: Employee = Employee("Prince","Agrahari",24,1200,"Intern","knoldus","prince.agrahari@knoldus.com")
  val knoldusCompany: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")

  "Employee" should "be valid" in {
    val employeeImpl = new EmployeeImpl(mockedEmployeeValidate)
    when(mockedEmployeeValidate.employeeIsValid(anuragEmployee)) thenReturn (true)
    val result = employeeImpl.createEmployee(anuragEmployee)
    assert(!result.isEmpty)
  }

  it should "be not valid" in {
    val employeeImpl = new EmployeeImpl(mockedEmployeeValidate)
    when(mockedEmployeeValidate.employeeIsValid(rachitEmployee)) thenReturn (false)
    val result = employeeImpl.createEmployee(rachitEmployee)
    assert(result.isEmpty)
  }

  // Integration Test Cases for EmployeeImpl Class:

  val companyReadDto = new CompanyReadDto()
  val emailValidator = new EmailValidator()
  val employeeValidator = new EmployeeValidator(companyReadDto, emailValidator)
  val employeeImpl = new EmployeeImpl(employeeValidator)

  "Employee of EmployeeImpl class" should "be valid" in {
    val PrinceEmployee: Employee = Employee("Prince","Agrahari",24,12000,"Intern","Knoldus","Prince.agrahari@knoldus.com")
    val result =  employeeImpl.createEmployee(PrinceEmployee)
    assert(!result.isEmpty)
  }

  it should "be invalid as it company doesnot exists in DB" in {
    val rachitEmployee: Employee = Employee("Rachit","Sharma",24,12000,"Intern","Google","rachit@knoldus.com")
    val result =  employeeImpl.createEmployee(rachitEmployee)
    assert(result.isEmpty)
  }

  it should "be invalid as email id is invalid" in {
    val princeEmployee: Employee = Employee("Prince","Agrahari",24,12000,"Intern","Knoldus","priya.dahiyaknoldus.com")
    val result = employeeImpl.createEmployee(princeEmployee)
    assert(result.isEmpty)
  }

  it should "be invalid as email id is invalid and company does not exists in DB" in {
    val princeEmployee: Employee = Employee("Prince","Agrahari",24,12000,"Intern","Google","prince.agrahariknoldus.com")
    val result =  employeeImpl.createEmployee(princeEmployee)
    assert(result.isEmpty)
  }

}
