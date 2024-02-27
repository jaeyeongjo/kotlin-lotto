package lotto.model

data class Result(val winningCountsByRank: Map<Rank, Int>) {
    fun calculateProfitRate(totalPurchaseCost: Int): Double {
        val totalProfit =
            winningCountsByRank.entries.sumOf { (rank, count) ->
                rank.winningMoney * count
            }
        return totalProfit.toDouble() / totalPurchaseCost
    }
}
