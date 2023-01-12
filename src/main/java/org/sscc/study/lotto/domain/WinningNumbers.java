package org.sscc.study.lotto.domain;

import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class WinningNumbers {
    private final Set<LottoNumber> winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningNumbers(String input, int bonusNumber) {
        winningNumbers = new HashSet<>();
        getWinningNumbers(input);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    private void getWinningNumbers(String input) {
        StringTokenizer st = new StringTokenizer(input, ", ");
        while (st.hasMoreTokens()) {
            winningNumbers.add(new LottoNumber(Integer.parseInt(st.nextToken())));
        }
        validate();
    }

    private void validate() {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("당첨 번호는 6개입니다.");
        }
    }

    public int checkNumbers(LotteryTicket lotteryTicket) {
        return (int) winningNumbers.stream()
                .filter(lotteryTicket::checkNumber)
                .count();
    }

    public boolean checkBonus(LotteryTicket lotteryTicket) {
        return lotteryTicket.checkNumber(bonusNumber);
    }
}
