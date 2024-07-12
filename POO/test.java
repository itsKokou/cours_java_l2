
public class test {
    public static void main(String[] args) {
        //---------------METHODE 1------------------------
        // String ch = "CPT";
        // String str = "100";
        // int width = 5;

        // String formatted = String.format("%0" + width + "d", Integer.valueOf(str));
        // ch+=formatted;
        // System.out.println(ch);
        //----------------------------------------------------

        // ---------------METHODE 2----------------------------
        String ch = "CPT";
        String str = String.format("%05d",100);
        ch +=str;
        System.out.println(ch);
    }
    
}
