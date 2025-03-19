import java.util.List;
import java.util.Map;

/**
 * Enhanced interface for a Job Search system. Extends the kernel and provides
 * additional functionality that enhances the core capabilities.
 *
 * @author Azra
 * @version 1.0
 */
public interface JobSearch extends JobSearchKernel {

    /**
     * Filters jobs by the required qualification.
     *
     * @param qualification
     *            the required qualification
     * @return list of jobs matching the qualification
     */
    List<JobPosting> filterByQualification(String qualification);

    /**
     * Filters jobs by work authorization status.
     *
     * @param status
     *            the work authorization status (e.g., "Sponsorship Available")
     * @return list of jobs matching the work authorization status
     */
    List<JobPosting> filterByWorkAuthorization(String status);

    /**
     * Filters jobs by languages spoken.
     *
     * @param languages
     *            the required languages
     * @return list of jobs matching the languages spoken
     */
    List<JobPosting> filterByLanguages(String languages);

    /**
     * Filters jobs by location.
     *
     * @param location
     *            the required job location
     * @return list of jobs matching the location
     */
    List<JobPosting> filterByLocation(String location);

    /**
     * Filters jobs by multiple criteria (e.g., qualification, work
     * authorization, languages).
     *
     * @param criteria
     *            a map of criteria to filter by
     * @return list of jobs matching the criteria
     */
    List<JobPosting> filterByMultiCriteria(Map<String, String> criteria);
}