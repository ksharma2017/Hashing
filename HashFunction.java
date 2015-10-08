public class HashFunction extends Hasher
{
    public int hash(Object obj){
        String mem = obj.toString();
        boolean stop = false;
        while (stop==false){
            if (mem.charAt(0)=='@'){
                stop = true;
            }
            mem = mem.substring(1,mem.length());
        }
        long hashcode = Long.parseLong(mem, 16);
        //System.out.println(hashcode);
        hashcode *= sumDigits(hashcode);
        //System.out.println(hashcode);
        hashcode += productDigits(hashcode);
        //System.out.println(hashcode);
        hashcode += sumEveryOtherDigit(hashcode);
        //System.out.println(hashcode);
        hashcode += productEveryOtherDigit(hashcode);
        //System.out.println(hashcode);
        //System.out.println(makeIntoInt(hashcode));
        return makeIntoInt(hashcode);
    }
    
    private int sumDigits(long n){
        int sum = 0;
        while (n>0){
            sum+=n%10;
            n/=10;
        }
        return sum;
    }
    
    private int productDigits(long n){
        int product = 1;
        n/=10;
        while (n>0){
            if (n%10!=0){
                product*=n%10;
            }
            n/=10;
        }
        return product;
    }
    
    private int sumEveryOtherDigit(long n){
        int sum = 0;
        n/=10;
        while (n>0){
            sum+=n%10;
            n/=100;
        }
        return sum;
    }
    
    private int productEveryOtherDigit(long n){
        int product = 1;
        n/=10;
        while (n>0){
            if (n%10!=0){
                product*=n%10;
            }
            n/=100;
        }
        return product;
    }
    
    private int makeIntoInt(long n){
        while(n>2147483647){
            n-=2147483647;
        }
        return (int) n;
    }
    
    public String getCoderName(){
        return "Kartikeya";
    }
}