package org.sscc.study.lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LotteryMachine {
    private static final int PRICE = 1000;
    private int number;
    private int manualNumber;
    private LotteryTickets lotteryTickets;
    private WinningStat winningStat = new WinningStat();
    private final NumberStrategy numberStrategy = new RandomLottoNumberGenerator();

    public void pay(int money) {
        this.number = money / PRICE;
        lotteryTickets = new LotteryTickets();
        winningStat = new WinningStat();
    }

    public void setManualNumber(int number) {
        this.manualNumber = number;
        validate();
    }

    private void validate() {
        if (number - manualNumber < 0) {
            throw new IllegalArgumentException("입급된 금액보다 수동으로 입력된 티켓이 더 많습니다.");
        }
    }

    public void buyManualTicket(List<String> givenNumbers) {
        givenNumbers.forEach(x -> lotteryTickets.addManualTicket(new LotteryTicket(getNumbers(x))));
    }

    public Set<LottoNumber> getNumbers(String givenNumber) {
        return Arrays.stream(givenNumber.split(", "))
                .map(x -> new LottoNumber(Integer.parseInt(x)))
                .collect(Collectors.toSet());
    }

    // 자동
    public void drawNumbers() {
        for (int i = 0; i < number - manualNumber; i++) {
            lotteryTickets.addAutoTicket(numberStrategy);
        }
    }

    public String getString() {
        return lotteryTickets.getString();
    }

    public int getNumber() {
        return number;
    }

    public int getManualNumber() {
        return manualNumber;
    }

    public WinningStat getStat(WinningNumbers winningNumbers) {
        lotteryTickets.duplicateNumbers(winningNumbers).forEach(winningStat::add);
        return winningStat;
    }
}
