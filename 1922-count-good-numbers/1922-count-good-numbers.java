class Solution {
    static final int MOD = 1_000_000_007;
    public int countGoodNumbers(long n) {

        long evencount= (n+1)/2;
        long oddcount= n/2;

        long evenways= power(5,evencount);
        long oddways =power(4,oddcount);

        return (int)((evenways *oddways) %MOD) ;
        
    }
     private long power(long base, long n){
        long result =1;
         base= base %MOD;
        while(n>0){
            if(n%2==1){
                result = (result *base) %MOD;
            }
            base =(base*base) % MOD;
            n/=2;
        }
        return result;
     }

}