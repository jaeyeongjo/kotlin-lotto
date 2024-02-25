package lotto.model

class ManualLottoMachine(val buyCount: Int, val lottoBuyBudget: LottoBuyBudget) {
    init {
        require(buyCount <= lottoBuyBudget.getBuyableLottoCount()) { PRICE_ERROR_MESSAGE }
    }

    fun createLottosFrom(manualInputNumbers: List<List<Int>>): List<Lotto> {
        lottoBuyBudget.subtractAvailableFunds(buyCount * lottoBuyBudget.pricePerLotto)
        return manualInputNumbers.map { Lotto(it.map(LottoNumber::of)) }
    }

    companion object {
        private const val PRICE_ERROR_MESSAGE = "수동으로 구입하는 로또의 가격은 로또 구입 가격이하여야 합니다."
    }
}
