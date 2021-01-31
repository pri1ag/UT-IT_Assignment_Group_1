package com.knoldus.request

import com.knoldus.models.Company
import com.knoldus.validator.CompanyValidator
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.flatspec.AnyFlatSpec

class CompanyImplTest extends AnyFlatSpec {

    // Unit Test Cases of CompanyImpl class:

    "the createCompany method" should "create company" in{
      val newCompany:Company = Company("Tesla","tesla@gmail.com","California")

      val mockedCompanyValidator= mock[CompanyValidator]
      when(mockedCompanyValidator.companyIsValid(newCompany)) thenReturn(true)

      val companyImpl:CompanyImpl=new CompanyImpl(mockedCompanyValidator)

      val result =companyImpl.createCompany(newCompany)
      assert(result==Option(newCompany.name))
    }

    it should "not create company as it already exist" in{
      val newCompany:Company = Company("Knoldus", "knoldus@gmail.com", "Noida")

      val mockedCompanyValidator= mock[CompanyValidator]
      when(mockedCompanyValidator.companyIsValid(newCompany)) thenReturn(false)

      val companyImpl:CompanyImpl=new CompanyImpl(mockedCompanyValidator)

      val result=companyImpl.createCompany(newCompany)

      assert(result==None)
    }


    // Integration Test Cases of CompanyImpl class:

    "the createCompany method of CompanyImpl class" should "create company" in {
      val company: Company = Company("HCL", "hcl@gmail.com", "Bangalore")

      val companyValidator: CompanyValidator = new CompanyValidator()
      val companyImpl: CompanyImpl = new CompanyImpl(companyValidator)

      val result=companyImpl.createCompany(company)

      assert(result == Option(company.name))
    }

    it should "not create company as it already exist" in {
      val company: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")

      val companyValidator: CompanyValidator = new CompanyValidator()
      val companyImpl: CompanyImpl = new CompanyImpl(companyValidator)

      val result=companyImpl.createCompany(company)

      assert(result == None)
    }

}
