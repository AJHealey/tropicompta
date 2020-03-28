package eu.healey_core.tropicompta.daybook

class Daybook(var transactions: List[Transaction] = Nil) {

  def addTransaction(transaction: Transaction): List[Transaction] = transaction +: transactions

  def popLastTransaction(): Transaction = {
    val head = transactions.head
    transactions = transactions.tail
    head
  }
}
