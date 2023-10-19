package javaProgramPackage;

public class tripletOfVoewels {
    
    public static void main(String[] args) 
    {
        tripletOfVoewels tri=new tripletOfVoewels();
        System.out.println(tri.maxVowels("weallloveyou", 7));
        
    }

    public int maxVowels(String s, int k) {
        
        int len=s.length();
        char[] c=s.toCharArray();
        int count=0;
        int i=0,j=0,k1=k;
        int backup=0;

        int max=0;
        while(i<len)
        {
            j=i;
            //Using Window sliding technic
            int frame=i+k;
            while(j<len && j<frame && isCharisVowels(c[j])) //1<3 && true //1<k && 
            {
                j++; //1 //2 //3
                backup++; 
            }
           if(max<backup) max=backup;
            
            i++;
            backup=0;
        }

    return max;

    }

    boolean isCharisVowels(char c)
        {
            String vowelsStr="aeiouAEIOU";
            return vowelsStr.contains(String.valueOf(c))?true:false;

        }
}

