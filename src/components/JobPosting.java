package components;

import java.util.List;

/**
 * Represents an immutable job posting.
 *
 * @param jobID
 *                the unique identifier for the job posting
 * @param title
 *                the title of the job
 * @param company
 *                the company offering the job
 * @param qualifications
 *                the list of qualifications required for the job
 * @param workAuthorization
 *                the work authorization status required for the job
 * @param languages
 *                the list of languages required or preferred for the job
 * @param location
 *                the location where the job is based
 */
public record JobPosting(String jobID, String title, String company,
                List<String> qualifications, String workAuthorization,
                List<String> languages, String location) {
}
