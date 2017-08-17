package com.training.integration.springintegrationtraining;


public class TransferToBean {

    public Person transferToPerson(String str) {
        String[] per = str.split(",");
        Person person = new Person();
        person.setName(per[0]);
        person.setSurname(per[1]);
        person.setAge(Integer.parseInt(per[2]));
        return person;
    }

}
