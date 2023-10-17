package javaProgramPackage;

class gcd
{
    
    public static void main(String[] args) 
    {
        System.out.println("gcdOfStrings(ABCABC,ABC) -" +gcdOfStrings("ABCABC","ABC"));
        System.out.println("gcdOfStrings(Leet,Code) -" +gcdOfStrings("Leet","Code"));

    }
    public static String  gcdOfStrings(String str1, String str2) {
        
        
        if(!(str1+str2).equals(str2+str1))
         {  
            return "";
         }
        
         return str1.substring(0,gcd(str1.length(),str2.length()))  ;    
         
    }
           
    public static int gcd(int a,int b)
    {
        return b == 0?a:gcd(b,a%b);
    }


}