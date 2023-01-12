package org.sscc.study.lotto.domain;

import java.util.HashSet;
import java.util.Set;

public class StaticLottoNumberGenerator implements NumberStrategy {
    private final Set<LottoNumber> lottoNumber = new HashSet<>();

    public StaticLottoNumberGenerator() {
        for (int i = 1; i <= 6; i++) {
            lottoNumber.add(new LottoNumber(i));
        }
    }

    @Override
    public Set<LottoNumber> getNumber() {
        return lottoNumber;
    }
}
