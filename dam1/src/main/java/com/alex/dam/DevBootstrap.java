package com.alex.dam;


import com.alex.dam.model.*;
import com.alex.dam.services.*;
import javafx.util.Builder;
import org.json.*;
import org.json.JSONArray;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final ParticipantService participantService;
    private final AddressService addressService;
    private final UserService userService;
    private final SessionService sessionService;
    private final PREService preService;
    private final OfferService offerService;
    private final OfferInstrumentService offerInstrumentService;


    public DevBootstrap(ParticipantService participantService, AddressService addressService, UserService userService,
                        SessionService sessionService, PREService preService, OfferService offerService, OfferInstrumentService offerInstrumentService) {
        this.participantService = participantService;
        this.addressService = addressService;
        this.userService = userService;
        this.sessionService = sessionService;
        this.preService = preService;
        this.offerService = offerService;
        this.offerInstrumentService=offerInstrumentService;

    }
    //private CompanyRepository companyRepository;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        try {
            initData();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void initData() throws ParseException {

        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");

        Date d1 = df.parse("29-11-2019");
        Date d2 = df.parse("30-11-2019");
        //enter addresses from json file
//        String fisier = "/Users/Alex/GitCursSIIT/dam1/src/main/java/com/alex/dam/adrese1.json";
//        File file = new File(fisier);
//        try {
//            String content = FileUtils.readFileToString(file, "utf-8");
//            JSONArray jsonArray =  new JSONArray(content);
//
//            for(int i=0;i<(jsonArray.length());i++){
//
//                JSONObject jsonObj = jsonArray.getJSONObject(i);
//                String streetname = (String) jsonObj.get("streetname");
//                String sstreetnumber = (String)jsonObj.get("streetnumber");
//                Integer streetnumber = Integer.parseInt(sstreetnumber);
//                String city = (String) jsonObj.get("city");
//                String country = (String) jsonObj.get("country");
//                String phoneNumber = (String) jsonObj.get("phone");
//                Address adresa = new Address(streetname,streetnumber,city,country,phoneNumber);
//                addressRepository.save(adresa);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//

//
//        Address pallady = new Address("Theodor Pallady",23,"Bucharest","Romania","0723518547");
//        Address berceni = new Address("Aleea Niculitel",25,"Bucharest","Romania","0723333547");
//        Address drtaberei = new Address("Valea Cascadelor",25,"Bucharest","Romania","0723323547");
//
//
        Address address11 = Address.builder().street("Dristorului").city("Timisoara").streetNumber(25).country("Romania").phoneNumber("0745323233").build();
        Address address12 = Address.builder().street("Soseaua Nordului").city("Bucuresti").streetNumber(15).country("Romania").phoneNumber("0745323233").build();
        Address address13 = Address.builder().street("Dristorului").city("Bucuresti").streetNumber(12).country("Romania").phoneNumber("0745363233").build();
        Address address14 = Address.builder().street("Stefan cel mare").city("Timisoara").streetNumber(5).country("Romania").phoneNumber("0745323833").build();
        Address address15 = Address.builder().street("Mihai Bravu").city("Bucuresti").streetNumber(28).country("Romania").phoneNumber("0745353233").build();

//        addressService.save(address11);
//        addressService.save(address12);
//        addressService.save(address13);
//        addressService.save(address14);
//        addressService.save(address15);

        PRE pre1=PRE.builder().codPre("12X32398R232").name("Echilibrarea SA").address(address11).companyStatus(Status.ACTIVE).registrationNumber("RO243523").build();
        PRE pre2=PRE.builder().codPre("12X32398R789").name("Balancing SA").address(address12).companyStatus(Status.ACTIVE).registrationNumber("RO342123").build();

        preService.save(pre1);
        preService.save(pre2);

        Participant part1 = Participant.builder().name("Turceni SA").address(address13).companyStatus(Status.ACTIVE).registrationNumber("RO223523").pre(pre1).build();
        Participant part2 = Participant.builder().name("Hidro Volt SA").address(address14).companyStatus(Status.ACTIVE).registrationNumber("RO943523").pre(pre1).build();
        Participant part3 = Participant.builder().name("Cazanul SA").address(address15).companyStatus(Status.ACTIVE).registrationNumber("RO023523").pre(pre2).build();



        participantService.save(part1);
        participantService.save(part2);
        participantService.save(part3);

        System.out.println("Loaded participants");

        User user1 = User.builder().name("turceni1").email("turceni1@turceni.ro").password("turceni1").participant(part1).build();
        User user2= User.builder().name("turceni2").email("turceni2@turceni.ro").password("turceni2").participant(part1).build();
        User user3 = User.builder().name("volt1").email("volt1@turceni.ro").password("volt2").participant(part2).build();
        User user4 = User.builder().name("volt2").email("volt2@turceni.ro").password("volt2").participant(part2).build();
        User user5 = User.builder().name("cazan1").email("cazan1@turceni.ro").password("cazan1").participant(part3).build();

        userService.save(user1);
        userService.save(user2);
        userService.save(user3);
        userService.save(user4);
        userService.save(user5);



        Session session1=new Session(d1,d2);
        sessionService.save(session1);

//        Offer offer1 = Offer.builder().dateTimeCreation(new Date()).user(user1).orderType(OrderType.SELL).build();
//        Offer offer2 = Offer.builder().dateTimeCreation(new Date()).user(user2).orderType(OrderType.BUY).build();
//        Offer offer3 = Offer.builder().dateTimeCreation(new Date()).user(user3).orderType(OrderType.BUY).build();
//



        Offer offer1 = new Offer(session1,user1,OrderType.SELL);
        Offer offer2 = new Offer(session1,user2,OrderType.BUY);
        Offer offer3 = new Offer(session1,user3,OrderType.SELL);
        Offer offer4 = new Offer(session1,user4,OrderType.BUY);
        Offer offer5 = new Offer(session1,user5,OrderType.SELL);
        //OfferInstrument offerInstrument25  = new OfferInstrument(offer1,1,20.5f,50.2f);


//        OfferInstrument offerInstrument1 = OfferInstrument.builder().offer(offer1).instrument(1).quantity(10.2f).price(100.2f).build();
//        OfferInstrument offerInstrument2 = OfferInstrument.builder().offer(offer1).instrument(2).quantity(10.1f).price(100.2f).build();
//        OfferInstrument offerInstrument3 = OfferInstrument.builder().offer(offer1).instrument(3).quantity(10.1f).price(100.2f).build();
//        OfferInstrument offerInstrument4 = OfferInstrument.builder().offer(offer1).instrument(4).quantity(10.1f).price(100.2f).build();
//        OfferInstrument offerInstrument5 = OfferInstrument.builder().offer(offer1).instrument(5).quantity(10.1f).price(100.2f).build();
//        OfferInstrument offerInstrument6 = OfferInstrument.builder().offer(offer2).instrument(6).quantity(10.1f).price(100.2f).build();
//        OfferInstrument offerInstrument7 = OfferInstrument.builder().offer(offer2).instrument(7).quantity(10.1f).price(100.2f).build();
//        OfferInstrument offerInstrument8 = OfferInstrument.builder().offer(offer2).instrument(8).quantity(10.1f).price(100.2f).build();
//        OfferInstrument offerInstrument9 = OfferInstrument.builder().offer(offer3).instrument(9).quantity(10.1f).price(100.2f).build();
//        OfferInstrument offerInstrument10 = OfferInstrument.builder().offer(offer3).instrument(10).quantity(10.1f).price(100.2f).build();
//        OfferInstrument offerInstrument11 = OfferInstrument.builder().offer(offer1).instrument(11).quantity(10.1f).price(100.2f).build();
//        OfferInstrument offerInstrument12 = OfferInstrument.builder().offer(offer3).instrument(12).quantity(10.1f).price(100.2f).build();
//        OfferInstrument offerInstrument13 = OfferInstrument.builder().offer(offer1).instrument(13).quantity(10.1f).price(100.2f).build();
//        OfferInstrument offerInstrument14 = OfferInstrument.builder().offer(offer1).instrument(14).quantity(10.1f).price(100.2f).build();
//        OfferInstrument offerInstrument15 = OfferInstrument.builder().offer(offer1).instrument(15).quantity(10.1f).price(100.2f).build();
//        OfferInstrument offerInstrument16 = OfferInstrument.builder().offer(offer1).instrument(16).quantity(10.1f).price(100.2f).build();
//        OfferInstrument offerInstrument17 = OfferInstrument.builder().offer(offer1).instrument(17).quantity(10.1f).price(100.2f).build();
//        OfferInstrument offerInstrument18 = OfferInstrument.builder().offer(offer1).instrument(18).quantity(10.1f).price(100.2f).build();
//        OfferInstrument offerInstrument19 = OfferInstrument.builder().offer(offer1).instrument(19).quantity(10.1f).price(100.2f).build();
//        OfferInstrument offerInstrument20 = OfferInstrument.builder().offer(offer1).instrument(20).quantity(10.1f).price(100.2f).build();
//        OfferInstrument offerInstrument21 = OfferInstrument.builder().offer(offer1).instrument(21).quantity(10.1f).price(100.2f).build();
//        OfferInstrument offerInstrument22 = OfferInstrument.builder().offer(offer1).instrument(22).quantity(10.1f).price(100.2f).build();
//        OfferInstrument offerInstrument23 = OfferInstrument.builder().offer(offer1).instrument(23).quantity(10.1f).price(100.2f).build();
//        OfferInstrument offerInstrument24 = OfferInstrument.builder().offer(offer1).instrument(24).quantity(10.1f).price(100.2f).build();

        //offer1.getInstruments().add(offerInstrument25);
          //offer1.getInstruments().add(OfferInstrument.builder().instrument(1).quantity(10.2f).price(100.2f).build());


        OfferInstrument offerInstrument25  = new OfferInstrument(offer1,1,20.5f,50.2f);
        offer1.setInstrument(offerInstrument25.getInstrument()-1,offerInstrument25);
//        offer1.getInstruments().add(OfferInstrument.builder().offer(offer1).instrument(2).quantity(10.1f).price(100.2f).build());
//        offer1.getInstruments().add(OfferInstrument.builder().offer(offer1).instrument(3).quantity(10.1f).price(100.2f).build());
//        offer2.getInstruments().add(OfferInstrument.builder().offer(offer2).instrument(3).quantity(10.1f).price(100.2f).build());
//        offer2.getInstruments().add(OfferInstrument.builder().offer(offer2).instrument(3).quantity(10.1f).price(100.2f).build());
//        offer2.getInstruments().add(OfferInstrument.builder().offer(offer2).instrument(3).quantity(10.1f).price(100.2f).build());
//        offer3.getInstruments().add(OfferInstrument.builder().offer(offer3).instrument(3).quantity(10.1f).price(100.2f).build());
//        offer3.getInstruments().add(OfferInstrument.builder().offer(offer3).instrument(3).quantity(10.1f).price(100.2f).build());
//        offer3.getInstruments().add(OfferInstrument.builder().offer(offer3).instrument(3).quantity(10.1f).price(100.2f).build());

        offerService.save(offer1);
        offerService.save(offer2);
        offerService.save(offer3);
        offerService.save(offer4);
        offerService.save(offer5);
//        offerService.save(offer2);
//        offerService.save(offer3);







//        addressRepository.save(pallady);
//        addressRepository.save(berceni);
//        addressRepository.save(drtaberei);
        //addressRepository.save(pallady);
        //addressRepository.save(berceni);
//        PRE pre1=new PRE("SC ECHILIBRU SA", "RO232321", Status.ACTIVE, "30XROCELMAI", berceni);
//        Participant partip1 = new Participant("SC ACASA SA","RO543212", Status.ACTIVE, pre1, pallady);
//        Participant partip2 = new Participant("SC RULMENTUL SA","RO123212", Status.ACTIVE, pre1, drtaberei);
//        preRepository.save(pre1);
//        participantRepository.save(partip1);
//        participantRepository.save(partip2);

        //Company acasa = new Company();
        //companyRepository.save(acasa);

        //Company acasa1 = new Company("SC ACASA1 SA",pallady,"RO543212", Status.ACTIVE);
        //companyRepository.save(acasa1);

    }

}
