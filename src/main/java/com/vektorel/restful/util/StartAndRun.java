package com.vektorel.restful.util;

import com.vektorel.restful.entity.Country;
import com.vektorel.restful.repository.CountryRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

@Configuration
@RequiredArgsConstructor
public class StartAndRun {

    private final CountryRepository countryRepository;

    @PostConstruct
    public void init(){

        new Thread(()->{
            saveCountries();
        }).start();

    }





    // bu metot şehir json dosyası okuyup db ye kayıt etmeli
    public void saveCountries(){
        if (!countryRepository.findAll().isEmpty()){
            return;
        }
        // try-with-resources
        try(BufferedReader bufferedReader =
                      new BufferedReader(new FileReader("Country.txt"))) {

            String satir;

            while ((satir=bufferedReader.readLine())!=null){

                if (satir.length()>3){

                    String [] ss=satir.split("'");
                    // ülke adi 1.indexten gelmektedir.
                  // System.out.print(ss[1]);
                    Country country= new Country();
                    country.setName(ss[1]);
                    countryRepository.save(country);
                }

            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }


}
