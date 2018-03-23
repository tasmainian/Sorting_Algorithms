package sort;
/**
 * @author Tasmiha Hassan, hassat3, 400083305
 * @version Eclipse Luna 
 */
public class Job implements Comparable<Job>{
	//Global variables
	private String jobName;
	private int processingTime;
	/**
	 * Constructor method for Job
	 * @param jobName = String value for jobID
	 * @param processingTime - int value of how long it takes to do a job
	 */
	public Job(String jobName, int processingTime){
		if(processingTime<0)
			throw new IllegalArgumentException();
		this.jobName=jobName;
		this.processingTime=processingTime;
	}
	
	//Return the job string
	public String getJobName(){
		return jobName;
	}
	
	//Return processing time of the job
	public int getProcessingTime(){
		return processingTime;
	}
	
	//Set processing time of the job
	public void setProcessingTime(int processingTime){
		this.processingTime = processingTime;
	}
	
	@Override
	/**
	 * Compare method
	 * @param j = a job
	 * @return an integer value which represents a comparison
	 */
	public int compareTo(Job j)
	{
		if(this.processingTime<j.processingTime){
			return -1;
		}
		if(this.processingTime>j.processingTime){
			return 1;
		}
		//TODO
		return 0;
	}
	
	public String toString(){
		return this.getJobName()+" "+this.getProcessingTime();
	}
}
