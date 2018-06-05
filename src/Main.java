import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Sale implements Comparable<Sale> {
    int a;
    int b;

    public Sale(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(Sale sale) {
        if (sale.a >= a) {
            return -1;
        } else
            return 1;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String num = bf.readLine();
        String[] count = num.trim().split(" ");
        double discountSum = 0;
        int sum = 0;
        int itemCount = Integer.parseInt(count[0]);
        int sale = Integer.parseInt(count[1]);
        int a = 0, b = 0;
        int n = 0, m = 0;
        Sale[] s = null;
        while (itemCount-- > 0) {
            count = bf.readLine().trim().split(" ");
            a = Integer.parseInt(count[0]);
            b = Integer.parseInt(count[1]);
            if (b == 1)
                discountSum += (double) a * 0.8;
            else
                discountSum += a;
            sum += a;
            n++;
        }
        s = new Sale[sale];
        while (sale-- > 0) {
            count = bf.readLine().trim().split(" ");
            s[m] = new Sale(Integer.parseInt(count[0]), Integer.parseInt(count[1]));
            m++;
        }
        Arrays.sort(s);
//		for (Sale sale2 : s) {
//			System.out.println(sale2.a+" "+sale2.b);
//		}
        for (int i = s.length - 1; i >= 0; i--) {
            Sale sale2 = s[i];
            if (sale2.a <= sum) {
                sum -= sale2.b;
                break;
            }
        }
        System.out.println(String.format("%.2f", Math.min(discountSum, sum)));
    }
}