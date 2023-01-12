package org.sscc.study.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class LotteryTicketTest {
    @Test
    @DisplayName("로또 번호 갯수가 6개가 아닐 때 에러처리 확인")
    public void testLottoNumber() {
        Set<LottoNumber> numbers = new HashSet<>();
        numbers.add(new LottoNumber(1));
        numbers.add(new LottoNumber(3));
        numbers.add(new LottoNumber(4));
        numbers.add(new LottoNumber(11));
        numbers.add(new LottoNumber(13));
        assertThatThrownBy(() -> {
            LotteryTicket lotteryTicket = new LotteryTicket(numbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}