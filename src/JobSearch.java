import java.util.HashMap;
import java.util.List;
import java.util.Map;

import components.list.List1L;

/**
 * JobSearch component.
 *
 * @author Azra
 */

public class JobSearch {
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
                jobID = i;
            }
        }
        return jobID;
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
     * Adds a new job posting to the system
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
        List<JobPosting> jobs = new List1<>();
        for (JobPosting job : this.jobs) {
            jobs.add(jobs.length(), job);
        }
        return jobs;

    }

    /**
     * Removes a job posting.
     *
     * @param jobID
     *            (job identifier #)
     */
    public void removeJob(String jobID) {
        // call method that find the job index by jobID
    }

    /*
     * Secondary Methods
     * ---------------------------------------------------------
     */

    /**
     * Filters a job by the required qualification.
     *
     * @param qualification
     * @return list of matching jobs
     */
    public void filterByQualification(String qualification) {
        List<JobPosting> filteredByQualification = new List1L<>();
        for (JobPosting job : this.jobs) {
            if (job.qualifications().contains(qualification)) {
                filtered.add(filtered.length(), job);
            }
        }
        return filtered;
    }

    /**
     * Filters a job based on work authorization.
     *
     * @param status
     * @return list of matching jobs
     */
    public void filterByWorkAuthorization(String status) {
        List<JobPosting> filteredByStatus = new List1L<>();
        for (JobPosting job : this.jobs) {
            if (job.status().contains(status)) {
                filteredByStatus.add(filteredByStatus.length(), job);
            }
        }
        return filteredByStatus;
    }

    /**
     * Filters a job based on languages spoken.
     *
     * @param languages
     * @return list of matching jobs
     */
    public void filterByWorkAuthorization(String languages) {
        List<JobPosting> filteredByLanguage = new List1L<>();
        for (JobPosting job : this.jobs) {
            if (job.languages().contains(languages)) {
                filteredByLanguage.add(filteredByLanguage.length(), job);
            }
        }
        return filteredByLanguage;
    }

    /**
     * Filters a job based on location.
     *
     * @param location
     * @return list of matching jobs
     */
    public void filterByWorkAuthorization(String location) {
        List<JobPosting> filteredByLoc = new List1L<>();
        for (JobPosting job : this.jobs) {
            if (job.location().contains(location)) {
                filteredByLoc.add(filteredByLoc.length(), job);
            }
        }
        return filteredByLoc;
    }

    /**
     * Filters a job based on multiple criteria.
     *
     * @param list
     *            of criteria (map??)
     * @return list of matching jobs
     */
    public void filterByMultiCriteria(Map<String, String> criteria) {
        List<JobPosting> multiFiltered = new List1L<>();
        // somehow implement this
        return multiFiltered;
    }

    /*
     * Java Record for Immutable Job Postings
     * ------------------------------------
     */

    /**
     * Represents an immutable job posting. (had to google how to do this not
     * sure if this is right)
     */
    public record JobPosting(String jobID, String title, String company,
            List<String> qualifications, String workAuthorization,
            List<String> languages, String location) {
    }

    /**
     * Main method.
     */
    public static void main(String[] args) {
        // um would add example jobs here i think
        // need to also let employers add jobs but for right now to test we can just add an example job
        JobPosting job1 = new JobPosting("101", "Customer Service", "BestBuy",
                "Customer Service", "Sponsorship Available",
                List.of("English", "Spanish"), "Columbus");
        jobSearch.addJob(job1);

        JobPosting job1 = new JobPosting("102", "Technician", "BestBuy",
                "Computer Skills", "Work Visa", "English", "Columbus");
        jobSearch.addJob(job1);

        Map<String, String> criteria = new HashMap<>();
        criteria.put("languages", "Spanish");
        criteria.put("location", "Columbus");
        criteria.put("workAuthorization", "Sponsorship Available");

        System.out.println(
                "Filtered Jobs (Spanish, Columbus, Sponsorship Available):");
        List<JobPosting> filteredJobs = jobSearch
                .filterByMultiCriteria(criteria);

        for (JobPosting job : filteredJobs) {
            System.out.println(job);
        }
    }

}
