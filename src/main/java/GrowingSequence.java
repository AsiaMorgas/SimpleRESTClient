public class GrowingSequence {

    public static void main(String[] args) {
        int tab[] ={4, 9, 7,1, 2, 0, 7, 9, 3, 8, 6} ;
        int n = 11;

        int result = longestGrowingSubstringLength(n, tab);
        System.out.println(result);
    }

    static int longestGrowingSubstringLength(int n, int tab[]) {
        int mx = 1;
        int length = 1;

        for (int i = 1; i < n; i++) {
            if (tab[i] > tab[i - 1]) {
                length += 1;
                if (length > mx) {
                    mx = length;
                }
            } else {
                length = 1;
            }
        }

        return mx;
    }
}
