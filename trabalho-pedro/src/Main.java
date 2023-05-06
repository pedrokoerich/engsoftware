import model.AdicionaGasto;
import model.CadastrarGanho;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        List<AdicionaGasto> listaGastos = new ArrayList<>();
        List<CadastrarGanho> listaGanhos = new ArrayList<>();
        int opcaoMenu = 0;

        Scanner in = new Scanner(System.in);

        // Inicio do codigo
        do {
            System.out.println("--- MENU DE CONSULTA - GESTÃO FINANCEIRA ---");
            System.out.println("1 - Cadastrar gasto");
            System.out.println("2 - Cadastrar ganho");
            System.out.println("3 - Mostrar gastos");
            System.out.println("4 - Mostrar ganhos");
            System.out.println("5 - Relatorio mensal");
            System.out.println("6 - Sair");

            opcaoMenu = in.nextInt();

            switch (opcaoMenu) {
                case 1:
                    System.out.print("Informe o tipo de gasto: ");
                    String tipoGasto = in.next();

                    System.out.print("Informe um nome para o gasto: ");
                    String gastoName = in.next();

                    System.out.print("Informe a data do gasto no padrão(ex: 19/02/2023): ");
                    String dataGastoIn = in.next();

                    System.out.print("Informe o valor do gasto: ");
                    double valorGasto = in.nextDouble();

                    System.out.print("Informe a forma de pagamento: ");
                    String formaPagamento = in.next();

                    AdicionaGasto gasto = new AdicionaGasto(gastoName, valorGasto, tipoGasto, formaPagamento, dataGastoIn);
                    listaGastos.add(gasto);
                    System.out.println(gasto.toString());
                    break;

                case 2:
                    System.out.print("Informe o nome do seu ganho: ");
                    String nomeGanho = in.next();

                    System.out.print("Informe a data do ganho no padrão(ex: 19/02/2023): ");
                    String dataGanho = in.next();

                    System.out.print("Informe o valor do ganho: ");
                    double valorGanho = in.nextDouble();

                    CadastrarGanho ganho = new CadastrarGanho(valorGanho, nomeGanho, dataGanho);
                    listaGanhos.add(ganho);
                    System.out.println(ganho.toString());
                    break;

                case 3:
                    System.out.println("--- LISTA DE GASTOS ---");
                    for (AdicionaGasto gasto3 : listaGastos) {
                        System.out.println(gasto3.toString());
                    }
                    break;

                case 4:
                    System.out.println("--- LISTA DE GANHOS ---");
                    for (CadastrarGanho ganho4 : listaGanhos) {
                        System.out.println(ganho4.toString());
                    }
                    break;

                case 5:
                    System.out.print("Informe o mês: ");
                    int mes = in.nextInt();

                    System.out.print("Informe o ano: ");
                    int ano = in.nextInt();

                    double totalGastos = 0;
                    double totalGanhos = 0;

                    DataConvert filtro = new DataConvert();

                    for (AdicionaGasto gasto2 : listaGastos) {
                        String dataGastoIn2 = gasto2.getDataDoGasto();
                        String dataConvertFiltro = filtro.filtraData(dataGastoIn2, mes, ano);

                        if (!dataConvertFiltro.equals("")) {
                            totalGastos += gasto2.getValor();
                        }
                        }
                
                for (CadastrarGanho ganho2 : listaGanhos) {
                    String dataGanho2 = ganho2.getDataGanho();
                    String dataConvertFiltro2 = filtro.filtraData(dataGanho2, mes, ano);
                    if (!dataConvertFiltro2.equals("")) {
                        totalGanhos += ganho2.getValor();
                    }
                }
                System.out.println("\nGastos no MES "+mes+" no ANO de "+ano);
                System.out.println("Total de ganhos: "+totalGanhos);
                System.out.println("Total de gastos: "+totalGastos);
                System.out.println("Saldo: "+ (totalGanhos - totalGastos));
                System.out.println("\n");
            }
            // Fim do codigo
        } while (opcaoMenu != 6);
    }
    
}