package org.sscc.study.lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LotteryTickets {
    private final List<LotteryTicket> lotteryTickets;

    public LotteryTickets() {
        lotteryTickets = new ArrayList<>();
    }

    public void addManualTicket(LotteryTicket lotteryTicket) {
        lotteryTickets.add(lotteryTicket);
    }

    public void addAutoTicket(NumberStrategy numberStrategy) {
        lotteryTickets.add(new LotteryTicket(numberStrategy.getNumber()));
    }

    public List<Prize> duplicateNumbers(WinningNumbers winningNumber) {
        return lotteryTickets.stream()
                .map(x -> Prize.getPrize(winningNumber.checkNumbers(x), winningNumber.checkBonus(x)))
                .collect(Collectors.toList());
    }

    public String getString() {
        return lotteryTickets.stream()
                .map(LotteryTicket::getString)
                .collect(Collectors.joining("\n"));
    }
}