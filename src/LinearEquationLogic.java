import java.util.Scanner;

public class LinearEquationLogic {

    //instance variables
    private Scanner scan;
    private String coord1;
    private int x1;
    private int y1;
    private String coord2;
    private int x2;
    private int y2;
    private LinearEquation line;

    //constructors
    public LinearEquationLogic(){
        scan = new Scanner(System.in);
        coord1 = "( ,  )";
        x1 = 0;
        y1 = 0;
        coord1 = "( ,  )";
        x2 = 0;
        y2 = 0;
    }

    //start method
    public void start(){
        System.out.println("Welcome to the linear equation calculator!"); // welcome user
        String anotherPair = "";
        while (!anotherPair.equals("n")) { //checks if user wants to enter another pair
            getCoords(); // asks for coordinates in (x, y)
            getXYCoords(); // decodes the xy values from coords & creates object for LinearEquation
            System.out.println();
            getData(); //prints information
            System.out.println();
            System.out.print("Would you like to enter another pair of coordinates? y/n: ");
            anotherPair = scan.nextLine(); // updates anotherPair
            System.out.println();
        }
        System.out.println("Thank you for using the slope calculator, goodbye!"); // thanks user
    }

    //helper methods
    private void getCoords(){
        System.out.print("Enter coordinate 1: "); // asks for coords
        coord1 = scan.nextLine(); // assigns coord to var
        System.out.print("Enter coordinate 2: ");
        coord2 = scan.nextLine();
    }

    private void getXYCoords(){
        int commaIdx1 = coord1.indexOf(",");
        String strX1 = coord1.substring(1,commaIdx1);
        String strY1 = coord1.substring(commaIdx1 + 2 ,coord1.length()-1);
        x1 = Integer.parseInt(strX1); // parse x and y as ints
        y1 = Integer.parseInt(strY1);
        int commaIdx2 = coord2.indexOf(",");
        String strX2 = coord2.substring(1,commaIdx2);
        String strY2 = coord2.substring(commaIdx2 + 2 ,coord2.length()-1);
        x2 = Integer.parseInt(strX2); // parse x and y as ints
        y2 = Integer.parseInt(strY2);

        line = new LinearEquation(x1,y1,x2,y2); //creates LinearEquationObject with xy values
    }

    private void getData(){
        System.out.println(line.lineInfo());
        if (!line.equation().equals("x = " + x1)){
            System.out.println();
            System.out.print("Enter a coordinate for x: "); //asks for x value
            double x = scan.nextDouble(); //assigns entered value into double var
            scan.nextLine();
            System.out.println();
            System.out.println("The point on the line is: " + line.coordinateForX(x)); //calculates corresponding y to entered x
        }
    }
}
