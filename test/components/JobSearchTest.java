package components;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 * JUnit test cases for the JobSearch abstract class.
 *
 * @author Azra
 */
public class JobSearchTest {

    /**
     * Tests the multi-criteria filter when the criteria match an existing job.
     */
    @Test
    public void testFilterByMultiCriteriaMatch() {
        JobSearch js = new JobSearch1L();
        JobPosting job = new JobPosting("101", "Customer Service", "BestBuy",
                List.of("Communication", "Bachelors Degree",
                        "Working with people"),
                "Sponsorship Available", List.of("English", "Spanish"),
                "Columbus");

        js.addJob(job);

        Map<String, String> criteria = new HashMap<>();
        criteria.put("languages", "Spanish");
        criteria.put("location", "Columbus");
        criteria.put("workAuthorization", "Sponsorship Available");

        List<JobPosting> result = js.filterByMultiCriteria(criteria);

        assertEquals(1, result.size());
        assertEquals("101", result.get(0).jobID());
    }

    /**
     * Tests the multi-criteria filter when no job matches the criteria.
     */
    @Test
    public void testFilterByMultiCriteriaNoMatch() {
        JobSearch js = new JobSearch1L();
        JobPosting job = new JobPosting("101", "Customer Service", "BestBuy",
                List.of("Communication", "Bachelors Degree",
                        "Working with people"),
                "Sponsorship Available", List.of("English", "Spanish"),
                "Columbus");

        js.addJob(job);

        Map<String, String> criteria = new HashMap<>();
        criteria.put("languages", "Arabic");
        criteria.put("location", "Hilliard");
        criteria.put("workAuthorization", "Sponsorship Available");

        List<JobPosting> result = js.filterByMultiCriteria(criteria);

        assertEquals(0, result.size());
    }

}
