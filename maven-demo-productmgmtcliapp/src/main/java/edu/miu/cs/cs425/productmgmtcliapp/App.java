package edu.miu.cs.cs425.productmgmtcliapp;

import edu.miu.cs.cs425.productmgmtcliapp.data.ProductDAO;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World of Maven!" );
        var dao = new ProductDAO();
        var products = dao.getProducts();
        products.stream()
                .forEach(System.out::println);
    }
}
