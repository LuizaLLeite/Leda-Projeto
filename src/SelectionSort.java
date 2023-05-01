
public class SelectionSort extends BaseArquivo { 

    public static void selectionSort(String[][] dados) {
        int n = dados.length;
        for (int i = 0; i < n - 1; i++) {
            int indiceMax = i;
            for (int j = i + 1; j < n; j++) {
                String elemento1 = dados[j][2].trim();
                String elemento2 = dados[indiceMax][2].trim();
                int valor1 = Integer.parseInt(elemento1);
                int valor2 = Integer.parseInt(elemento2);
                if (valor1 > valor2) {
                    indiceMax = j;
                }
            }
            if (indiceMax != i) {
                String[] temp = dados[i];
                dados[i] = dados[indiceMax];
                dados[indiceMax] = temp;
            }
        }
    }
    
    public static void selectionSortMes(String[][] dados) {
        int n = dados.length;
    
        for (int i = 0; i < n - 1; i++) {
            int indiceMin = i;
    
            for (int j = i + 1; j < n; j++) {
                if (compararMeses(dados[j][1], dados[indiceMin][1]) < 0) {
                    indiceMin = j;
                }
            }
    
            trocar(dados, i, indiceMin);
        }
    }
    
    private static int compararMeses(String data1, String data2) {
        int mes1 = extrairMes(data1);
        int mes2 = extrairMes(data2);
    
        return Integer.compare(mes1, mes2);
    }
    
    private static void trocar(String[][] dados, int i, int j) {
        String[] temp = dados[i];
        dados[i] = dados[j];
        dados[j] = temp;
    }
    
    private static int extrairMes(String data) {
        String[] partes = data.split(" ")[0].split("/");
        if (partes.length >= 2) {
            return Integer.parseInt(partes[1]);
        } else {
            return -1;
        }
    }

    /////CAMPO LENGTH/////
    public static void medioCaso() {
        String arquivoDeEntrdada = "Arquivos-Base//passwords_formated_data.csv"; 
        String arquivoMedioCaso = "Arquivos//passwords_length_selectionSort_medioCaso.csv"; 
        
        String[][] data = readCSV(arquivoDeEntrdada);
        if (data != null) {
            selectionSort(data);
            writeCSV(data, arquivoMedioCaso);
        } else {
            System.out.println("O arquivo de entrada está vazio.");
        }
    }
    public static void melhorCaso() {
        String arquivoMedioCaso = "Arquivos//passwords_length_selectionSort_medioCaso.csv"; 
        String arquivoMelhorCaso = "Arquivos//passwords_length_selectionSort_melhorCaso.csv";

        String[][] data = readCSV(arquivoMedioCaso);
        if (data != null) {
            selectionSort(data);
            writeCSV(data, arquivoMelhorCaso);
        } else {
            System.out.println("O arquivo de entrada está vazio.");
        }
        
    }
    public static void piorCaso() {
        String arquivoPiorCaso = "Arquivos//passwords_length_selectionSort_piorCaso.csv";
        String arquivoDeEntrdadaPiorCaso = "Arquivos-Base//passwords_formated_data.csv";

        String[][] data = readCSV(arquivoDeEntrdadaPiorCaso);
        if (data != null) {
            selectionSort(data);
            writeCSV(data, arquivoPiorCaso);
        } else {
            System.out.println("O arquivo de entrada está vazio.");
        }
        
    }

    ////CAMPO MÊS ///////
    public static void medioCasoMes() {
        String filePath = "Arquivos-Base//passwords_formated_data.csv";
        String[][] data = readCSV(filePath);
        selectionSortMes(data);
    
        String outputFileName = "Arquivos//passwords_data_month_selectionSort_medioCaso.csv";
        writeCSV(data, outputFileName);
    }
    
    public static void melhorCasoMes() {
        String filePath = "Arquivos//passwords_data_month_selectionSort_medioCaso.csv";
        String[][] data = readCSV(filePath);
        selectionSortMes(data);
    
        String outputFileName = "Arquivos//passwords_data_month_selectionSort_melhorCaso.csv";
        writeCSV(data, outputFileName);
    }
    
    public static void piorCasoMes() {
        String filePath = "Arquivos-Base//passwords_formated_data_month_decrescente.csv";
        String[][] data = readCSV(filePath);
        selectionSortMes(data);
    
        String outputFileName = "Arquivos//passwords_data_month_selectionSort_piorCaso.csv";
        writeCSV(data, outputFileName);
    }
}