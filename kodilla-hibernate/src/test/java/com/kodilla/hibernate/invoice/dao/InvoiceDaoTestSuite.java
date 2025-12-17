package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionMessage;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;

    @Autowired
    private ItemDao itemDao;

    @Autowired
    private ProductDao productDao;

    @Test
    void testInvoiceDaoSave() {
        //Given
        Product product1 = new Product("Iphone");
        Product product2 = new Product("Samsung TV");

        productDao.save(product1);
        productDao.save(product2);

        Item item1 = new Item(product1, new BigDecimal(2500), 3, new BigDecimal(4500));
        Item item2 = new Item(product2, new BigDecimal(5500), 1, new BigDecimal(7500));

        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);

        Invoice invoice = new Invoice("550143", items);

        item1.setInvoice(invoice);
        item2.setInvoice(invoice);
        //When
        invoiceDao.save(invoice);
        int invoiceId = invoice.getId();

        //Then
        assertNotNull(invoiceId);
        assertNotEquals(0, invoiceId);
        //CleanUp
        invoiceDao.deleteById(invoiceId);
        itemDao.delete(item1);
        itemDao.delete(item2);
        productDao.delete(product1);
        productDao.delete(product2);

    }
}
