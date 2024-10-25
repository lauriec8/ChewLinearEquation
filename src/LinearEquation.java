public class LinearEquation {

    //instance variables
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    //constructor
    public LinearEquation(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    // calculations
    public double distance(){
        return roundedToHundredth(Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1,2))); // rounds input to hundredth
    }

    public double slope(){
        double slope = (double) (y2 - y1) / (x2 - x1); // difference of y - difference of x = slope
        return roundedToHundredth(slope); // returns slope
    }

    public double yIntercept(){
        return roundedToHundredth(y1 - (x1 * slope())); // y - slope * x = y intercept
    }

    //info about line & points
    public String equation() {
        int deltaX = x2 - x1;
        int deltaY = y2 - y1;
        String equation = "";
        if (deltaX == 0) {
            equation += "x = " + x1; // vertical line
            return equation;
        } else {
            equation += "y = ";
            if (deltaY == 0) {
                equation += y1; //horizontal line
                return equation;
            }
            if (slope() == 1) {
                equation += "x"; // y = x
            } else if (slope() == -1) {
                equation += "-x"; // y = -x
            } else if (slope() % 1 == 0) {
                equation += (int) slope() + "x"; // y = (positive slope)x
            } else if (deltaX < 0 && deltaY < 0) {
                equation += Math.abs(deltaY) + "/" + Math.abs(deltaX) + "x"; // y = (slope)x
            } else if (deltaX < 0) {
                equation += "-" + deltaY + "/" + Math.abs(deltaX) + "x"; // y = -(abs slope)x
            } else {
                equation += deltaY + "/" + deltaX + "x" ; // y = (slope)x
            }
            if (yIntercept() != 0) {
                if (yIntercept() < 0) {
                    equation += " - " + Math.abs(yIntercept()); // negative intercept
                } else {
                    equation += " + " + yIntercept(); // positive intercept
                }
            }
        }
        return equation;
    }

    public String coordinateForX(double x){
        double y = slope() * x + yIntercept();
        return "(" + x + ", " + y + ")";
    }

    public String lineInfo(){ // returns line info as string
        if (equation().equals("x = " + x1)){
            return "The points are on a vertical line: " + equation();
        }
        String lineInfo = "The two points are: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")" + "\n";
        lineInfo += "The equation of the line between these points is: " + equation() + "\n";
        lineInfo += "The y-intercept of this line is: " + yIntercept() + "\n";
        lineInfo += "The slope of this line is: " + slope() + "\n";
        lineInfo += "The distance between these two points is: " + distance();
        return lineInfo;
    }

    private double roundedToHundredth(double toRound){
        return Math.round(toRound * 100) / 100.0;
    }
}
