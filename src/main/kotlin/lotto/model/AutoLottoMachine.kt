package lotto.model

object AutoLottoMachine {
    fun createLottos(
        lottoBuyBudget: LottoBuyBudget,
        lottoNumbersGenerator: LottoNumbersGenerator,
    ): List<Lotto> {
        val count = lottoBuyBudget.getTotalLottoBuyCount()
        return List(count) { createLotto(lottoNumbersGenerator) }
    }

    private fun createLotto(lottoNumbersGenerator: LottoNumbersGenerator): Lotto = Lotto(lottoNumbersGenerator.generate())
}
