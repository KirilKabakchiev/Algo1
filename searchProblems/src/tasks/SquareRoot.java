package tasks;

public class SquareRoot {
	public static final double PRECISION = 0.000001;
	
	public double square_root(double number){
		double from = 0, to = number, mid = 0;
		while(to - from >= PRECISION){
			mid = from + (to - from)/2;
			if(mid * mid < number){
				from = mid;
			}
			else {
				to = mid;
			}
		}
		return mid;
	}
	
	public static void main(String[] args) {
		double square_root = new SquareRoot().square_root(3);
		System.out.println(square_root);
	}
}

