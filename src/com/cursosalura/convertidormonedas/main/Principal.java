package com.cursosalura.convertidormonedas.main;

import com.cursosalura.convertidormonedas.calculation.MessageForUser;
import com.cursosalura.convertidormonedas.calculation.RequestData;
import com.cursosalura.convertidormonedas.calculation.WriteRequests;
import com.cursosalura.convertidormonedas.exceptions.InvalidOptionsException;
import com.cursosalura.convertidormonedas.exceptions.ProgramExitException;
import com.cursosalura.convertidormonedas.models.ExchangeRateInput;
import com.cursosalura.convertidormonedas.models.UserInput;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        MessageForUser messageData = new MessageForUser();
        Scanner scanner = new Scanner(System.in);


        RequestData requestData = new RequestData();
        WriteRequests writer = new WriteRequests();
        ArrayList<UserInput> allElements = new ArrayList<>();


        messageData.showCurrencyMessage();

        while (true) {


            try {
                UserInput model = new UserInput();

                messageData.showMessageToUser("cambiar");
                model.setCurrentCurrency(getCurrencyFromUser(scanner));

                messageData.showMessageToUser("obtener");
                model.setNewCurrency(getCurrencyFromUser(scanner));


                ExchangeRateInput data = requestData.requestDataFromExchange(model.getCurrentCurrency());

                float factor = data.conversion_rates().get(model.getNewCurrency());

                conversionMethod( factor, scanner, model);
                allElements.add(model);


                if(!otherOptions(scanner, messageData, writer, model, allElements)){
                    System.out.println("Gracias por usar nuestros servicios, vuelva pronto.");
                    break;
                }

            } catch (IllegalArgumentException e) {
                System.out.println("Error en la url, verifique la dirección");

            } catch (ProgramExitException e) {
                System.out.println(e.getMessage());
                break;
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Error, Ingrese un valor válido.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static String getCurrencyFromUser(Scanner scanner) throws ProgramExitException {

        int selectedOption;
        String currency = "";


        selectedOption = scanner.nextInt();
        if (selectedOption == 24) {
            throw new ProgramExitException("\nPrograma finalizado. Gracias por usar nuestros servicios, vuelva pronto.");
        }

        try {
            verifyOptionIsValid(selectedOption);
            currency = getCurrentToRequest(selectedOption);


        } catch (InputMismatchException e) {
            scanner.nextLine();
            System.out.println("\nError: Entrada inválida. Intente de nuevo");
        } catch (InvalidOptionsException e) {
            System.out.println(e.getMessage());
        }

        return currency;


    }

    public static void verifyOptionIsValid(int option) throws InvalidOptionsException {
        if (option <= 0 || option > 24) {

            throw new InvalidOptionsException("Opción inválida, intente de nuevo.");
        }

    }

    public static String getCurrentToRequest(int selectedOption) {
        String currency = "";


        switch (selectedOption) {
            case 1:
                currency = "AUD";
                break;
            case 2:
                currency = "BRL";
                break;
            case 3:
                currency = "CAD";
                break;
            case 4:
                currency = "CHF";
                break;
            case 5:
                currency = "CNY";
                break;
            case 6:
                currency = "DKK";
                break;
            case 7:
                currency = "EUR";
                break;
            case 8:
                currency = "GBP";
                break;
            case 9:
                currency = "HKD";
                break;
            case 10:
                currency = "INR";
                break;
            case 11:
                currency = "JPY";
                break;
            case 12:
                currency = "KRW";
                break;
            case 13:
                currency = "LKR";
                break;
            case 14:
                currency = "MXN";
                break;
            case 15:
                currency = "MYR";
                break;
            case 16:
                currency = "NOK";
                break;
            case 17:
                currency = "NZD";
                break;
            case 18:
                currency = "SEK";
                break;
            case 19:
                currency = "SGD";
                break;
            case 20:
                currency = "THB";
                break;
            case 21:
                currency = "TWD";
                break;
            case 22:
                currency = "USD";
                break;
            case 23:
                currency = "ZAR";
                break;
            default:
                System.out.println("Error");
                break;

        }
        return currency;

    }

    private static void conversionMethod(float conversionFactor, Scanner scanner, UserInput model) {
        float changedCurrency;
        float valueToChange;
        System.out.print("Ingrese el valor monetario que desea convertir: $ ");
        model.setCurrencyValue(scanner.nextFloat());

        changedCurrency = model.getCurrencyValue() * conversionFactor;

        model.setNewCurrencyValue((float) (Math.round(changedCurrency * 100.00) / 100.00));



        System.out.println("\n------------------------------------------------------------");
        System.out.println("El valor de cambio de " + model.getCurrencyValue() + " " + model.getCurrentCurrency() + " a " + model.getNewCurrency() +
                " es de $ " + model.getNewCurrencyValue() + " (" + model.getNewCurrency() + ").");
        System.out.println("------------------------------------------------------------");
    }

    private static boolean otherOptions(Scanner scanner, MessageForUser messageData, WriteRequests writer, UserInput model, ArrayList<UserInput> allElements) throws IOException {
        int continueConvert;

        System.out.println("\n¿Desea hacer otra conversión? Selecciona el número de la opción que prefieras.");
        System.out.println("1. Sí. | 2. No, deseo salir del programa sin imprimir los registros. | 3. Imprimir los registros que he consultado y luego salir.");
        continueConvert = scanner.nextInt();


        if (continueConvert == 1) {
            messageData.showCurrencyMessage();
            return true;

        } else if (continueConvert == 2) {
            allElements.clear();
            return false;
        } else if (continueConvert == 3) {
            writeAFile(writer,model, allElements );

            return false;
        } else {
            System.out.println("(Opción inválida, por favor intente de nuevo. ");
            return otherOptions(scanner, messageData, writer, model, allElements);
        }
    }

    public static void writeAFile(WriteRequests writer, UserInput model, ArrayList<UserInput> allElements) throws IOException {

       try {

           writer.saveJson(allElements);
       } catch (IOException e){
           System.out.println(e.getMessage());
       }
    }

}
