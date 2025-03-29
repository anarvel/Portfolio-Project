import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Abtrast class for a Job Search system. Provides implemenation for filtering
 * using kernel methods.
 *
 * @author Azra
 * @version 1.0
 */
public class JobSearchSecondary implements JobSearch {

    @Override
    public List<JobPosting> filterByQualification(String qualification) {
        List<JobPosting> filteredJobs = new ArrayList<>();
        for (JobPosting job : this.getAllJobs()) {
            if (job.getQualification().equalsIgnoreCase(qualification)) {
                filteredJobs.add(job);
            }
        }
        return filteredJobs;
    }

    @Override
    public List<JobPosting> filterByWorkAuthorization(String status) {
        List<JobPosting> filteredJobs = new ArrayList<>();
        for (JobPosting job : this.getAllJobs()) {
            if (job.getWorkAuthorization().equalsIgnoreCase(status)) {
                filteredJobs.add(job);
            }
        }
        return filteredJobs;
    }

    @Override
    public List<JobPosting> filterByLanguages(String languages) {
        List<JobPosting> filteredJobs = new ArrayList<>();
        for (JobPosting job : this.getAllJobs()) {
            if (job.getLanguagesSpoken().contains(languages)) {
                filteredJobs.add(job);
            }
        }
        return filteredJobs;
    }

    @Override
    public List<JobPosting> filterByLocation(String location) {
        List<JobPosting> filteredJobs = new ArrayList<>();
        for (JobPosting job : this.getAllJobs()) {
            if (job.getLocation().equalsIgnoreCase(location)) {
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
                        && !job.getQualification().equalsIgnoreCase(value)) {
                    matchesAll = false;
                } else if (key.equalsIgnoreCase("workAuthorization") && !job
                        .getWorkAuthorization().equalsIgnoreCase(value)) {
                    matchesAll = false;
                } else if (key.equalsIgnoreCase("languages")
                        && !job.getLanguagesSpoken().contains(value)) {
                    matchesAll = false;
                } else if (key.equalsIgnoreCase("location")
                        && !job.getLocation().equalsIgnoreCase(value)) {
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
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        JobSearchComponent other = (JobSearchComponent) obj;
        return this.getAllJobs().equals(other.getAllJobs());
    }

    @Override
    public String toString() {
        return "JobSearchComponent with " + this.getAllJobs().size()
                + " job postings.";
    }

}
