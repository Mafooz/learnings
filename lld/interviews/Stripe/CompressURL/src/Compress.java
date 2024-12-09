public class Compress {
    public String compress(String s) {
        StringBuilder sb = new StringBuilder();
        String[] majors = s.split("/");
        for (int i = 0; i < majors.length; i++) {
            if (i > 0) {
                sb.append("/");
            }

            String major = majors[i];
            String[] minors = major.split("\\.");
            for (int j = 0; j < minors.length; j++) {
                String minor = compressPart(minors[j]);
                if (j > 0) {
                    sb.append(".");
                }
                sb.append(minor);
            }

        }
        return sb.toString();
    }

    public String compress(String s, int m) {
        StringBuilder sb = new StringBuilder();
        String[] majors = s.split("/");
        for (int i = 0; i < majors.length; i++) {
            if (i > 0) {
                sb.append("/");
            }

            String major = majors[i];
            String[] minors = major.split("\\.");

            char c1 = 0, c2 = 0;
            int len = 0;

            for (int j = 0; j < minors.length; j++) {
                if (j < m - 1) {
                    if (j > 0) {
                        sb.append(".");
                    }
                    String minor = compressPart(minors[j]);
                    sb.append(minor);
                    continue;
                }

                if (j == m - 1) {
                    c1 = minors[j].charAt(0);
                    len--;
                }
                if (j == minors.length - 1) c2 = minors[j].charAt(minors[j].length() - 1);
                len += minors[j].length() + 1;
            }

            if (len > 0) {
                if (m > 1) sb.append(".");
                sb.append(c1).append(len - 2).append(c2);
            }

        }
        return sb.toString();

    }

    private String compressPart(String s) {
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        sb.append(len - 2);
        sb.append(s.charAt(len - 1));
        return sb.toString();
    }

    public static void main(String[] args) {
        Compress comp = new Compress();
        System.out.println(comp.compress("stripe.com/payments/checkout/customer.maria"));
        System.out.println(comp.compress("stripe.com/payments/checkout/customer.maria", 1));
        System.out.println(comp.compress("section/how.to.write.a.java.program.in.one.day"));
        System.out.println(comp.compress("section/how.to.write.a.java.program.in.one.day", 3));
    }
}