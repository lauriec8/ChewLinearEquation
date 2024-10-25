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
        return roundedToHundredth(Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1,2)));
    }

    public double slope(){
        double slope = (double) (y2 - y1) / (x2 - x1);
        return roundedToHundredth(slope);
    }

    public double yIntercept(){
        return roundedToHundredth(y1 - (x1 * slope()));
    }

    //info about line & points
    public String equation() {
        int deltaX = x2 - x1;
        int deltaY = y2 - y1;
        String equation = "";
        if (deltaX == 0) {
            equation += "x = " + x1;
            return equation;
        } else {
            equation += "y = ";
            if (deltaY == 0) {
                equation += y1;
                return equation;
            }
            if (slope() == 1) {
                equation += "x";
            } else if (slope() == -1) {
                equation += "-x";
            } else if (slope() % 1 == 0) {
                equation += (int) slope() + "x";
            } else if (deltaX < 0 && deltaY < 0) {
                equation += Math.abs(deltaY) + "/" + Math.abs(deltaX) + "x";
            } else if (deltaX < 0) {
                equation += "-" + deltaY + "/" + Math.abs(deltaX) + "x";
            } else {
                equation += deltaY + "/" + deltaX + "x" ;
            }
            if (yIntercept() != 0) {
                if (yIntercept() < 0) {
                    equation += " - " + Math.abs(yIntercept());
                } else {
                    equation += " + " + yIntercept();
                }
            }
        }
        return equation;
    }

    public String coordinateForX(double x){
        double y = slope() * x + yIntercept();
        return "(" + x + ", " + y + ")";
    }

    public String lineInfo(){
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
