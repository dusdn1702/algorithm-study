import java.util.*;
import java.util.stream.Collectors;

public class 후보키 {//1, 2, 3, 01,
    static List<String> index = new ArrayList<>();//0, 01, 012, 0123, 1, 12, 123, 2, 23,
    static List<String> allIndexesUnique = new ArrayList<>();//[400, apeach], [200, muji]  ...
    static List<String> result = new ArrayList<>();

    public int solution(String[][] relation) {
        int answer = 0;
        int column = relation.length;
        int row = relation[0].length;

        makeIndex(row);
        makeAllHubos(relation, column);
        Collections.sort(allIndexesUnique);

        //완벽 print

        //최소키 답 없음
        for (int i = 0; i < allIndexesUnique.size(); i++) {
            String s = allIndexesUnique.get(i);

            boolean flag = true;

            for (int j = 0; j < allIndexesUnique.size(); j++) {
                if (i == j) continue;
                if (s.contains(allIndexesUnique.get(j))) {
                    flag = false;
                    break;
                    // allIndexesUnique.remove(allIndexesUnique.get(j));
                    // break;
                }
            }
            if (flag) {
                result.add(s);
            }

        }
        return result.size();
    }

    private void makeAllHubos(String[][] relation, int column) {
        for (int i = 0; i < index.size(); i++) {
            String s = index.get(i);
            List<Integer> indexes = Arrays.stream(s.split(""))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            Set<List<String>> all = new HashSet<>();
            for (int j = 0; j < column; j++) {
                List<String> elements = new ArrayList<>();
                for (Integer index : indexes) {
                    elements.add(relation[j][index]);
                }
                all.add(elements);
            }
            if (all.size() == column) {
                allIndexesUnique.add(s);
            }
        }
    }

    private void makeIndex(int row) {

        for (int i = 0; i < row; i++) {
            String now = "";
            for (int j = i; j < row; j++) {
                now += String.valueOf(j);
                index.add(now);
            }
        }
    }
}
