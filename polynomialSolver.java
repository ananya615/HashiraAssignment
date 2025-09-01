import org.json.JSONObject;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class PolynomialSolver {
    public static void main(String[] args) throws Exception {
        if (args.length < 2) return;

        String content = Files.readString(Paths.get(args[0]));
        JSONObject obj = new JSONObject(content);

        int k = obj.getJSONObject("keys").getInt("k");

        List<BigInteger> roots = new ArrayList<>();
        for (String key : obj.keySet()) {
            if (key.equals("keys")) continue;
            JSONObject r = obj.getJSONObject(key);
            roots.add(new BigInteger(r.getString("value"), Integer.parseInt(r.getString("base"))));
        }

        Collections.sort(roots);
        List<BigInteger> selected = roots.subList(0, k);
        BigInteger[] coef = getCoefficients(selected);

        String out = "Input File: " + args[0] + "\nRoots: " + selected + "\nPolynomial Coefficients: " + Arrays.toString(coef) + "\n";
        Files.writeString(Paths.get(args[1]), out);
        System.out.println(out);
    }

    private static BigInteger[] getCoefficients(List<BigInteger> roots) {
        int d = roots.size();
        BigInteger[] c = new BigInteger[d + 1];
        Arrays.fill(c, BigInteger.ZERO);
        c[0] = BigInteger.ONE;
        for (BigInteger r : roots) {
            for (int i = d; i >= 1; i--) {
                c[i] = c[i].subtract(r.multiply(c[i - 1]));
            }
        }
        return c;
    }
}
