package org.sscc.study.lotto.domain;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class LotteryTicket {
    private static final int NUMBER = 6;
    private final Set<LottoNumber> lotteryNumbers = new HashSet<>();

    public LotteryTicket(Set<LottoNumber> numbers) {
        validate(numbers);
        lotteryNumbers.addAll(numbers);
    }

    private void validate(Set<LottoNumber> numbers) {
        if (numbers.size() != NUMBER) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    public String getString() {
        return "[" + lotteryNumbers.stream()
                .sorted()
                .map(x -> String.valueOf(x.getNumber()))
                .collect(Collectors.joining(", ")) + "]";
    }

    public boolean checkNumber(LottoNumber lottoNumber) {
        return lotteryNumbers.contains(lottoNumber);
    }
}
