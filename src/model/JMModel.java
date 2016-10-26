package model;
/**
 * M-O model
 * @author daxu
 *
 */
public class JMModel extends CommonModelParent implements ModelInterface{

	public JMModel(double[] time, double[] number) {
		super(time, number);
	}

	/**
	 * method to calculate the parameter and assign to the result
	 * param: errorValue
	 */
	@Override
	public void calculate(double errorValue) {
		// TODO Auto-generated method stub
		double b0,b1=0;

		double left = 0.03;
		double right = 0;

		int n = this.failureDate.time.length;
		double tn = this.failureDate.time[n-1];

		//估计故障期望数N
		int N = n;
		while(true){//迭代法计算
			double sum = 0;
			for(int i=0;i<n;++i){
				sum += 1/(N-i);
			}
			N ++;
		}
	}





	/**
	 * display the estimation result
	 */
	@Override
	public void printResult() {
		System.out.println(this.estimationResults.expectFaultNum);;
	}



	public static void main(String[] args) {
		// failure date set
//		float []time = new float[]{5,9,10,15,18,26,27,35,42,46,50,56,63,67,72,75,78,85,88,98,
//				100,111,125,129,137,142,155,165,181,204};
//		float []time = new float[]{5,9,10,15,18,26,27,35,42,46,50,56,63,67,72};
		double []time = new double[]{5,14,24,39,57,
				83, 110,145,187,234,
				284,340,403,470,542};
//		for(int i=0;i)
//		float []time = new float[]{5,4,1,5,3,8,1,8,7,4,4,6,7,4,7};
//		System.out.println(time.length);

		double []number = new double[]{1,2,3};

		//choose a model
		JMModel jmModel = new JMModel(time, number);
		jmModel.calculate(0.00001);



	}
}
