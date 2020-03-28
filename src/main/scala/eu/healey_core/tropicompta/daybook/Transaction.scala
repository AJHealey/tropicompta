package eu.healey_core.tropicompta.daybook

import java.time.LocalDate

case class Transaction(date: LocalDate, reference: String, debits: List[AccountFlow], credits: List[AccountFlow])
