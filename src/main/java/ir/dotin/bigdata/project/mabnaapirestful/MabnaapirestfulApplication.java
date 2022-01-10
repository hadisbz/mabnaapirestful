package ir.dotin.bigdata.project.mabnaapirestful;

import ir.dotin.bigdata.project.mabnaapirestful.api.response.calendars.OccasionTypesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.service.calendars.CalendarsService;
import ir.dotin.bigdata.project.mabnaapirestful.service.calendars.DatesService;
import ir.dotin.bigdata.project.mabnaapirestful.service.calendars.OccasionTypesService;
import ir.dotin.bigdata.project.mabnaapirestful.service.exchange.MarketMessagesService;
import ir.dotin.bigdata.project.mabnaapirestful.service.exchange.ReportSourcesService;
import ir.dotin.bigdata.project.mabnaapirestful.service.exchange.SourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MabnaapirestfulApplication implements CommandLineRunner {

    @Autowired
    private CalendarsService calendarsService;

    @Autowired
    private DatesService datesService;

    @Autowired
    private OccasionTypesService occasionTypesService;

    @Autowired
    private SourcesService sourcesService;

    @Autowired
    private ReportSourcesService reportSourcesService;

    @Autowired
    private MarketMessagesService marketMessagesService;

    public static void main(String[] args) {
        SpringApplication.run(MabnaapirestfulApplication.class, args).close();
    }

    @Override
    public void run(String... args) throws Exception {
//        calendarsService.save();
//        datesService.save();
//        occasionTypesService.save();
//        sourcesService.save();
//        reportSourcesService.save();
        marketMessagesService.save();
    }
}
