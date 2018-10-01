import java.util.Random;

class Perceptron{
	static double lrate;
    static double Bias;
	public static void main(String args[]){
		
        Random r = new Random();
		double weight[];
		
        weight = new double[2];
		Bias = r.nextDouble();	
		
        int input[][] = {{0,0},{0,1},{1,0},{1,1}};
		int output[] = {0,0,0,1};
        
        lrate = 0.1;
		
        for(int i=0;i<weight.length;i++){
		
        	weight[i] = r.nextDouble();
		
        }

		Train(input,output,weight,0.2,lrate,200);

		for(int i=0;i<input.length;i++){

			System.out.println(input[i][0]+","+input[i][1]+" : "+(input[i][0]*weight[0]+input[i][1]*weight[1]+Bias >0 ? 1:0));
		
        }

		System.out.println("y(x) = "+ weight[1]/-weight[0]+"x + "+(Bias/-weight[0]));


	}
	static void Train(int input[][],int output[],double weight[],double threshold,double lrate,int epcho){
		int error = 0,tError=0;
		for(int i=0;i<epcho;i++){
			
			tError = 0;
			
			for(int j=0;j<output.length;j++){
				
				int y = Sum(weight,input[j],threshold);
				error = output[j] - y;

				tError += error*error;

				for(int k=0;k<input[0].length;k++){
					weight[k] += (lrate * input[j][k] * error); 
				}

                Bias += lrate * error;

			}
			
			if(tError == 0){
				break;
			}
		
			
		}
	}
	static int Sum(double weight[],int[] input,double threshold){
		double sum = 0.0;

		for(int i=0;i<input.length;i++){
			sum += weight[i]*input[i]; 
		}
		sum+=Bias;
		if(sum>0){
			return 1;
		}
		else{
			return 0;
		}
	}
}