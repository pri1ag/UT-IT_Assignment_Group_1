package com.knoldus.validator
import com.knoldus.db.CompanyReadDto
import com.knoldus.models.Employee
import com.knoldus.models.Company
import org.scalatest.flatspec.AnyFlatSpec
import org.mockito.MockitoSugar.{mock, when}

class EmployeeValidatorTest extends AnyFlatSpec {

  val googleCompany: Company = Company("Google", "google@gmail.com", "Noida")
  val princeEmployee: Employee = Employee("Prince","Agrahari",24,12000,"Intern","knoldus","prince@knoldus.com")
  val mockedCompanyREadDto = mock[CompanyReadDto]
  val mockedEmailValidator = mock[EmailValidator]

  "Employee" should "be a valid employee" in{
    when(mockedCompanyREadDto.getCompanyByName(princeEmployee.companyName)) thenReturn(Option(googleCompany))
    when(mockedEmailValidator.emailIdIsValid(princeEmployee.emailId)) thenReturn(true)
    val employeeValidator= new EmployeeValidator(mockedCompanyREadDto ,  mockedEmailValidator)
    val result=employeeValidator.employeeIsValid(princeEmployee)
    assert(result)
  }

  "Employee" should "be a invalid employee as it already exists" in{
    when(mockedCompanyREadDto.getCompanyByName(princeEmployee.companyName)) thenReturn(None)
    when(mockedEmailValidator.emailIdIsValid(princeEmployee.emailId)) thenReturn(true)
    val employeeValidator= new EmployeeValidator(mockedCompanyREadDto ,  mockedEmailValidator)
    val result=employeeValidator.employeeIsValid(princeEmployee)
    assert(!result)
  }

  "Employee" should "be a invalid employee and email id is valid" in{
    when(mockedCompanyREadDto.getCompanyByName(princeEmployee.companyName)) thenReturn(Option(googleCompany))
    when(mockedEmailValidator.emailIdIsValid(princeEmployee.emailId)) thenReturn(false)
    val employeeValidator= new EmployeeValidator(mockedCompanyREadDto ,  mockedEmailValidator)
    val result=employeeValidator.employeeIsValid(princeEmployee)
    assert(!result)
  }

  "Employee" should "be a invalid employee and as email id is invalid" in{
    when(mockedCompanyREadDto.getCompanyByName(princeEmployee.companyName)) thenReturn(None)
    when(mockedEmailValidator.emailIdIsValid(princeEmployee.emailId)) thenReturn(false)
    val employeeValidator= new EmployeeValidator(mockedCompanyREadDto ,  mockedEmailValidator)
    val result=employeeValidator.employeeIsValid(princeEmployee)
    assert(!result)
  }

}
