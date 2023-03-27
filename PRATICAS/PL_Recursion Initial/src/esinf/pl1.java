package esinf;

public class pl1 {
    public static String reversString(String value) {
        if (value.length() == 0) {
            return "";
        }
        //invocando recursivamente tirando o caracter mais a esquerda e quando for 0 acaba e vai somando o carater que tirou nesse
        //momento
        return reversString(value.substring(1)) + value.charAt(0);
    }

    public static int productOfIntegers(int m, int n) {
        if (n == 0) {
            return 0;

        }
        return m + productOfIntegers(m, n - 1);
    }

    public static int greatestCommonDivisor(int m, int n) {
        int k = 0;
        if (m < n)
            k = m;
        if (m > n)
            k = n;
        if (m == n)
            k = m;
        return greatestCD(m, n, k);

    }

    public static int greatestCD(int m, int n, int k) {
        if (m % k == 0 && n % k == 0) {
            return k;
        }
        k--;
        return greatestCD(m, n, k);
    }
    //outro metodo de fazer o maximodivisorcomum

    public static int mdc(int m, int n) {
        if (n < m) {
            return mdc(n, m);
        } else {
            if (/* n>= m && */n % m == 0) {
                return m;


            }else{
                return mdc(m, n % m);
            }
        }

    }

    public static int convertStringToInteger(String a) {
        return returnStringToInt(a, 0);
    }

    public static int returnStringToInt(String a, int k) {
        if (a.length() == 0) {
            return k;
        }
        //percorre a string e vai adicionando a k cada numero
        k = (int) (k + (Math.pow(10, a.length() - 1) * Integer.parseInt(String.valueOf(a.charAt(0)))));

        return returnStringToInt(a.substring(1), k);
    }
    //outro metodo returnstringtoint


    public static String isPalindrome(int a){
        if(isP( a,  a,  0)) return "É palindromo";
        return "Não é palindromo.";
    }

    public static boolean isP(int a, int b, int res) {
        if (b == 0) {
            return a == res;
        }
        res = res * 10 + b % 10;
        b -= b % 10;
        b = b / 10;
        return isP(a, b, res);
    }

    public static int sumarray(int [][] a , int i , int j){
        if(a.length == 0 ) return 0; //valido se vazio
        if(i== a.length -1 && j==a[0].length-1){
            return a[i][j];
        }
        int s = a[i][j];
        j++;
        if(j ==a[0].length){
            i++;
            j=0;
        }
        return s +sumarray(a,i,j);
    }


    public static void main(String[] args) {
        System.out.println(reversString("aaaabbbb"));
        System.out.println(productOfIntegers(3, 2));
        System.out.println(greatestCommonDivisor(3, 9));
        System.out.println(convertStringToInteger("12345"));
        System.out.println(isPalindrome(232));
        int[][] a = {{1, 2}, {3, 4}};
        int x = 0;
        int y = 0;
        System.out.println(sumarray(a, x, y));
        


    }
}
