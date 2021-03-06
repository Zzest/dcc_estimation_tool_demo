package model;



/**
 * data structure to store the failure dataset
 * @author daxu
 *
 */
class FailureDataSet{
	/**
	 * private attributes including time and number, time is the array of failure time
	 */
	public double []time;
	public double []number;

	/**
	 *
	 * @param time: array of failure time
	 * @param number: array of failure times within certain time
	 */
	public FailureDataSet(double []time, double []number){
		this.time = time;
		this.number = number;
	}
}

/**
 * data structure to store the estimation results
 * @author daxu
 *
 */
class EstimationResults{
	public double mttf;
	public double reliability;
	public double failureRate;
	public double residualFaultNum;
	public double expectFaultNum;

	public EstimationResults(){
		this.mttf = -1.0;
		this.reliability =  -1.0;
		this.failureRate =  -1.0;
		this.residualFaultNum =  -1.0;
		this.expectFaultNum =  -1.0;
	}

}

/**
 *parent of six general models such as JM, GO and so on
 * @author daxu
 *
 */
public class CommonModelParent {
	/**
	 *public attribute including failure dateset and estimation result
	 */
	public FailureDataSet failureDate;
	public EstimationResults estimationResults;

	/**
	 * constructor of parent requires parameter including time and number
	 * @param time
	 * @param number
	 */
	public CommonModelParent(double []time, double []number){
		this.failureDate = new FailureDataSet(time, number);
		this.estimationResults = new EstimationResults();
	}
}
