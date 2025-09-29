package components;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * JobSearch use case that creates job postings, adds them to the job search,
 * and then filters them based on user-defined criteria.
 * <p>
 *
 * @author Azra
 */
public final class JobSearchDemo {

        /**
         * Private constructor.
         */
        private JobSearchDemo() {

        }

        /**
         * Main method.
         *
         * @param args
         *                Command-line arguments (not used).
         */
        public static void main(String[] args) {

                JobSearch js = new JobSearch1L();

                JobPosting job1 = new JobPosting("101", "Customer Service",
                                "BestBuy",
                                List.of("Communication", "Bachelors Degree",
                                                "Working with people"),
                                "Sponsorship Available",
                                List.of("English", "Spanish"), "Columbus");
                js.addJob(job1);

                JobPosting job2 = new JobPosting("102", "Technician", "BestBuy",
                                List.of("Computer Skills", "Microsoft Excel",
                                                "Experience with fixing technology"),
                                "Work Visa", List.of("N/A"), "Hilliard");
                js.addJob(job2);

                Map<String, String> criteria = new HashMap<>();
                criteria.put("languages", "Spanish");
                criteria.put("location", "Columbus");
                criteria.put("workAuthorization", "Sponsorship Available");

                System.out.println(
                                "Filtered Jobs (Spanish, Columbus, Sponsorship Available):");
                List<JobPosting> filteredJobs = js
                                .filterByMultiCriteria(criteria);

                for (JobPosting job : filteredJobs) {
                        System.out.println(job);
                }
        }
}
