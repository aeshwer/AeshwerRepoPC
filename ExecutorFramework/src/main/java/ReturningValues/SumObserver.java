package ReturningValues;

public class SumObserver implements ResultListner<Integer>{

	private String taskId;
	
	public SumObserver(String taskId) {
		this.taskId=taskId;
	}
	
	 
	public void notifyResult(Integer result) {
		
		System.out.println("Reult for " + taskId +" ="+ result);		
	}

}
