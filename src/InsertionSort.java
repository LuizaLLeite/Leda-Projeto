public class InsertionSort extends BaseArquivo {
    
    public static void insertionSort(String[][] dados) {
        int n = dados.length;
        for (int i = 1; i < n; i++) {
            String[] key = dados[i];
            int j = i - 1;
            while (j >= 0 && compareRows(dados[j], key) < 0) {
                dados[j + 1] = dados[j];
                j--;
            }
            dados[j + 1] = key;
        }
    }

    public static int compareRows(String[] linha1, String[] linha2) {
        String elemento1 = linha1[2].trim();
        String elemento2 = linha2[2].trim();
        int valor1 = elemento1.isEmpty() ? 0 : Integer.parseInt(elemento1);
        int valor2 = elemento2.isEmpty() ? 0 : Integer.parseInt(elemento2);
            return Integer.compare(valor1, valor2);
    }

    private static int extractMonth(String dateString) {
        String[] partes = dateString.split(" ")[0].split("/");
        if (partes.length >= 2) {
            return Integer.parseInt(partes[1]);
        } else {
            return -1; 
        }
    }

    private static void insertionSortMes(String[][] dados) {
        int n = dados.length;
        for (int i = 1; i < n; i++) {
            String[] key = dados[i];
            String dateString = key[1].trim();
            int mes = extractMonth(dateString);
            int j = i - 1;
            while (j >= 0 && extractMonth(dados[j][1].trim()) > mes) {
                dados[j + 1] = dados[j];
                j--;
            }
            dados[j + 1] = key;
        }
    }


    //////CAMPO LENTH //////
    public static void medioCaso() {
        String arquivoDeEntrdada = "Arquivos-Base//passwords_formated_data.csv"; 
        String arquivoMedioCaso = "Arquivos//passwords_length_insertionSort_medioCaso.csv"; 
        
        String[][] data = readCSV(arquivoDeEntrdada);
        if (data != null) {
            insertionSort(data);
            writeCSV(data, arquivoMedioCaso);
        } else {
            System.out.println("O arquivo de entrada está vazio.");
        }
    }
    public static void melhorCaso() {
        String arquivoMedioCaso = "Arquivos//passwords_length_insertionSort_medioCaso.csv"; 
        String arquivoMelhorCaso = "Arquivos//passwords_length_insertionSort_melhorCaso.csv";

        String[][] data = readCSV(arquivoMedioCaso);
        if (data != null) {
            insertionSort(data);
            writeCSV(data, arquivoMelhorCaso);
        } else {
            System.out.println("O arquivo de entrada está vazio.");
        }
        
    }
    public static void piorCaso() {
        String arquivoPiorCaso = "Arquivos//passwords_length_insertionSort_piorCaso.csv";
        String arquivoDeEntrdadaPiorCaso = "Arquivos-Base//passwords_formated_data_crescente.csv";

        String[][] data = readCSV(arquivoDeEntrdadaPiorCaso);
        if (data != null) {
            insertionSort(data);
            writeCSV(data, arquivoPiorCaso);
        } else {
            System.out.println("O arquivo de entrada está vazio.");
        }
        
    }

     ////// CAMPO MÊS //////
    public static void medioCasoMes() {
        String arquivoDeEntrada = "Projeto-leda//Arquivos-Base//passwords_formated_data.csv";
        String[][] data = readCSV(arquivoDeEntrada); 
        insertionSortMes(data); 

        String arquivoDeSaida = "Arquivos//passwords_data_month_insertionSort_medioCaso.csv" ;
        writeCSV(data, arquivoDeSaida);
        
    }
    public static void melhorCasoMes() {
        String arquivoDeEntrada = "Arquivos//passwords_data_month_insertionSort_medioCaso.csv";
        String[][] data = readCSV(arquivoDeEntrada); 
        insertionSortMes(data); 

        String arquivoDeSaida  = "Arquivos//passwords_data_month_insertionSort_melhorCaso.csv" ;
        writeCSV(data, arquivoDeSaida);
        
    }
    public static void piorCasoMes() {
        String arquivoDeEntrada = "Arquivos-Base//passwords_formated_data_month_decrescente.csv";
        String[][] data = readCSV(arquivoDeEntrada); 
        insertionSortMes(data); 

        String arquivoDeSaida  = "Arquivos//passwords_data_month_insertionSort_piorCaso.csv" ;
        writeCSV(data, arquivoDeSaida);
        
    }
}