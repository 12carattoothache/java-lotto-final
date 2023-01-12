package org.sscc.study.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LotteryTicketsTest {
    @Test
    @DisplayName("당첨번호 입력 시 번호가 일치하는 지 확인")
    public void testWinning() {
        LotteryTickets lotteryTickets = new LotteryTickets();
        lotteryTickets.addAutoTicket(new StaticLottoNumberGenerator());
        List<Prize> matchData = lotteryTickets.
                duplicateNumbers(new WinningNumbers("1, 2, 3, 4, 5, 6", 7));
        assertThat(matchData.get(0)).isEqualTo(Prize.FIRST);
    }

    @Test
    @DisplayName("2등(5개-보너스볼)이 일치되는 지 확인")
    public void testSecond() {
        LotteryTickets lotteryTickets = new LotteryTickets();
        lotteryTickets.addAutoTicket(new StaticLottoNumberGenerator());
        List<Prize> matchData = lotteryTickets.
                duplicateNumbers(new WinningNumbers("1, 2, 3, 4, 5, 10", 6));
        assertThat(matchData.get(0)).isEqualTo(Prize.SECOND);
    }

    @Test
    @DisplayName("로또 번호가 문자열 형식에 맞게 출력되는 지 확인")
    public void testNumberString() {
        LotteryTickets lotteryTickets = new LotteryTickets();
        lotteryTickets.addAutoTicket(new StaticLottoNumberGenerator());
        String result = lotteryTickets.getString();
        assertThat(result).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}

