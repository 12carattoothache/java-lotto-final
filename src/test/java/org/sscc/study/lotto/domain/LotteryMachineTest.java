package org.sscc.study.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class LotteryMachineTest {
    @Test
    @DisplayName("가격에 맞는 갯수를 구매했는 지 확인")
    public void testNumber() {
        LotteryMachine lotteryMachine = new LotteryMachine();
        lotteryMachine.pay(14000);
        lotteryMachine.drawNumbers();
        assertThat(lotteryMachine.getNumber()).isEqualTo(14);
    }

    @ParameterizedTest
    @DisplayName("1~45 이외의 값 입력 시 예외 처리 확인")
    @ValueSource(strings = {
            "1, 2, 3, 4, 5, 49",
            "50, 2, 3, 4, 5, 6"
    })
    public void testException(String input) {
        assertThatThrownBy(() -> {
            WinningNumbers winningNumbers = new WinningNumbers(input, 7);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("6개 숫자가 입력되지 않았을 때의 예외 처리 확인")
    @ValueSource(strings = {
            "1, 2, 3, 3, 4, 4",
            "1, 2, 3"
    })
    public void testLottoNumber(String input) {
        assertThatThrownBy(() -> {
            WinningNumbers winningNumbers = new WinningNumbers(input, 7);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액보다 더 많은 개수의 수동 로또 구매 개수가 입력되었을 때")
    @Test
    public void testManualNumber(){
        LotteryMachine lotteryMachine = new LotteryMachine();
        lotteryMachine.pay(1000);
        assertThatThrownBy(()-> lotteryMachine.setManualNumber(3)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("수동로또 티켓이 올바르게 당첨 되는 지 확인")
    @Test
    public void testManualTicket(){
        LotteryMachine lotteryMachine = new LotteryMachine();
        lotteryMachine.pay(3000);
        lotteryMachine.setManualNumber(3);
        lotteryMachine.buyManualTicket(Arrays.asList("1, 2, 3, 4, 5, 6",
                "1, 3, 5, 7, 9, 11", "2, 4, 6, 8, 10, 12"));
        WinningStat stat = lotteryMachine.getStat(new WinningNumbers("1, 2, 3, 4, 5, 6", 7));
        assertThat(stat.get(Prize.FIRST)).isEqualTo(1);
    }
}