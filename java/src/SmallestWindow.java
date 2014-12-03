/**
 * Created by lgylym on 2014/12/3.
 *
 * You are given a text file too large to fit in memory and 3 strings A, B, C.
 * For each string, you have a sorted array listing the positions of the string in the file (e.g., inverted indices).
 * Find the smallest window containing the 3 strings. Order of appearance does not matter.
 *
 * {b,c} a {b,c}
 * c1 b1 (c1) a1 (c2) b2 c2
 * a - min(smallB,smallC)
 * max(bigB,bigC)-a
 * bigC-smallB
 * bigB-smallC
 */
public class SmallestWindow {
    public int getSmallestWindow(int[] A, int [] B, int[] C) {

        int startB = 0;
        int startC = 0;

        int result = A[A.length-1];//maybe even bigger, max(A,B,C)

        for(int a:A) {
            int smallB = getGreatestSmall(B,startB,a);
            int bigB = smallB + 1;
            if(bigB >= B.length) {
                bigB = -1;
            }
            startB = smallB;
            if(startB == -1) {
                startB = 0;
            }

            int smallC = getGreatestSmall(C,startC,a);
            int bigC = smallC >= (C.length - 1) ? -1 : smallC + 1;
            startC = smallC == -1 ? 0 : smallC;

            if(Math.min(smallB,smallC) != -1) {
                if(B[smallB] > C[smallC]) {
                    result = Math.min(result, a-C[smallC]);
                }else {
                    result = Math.min(result, a-B[smallB]);
                }
            }
            if(smallB != -1 && bigC != -1) {
                result = Math.min(result, C[bigC]-B[smallB]);
            }
            if(smallC != -1 && bigB != -1) {
                result = Math.min(result, B[bigB]-C[smallC]);
            }
            if(Math.min(bigB,bigC) != -1) {
                if(B[bigB] > C[bigC]) {
                    result = Math.min(result, B[bigB] - a);
                }else {
                    result = Math.min(result, C[bigC] - a);
                }

            }
        }
        return result;
    }

    //return the index of the biggest item that is smaller than value
    //return -1 if not exist
    private int getGreatestSmall(int[] X, int start, int value) {
        for(int i = start; i < X.length; i++) {
            if(X[i] >= value) {
                return i-1;
            }
        }
        return X.length-1;
    }

    public static void main(String[] args) {
        SmallestWindow sw = new SmallestWindow();
        int[] A = {1,10,100};
        int[] B = {2,4,5};
        int[] C = {8};
        System.out.print(sw.getSmallestWindow(A,B,C));
    }


}
