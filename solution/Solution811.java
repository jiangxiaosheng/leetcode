import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution811 {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String domain: cpdomains) {
            String[] eles = domain.split(" ");
            int cnt = Integer.parseInt(eles[0]);
            String url = eles[1];
            for (String d : resolve(url)) {
                map.put(d, map.getOrDefault(d, 0) + cnt);
            }
        }
        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            res.add(entry.getValue() + " " + entry.getKey());
        }
        return res;
    }

    private List<String> resolve(String url) {
        List<String> res = new ArrayList<>();
        int idx;
        do {
            res.add(url);
            idx = url.indexOf('.');
            url = url.substring(idx + 1);
        } while (idx != -1);
        return res;
    }
}
