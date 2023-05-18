package aku.com;

public class Solution {
private final String[] belowTen = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    
    private final String[] belowTwenty = new String[] 
    {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    
    private final String[] belowHundred = new String[] {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(long num) {
        if(num == 0){
            return "zero";
        }else{
            return helper(num);
        }
    }
    private String helper(long num){
        String ans = new String();
        if(num < 10){
            ans = belowTen[(int) num];
        }else if(num < 20){
            ans = belowTwenty[(int) (num-10)];
        }else if( num < 100){
            ans = belowHundred[(int) (num/10)] +" "+ helper(num%10);
        }else if( num < 1000){
            ans = helper(num / 100) + " Hundred " + helper(num % 100);
        }else if(num < 100000){
            ans = helper(num / 1000) + " Thousand " + helper(num%1000);
        }else if(num < 1000000){
            ans = helper(num / 100000) + " Lakh " + helper(num %100000);
        }else if(num < 1000000000){
            ans = helper(num / 1000000) + " Million " + helper(num %1000000);
        }else{
            ans = helper(num / 1000000000) + " Billion " + helper(num%1000000000);
        }
        return ans.trim();
    }
}
