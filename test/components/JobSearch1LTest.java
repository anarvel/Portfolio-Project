package components;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

/**
 * JUnit test cases for the JobSearch1L kernal implementation.
 *
 * @author Azra
 */
public class JobSearch1LTest {

    /**
     * Tests adding a job and verifying that it exists in the system.
     */
    @Test
    public void testAddOneJob() {
        JobSearch js = new JobSearch1L();
        JobPosting job = new JobPosting("101", "Customer Service", "BestBuy",
                List.of("Communication", "Bachelors Degree",
                        "Working with people"),
                "Sponsorship Available", List.of("English", "Spanish"),
                "Columbus");

        js.addJob(job);

        boolean found = false;
        for (JobPosting j : js.getAllJobs()) {
            if (j.equals(job)) {
                found = true;
                break;
            }
        }
        assertTrue(found);
    }

    /**
     * Tests adding multiple different jobs and verifying that they exist in the
     * system.
     */
    @Test
    public void testAddMultipleJobs() {
        JobSearch js = new JobSearch1L();
        JobPosting job1 = new JobPosting("101", "Customer Service", "BestBuy",
                List.of("Communication", "Bachelors Degree",
                        "Working with people"),
                "Sponsorship Available", List.of("English", "Spanish"),
                "Columbus");

        JobPosting job2 = new JobPosting("102", "Technician", "Walmart",
                List.of("Computer Skills", "Microsoft Excel",
                        "Experience with fixing technology"),
                "Work Visa", List.of("N/A"), "Hilliard");

        js.addJob(job1);
        js.addJob(job2);

        boolean found1 = false;
        for (JobPosting j : js.getAllJobs()) {
            if (j.equals(job1)) {
                found1 = true;
                break;
            }
        }

        boolean found2 = false;
        for (JobPosting j : js.getAllJobs()) {
            if (j.equals(job2)) {
                found1 = true;
                break;
            }
        }
        assertTrue(found1);
        assertTrue(found2);
    }

    /**
     * Tests adding a duplicate job.
     */
    @Test
    public void testAddDuplicateJob() {
        JobSearch js = new JobSearch1L();
        JobPosting job1 = new JobPosting("101", "Customer Service", "BestBuy",
                List.of("Communication", "Bachelors Degree",
                        "Working with people"),
                "Sponsorship Available", List.of("English", "Spanish"),
                "Columbus");

        JobPosting job2 = new JobPosting("102", "Technician", "Walmart",
                List.of("Computer Skills", "Microsoft Excel",
                        "Experience with fixing technology"),
                "Work Visa", List.of("N/A"), "Hilliard");

        js.addJob(job1);
        js.addJob(job2);

        boolean found1 = false;
        for (JobPosting j : js.getAllJobs()) {
            if (j.equals(job1)) {
                found1 = true;
                break;
            }
        }

        boolean found2 = false;
        for (JobPosting j : js.getAllJobs()) {
            if (j.equals(job2)) {
                found1 = true;
                break;
            }
        }
        assertTrue(found1);
        assertTrue(found2);
    }

    /**
     * Tests removing a job and verifying that it no longer exists in the
     * system.
     */
    @Test
    public void testRemoveJob() {
        JobSearch js = new JobSearch1L();
        JobPosting job = new JobPosting("101", "Customer Service", "BestBuy",
                List.of("Communication", "Bachelors Degree",
                        "Working with people"),
                "Sponsorship Available", List.of("English", "Spanish"),
                "Columbus");

        js.addJob(job);
        JobPosting removed = js.removeJob("101");

        boolean found = false;
        for (JobPosting j : js.getAllJobs()) {
            if (j.equals(job)) {
                found = true;
                break;
            }
        }
        assertEquals("101", removed.jobID());
        assertFalse(found);
    }

    /**
     * Tests removing a job and returning the correct JobPosting.
     */
    @Test
    public void testRemoveJobReturnsCorrectJob() {
        JobSearch js = new JobSearch1L();
        JobPosting job = new JobPosting("101", "Customer Service", "BestBuy",
                List.of("Communication", "Bachelors Degree",
                        "Working with people"),
                "Sponsorship Available", List.of("English", "Spanish"),
                "Columbus");

        js.addJob(job);
        JobPosting removed = js.removeJob("101");

        assertEquals(job, removed);
    }

    /**
     * Tests removing one job when multiple exist and verifying others remain.
     */
    @Test
    public void testRemoveOneJobAmongMany() {
        JobSearch js = new JobSearch1L();
        JobPosting job1 = new JobPosting("101", "Customer Service", "BestBuy",
                List.of("Communication", "Bachelors Degree",
                        "Working with people"),
                "Sponsorship Available", List.of("English", "Spanish"),
                "Columbus");

        JobPosting job2 = new JobPosting("102", "Technician", "Walmart",
                List.of("Computer Skills", "Microsoft Excel",
                        "Experience with fixing technology"),
                "Work Visa", List.of("N/A"), "Hilliard");

        js.addJob(job1);
        js.addJob(job2);
        js.removeJob("101");

        boolean found1 = false;
        for (JobPosting j : js.getAllJobs()) {
            if (j.equals(job1)) {
                found1 = true;
                break;
            }
        }

        boolean found2 = false;
        for (JobPosting j : js.getAllJobs()) {
            if (j.equals(job2)) {
                found2 = true;
                break;
            }
        }
        assertFalse(found1);
        assertTrue(found2);

    }
}
