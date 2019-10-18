package marketstoresystem;

import java.util.Scanner;

public class Main {
    //INPUTS:
    //Bronze:
    //Mock data: turnover $0, purchase value $150;
    //Silver:
    //Mock data: turnover $600, purchase value $850;
    //Gold:
    //Mock data: turnover $1500, purchase value $1300;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String tierLevel = line.substring(0, line.indexOf(":"));
        String mockData = scanner.nextLine();
        double turnoverValue = Double.parseDouble(mockData.substring(mockData.indexOf("$") + 1, mockData.indexOf(",")));
        double purchaseValue = Double.parseDouble(mockData.substring(mockData.lastIndexOf("$") + 1, mockData.lastIndexOf(";")));

        System.out.println(new PayDesk(tierLevel, turnoverValue, purchaseValue).toString());


    }
}
