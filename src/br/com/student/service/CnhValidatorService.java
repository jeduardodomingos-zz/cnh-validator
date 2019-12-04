package br.com.student.service;

public class CnhValidatorService {

    public boolean checkLength(String cnh){
        if(cnh != null){
            if(cnh.length() == 11){
                return true;
            }
        }

        return false;
    }

    public boolean checkNumeric(String cnh){
        long parsedCnh;

        try{
            parsedCnh = Long.parseLong(cnh);
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    public boolean checkDigit(String cnhNumber) {
        Long sum = 0L;
        Long firstModuleResult = 0L;
        Long secondModuleResult = 0L;
        Integer currentDigit;
        Long validatedDigit;

        Long firstDigit = Long.parseLong(cnhNumber.substring(9,10));
        Long secondDigit = Long.parseLong(cnhNumber.substring(10,11));

        boolean firstDigitValidated = false;
        boolean secondDigitValidated = false;

        for(int index = 9; index >= 1; index--){
            currentDigit = Integer.parseInt(cnhNumber.substring((9 - index), ((9 - index) + 1)));
            sum += (currentDigit * index);
        }

        firstModuleResult = sum%11;

        validatedDigit = firstModuleResult > 9 ? 0 : firstModuleResult;

        if(validatedDigit.equals(firstDigit)){
            firstDigitValidated = true;
        }

        sum = 0L;

        for (int index = 1; index <= 9; index++){
            currentDigit = Integer.parseInt(cnhNumber.substring((index - 1), ((index - 1) + 1)));
            sum += (currentDigit * index);
        }

        secondModuleResult = sum%11;

        if(firstModuleResult > 9){
            if((secondModuleResult - 2) < 0){
                secondModuleResult += 9;
            }else if ((secondModuleResult - 2) >= 0){
                secondModuleResult -= 2;
            }
        }

        validatedDigit = secondModuleResult > 9 ? 0 : secondModuleResult;

        if(validatedDigit.equals(secondDigit)){
            secondDigitValidated = true;
        }

        return firstDigitValidated && secondDigitValidated;
    }

    public boolean validateCnh(String cnhNumber){
        if(!checkLength(cnhNumber) || !checkNumeric(cnhNumber) || !checkDigit(cnhNumber)){
            return false;
        }

        return true;
    }

}
