/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esinf;

import javax.swing.plaf.IconUIResource;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

/**
 * @author DEI-ISEP
 */
public class Supermarket {
    Map<Invoice, Set<Product>> sup;

    Supermarket() {
        sup = new HashMap<>();
    }

    // Reads invoices from a list of String
    void getInvoices(List<String> l) throws Exception {
        Invoice invoice = null;
        Set<Product> productSet = null;
        for (String line : l) {
            if (line.trim().charAt(0) == 'I') {
                if (invoice != null) {
                    sup.put(invoice, productSet);
                }
                String[] temp = line.split(",");
                invoice = new Invoice(temp[1], temp[2]);
                productSet = new HashSet<>();
            }
            if (line.trim().charAt(0) == 'P') {
                String[] temp = line.trim().split(",");
                Product product = new Product(temp[1], Integer.parseInt(temp[2]), Long.parseLong(temp[3]));
                productSet.add(product);
            }
        }
        sup.put(invoice, productSet);
    }

    // returns a set in which each number is the number of products in the r
    // invoice 
    Map<Invoice, Integer> numberOfProductsPerInvoice() {
        Map<Invoice, Integer> ProductsPerInvoice = new HashMap<>();
        for (Invoice inv : sup.keySet()) {
            Set<Product> productSet = sup.get(inv);
            Integer count = productSet.size();
            ProductsPerInvoice.put(inv, count);
        }
        return ProductsPerInvoice;
    }

    // returns a Set of invoices in which each date is >d1 and <d2
    Set<Invoice> betweenDates(LocalDate d1, LocalDate d2) {
        Set<Invoice> inv = new HashSet<>();
        for (Invoice invoice : sup.keySet()) {
            if (invoice.getDate().compareTo(d1) > 0 && invoice.getDate().compareTo(d2) < 0) {
                inv.add(invoice);
            }
        }
        return inv;
    }

    // returns the sum of the price of the product in all the invoices
    long totalOfProduct(String productId) {
        long sum = 0;
        for (Invoice inv : sup.keySet()) {
            Set<Product> productSet = sup.get(inv);
            for (Product prod : productSet) {
                //validar produto
                if (productId.equals(prod.getIdentification())) {
                    sum += prod.getPrice() * prod.getQuantity();
                }
            }
        }

        return sum;
    }

    // converts a map of invoices and products to a map which key is a product
    // identification and the values are a set of the invoices in which it appears
    Map<String, Set<Invoice>> convertInvoices() {
        Map<String, Set<Invoice>> invertMap = new HashMap<>();

        for (Invoice inv : sup.keySet()){
            Set<Product> productSet= sup.get(inv);
            for (Product prod: productSet){
                if(invertMap.containsKey(prod.getIdentification())){
                    invertMap.get(prod.getIdentification()).add(inv);
                }else{
                    Set<Invoice>invoiceSet = new HashSet<>();
                    invoiceSet.add(inv);
                    invertMap.put(prod.getIdentification(),invoiceSet);
                }
            }
        }

        return invertMap;
    }

}
