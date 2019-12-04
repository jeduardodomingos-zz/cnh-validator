package br.com.student;

import br.com.student.service.CnhValidatorService;

public class Main {

    public static void main(String[] args) {
        CnhValidatorService c = new CnhValidatorService();

        System.out.println(c.validateCnh(""));
    }
}
