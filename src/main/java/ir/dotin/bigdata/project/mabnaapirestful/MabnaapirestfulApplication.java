package ir.dotin.bigdata.project.mabnaapirestful;

import ir.dotin.bigdata.project.mabnaapirestful.api.response.calendars.OccasionTypesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.PercentageDealerTypesModel;
import ir.dotin.bigdata.project.mabnaapirestful.service.calendars.CalendarsService;
import ir.dotin.bigdata.project.mabnaapirestful.service.calendars.DatesService;
import ir.dotin.bigdata.project.mabnaapirestful.service.calendars.OccasionTypesService;
import ir.dotin.bigdata.project.mabnaapirestful.service.contracts.ContractStylesService;
import ir.dotin.bigdata.project.mabnaapirestful.service.contracts.ContractTypesService;
import ir.dotin.bigdata.project.mabnaapirestful.service.exchange.*;
import ir.dotin.bigdata.project.mabnaapirestful.service.stock.*;
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

    @Autowired
    private PercentageActionTypesService percentageActionTypesService;

    @Autowired
    private PercentageDealerTypesService percentageDealerTypesService;

    @Autowired
    private PercentagesService percentagesService;

    @Autowired
    private InstrumentGroupService instrumentGroupService;

    @Autowired
    private ContractStylesService contractStylesService;

    @Autowired
    private ContractTypesService contractTypesService;

    @Autowired
    private AssetStatesService assetStatesService;

    @Autowired
    private AssetTypesService assetTypesService;

    @Autowired
    private BoardsService boardsService;

    @Autowired
    private ExchangesService exchangesService;

    @Autowired
    private GenderTypesService genderTypesService;

    @Autowired
    private IndexesService indexesService;

    @Autowired
    private InstrumentExchangeStatesService instrumentExchangeStatesService;

    @Autowired
    private InstrumentGroupStateTypesService instrumentGroupStateTypesService;

    @Autowired
    private MarketsService marketsService;

    @Autowired
    private PersonsService personsService;

    @Autowired
    private ReportSubTitlesService reportSubTitlesService;

    @Autowired
    private ReportTitlesService reportTitlesService;

    @Autowired
    private CompanyContactInfoTypesService companyContactInfoTypesService;

    @Autowired
    private MeetingTypesService meetingTypesService;

    @Autowired
    private ProductsService productsService;

    @Autowired
    private DirectorTypesService directorTypesService;


    public static void main(String[] args) {
        SpringApplication.run(MabnaapirestfulApplication.class, args).close();
    }

    @Autowired
    private PositionsService positionsService;

    @Override
    public void run(String... args) throws Exception {
//        calendarsService.save();
//        datesService.save();
//        occasionTypesService.save();
//        sourcesService.save();
//        reportSourcesService.save();
//        marketMessagesService.save();
//        percentageActionTypesService.save();
//        percentageDealerTypesService.save();
//        percentagesService.save();
//        instrumentGroupService.save();
//        contractStylesService.save();
//       contractTypesService.save();
//        assetStatesService.save();
//        assetTypesService.save();
//        boardsService.save();
//        exchangesService.save();
//        genderTypesService.save();
//        indexesService.save();
//        instrumentExchangeStatesService.save()
//     instrumentGroupStateTypesService.save();
//     marketsService.save();
//        personsService.save(); //Error: gender_type is not string
//        reportSubTitlesService.save();
//        reportTitlesService.save();
//        companyContactInfoTypesService.save();
 //       meetingTypesService.save();
        //productsService.save();
        //directorTypesService.save();
        positionsService.save();

    }
}
