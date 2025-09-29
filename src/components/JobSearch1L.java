package components;

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

    /**
     * A list of job postings in the system.
     */
    private List1L<JobPosting> jobs;

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
        assert jobID != null : "Violation of: jobID is not null";
        int index = 0;
        for (JobPosting job : this.jobs) {
            if (job.jobID().equals(jobID)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    /**
     * Creator of initial representation - new empty job list.
     */

    private void createNewRep() {
        this.jobs = new List1L<JobPosting>();
    }

    /*
     * Constructors -----------------------------------------------------------
     */

    /**
     * No-argument constructor.
     */
    public JobSearch1L() {
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
    @Override
    public final void addJob(JobPosting job) {
        assert job != null : "Violation of: job is not null";
        assert this.findJobIndex(
                job.jobID()) == -1 : "Violation of: jobID must be unique";
        this.jobs.addRightFront(job);
    }

    /**
     * Retrieves all job postings.
     *
     * @return all the job postings
     */
    @Override
    public List1L<JobPosting> getAllJobs() {
        List1L<JobPosting> jobsCopy = new List1L<>();
        for (JobPosting job : this.jobs) {
            jobsCopy.addRightFront(job);
        }
        return jobsCopy;

    }

    /**
     * Removes a job posting.
     *
     * @param jobID
     *            (job identifier #)
     */
    @Override
    public JobPosting removeJob(String jobID) {
        assert jobID != null : "Violation of: jobID is not null";
        int index = this.findJobIndex(jobID);
        if (index != -1) {
            this.jobs.moveToStart();
            for (int i = 0; i < index; i++) {
                this.jobs.advance();
            }
            return this.jobs.removeRightFront();
        }
        return null;
    }

    /**
     * Creates a new instance of the JobSearch1L class.
     *
     * This method is used to create a new, independent instance of the
     * JobSearch1L class, which will be initialized with an empty list of job
     * postings.
     *
     * @return A new instance of JobSearch1L with an empty list of job postings.
     */
    @Override
    public JobSearch newInstance() {
        try {
            return this.getClass().getConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new AssertionError(
                    "Cannot construct object of type " + this.getClass());
        }
    }

    /**
     * Clears the current job search system.
     *
     * This method resets the job search system by creating a new empty list of
     * job postings. Any previous job postings in the system will be removed.
     */
    @Override
    public void clear() {
        this.createNewRep();
    }

    /**
     * Transfers job postings from another JobSearch instance.
     *
     * This method copies the job postings from the given source JobSearch
     * instance to this JobSearch1L instance. The source instance must be of
     * type JobSearch1L.
     *
     * @param source
     *            The JobSearch instance from which job postings will be copied.
     * @throws ClassCastException
     *             If the source is not an instance of JobSearch1L.
     */
    @Override
    public void transferFrom(JobSearch source) {
        assert source != null : "Violation of: source is not null";
        assert source != this : "Violation of: source is not this";
        assert source instanceof JobSearch1L : ""
                + "Violation of: source is of dynamic type JobSearchExample";
        /*
         * This cast cannot fail since the assert above would have stopped
         * execution in that case.
         */
        JobSearch1L localSource = (JobSearch1L) source;
        this.jobs = localSource.jobs;
        localSource.createNewRep();
    }
}
