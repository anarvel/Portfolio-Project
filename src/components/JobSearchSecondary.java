package components;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Abstract class for a Job Search system. Provides default implementations for
 * filtering job postings using kernel methods defined in the JobSearch
 * interface.
 * <p>
 *
 * @author Azra
 * @version 1.0
 */
public abstract class JobSearchSecondary implements JobSearch {

    @Override
    public List<JobPosting> filterByQualification(String qualification) {
        List<JobPosting> filteredJobs = new ArrayList<>();
        for (JobPosting job : this.getAllJobs()) {
            if (job.qualifications().contains(qualification)) {
                filteredJobs.add(job);
            }
        }
        return filteredJobs;
    }

    @Override
    public List<JobPosting> filterByWorkAuthorization(String status) {
        List<JobPosting> filteredJobs = new ArrayList<>();
        for (JobPosting job : this.getAllJobs()) {
            if (job.workAuthorization().equalsIgnoreCase(status)) {
                filteredJobs.add(job);
            }
        }
        return filteredJobs;
    }

    @Override
    public List<JobPosting> filterByLanguages(String languages) {
        List<JobPosting> filteredJobs = new ArrayList<>();
        for (JobPosting job : this.getAllJobs()) {
            if (job.languages().contains(languages)) {
                filteredJobs.add(job);
            }
        }
        return filteredJobs;
    }

    @Override
    public List<JobPosting> filterByLocation(String location) {
        List<JobPosting> filteredJobs = new ArrayList<>();
        for (JobPosting job : this.getAllJobs()) {
            if (job.location().equalsIgnoreCase(location)) {
                filteredJobs.add(job);
            }
        }
        return filteredJobs;
    }

    @Override
    public List<JobPosting> filterByMultiCriteria(
            Map<String, String> criteria) {
        List<JobPosting> filteredJobs = new ArrayList<>();
        for (JobPosting job : this.getAllJobs()) {
            boolean matchesAll = true;
            for (Map.Entry<String, String> entry : criteria.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (key.equalsIgnoreCase("qualification")
                        && !job.qualifications().contains(value)) {
                    matchesAll = false;
                } else if (key.equalsIgnoreCase("workAuthorization")
                        && !job.workAuthorization().equalsIgnoreCase(value)) {
                    matchesAll = false;
                } else if (key.equalsIgnoreCase("languages")
                        && !job.languages().contains(value)) {
                    matchesAll = false;
                } else if (key.equalsIgnoreCase("location")
                        && !job.location().equalsIgnoreCase(value)) {
                    matchesAll = false;
                }
            }
            if (matchesAll) {
                filteredJobs.add(job);
            }
        }
        return filteredJobs;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof JobSearch)) {
            return false;
        }

        JobSearch other = (JobSearch) obj;
        return this.getAllJobs().equals(other.getAllJobs());
    }

    @Override
    public int hashCode() {
        return this.getAllJobs().hashCode();
    }

    @Override
    public String toString() {
        return "JobSearch with " + this.getAllJobs().rightLength()
                + " job postings.";
    }

}
