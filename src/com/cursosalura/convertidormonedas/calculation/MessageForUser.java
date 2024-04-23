package com.cursosalura.convertidormonedas.calculation;

public class MessageForUser {


    public void showMessageToUser(String proceso) {


        System.out.print("Selecciona el número de la opción de la moneda que desea " + proceso + ": ");

    }

    public void showCurrencyMessage() {
            System.out.println("""
            ***************************************************************************************************
            
                 1. Dólar Australiano (AUD)    |  2. Real Brasileño (BRL)    |  3. Dólar Canadiense (CAD)
                 4. Franco Suizo (CHF)         |  5. Yuan Chino (CNY)        |  6. Corona Danesa (DKK)
                 7. Euro (EUR)                 |  8. Libra Esterlina (GBP)   |  9. Dólar de Hong Kong (HKD)
                10. Rupia India (INR)          | 11. Yen Japonés (JPY)       | 12. Won Surcoreano (KRW)
                13. Rupia Sri Lanka (LKR)      | 14. Peso mexicano (MXN)     | 15. Ringgit Malayo (MYR)
                16. Corona Noruega (NOK)       | 17. Dolar Neozelandés (NZD) | 18. Corona Sueca (SEK)
                19. Dólar de Singapur (SGD)    | 20. Baht Tailandés (THB)    | 21. Nuevo dólar Taiwanés (TWD)
                22. Dólar Estadounidense (USD) | 23. Rand Sudafricano (ZAR)  | 24. Salir
                
            ***************************************************************************************************
            """);

    }










}
