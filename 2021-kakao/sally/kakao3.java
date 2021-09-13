import java.math.BigDecimal;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

class kakao3 {
    int basicTime;
    int basicFee;
    int timeUnit;
    int feeUnit;

    public int[] solution(int[] fees, String[] records) {
        basicTime = fees[0];
        basicFee = fees[1];
        timeUnit = fees[2];
        feeUnit = fees[3];

        List<String> cars = new ArrayList<>();
        Map<String, List<LocalTime>> report = new HashMap<>();
        for (String record : records) {
            String[] s = record.split(" ");
            String time = s[0];
            String num = s[1];
            String inOut = s[2];

            if (!cars.contains(num)) {
                cars.add(num);
            }

            int[] hm = Arrays.stream(time.split(":"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            LocalTime localTime = LocalTime.of(hm[0], hm[1]);
            if (report.containsKey(num)) {
                report.computeIfPresent(num, (s1, stringLocalTimeMap) -> new ArrayList<>(stringLocalTimeMap)).add(localTime);
                continue;
            }
            report.put(num, Collections.singletonList(localTime));
        }

        Collections.sort(cars);
        int[] answer = new int[cars.size()];
        for (int i = 0; i < cars.size(); i++) {
            List<LocalTime> stringLocalTimeMap = new ArrayList<>(report.get(cars.get(i)));
            Collections.sort(stringLocalTimeMap);
            if (stringLocalTimeMap.size() % 2 == 1) {
                stringLocalTimeMap.add(LocalTime.of(23, 59));
            }

            int allTime = 0;
            for (int j = 0; j < stringLocalTimeMap.size(); j += 2) {
                LocalTime end = stringLocalTimeMap.get(j + 1);
                LocalTime start = stringLocalTimeMap.get(j);
                allTime += ChronoUnit.MINUTES.between(start, end);
            }
            answer[i] = getMoney(allTime);
        }
        return answer;
    }

    private int getMoney(int minutes) {
        if (minutes < basicTime) {
            return basicFee;
        } else {
            minutes -= basicTime;
            BigDecimal total = new BigDecimal(minutes);
            BigDecimal unit = new BigDecimal(timeUnit);
            int ceil = total.divide(unit, 0, BigDecimal.ROUND_UP).intValue();
            return (ceil * feeUnit) + basicFee;
        }
    }
}
