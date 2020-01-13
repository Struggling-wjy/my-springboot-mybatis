package com.example.myspringbootmybatis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
public class DateConfig {
    @Bean
    public Converter<String, Date> addNewConverter(){
        return new Converter<String, Date>() {
            @Override
            public Date convert(String source) {
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date=null;
                try {
                    date=sdf.parse(source);
                } catch (ParseException e) {
                    SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd HH:mm");
                    try{
                        date=sdf2.parse(source);
                    } catch (ParseException ex) {
                        SimpleDateFormat sdf3= new SimpleDateFormat("yyyy-MM-dd");
                        try {
                            date=sdf3.parse(source);
                        } catch (ParseException exception) {
                            System.out.println("日期格式转换错误"+exception);
                        }
                    }
                }
                return date;
            }
        };
    }
}

