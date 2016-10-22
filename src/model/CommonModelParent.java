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
	public float []time;
	public float []number;

	/**
	 *
	 * @param time: array of failure time
	 * @param number: array of failure times within certain time
	 */
	public FailureDataSet(float []time, float []number){
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
	public float mttf;
	public float reliability;
	public float failureRate;
	public float residualFaultNum;
	public float expectFaultNum;

	public EstimationResults(){
		this.mttf = (float) -1.0;
		this.reliability = (float) -1.0;
		this.failureRate = (float) -1.0;
		this.residualFaultNum = (float) -1.0;
		this.expectFaultNum = (float) -1.0;
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
	public CommonModelParent(float []time, float []number){
		this.failureDate = new FailureDataSet(time, number);
		this.estimationResults = new EstimationResults();
	}
}
