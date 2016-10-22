package model;
/**
 * M-O model
 * @author daxu
 *
 */
public class MOModel extends CommonModelParent implements ModelInterface{

	public MOModel(float[] time, float[] number) {
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
		float tn = this.failureDate.time[n-1];

		while(true){//迭代法计算
			double sum=0;
			for(int i=0; i<n;++i){
				sum+=1/(1+left*this.failureDate.time[i]);
			}
			right = (float) (sum*(1+left*tn)*Math.log(1+left*tn))/n/tn;

			if(Math.abs(left-right)<errorValue){
				b1 = left;
				b0 = n/Math.log(1+b1*tn);
				System.out.println("b1:"+b1+" b0:"+ b0);
				break;
			}
			left = right;
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
		float []time = new float[]{5,9,10,15,18,26,27,35,42,46,50,56,63,67,72};
		System.out.println(time.length);

		float []number = new float[]{1,2,3};

		//choose a model
		MOModel moModel = new MOModel(time, number);
		moModel.calculate(0.00001);
		moModel.printResult();



	}
}
