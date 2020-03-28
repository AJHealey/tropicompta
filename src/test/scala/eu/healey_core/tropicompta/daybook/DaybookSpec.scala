package eu.healey_core.tropicompta.daybook

import java.time.LocalDate

import org.scalatest.flatspec.AnyFlatSpec


class DaybookSpec extends AnyFlatSpec {

  "A Daybook" should "contains an added Transaction" in {
    val daybook = new Daybook()
    val newTransaction = Transaction(date = LocalDate.now(), reference = "Test")
    daybook add newTransaction
    assert(daybook.transactions contains newTransaction)
  }

  "An empty Daybook" should "produce Option.empty when popLastTransaction is invoked" in {
    val emptyDaybook = new Daybook()
    assertResult(Option.empty)(emptyDaybook.popLastTransaction())
  }

}
