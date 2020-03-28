package eu.healey_core.tropicompta.daybook

class Daybook(var transactions: List[Transaction] = Nil) {

  def add(transaction: Transaction): Unit = { transactions = transaction +: transactions }

  def popLastTransaction(): Option[Transaction] = this.transactions match {
    case head :: tail =>
      transactions = tail
      Option(head)
    case _ => Option.empty
  }
}
