package org.sscc.study.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class WinningStatTest {

    @Test
    @DisplayName("수익률 계산 테스트")
    public void testPortfolio() {
        WinningStat winningStat = new WinningStat();
        winningStat.add(Prize.FIFTH);
        winningStat.add(Prize.FIFTH);
        winningStat.add(Prize.SECOND);
        assertThat(winningStat.portfolio(10000)).isEqualTo(3001.00);
    }

    @Test
    @DisplayName("당첨 개수 확인 테스트")
    public void testNumber() {
        WinningStat winningStat = new WinningStat();
        winningStat.add(Prize.FIRST);
        winningStat.add(Prize.THIRD);
        winningStat.add(Prize.NONE);
        assertThat(winningStat.get(Prize.THIRD)).isEqualTo(1);
    }

    @Test
    @DisplayName("5개 일치 시 보너스볼 일치에 대해 분리되는 지 확인")
    public void testSecond() {
        WinningStat winningStat = new WinningStat();
        winningStat.add(Prize.SECOND);
        winningStat.add(Prize.THIRD);
        assertThat(winningStat.get(Prize.SECOND)).isEqualTo(1);
    }
}