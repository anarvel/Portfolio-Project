package components;

import java.util.List;

/**
 * JobSearch use case that adds jobs to the JobSearch component and printing all
 * jobs stored.
 *
 * @author Azra
 */
public final class JobSearchDemo2 {

        /**
         * Private constructor.
         */
        private JobSearchDemo2() {
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

                JobPosting job2 = new JobPosting("102", "Technician", "BestBuy",
                                List.of("Computer Skills", "Microsoft Excel",
                                                "Experience with fixing technology"),
                                "Work Visa", List.of("N/A"), "Hilliard");

                js.addJob(job1);
                js.addJob(job2);

                System.out.println("Added jobs:");
                for (JobPosting job : js.getAllJobs()) {
                        System.out.println(job);
                }
        }
}
