package com.training.integration.springintegrationtraining.Flowa;

import com.training.integration.springintegrationtraining.Person;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.support.GenericMessage;

import java.io.IOException;
import java.util.List;

public class PersonMessageConverter implements HttpMessageConverter<Person> {

    @Override
    public boolean canRead(Class<?> aClass,
                           MediaType mediaType) {
        return true;
    }

    @Override
    public boolean canWrite(Class<?> aClass,
                            MediaType mediaType) {
        return true;
    }

    @Override
    public List<MediaType> getSupportedMediaTypes() {
        return null;
    }

    @Override
    public Person read(Class<? extends Person> aClass,
                       HttpInputMessage httpInputMessage) throws
                                                          IOException,
                                                          HttpMessageNotReadableException {
        return null;
    }

    @Override
    public void write(Person person,
                      MediaType mediaType,
                      HttpOutputMessage httpOutputMessage) throws
                                                           IOException,
                                                           HttpMessageNotWritableException {

    }
}
