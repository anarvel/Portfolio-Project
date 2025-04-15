import java.util.List;

import components.list.List1L;

/**
 * Kernal implementation of JobSearch.
 *
 * @convention <pre>
 * this.jobs is not null and contains only non-null JobPosting entries.
 * Each jobID is unique in the list.
 * </pre>
 *
 * @correspondence <pre>
 * The abstract value modeled by this component is a sequence of JobPosting objects,
 * where each JobPosting corresponds to an entry in this.jobs, preserving order.
 * </pre>
 *
 * @author Azra
 */

public class JobSearch1L extends JobSearchSecondary {
    /*
     * Private members --------------------------------------------------------
     */

    private List<JobPosting> jobs;

    /*
     * Private helper methods -------------------------------------------------
     */

    /**
     * Searches for a job by ID.
     *
     * @param jobID
     *            the unique job identifier
     * @return the index of the job
     */
    private int findJobIndex(String jobID) {
        for (int i = 0; i < this.jobs.length(); i++) {
            JobPosting job = this.jobs.remove(i);
            this.jobs.add(i, job);

            if (job.jobID().equals(jobID)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Creator of initial representation - new empty job list.
     */

    private void createNewRep() {
        this.jobs = new List1L<>();
    }

    /*
     * Constructors -----------------------------------------------------------
     */

    /**
     * No-argument constructor.
     */
    public jobSearch() {
        this.createNewRep();
    }

    /*
     * Kernel methods ---------------------------------------------------------
     */

    /**
     * Adds a new job posting to the system.
     *
     * @param job
     */
    public final void addJob(JobPosting job) {
        assert job != null : "Violation of: job is not null";
        this.jobs.add(this.jobs.length(), job);
    }

    /**
     * Retrieves all job postings.
     *
     * @return all the job postings
     */
    public List<JobPosting> getAllJobs() {
        List<JobPosting> jobsCopy = new List1<>();
        for (JobPosting job : this.jobs) {
            jobsCopy.add(jobsCopy.length(), job);
        }
        return jobsCopy;

    }

    /**
     * Removes a job posting.
     *
     * @param jobID
     *            (job identifier #)
     */
    public void removeJob(String jobID) {
        assert jobID != null : "Violation of: jobID is not null";
        int index = this.findJobIndex(jobID);
        if (index != -1) {
            this.jobs.remove(index);
        }
    }

}
