package ir.dotin.bigdata.project.mabnaapirestful;

import ir.dotin.bigdata.project.mabnaapirestful.service.bonds.BondsService;
import ir.dotin.bigdata.project.mabnaapirestful.service.bonds.InterestPaymentsService;
import ir.dotin.bigdata.project.mabnaapirestful.service.broker.BrokersService;
import ir.dotin.bigdata.project.mabnaapirestful.service.MortgageLoans.MortgageLoansService;
import ir.dotin.bigdata.project.mabnaapirestful.service.TestService;
import ir.dotin.bigdata.project.mabnaapirestful.service.bonds.BondAuthorityTypesService;
import ir.dotin.bigdata.project.mabnaapirestful.service.calendars.CalendarsService;
import ir.dotin.bigdata.project.mabnaapirestful.service.calendars.DatesService;
import ir.dotin.bigdata.project.mabnaapirestful.service.calendars.OccasionTypesService;
import ir.dotin.bigdata.project.mabnaapirestful.service.contracts.ContractHistoryService;
import ir.dotin.bigdata.project.mabnaapirestful.service.contracts.ContractStylesService;
import ir.dotin.bigdata.project.mabnaapirestful.service.contracts.ContractTypesService;
import ir.dotin.bigdata.project.mabnaapirestful.service.contracts.ContractsService;
import ir.dotin.bigdata.project.mabnaapirestful.service.exchange.*;
import ir.dotin.bigdata.project.mabnaapirestful.service.stock.*;
import ir.dotin.bigdata.project.mabnaapirestful.service.fund.DividendPaymentsService;
import ir.dotin.bigdata.project.mabnaapirestful.service.fund.FundValuesService;
import ir.dotin.bigdata.project.mabnaapirestful.service.fund.FundsService;
import ir.dotin.bigdata.project.mabnaapirestful.service.fund.RatingsService;
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

    @Autowired
    private IndexInstrumentEffectsService indexInstrumentEffectsService;

    @Autowired
    TradesService tradesService;

    @Autowired
    private InstrumentBaseVolumesService instrumentBaseVolumesService;

    @Autowired
    private InstrumentStaticThresholdsService instrumentStaticThresholdsService;

    @Autowired
    private AssetsService assetsService;

    @Autowired
    private InitialPublicOfferingsService initialPublicOfferingsService;

    @Autowired
    private BidAsksService bidAsksService;

    @Autowired
    private TheoreticalOpeningPricesService theoreticalOpeningPricesService;

    @Autowired
    private IndexInstrumentsService indexInstrumentsService;

    @Autowired
    private PercentageValuesService percentageValuesService;

    @Autowired
    private BoardOfDirectorsItemsService boardOfDirectorsItemsService;

    @Autowired
    private BalancesheetsService balancesheetsService;

    @Autowired
    private ProfitLossesService profitLossesService;

    @Autowired
    private ReportImagesService reportImagesService;

    @Autowired
    private ProfitLossItemsService profitLossItemsService;

    @Autowired
    private CashFlowsService cashFlowsService;

    @Autowired
    private CashFlowItemsService cashFlowItemsService;

    @Autowired
    private AssetCategoriesService assetCategoriesService;

    @Autowired
    private InstrumentGroupStatesService instrumentGroupStatesService;

    @Autowired
    private EpsesService epsesService;

    @Autowired
    private ProductionSalesService productionSalesService;

    @Autowired
    private MeetingInvitesService meetingInvitesService;

    @Autowired
    private UnitsService unitsService;

    @Autowired
    private CapitalChangesService capitalChangesService;

    @Autowired
    private ProductionSaleItemsService productionSaleItemsService;

    @Autowired
    private ShareHoldersItemsService shareHoldersItemsService;

    @Autowired
    private BalancesheetItemsService balancesheetItemsService;

    @Autowired
    private TradeDetailsService tradeDetailsService;

    @Autowired
    private InstrumentStatesService instrumentStatesService;

    @Autowired
    private InterestPaymentsService interestPaymentsService;

    @Autowired
    private BondsService bondsService;

    @Autowired
    private ContractHistoryService contractHistoryService;

    @Autowired
    private IntradayTradesService intradayTradesService;

    public static void main(String[] args) {
        SpringApplication.run(MabnaapirestfulApplication.class, args).close();
    }



    @Override
    public void run(String... args) throws Exception {
//        reportImagesService.save();

        // categoriesService.save();
//        assetsService.save();
//        testService.test();
//        profitLossesService.save();
//        calendarsService.save();
//        datesService.save();
//        occasionTypesService.save();
        //  sourcesService.save();
       // reportSourcesService.save();
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
//        companyContactInfoTypesService.save();
//        meetingTypesService.save();
//        productsService.save();
//        directorTypesService.save();
//        positionsService.save();
       //newsService.save();
//        balancesheetFieldsService.save();
//        cashflowFieldsService.save();
//        profitlossFieldsService.save();
//        bondAuthorityTypesService.save();
//        indexTradeSummariesService.save();
//        indexIntradayTradeSummariesService.save();
//        indexValuesService.save();
//        mortgageLoansService.save();
//        indexIntradayValuesService.save();
//        companiesService.save();
//        contractsService.save();
//        fundsService.save();
//        categoriesService.save();
//        reportsService.save();
//        brokersService.save();
//        fundValuesService.save();
//        ratingsService.save();
//        dividendPaymentsService.save()
//        companyContactInfosService.save();
//        meetingsService.save();
//        companyCategoriesService.save();
//        freeFloatsService.save();
//        shareHoldersService.save();
//        instrumentsService.save();
//        percentageGroupsService.save();
//        boardOfDirectorsService.save();
//        dividendPayoutsService.save();
//        indexInstrumentEffectsService.save();
//        tradesService.save();
//        instrumentBaseVolumesService.save();
//        instrumentStaticThresholdsService.save();
//        assetsService.save();//todo: categories is a list not inserted
//        initialPublicOfferingsService.save();
//        bidAsksService.save();
//        theoreticalOpeningPricesService.save();
//        indexInstrumentsService.save();
//        percentageValuesService.save();
//        boardOfDirectorsItemsService.save();
//        balancesheetsService.save();
//        profitLossItemsService.save();
//        cashFlowsService.save();
//        cashFlowItemsService.save();
//        cashflowFieldsService.save();
//        reportsService.save();
//        assetCategoriesService.save();
//        instrumentGroupStatesService.save();
//        epsesService.save();
//        productionSalesService.save();
//        meetingInvitesService.save();
//        unitsService.save();
//        capitalChangesService.save();
//        productionSaleItemsService.save();
//        shareHoldersItemsService.save();
//        balancesheetItemsService.save();
//        tradeDetailsService.save();
//        instrumentStatesService.save();
//        interestPaymentsService.save();
//        bondsService.save();
//        contractHistoryService.save();
        intradayTradesService.save();

    }
}
