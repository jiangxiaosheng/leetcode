import java.util.ArrayList;
import java.util.List;

public class Solution412 {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(i + 1 + "");
        }
        for (int i = 3; i <= n; i += 3) res.set(i - 1, "Fizz");
        for (int i = 5; i <= n; i += 5) res.set(i - 1, "Buzz");
        for (int i = 15; i <= n; i += 15) res.set(i - 1, "FizzBuzz");
        return res;
//        for (int i = 0; i < n; i++) {
//            if ((i + 1) % 3 == 0 && (i + 1) % 5 == 0)
//                res.add("FizzBuzz");
//            else if ((i + 1) % 3 == 0)
//                res.add("Fizz");
//            else if ((i + 1) % 5 == 0)
//                res.add("Buzz");
//            else
//                res.add((i + 1) + "");
//        }
//        return res;
    }
}
