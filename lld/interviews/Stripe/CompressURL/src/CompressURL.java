public class CompressURL {

    public static String[][] getSplitValue(String inputURL) {
        String[] separatedUsingSlash = inputURL.split("/");
        int size = separatedUsingSlash.length;
        String[][] res = new String[size][];
        int i=0;
        for(String slashSeparated: separatedUsingSlash) {
            String[] separatedUsingDot = slashSeparated.split("\\.");
            res[i] = separatedUsingDot;
            i++;
        }
        return res;
    }

    public static String compressString(String string) {
        StringBuilder sb = new StringBuilder();
        int size = string.length();
        sb.append(string.charAt(0));
        if (size-2>0)
            sb.append(size-2);
        if (size>1)
            sb.append(string.charAt(size-1));
        return sb.toString();
    }

    public static String compress(String compress) {
        return compress(compress, Integer.MAX_VALUE);
    }

    public static String compress(String string, int m) {
        String[][] separatorStrings = getSplitValue(string);
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<separatorStrings.length; i++) {
            int j;
            for(j=0;j<Math.min(m-1, separatorStrings[i].length);j++) {
                sb.append(compressString(separatorStrings[i][j]));
                if (j!=separatorStrings[i].length-1) {
                    sb.append(".");
                }
            }
            if (j<separatorStrings[i].length) {
                int count=0;
                char firstChar = separatorStrings[i][j].charAt(0);
                char lastChar = separatorStrings[i][j].charAt(separatorStrings[i][j].length()-1);
                while(j<separatorStrings[i].length) {
                    count+=separatorStrings[i][j].length() +1;
                    lastChar=separatorStrings[i][j].charAt(separatorStrings[i][j].length()-1);
                    j++;
                }
                count-=3;
                sb.append(firstChar).append(count).append(lastChar);
            }
            if (i!=separatorStrings.length-1) {
                sb.append("/");
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(compress("stripe.com/payments/checkout/customer.maria"));
        System.out.println(compress("stripe.com/payments/checkout/customer.maria", 1));
        System.out.println(compress("section/how.to.write.a.java.program.in.one.day"));
        System.out.println(compress("section/how.to.write.a.java.program.in.one.day",3));
    }
}
