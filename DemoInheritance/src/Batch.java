
public class Batch {
private String batchName;
private String batchDate;
private Interviewer interviewer;
private candidate Candidate[];
public Batch() {
	// TODO Auto-generated constructor stub
}
public Batch(String batchName, String batchDate) {
	super();
	this.batchName = batchName;
	this.batchDate = batchDate;
}
public String getBatchName() {
	return batchName;
}
public void setBatchName(String batchName) {
	this.batchName = batchName;
}
public String getBatchDate() {
	return batchDate;
}
public void setBatchDate(String batchDate) {
	this.batchDate = batchDate;
}
public Interviewer getInterviewer() {
	return interviewer;
}
public void setInterviewer(Interviewer interviewer) {
	this.interviewer = interviewer;
}
public candidate[] getCandidate() {
	return Candidate;
}
public void setCandidate(candidate[] candidate) {
	Candidate = candidate;
}


}
