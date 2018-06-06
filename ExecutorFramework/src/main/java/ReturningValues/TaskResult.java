package ReturningValues;

public class TaskResult<S,R> {
	
	private R result;
	private S taskId;

	public R getResult() {
		return result;
	}

	public void setResult(R result) {
		this.result = result;
	}

	public S getTaskId() {
		return taskId;
	}

	public void setTaskId(S taskId) {
		this.taskId = taskId;
	}

	public TaskResult(S taskId, R result) {
		this.taskId = taskId;
		this.result = result;
	}

	@Override
	public String toString() {
		return "***TaskResult[taskId= "+taskId+"]"+" Result="+result;
	}
	
}
