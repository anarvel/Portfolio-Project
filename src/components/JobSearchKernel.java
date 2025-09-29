package components;

import components.list.List1L;
import components.standard.Standard;

/**
 * Kernel interface for a Job Search system. Defines the minimal core operations
 * for managing job postings.
 *
 * @author Azra
 * @version 1.0
 */
public interface JobSearchKernel extends Standard<JobSearch> {
    /**
     * Adds a new job posting to the job search system.
     *
     * @param job
     *            The job posting to be added.
     * @requires job != null
     * @ensures The job is added to the system.
     */
    void addJob(JobPosting job);

    /**
     * Removes a job posting from the job search system based on its ID and
     * returns the ID.
     *
     * @param jobID
     *            The unique identifier of the job to be removed.
     * @requires jobID != null and jobID exists in the system
     * @ensures The job with the given ID is removed from the system.
     * @return The jobID removed.
     */
    JobPosting removeJob(String jobID);

    /**
     * Retrieves a list of all job postings currently in the system.
     *
     * @return A list containing all job postings.
     * @ensures The returned list contains all jobs currently in the system.
     */
    List1L<JobPosting> getAllJobs();
}
