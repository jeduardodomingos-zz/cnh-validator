package br.com.student;

import br.com.student.service.CnhValidatorService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        CnhValidatorService c = new CnhValidatorService();
        Scanner sc = new Scanner(System.in);
        String entryValue = "";

        int continueOption = 0;

        do {
            System.out.println("Informe a CNH para validação: " );
            entryValue = sc.next();

            System.out.println("A CNH " + entryValue + " é " + (c.validateCnh(entryValue) ? "Válida" : "Inválida"));

            System.out.println("Deseja validar uma nova cnh ? (1 - Sim | 2 - Não)\n");
            continueOption = sc.nextInt();

            while(continueOption != 2 && continueOption != 1){
                System.out.println("Opção inválida ! Informe uma opção válida para continuar! (1 - Sim | 2 - Não)\n");
                continueOption = sc.nextInt();
            }
        }while (continueOption == 1);

        System.out.println("Consulta Finalizado.");
    }
}
