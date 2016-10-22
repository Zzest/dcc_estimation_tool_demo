package model;


/**
 *ModelInterface is a interface which defines the functions for a model to realize,
 * including calculate, display results and so on.
 * @author daxu
 *
 */
public interface ModelInterface {
	/**
	 * function to realize the calculation
	 * param errorValue: define the precision of the method
	 */
	void calculate(double errorValue);

	/**
	 * function to print the result
	 */
	void printResult();
}
