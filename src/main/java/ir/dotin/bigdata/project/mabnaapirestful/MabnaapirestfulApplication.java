package ir.dotin.bigdata.project.mabnaapirestful;

import ir.dotin.bigdata.project.mabnaapirestful.service.broker.BrokersService;
import ir.dotin.bigdata.project.mabnaapirestful.service.MortgageLoans.MortgageLoansService;
import ir.dotin.bigdata.project.mabnaapirestful.service.TestService;
import ir.dotin.bigdata.project.mabnaapirestful.service.bonds.BondAuthorityTypesService;
import ir.dotin.bigdata.project.mabnaapirestful.service.calendars.CalendarsService;
import ir.dotin.bigdata.project.mabnaapirestful.service.calendars.DatesService;
import ir.dotin.bigdata.project.mabnaapirestful.service.calendars.OccasionTypesService;
import ir.dotin.bigdata.project.mabnaapirestful.service.contracts.ContractStylesService;
import ir.dotin.bigdata.project.mabnaapirestful.service.contracts.ContractTypesService;
import ir.dotin.bigdata.project.mabnaapirestful.service.contracts.ContractsService;
import ir.dotin.bigdata.project.mabnaapirestful.service.exchange.*;
import ir.dotin.bigdata.project.mabnaapirestful.service.fund.DividendPaymentsService;
import ir.dotin.bigdata.project.mabnaapirestful.service.fund.FundValuesService;
import ir.dotin.bigdata.project.mabnaapirestful.service.fund.FundsService;
import ir.dotin.bigdata.project.mabnaapirestful.service.fund.RatingsService;
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


    @Autowired
    private PositionsService positionsService;

    @Autowired
    private NewsService newsService;

    @Autowired
    private BalancesheetFieldsService balancesheetFieldsService;

    @Autowired
    private CashflowFieldsService cashflowFieldsService;

    @Autowired
    private ProfitlossFieldsService profitlossFieldsService;

    @Autowired
    private BondAuthorityTypesService bondAuthorityTypesService;

    @Autowired
    private IndexTradeSummariesService indexTradeSummariesService;

    @Autowired
    private IndexIntradayTradeSummariesService indexIntradayTradeSummariesService;

    @Autowired
    private IndexValuesService indexValuesService;

    @Autowired
    private MortgageLoansService mortgageLoansService;

    @Autowired
    private IndexIntradayValuesService indexIntradayValuesService;

    @Autowired
    private CompaniesService companiesService;

    @Autowired
    private ContractsService contractsService;

    @Autowired
    private TestService testService;

    @Autowired
    private FundsService fundsService;

    @Autowired
    private CategoriesService categoriesService;

    @Autowired
    private ReportsService reportsService;

    @Autowired
    private BrokersService brokersService;

    @Autowired
    private FundValuesService fundValuesService;

    @Autowired
    private RatingsService ratingsService;

    @Autowired
    private DividendPaymentsService dividendPaymentsService;

    @Autowired
    private CompanyContactInfosService companyContactInfosService;

    @Autowired
    private MeetingsService meetingsService;

    @Autowired
    private CompanyCategoriesService companyCategoriesService;

    @Autowired
    private FreeFloatsService freeFloatsService;

    @Autowired
    private ShareHoldersService shareHoldersService;

    @Autowired
    private InstrumentsService instrumentsService;

    @Autowired
    private PercentageGroupsService percentageGroupsService;

    @Autowired
    private BoardOfDirectorsService boardOfDirectorsService;

    @Autowired
    private DividendPayoutsService dividendPayoutsService;

    public static void main(String[] args) {
        SpringApplication.run(MabnaapirestfulApplication.class, args).close();
    }



    @Override
    public void run(String... args) throws Exception {
        testService.test();
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
//        contractTypesService.save();
//        assetStatesService.save();
//        assetTypesService.save();
//        boardsService.save();
//        exchangesService.save();
//        genderTypesService.save();
//        indexesService.save();
//        instrumentExchangeStatesService.save();
//        instrumentGroupStateTypesService.save();
//        marketsService.save();
//        personsService.save(); //Error: gender_type is not string
//        reportSubTitlesService.save();
//        reportTitlesService.save();
 //      companyContactInfoTypesService.save();
//        meetingTypesService.save();
//        productsService.save();
//        directorTypesService.save();
//        positionsService.save();
//        newsService.save();
//        balancesheetFieldsService.save();
//        cashflowFieldsService.save();
//        profitlossFieldsService.save();
//        bondAuthorityTypesService.save();
//        indexTradeSummariesService.save();
//        indexIntradayTradeSummariesService.save();
//        indexValuesService.save();
//        mortgageLoansService.save();
//        indexIntradayValuesService.save();
//       companiesService.save();
  //      contractsService.save();
//        fundsService.save();
 //       categoriesService.save();
  //      reportsService.save();
  //      brokersService.save();
  //      fundValuesService.save();
//        ratingsService.save();
 //       dividendPaymentsService.save();
 //       companyContactInfosService.save();
//        meetingsService.save();
//        companyCategoriesService.save();
//        freeFloatsService.save();
//        shareHoldersService.save();
//        instrumentsService.save();
//        percentageGroupsService.save();
//        boardOfDirectorsService.save();
        dividendPayoutsService.save();

    }
}
