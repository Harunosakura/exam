package ThirtyDays;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

interface AdvancedArithmetic {

    int divisorSum(int n);
}

class Calculator implements AdvancedArithmetic {

    static Stack<Character> stack = new Stack<>();
    static Queue<Character> queue = new LinkedList<>();

    static void pushCharacter(char ch) {
        stack.push(ch);
    }

    static void enqueueCharacter(char ch) {
        queue.add(ch);
    }

    static char popCharacter() {
        return stack.pop();
    }

    static char dequeueCharacter() {
        return queue.remove();
    }

    public int divisorSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                sum += i;
            }
            int x = 3, y = 3;
            System.out.println(Math.pow(x, y));
            //    System.out.println(i+"  "+n+" "+n%i);
        }
        // System.out.println("I implemented: AdvancedArithmetic");
        //  System.out.println(sum);
        return sum;
    }

    public int power(int n, int p) {
        if (n < 0 || p < 0) {
            throw new NumberFormatException("n and p should be non-negative");
        }
        return (int) Math.pow(n, p);
    }

    // Complete the morganAndString function below.
    static String morganAndString1(String a, String b) {
        char[] toCharArrayA = a.toCharArray();
        char[] toCharArrayB = b.toCharArray();
        int aLength = toCharArrayA.length;
        int bLength = toCharArrayB.length;
        boolean aGreaterLength = true;
        int minlength = bLength;
        if (aLength < bLength) {
            aGreaterLength = false;
            minlength = aLength;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < minlength; i++) {
            sb.append(toCharArrayB[i]);
            sb.append(toCharArrayA[i]);
//            queue.add(toCharArrayB[i]);
//           queue.add(toCharArrayA[i]);
            if (i == minlength - 1 && aGreaterLength) {
                for (int j = i; j < aLength; j++) {
                    sb.append(toCharArrayA[j]);
                }
            }
            //         queue.add(toCharArrayA[j]);
            if (i == minlength - 1 && !aGreaterLength) {
                for (int j = i; j < bLength; j++) {
                    sb.append(toCharArrayB[j]);
                }
            }
            //      queue.add(toCharArrayB[j]);
        }
        //System.out.println(sb.toString());
//        String val = "";
        return sb.toString();
    }

    // Complete the morganAndString function below.
    static String morganAndString(String a, String b) {
//        a= a.replaceAll("([a-z])", "");
//        b= b.replaceAll("([a-z])", "");
        int aLength = a.toCharArray().length;
        int bLength = b.toCharArray().length;
        int maxlength = aLength + bLength;

        Queue<Character> queueA = new LinkedList<>();
        Queue<Character> queueB = new LinkedList<>();
        for (int i = 0; i < aLength; i++) {
            queueA.add(a.charAt(i));
        }

        for (int i = 0; i < bLength; i++) {
            queueB.add(b.charAt(i));
        }
        char qA = 0;
        char qB = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < maxlength; i++) {
            if (queueA.isEmpty() && queueB.isEmpty()) {
                break;
            }
            System.out.println(i+ "A"+queueA);
            System.out.println(i+ "B"+queueB);
            System.out.println(i+ "R"+sb.toString());
            if (qA == 0 && !queueA.isEmpty()) {
                qA = queueA.remove();
            }
            if (qB == 0 && !queueB.isEmpty()) {
                qB = queueB.remove();
            }
            if (qA != 0 && qB != 0) {
                if (qA < qB) {
                    sb.append(qA);
                    qA = 0;
                    continue;

                } else if (qA > qB) {
                    sb.append(qB);
                    qB = 0;
                    continue;

                } else {
                    if (a.substring(aLength-queueA.size()-1).compareTo(b.substring(bLength-queueB.size()-1)) <= 0) {
                        sb.append(qA);
                        qA = 0;
                    } else {
                        sb.append(qB);
                        qB = 0;
                    }
                    continue;

                }
            } else if (qA != 0) {
                aLength = queueA.size();
                sb.append(qA);
                for (int j = 0; j < aLength; j++) {
                    qA = queueA.remove();
                    sb.append(qA);
                }
            } else if (qB != 0) {
                bLength = queueB.size();
                sb.append(qB);
                for (int j = 0; j < bLength; j++) {
                    qB = queueB.remove();
                    sb.append(qB);
                }
            }
            System.out.println(sb.toString());

        }
        return sb.toString();
    }

    public static void main(String[] args) {
       morganAndString("YZYYZYZYY", "ZYYZYZYY");
        int compareTo = "YZYYZYZYY".compareTo("ZYYZYZYY");
        System.out.println(compareTo);
        //YZYYZYYZYZYYZYZYY
        //YZYYZZYZYZYY
        //YZYYZYZYYZYYZYZYY
        System.out.println("YZYYZYZYY".substring("YZYYZYZYY".length()-1-3));
               // .compareTo("ZYYZYZYY");
    }
}
