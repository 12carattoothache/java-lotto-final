package org.sscc.study.lotto.domain;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final int MAXIMUM = 45;
    private static final int MINIMUM = 1;
    private final int number;

    public LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number > MAXIMUM || number < MINIMUM) {
            throw new IllegalArgumentException("알맞지 않은 로또 번호입니다 ( 1 ~ 45 사이의 수만 가능 )");
        }
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof LottoNumber) {
            return this.number == ((LottoNumber) obj).getNumber();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return number;
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(this.getNumber(), o.getNumber());
    }
}
