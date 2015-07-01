public class EANValidator {    
    public static boolean validate(final String eanCode) {
        int checkSum = Character.getNumericValue(eanCode.charAt(12)); 
        int accumulation = 0; 
        for (int i = 0; i < 12; i++) {
            Integer data = Character.getNumericValue(eanCode.charAt(i)); 
            if ((i % 2) == 0) {
                accumulation = accumulation + data; 
            } else {
                accumulation = accumulation + data * 3 ; 
            }
        }
        if ((accumulation % 10) == 0) { return 0 == checkSum;} 
        else {
            return (10 - (accumulation % 10) == checkSum);  
        }
    }
}
