public class Counting extends BaseArquivo{

    public static void countingSort(String[][] dados) {
        int n = dados.length;
        int maximo = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            String elemento = dados[i][2].trim();
            int valor = Integer.parseInt(elemento);
            if (valor > maximo) {
                maximo = valor;
            }
        }

        int[] contagem = new int[maximo + 1];
        for (int i = 0; i < n; i++) {
            String elemento = dados[i][2].trim();
            int valor = Integer.parseInt(elemento);
            contagem[maximo - valor]++;
        }

        for (int i = 1; i <= maximo; i++) {
            contagem[i] += contagem[i - 1];
        }

        String[][] dadosOrdenados = new String[n][];
        for (int i = n - 1; i >= 0; i--) {
            String elemento = dados[i][2].trim();
            int valor = Integer.parseInt(elemento);
            int indice = contagem[maximo - valor]--;

            dadosOrdenados[indice - 1] = dados[i];
        }

        for (int i = 0; i < n; i++) {
            dados[i] = dadosOrdenados[i];
        }
    }

    private static int extrairMes(String dataString) {
        String[] partes = dataString.split(" ")[0].split("/");
        if (partes.length >= 2) {
            return Integer.parseInt(partes[1]);
        } else {
            return -1; 
        }
    }

    public static void countingSortMes(String[][] dados) {
        int n = dados.length;
        int maximo = 12;

        int[] contagem = new int[maximo + 1];
        for (int i = 0; i < n; i++) {
            if (dados[i] != null && dados[i].length > 1 && dados[i][1] != null) {
                String dataString = dados[i][1].trim();
                int mes = extrairMes(dataString);
                if (mes >= 1 && mes <= maximo) {
                    contagem[mes]++;
                }
            }
        }

        for (int i = 1; i <= maximo; i++) {
            contagem[i] += contagem[i - 1];
        }

        String[][] dadosOrdenados = new String[n][];
        for (int i = n - 1; i >= 0; i--) {
            if (dados[i] != null && dados[i].length > 1 && dados[i][1] != null) {
                String dataString = dados[i][1].trim();
                int mes = extrairMes(dataString);
                if (mes >= 1 && mes <= maximo) {
                    int indice = contagem[mes]--;
                    dadosOrdenados[indice - 1] = dados[i];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            dados[i] = dadosOrdenados[i];
        }
    }


    //////CAMPO LENTH //////
    public static void medioCaso() {
        String arquivoDeEntrada = "Arquivos-Base//passwords_formated_data.csv";
        String arquivoMedioCaso = "Arquivos//passwords_length_counting_medioCaso.csv"; 
        
        String[][] data = readCSV(arquivoDeEntrada);
        if (data != null) {
            countingSort(data);
            writeCSV(data, arquivoMedioCaso);
        } else {
            System.out.println("O arquivo de entrada está vazio.");
        }
    }

    public static void melhorCaso() {
        String arquivoMedioCaso = "Arquivos//passwords_length_counting_medioCaso.csv"; 
        String arquivoMelhorCaso = "Arquivos//passwords_length_counting_melhorCaso.csv";

        String[][] data = readCSV(arquivoMedioCaso);
        if (data != null) {
            countingSort(data);
            writeCSV(data, arquivoMelhorCaso);
        } else {
            System.out.println("O arquivo de entrada está vazio.");
        }    
    }

    public static void piorCaso() {
        String arquivoPiorCaso = "Arquivos//passwords_length_counting_piorCaso.csv";
        String arquivoDeEntrdaPiorCaso = "Arquivos-Base//passwords_formated_data_crescente.csv";

        String[][] data = readCSV(arquivoDeEntrdaPiorCaso);
        if (data != null) {
            countingSort(data);
            writeCSV(data, arquivoPiorCaso);
        } else {
            System.out.println("O arquivo de entrada está vazio.");
        }   
    }
    
    ////// CAMPO MÊS //////
    public static void medioCasoMes() {
      
        String arquivoDeEntrada = "Arquivos-Base//passwords_formated_data.csv";
        String[][] data = readCSV(arquivoDeEntrada); 
        countingSortMes(data); 

        String arquivoDeSaida = "Arquivos//passwords_data_month_counting_medioCaso.csv" ;
        writeCSV(data, arquivoDeSaida);
        
    }
    public static void melhorCasoMes() {
      
        String arquivoDeEntrada = "Arquivos//passwords_data_month_counting_medioCaso.csv";
        String[][] data = readCSV(arquivoDeEntrada); 
        countingSortMes(data); 

        String arquivoDeSaida = "Arquivos//passwords_data_month_counting_melhorCaso.csv" ;
        writeCSV(data, arquivoDeSaida);
        
    }
    public static void piorCasoMes() {
        
        String arquivoDeEntrada = "Arquivos-Base//passwords_formated_data_month_decrescente.csv";
        String[][] data = readCSV(arquivoDeEntrada); 
        countingSortMes(data); 

        String arquivoDeSaida = "Arquivos//passwords_data_month_counting_piorCaso.csv" ;
        writeCSV(data, arquivoDeSaida);
        
    }
    
}