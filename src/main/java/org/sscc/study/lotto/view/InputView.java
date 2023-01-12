package org.sscc.study.lotto.view;

import org.sscc.study.lotto.domain.InputMoney;
import org.sscc.study.lotto.domain.WinningNumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private final Scanner sc = new Scanner(System.in);

    public InputMoney inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return new InputMoney(Integer.parseInt(sc.nextLine()));
    }

    public int inputManualNumber() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return Integer.parseInt(sc.nextLine());
    }

    public List<String> inputLotteryNumbers(int number) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<String> get = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            get.add(sc.nextLine());
        }
        return get;
    }

    public WinningNumbers inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String s = sc.nextLine();
        System.out.println("보너스 볼을 입력해 주세요.");
        return new WinningNumbers(s, Integer.parseInt(sc.nextLine()));
    }
}
