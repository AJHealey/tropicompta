package eu.healey_core.tropicompta.model

/**
 * Represent an out cash flow
 * @param provider: provider name
 * @param price: prive of the payment vat excluded
 * @param vatRate: rate of the applied vat
 * @param professionalPart: professional part of the payment (default to 1). Between 0 and 1.
 * @param deductibleVatPart: Part of the paid vat that can be deduced. Cannot be lower than 0.
 */
class Payment(val provider: String, val price: BigDecimal, val vatRate: BigDecimal, val professionalPart: BigDecimal = 1, val deductibleVatPart: BigDecimal = 1) {
  val ONE: BigDecimal = BigDecimal("1")


  def computeVat: BigDecimal = this.price * this.vatRate
  def computeVatIncludedPrice: BigDecimal = this.price + this.computeVat
  def computeDeductibleVat: BigDecimal = this.computeVat * this.deductibleVatPart
  def computePrivateCharge: BigDecimal = this.computeVatIncludedPrice * (ONE - this.professionalPart)
  def computeProfessionalCharge: BigDecimal =
    this.computeVatIncludedPrice -
      this.computePrivateCharge -
      this.computeDeductibleVat
}
