package org.sscc.study.lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class WinningStat {
    private final Map<Prize, Integer> stat = new HashMap<>();

    public WinningStat() {
        for (Prize prize : Prize.values()) {
            stat.put(prize, 0);
        }
    }

    public void add(Prize prize) {
        stat.replace(prize, stat.get(prize) + 1);
    }

    public int get(Prize prize) {
        return stat.get(prize);
    }

    private int totalPrize() {
        return stat.keySet().stream()
                .map(n -> n.getPrize() * stat.get(n))
                .reduce(Integer::sum)
                .orElse(0);
    }

    public double portfolio(int price) {
        return (double) totalPrize() / price;
    }
}
