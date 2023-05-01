public class QuickSort extends BaseArquivo{
    
    public static void quickSort(String[][] data, int baixo, int alto) {
        if (baixo < alto) {
            int partitionIndex = partition(data, baixo, alto);
            quickSort(data, baixo, partitionIndex - 1);
            quickSort(data, partitionIndex + 1, alto);
        }
    }

    public static int partition(String[][] data, int baixo, int alto) {
        String pivoLength = data[alto][2].trim();
        int pivo = Integer.parseInt(pivoLength);
        int i = baixo - 1;
        for (int j = baixo; j < alto; j++) {
            String elementoLength = data[j][2].trim();
            int elemento = Integer.parseInt(elementoLength);
            if (elemento > pivo) {
                i++;
                String[] temp = data[i];
                data[i] = data[j];
                data[j] = temp;
            }
        }
        String[] temp = data[i + 1];
        data[i + 1] = data[alto];
        data[alto] = temp;
        return i + 1;
    }
    
    private static int extractMonth(String dateString) {
        String[] partes = dateString.split(" ")[0].split("/");
        if (partes.length >= 2) {
            return Integer.parseInt(partes[1]);
        } else {
            return -1; 
        }
    }

    private static int partitionMes(String[][] data, int baixo, int alto) {
        String[] pivo = data[alto];
        int i = baixo - 1;
        for (int j = baixo; j <= alto - 1; j++) {
            String dateString = data[j][1].trim();
            int mes = extractMonth(dateString);
            if (mes < extractMonth(pivo[1].trim())) {
                i++;
                String[] temp = data[i];
                data[i] = data[j];
                data[j] = temp;
            }
        }
        String[] temp = data[i + 1];
        data[i + 1] = data[alto];
        data[alto] = temp;
        return i + 1;
    }
    
    private static void quickSortMes(String[][] data, int baixo, int alto) {
        if (baixo < alto) {
            int pi = partitionMes(data, baixo, alto);
            quickSortMes(data, baixo, pi - 1);
            quickSortMes(data, pi + 1, alto);
        }
    }


    //////CAMPO LENTH //////
    public static void medioCaso() {
        String arquivoDeEntrada = "Arquivos-Base//passwords_formated_data.csv"; 
        String arquivoMedioCaso = "Arquivos//passwords_length_quickSort_medioCaso.csv"; 
    
        String[][] data = readCSV(arquivoDeEntrada);
        if (data != null) {
            quickSort(data, 0, data.length - 1);
            writeCSV(data, arquivoMedioCaso);
        } else {
            System.out.println("O arquivo de entrada está vazio.");
        }
    }
    public static void melhorCaso() {
        String arquivoMedioCaso = "Arquivos//passwords_length_quickSort_medioCaso.csv"; 
        String arquivoMelhorCaso = "Arquivos//passwords_length_quickSort_melhorCaso.csv";

        String[][] data = readCSV(arquivoMedioCaso);
        if (data != null) {
            quickSort(data, 0, data.length - 1);
            writeCSV(data, arquivoMelhorCaso);
        } else {
            System.out.println("O arquivo de entrada está vazio.");
        }
    }

    public static void piorCaso() {
        String arquivoDeEntradaPiorCaso = "Arquivos-Base//passwords_formated_data_crescente.csv"; 
        String arquivoPiorCaso = "Arquivos//passwords_length_quickSort_piorCaso.csv"; 
        
        String[][] data = readCSV(arquivoDeEntradaPiorCaso);
        if (data != null) {
            quickSort(data, 0, data.length - 1);
            writeCSV(data, arquivoPiorCaso);
        } else {
            System.out.println("O arquivo de entrada está vazio.");
        }
    }

        
    ///// CAMPO MÊS //////
    public static void medioCasoMes() {
        String arquivoDeEntrada = "Arquivos-Base//passwords_formated_data.csv";
        String[][] data = readCSV(arquivoDeEntrada); 
        quickSortMes(data, 0, data.length - 1);  

        String arquivoDeSaida = "Arquivos//passwords_data_month_quickSort_medioCaso.csv" ;
        writeCSV(data, arquivoDeSaida);
        
    }
    public static void melhorCasoMes() {
        String arquivoDeEntrada = "Arquivos//passwords_data_month_quickSort_medioCaso.csv";
        String[][] data = readCSV(arquivoDeEntrada); 
        quickSortMes(data, 0, data.length - 1);  

        String arquivoDeSaida = "Arquivos//passwords_data_month_quickSort_melhorCaso.csv" ;
        writeCSV(data, arquivoDeSaida);
        
    }
    public static void piorCasoMes() {
        String arquivoDeEntrada = "Arquivos-Base//passwords_formated_data_month_decrescente.csv";
        String[][] data = readCSV(arquivoDeEntrada); 
        quickSortMes(data, 0, data.length - 1); 

        String arquivoDeSaida = "Arquivos//passwords_data_month_quickSort_piorCaso.csv" ;
        writeCSV(data, arquivoDeSaida);
        
    }
}