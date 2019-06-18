public class BSFB {

	public static void main(String[] args) {
		
		for (int i = 0; i < 100; i++) {
			if(i%10==0)
				System.out.println();
			System.out.print(gPV((double)(Math.random()+1)*10)+"\t");
		}
				
	}
	
	private static int gPV(double l){
		int x = 0;
		double y = Math.random(),cdf = gPP(x,l);
		while(cdf < y){
			x++;
			cdf += gPP(x,l);
		}
		return x;
	}
	
	private static double gPP(int k,double l){
		double c = Math.exp(-l);
		double sum = 1;
		for (int i = 1; i <= k; i++) {
			sum *= l/i;
		}
		return sum*c;
	}
	
}
