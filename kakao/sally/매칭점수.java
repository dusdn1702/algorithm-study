import java.util.*;

class Solution {
    static String realWord = "";

    public int solution(String word, String[] pages) {
        realWord = word;
        int answer = 0;
        Map<Integer, String> mappingUrl = new HashMap<>();
        Map<String, Integer> basicScore = new HashMap<>();
        Map<String, List<String>> linkedPages = new HashMap<>();
        Map<String, Integer> linkScore = new HashMap<>();

        for (int i = 0; i < pages.length; i++) {
            String[] split = pages[i].split("\n");
            List<String> headers = new ArrayList<>();
            List<String> bodies = new ArrayList<>();
            List<String> linked = new ArrayList<>();

            for (int j = 0; j < split.length; j++) {
                if (split[i].contains("<head>")) {
                    j += 1;
                    while (!split[i].contains("</head>")) {
                        headers.add(split[i]);
                        j += 1;
                    }
                }
                if (split[i].contains("<body>")) {
                    j += 1;
                    while (!split[i].contains("</body>")) {
                        bodies.add(split[i]);
                        j += 1;

                        if (split[i].contains("a href=")) {
                            linked.add(split[i]);
                        }
                    }
                }
            }
            String pageUrl = makePageUrl(headers);
            int count = makeBasic(bodies);
            List<String> linkedUrls = makeUrls(linked);
            basicScore.put(pageUrl, count);
            linkedPages.put(pageUrl, linkedUrls);
            linkScore.put(pageUrl, count/linkedUrls.size());
            mappingUrl.put(i, pageUrl);
        }

        for(Map.Entry<Integer, String> basic : mappingUrl.entrySet()) {
            String value = basic.getValue();
            Integer count = basicScore.get(value);
            List<String> p = linkedPages.get(value);

            for(String pp : p){
                if(linkScore.keySet().stream().anyMatch(s -> s.contains(pp))) {
                    //여기서부터 맵해서 점수 계산......
                }
            }
        }
        System.out.println("!@#" + linkedPages);
        System.out.println("^&*" + basicScore);
        return answer;
    }

    private List<String> makeUrls(List<String> linked) {
        List<String> urls = new ArrayList<>();
        for (String link : linked) {
            String[] s = link.split(" ");
            for (String str : s) {
                if (str.contains("href=")) {
                    urls.add(str.split("=")[1]);
                }
            }
        }
        return urls;
    }

    private int makeBasic(List<String> bodies) {
        int count = 0;
        for (String body : bodies) {
            if (body.toLowerCase(Locale.ROOT).contains(realWord)) {
                if(body.toLowerCase(Locale.ROOT).split(realWord).length < 2){
                    count += 1;
                    continue;
                }
                count += body.toLowerCase(Locale.ROOT).split(realWord).length - 1;
            }
        }
        return count;
    }

    private String makePageUrl(List<String> headers) {
        for (String header : headers) {
            if (header.contains("<meta property")) {
                String[] s1 = header.split(" ");

                for (String s2 : s1) {
                    if (s2.contains("content")) {
                        String[] split1 = s2.split("=");
                        return split1[1];
                    }
                }
            }
        }
        return "";
    }
}
