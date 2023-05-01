

public class HeapSort extends BaseArquivo {
    
    public static void heapSort(String[][] dados) {
        int n = dados.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(dados, n, i);
        }
        for (int i = n - 1; i >= 0; i--) {
            String[] temp = dados[0];
            dados[0] = dados[i];
            dados[i] = temp;
            heapify(dados, i, 0);
        }
    }
    
    public static void heapify(String[][] dados, int n, int i) {
        int maior = i;
        int esquerda = 2 * i + 1; 
        int direita = 2 * i + 2; 

        if (esquerda < n && compararValores(dados[esquerda][2].trim(), dados[maior][2].trim()) > 0) {
            maior = esquerda;
        }
        if (direita < n && compararValores(dados[direita][2].trim(), dados[maior][2].trim()) > 0) {
            maior = direita;
        }
        if (maior != i) {
            String[] troca = dados[i];
            dados[i] = dados[maior];
            dados[maior] = troca;
            heapify(dados, n, maior);
        }
    }
    
    public static int compararValores(String valor1, String valor2) {
        if (valor1.isEmpty() && valor2.isEmpty()) {
            return 0;
        } else if (valor1.isEmpty()) {
            return -1;
        } else if (valor2.isEmpty()) {
            return 1;
        } else {
            int intValue1 = Integer.parseInt(valor1);
            int intValue2 = Integer.parseInt(valor2);
            return Integer.compare(intValue2, intValue1);
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

private static void heapify(String[][] dados, int n, int i, int indiceMes) {
    int maior = i;
    int esquerda = 2 * i + 1;
    int direita = 2 * i + 2;

    if (esquerda < n && extrairMes(dados[esquerda][indiceMes]) > extrairMes(dados[maior][indiceMes])) {
        maior = esquerda;
    }
    
    if (direita < n && extrairMes(dados[direita][indiceMes]) > extrairMes(dados[maior][indiceMes])) {
        maior = direita;
    }
    
    if (maior != i) {
        String[] temp = dados[i];
        dados[i] = dados[maior];
        dados[maior] = temp;
    
        heapify(dados, n, maior, indiceMes);
    }
}

public static void heapSortMes(String[][] dados) {
    int n = dados.length;
    int indiceMes = 1;

    for (int i = n / 2 - 1; i >= 0; i--) {
        heapify(dados, n, i, indiceMes);
    }

    for (int i = n - 1; i >= 0; i--) {
        String[] temp = dados[0];
        dados[0] = dados[i];
        dados[i] = temp;

        heapify(dados, i, 0, indiceMes);
    }
}
   //////CAMPO LENTH //////
   public static void medioCaso() {
    String arquivoDeEntrada = "Leda-Projeto//Arquivos-Base//passwords_formated_data.csv"; // Caminho do arquivo de entrada
    String arquivoMedioCaso = "Leda-Projeto//Arquivos//passwords_length_heapSort_medioCaso.csv"; // Caminho do arquivo de saída
    
    String[][] data = readCSV(arquivoDeEntrada);
    if (data != null) {
        heapSort(data);
        writeCSV(data, arquivoMedioCaso);
    } else {
        System.out.println("O arquivo de entrada está vazio.");
    }
}
public static void melhorCaso() {
    String arquivoMedioCaso = "Leda-Projeto//Arquivos//passwords_length_heapSort_medioCaso.csv"; // Caminho do arquivo de saída
    String arquivoMelhorCaso = "Leda-Projeto//Arquivos//passwords_length_heapSort_melhorCaso.csv";

    String[][] data = readCSV(arquivoMedioCaso);
    if (data != null) {
        heapSort(data);
        writeCSV(data, arquivoMelhorCaso);
    } else {
        System.out.println("O arquivo de entrada está vazio.");
    }
    
}
public static void piorCaso() {
    String arquivoPiorCaso = "Leda-Projeto//Arquivos//passwords_length_heapSort_piorCaso.csv";
    String arquivoDeEntrdaPiorCaso = "Leda-Projeto//Arquivos-Base//passwords_formated_data_crescente.csv";

    String[][] data = readCSV(arquivoDeEntrdaPiorCaso);
    if (data != null) {
        heapSort(data);
        writeCSV(data, arquivoPiorCaso);
    } else {
        System.out.println("O arquivo de entrada está vazio.");
    }
    
}
////// CAMPO MÊS //////
    public static void medioCasoMes() {
        String arquivoDeEntrada = "Leda-Projeto//Arquivos-Base//passwords_formated_data.csv";
        String[][] data = readCSV(arquivoDeEntrada);

        heapSortMes(data);
        String arquivoDeSaida = "Leda-Projeto//Arquivos//passwords_data_month_heapSort_medioCaso.csv";
        writeCSV(data, arquivoDeSaida);
    }

    public static void melhorCasoMes() {
        String arquivoDeEntrada = "Leda-Projeto//Arquivos//passwords_data_month_heapSort_medioCaso.csv";
        String[][] data = readCSV(arquivoDeEntrada);

        heapSortMes(data);
        String arquivoDeSaida = "Leda-Projeto//Arquivos//passwords_data_month_heapSort_melhorCaso.csv";
        writeCSV(data, arquivoDeSaida);
    }

    public static void piorCasoMes() {
        String arquivoDeEntrada = "Leda-Projeto//Arquivos-Base//passwords_formated_data_month_decrescente.csv";
        String[][] data = readCSV(arquivoDeEntrada);

        heapSortMes(data);
        String arquivoDeSaida = "Leda-Projeto//Arquivos//passwords_data_month_heapSort_piorCaso.csv";
        writeCSV(data, arquivoDeSaida);
    }
    
}

