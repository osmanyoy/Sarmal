package com.training.spring.customer;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FileCustomerDAO implements ICustomerDAO {
    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customerList = new ArrayList<>();
        try (Stream<String> lines = Files.lines(Paths.get("cutomers.txt"))) {
            lines.map(line -> line.split(","))
                 .forEach(cust -> customerList.add(new Customer(Long.parseLong(cust[0]),
                                                                cust[1],
                                                                cust[2],
                                                                Integer.parseInt(cust[3]))));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return customerList;
    }
}
