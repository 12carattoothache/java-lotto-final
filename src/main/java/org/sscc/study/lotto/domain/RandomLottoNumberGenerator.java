package org.sscc.study.lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoNumberGenerator implements NumberStrategy {
    private static final int MAXIMUM = 45;
    private static final int MINIMUM = 1;
    private static final int NUMBER = 6;
    private static final List<LottoNumber> lottoNumbers = IntStream.range(MINIMUM, MAXIMUM)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toList());

    @Override
    public Set<LottoNumber> getNumber() {
        Collections.shuffle(lottoNumbers);
        return new HashSet<>(lottoNumbers.subList(0, NUMBER));
    }
}
