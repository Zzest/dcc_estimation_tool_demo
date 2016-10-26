package model;

/**
 * M-O model
 *
 * @author daxu
 *
 */
public class JMModel extends CommonModelParent implements ModelInterface {

	public JMModel(double[] time, double[] number) {
		super(time, number);
	}

	/**
	 * method to calculate the parameter and assign to the result param:
	 * errorValue
	 */
	@Override
	public void calculate(double deviation) {
		// TODO Auto-generated method stub
//		double b0, b1 = 0;

//		double left = 0.03;
//		double right = 0;

		int n = this.failureDate.time.length;
		double tn = this.failureDate.time[n - 1];

		// 估计故障期望数N
		int N = n;
		double deviation1 = 1000000;// 极大数
		while (true) {// 迭代法计算
			double sum1 = 0, sum2 = 0, sum3 = 0;
			double result = 0;
			for (int i = 0; i < n; ++i) {
				sum1 += 1.0 / (N - i);
				sum2 += this.failureDate.time[i];
				sum3 += i * this.failureDate.time[i];
			}
//			double left = sum1;
//			double right =  n *sum2/ (N*sum2 - sum3);
			result = sum1 - n *sum2/ (N*sum2 - sum3);
			if (deviation1 > Math.abs(result)) {
				System.out.println(deviation1);
				System.out.println(N);
				deviation1 = Math.abs(result);
			} else {
				System.out.println(deviation);
				System.out.println(N);
				break;
			}
			N++;
		}
	}

	/**
	 * display the estimation result
	 */
	@Override
	public void printResult() {
		System.out.println(this.estimationResults.expectFaultNum);
		;
	}

	public static void main(String[] args) {
		// failure date set
		// float []time = new
		// float[]{5,9,10,15,18,26,27,35,42,46,50,56,63,67,72,75,78,85,88,98,
		// 100,111,125,129,137,142,155,165,181,204};
//		double[] time = new double[] { 5, 9, 10, 15, 18, 26, 27, 35, 42, 46, 50, 56, 63, 67, 72 };
		double[] time = new double[] { 9, 12, 11, 4, 7, 2, 5, 8, 5, 7, 1, 6, 1, 9, 4, 1, 3, 3, 6, 1, 11, 33, 7, 91, 2, 1 };
		double[] number = new double[] { 1, 2, 3 };

		// choose a model
		JMModel jmModel = new JMModel(time, number);
		jmModel.calculate(0.001);

	}
}
