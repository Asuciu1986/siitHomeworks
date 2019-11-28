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

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final ParticipantService participantService;
    private final AddressService addressService;
    private final UserService userService;
    private final SessionService sessionService;
    private final PREService preService;
    private final OfferService offerService;


    public DevBootstrap(ParticipantService participantService, AddressService addressService, UserService userService, SessionService sessionService, PREService preService, OfferService offerService) {
        this.participantService = participantService;
        this.addressService = addressService;
        this.userService = userService;
        this.sessionService = sessionService;
        this.preService = preService;
        this.offerService = offerService;

    }
    //private CompanyRepository companyRepository;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){


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
