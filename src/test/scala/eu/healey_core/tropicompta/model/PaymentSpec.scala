package eu.healey_core.tropicompta.model

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class PaymentSpec extends AnyFlatSpec with Matchers {

  "A fully professional payment" should "not contain any private charge" in {
    val payment = new Payment("Leonidas", price = 250, vatRate = 0.21)
    payment.computePrivateCharge should be (0)
  }

  "A fully deductible professional payment" should "have its vat fully deductible" in {
    val payment = new Payment("Librairie Miro", price = 120, vatRate = 0.21)
    payment.computeProfessionalCharge shouldEqual 120
    payment.computeDeductibleVat shouldEqual 25.20
    payment.computePrivateCharge shouldEqual 0
  }

  "A payment without deductible vat" should "have no deductible vat" in {
    val payment = new Payment("Chez Tonton", price = 250, vatRate = 0.21, deductibleVatPart = 0)
    payment.computeDeductibleVat should be (0)
    payment.computeProfessionalCharge shouldEqual payment.computeVatIncludedPrice
  }

}
