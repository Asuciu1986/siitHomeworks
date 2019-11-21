package com.alex.dam;


import com.alex.dam.Model.*;
import com.alex.dam.Repository.AddressRepository;
import com.alex.dam.Repository.CompanyRepository;
import com.alex.dam.Repository.PRERepository;
import com.alex.dam.Repository.ParticipantRepository;
import org.json.*;
import org.json.JSONArray;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Set;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private ParticipantRepository participantRepository;
    private AddressRepository addressRepository;
    private PRERepository preRepository;
    //private CompanyRepository companyRepository;

    public DevBootstrap(AddressRepository addressRepository, ParticipantRepository participantRepository, PRERepository preRepository){
        this.addressRepository=addressRepository;
        this.participantRepository=participantRepository;
        this.preRepository=preRepository;
        //this.companyRepository=companyRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){


        //enter addresses from json file
        String fisier = "D:\\GitRepo\\cplusplus\\dam1\\src\\main\\java\\com\\alex\\dam\\adrese1.json";
        File file = new File(fisier);


        try {
            String content = FileUtils.readFileToString(file, "utf-8");
            JSONArray jsonArray =  new JSONArray(content);

            for(int i=0;i<(jsonArray.length());i++){

                JSONObject jsonObj = jsonArray.getJSONObject(i);
                String streetname = (String) jsonObj.get("streetname");
                String sstreetnumber = (String)jsonObj.get("streetnumber");
                Integer streetnumber = Integer.parseInt(sstreetnumber);
                String city = (String) jsonObj.get("city");
                String country = (String) jsonObj.get("country");
                String phoneNumber = (String) jsonObj.get("phone");
                Address adresa = new Address(streetname,streetnumber,city,country,phoneNumber);
                addressRepository.save(adresa);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }



        Address pallady = new Address("Theodor Pallady",23,"Bucharest","Romania","0723518547");
        Address berceni = new Address("Aleea Niculitel",25,"Bucharest","Romania","0723333547");
        Address drtaberei = new Address("Valea Cascadelor",25,"Bucharest","Romania","0723323547");
//        addressRepository.save(pallady);
//        addressRepository.save(berceni);
//        addressRepository.save(drtaberei);
        //addressRepository.save(pallady);
        //addressRepository.save(berceni);
        PRE pre1=new PRE("SC ECHILIBRU SA", "RO232321", Status.ACTIVE, "30XROCELMAI", berceni);
        Participant partip1 = new Participant("SC ACASA SA","RO543212", Status.ACTIVE, pre1, pallady);
        Participant partip2 = new Participant("SC RULMENTUL SA","RO123212", Status.ACTIVE, pre1, drtaberei);
        preRepository.save(pre1);
        participantRepository.save(partip1);
        participantRepository.save(partip2);

        //Company acasa = new Company();
        //companyRepository.save(acasa);

        //Company acasa1 = new Company("SC ACASA1 SA",pallady,"RO543212", Status.ACTIVE);
        //companyRepository.save(acasa1);

    }

}
