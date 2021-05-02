package edu.cs.uga.DatabaseTermProject;

import edu.cs.uga.DatabaseTermProject.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Controller
public class HelloController {
    Connection conn;

    public HelloController() {
        //try-catch for when there is no connection to the database
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/brazil_ecomm?autoReconnect=true&useSSL=false", "root", "root");
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }


    //home page
    @GetMapping({"/", "/home"})
    public String index(Model model) {

        float avgProduct, minProduct, maxProduct, avgCategory, minCategory, maxCategory;
        avgProduct = minProduct = maxProduct = avgCategory = minCategory = maxCategory = 0;
        int countProduct, countCategory, countSeller, countCustomer;
        countProduct = countCategory = countSeller = countCustomer = 0;

        try {
            Statement statement = conn.createStatement();
            ResultSet res = statement.executeQuery("select count(seller_id) as countSeller from sellers");
            while (res.next()) {
                countSeller = res.getInt("countSeller");
            }

            statement = conn.createStatement();
            res = statement.executeQuery("select count(customer_id) as countCustomer from customers");
            while (res.next()) {
                countCustomer = res.getInt("countCustomer");
            }

            statement = conn.createStatement();
            res = statement.executeQuery("select round(avg(avgPrice),2) as totalAverage, round(min(avgPrice),2) as min , " +
                    "round(max(avgPrice),2) as max ,count(avgPrice) as count " +
                    "from (select avg(price) as avgPrice from order_items group by product_id) as prices ");
            while (res.next()) {
                avgProduct = res.getFloat("totalAverage");
                minProduct = res.getFloat("min");
                maxProduct = res.getFloat("max");
                countProduct = res.getInt("count");
            }

            statement = conn.createStatement();
            res = statement.executeQuery("select round(avg(avgPrice),2) as totalAverage, round(min(avgPrice),2) as minPrice , " +
                    "round(max(avgPrice),2) as maxPrice ,count(avgPrice) as count " +
                    "from (select avg(price) as avgPrice from order_items " +
                    "join products ON order_items.product_id  = products.product_id " +
                    "join product_category on products.product_category_name = product_category.product_category_name " +
                    "group by products.product_category_name) as prices ");
            while (res.next()) {
                avgCategory = res.getFloat("totalAverage");
                minCategory = res.getFloat("minPrice");
                maxCategory = res.getFloat("maxPrice");
                countCategory = res.getInt("count");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        model.addAttribute("countSeller", countSeller);
        model.addAttribute("countCustomer", countCustomer);
        model.addAttribute("avgCategory", avgCategory);
        model.addAttribute("minCategory", minCategory);
        model.addAttribute("maxCategory", maxCategory);
        model.addAttribute("countCategory", countCategory);
        model.addAttribute("avgProduct", avgProduct);
        model.addAttribute("minProduct", minProduct);
        model.addAttribute("maxProduct", maxProduct);
        model.addAttribute("countProduct", countProduct);
        return "home";
    }

    //products page
    @GetMapping({"/products"})
    public String products(@RequestParam(value = "page", defaultValue = "0") int page,
                           @RequestParam(value = "sort", defaultValue = "highToLow") String sort,
                           Model model) {
        if (page < 0) {
            page = 0;
        }
        General general = null;
        List<Product> products = new ArrayList<>();
        String query;
        switch (sort) {
            case "best-seller":
                query = "select round(avg(price),2) as avgPrice, products.product_id, product_category_name_english , count(order_items.product_id) as sold from order_items " +
                        "JOIN products ON order_items.product_id  = products.product_id " +
                        "JOIN product_category ON products.product_category_name = product_category.product_category_name " +
                        "JOIN orders ON order_items.order_id = orders.order_id " +
                        "where order_status = 'delivered' " +
                        "group by products.product_id " +
                        "order by sold desc " +
                        "LIMIT " + page * 21 + ",21";
                break;
            case "lowToHigh":
                query = "select round(avg(price),2) as avgPrice, products.product_id, product_category_name_english from order_items " +
                        "JOIN products ON order_items.product_id  = products.product_id " +
                        "JOIN product_category ON products.product_category_name = product_category.product_category_name " +
                        "group by products.product_id " +
                        "order by avgPrice " +
                        "LIMIT " + page * 21 + ",21";
                break;
            case "highToLow":
            default:
                query = "select round(avg(price),2) as avgPrice, products.product_id, product_category_name_english from order_items " +
                        "JOIN products ON order_items.product_id  = products.product_id " +
                        "JOIN product_category ON products.product_category_name = product_category.product_category_name " +
                        "group by products.product_id " +
                        "order by avgPrice desc " +
                        "LIMIT " + page * 21 + ",21";
                break;
        }

        try {
            Future fillProducts = Executors.newSingleThreadExecutor().submit(() -> {
                try {
                    Statement statement = conn.createStatement();
                    ResultSet res = statement.executeQuery(query);
                    while (res.next()) {
                        products.add(new Product(res.getString("product_id"),
                                res.getString("product_category_name_english"),
                                res.getFloat("avgPrice")));
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            });

            Future<General> getGeneral =
                    Executors.newSingleThreadExecutor().submit(() -> {
                        try {
                            Statement statement = conn.createStatement();
                            ResultSet res = statement.executeQuery("select round(avg(avgPrice),2) as totalAverage, round(min(avgPrice),2) as min , " +
                                    "round(max(avgPrice),2) as max ,count(avgPrice) as count " +
                                    "from (select avg(price) as avgPrice from order_items group by product_id) as prices ");
                            while (res.next()) {
                                return new General(res.getFloat("totalAverage"),
                                        res.getFloat("min"),
                                        res.getFloat("max"),
                                        res.getInt("count")
                                );
                            }
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                        return null;
                    });
            fillProducts.get();
            general = getGeneral.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("products", products);
        model.addAttribute("general", general);
        model.addAttribute("page", page);
        model.addAttribute("sort", sort);
        return "products";
    }

    //product page
    @GetMapping({"/product"})
    public String productView(@RequestParam(value = "page", defaultValue = "0") int page,
                              @RequestParam(value = "id") String id,
                              Model model) {
        if (page < 0) {
            page = 0;
        }
        float avgPrice, minPrice, maxPrice;
        maxPrice = minPrice = avgPrice = 0;
        int count = 0;
        Product product = null;
        List<Customer> customers = new ArrayList<>();

        String query = "select p.product_id, round(avg(review_score),2) as score, round(avg(price),2) as price, " +
                "count(p.product_id) as sold, product_category_name_english, p.product_category_name from products p " +
                "JOIN product_category ON p.product_category_name = product_category.product_category_name " +
                "JOIN order_items ON p.product_id = order_items.product_id " +
                "JOIN orders ON order_items.order_id = orders.order_id " +
                "JOIN order_reviews ON orders.order_id = order_reviews.order_id " +
                "where order_items.product_id ='" + id + "'and order_status = 'delivered' " +
                "group by p.product_id ";

        try {
            Statement statement = conn.createStatement();
            ResultSet res = statement.executeQuery(query);
            while (res.next()) {
                product = new Product(res.getString("product_id"),
                        res.getString("product_category_name_english"),
                        res.getString("product_category_name"),
                        res.getFloat("price"),
                        res.getFloat("score"),
                        res.getInt("sold"));
            }

            statement = conn.createStatement();
            res = statement.executeQuery("select orders.customer_id, count(orders.customer_id) as customerProduct from orders " +
                    "join order_items on orders.order_id = order_items.order_id " +
                    "where product_id = '" + id + "' " +
                    "group by orders.customer_id " +
                    "order by customerProduct desc ");
            while (res.next()) {
                customers.add(new Customer(res.getString("customer_id"),
                        res.getInt("customerProduct")));
            }

            statement = conn.createStatement();
            res = statement.executeQuery("select round(avg(avgPrice),2) as totalAverage, round(min(avgPrice),2) as min , " +
                    "round(max(avgPrice),2) as max ,count(avgPrice) as count " +
                    "from (select avg(price) as avgPrice from order_items group by product_id) as prices ");
            while (res.next()) {
                avgPrice = res.getFloat("totalAverage");
                minPrice = res.getFloat("min");
                maxPrice = res.getFloat("max");
                count = res.getInt("count");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        model.addAttribute("product", product);
        model.addAttribute("customers", customers);
        model.addAttribute("count", count);
        model.addAttribute("min", minPrice);
        model.addAttribute("max", maxPrice);
        model.addAttribute("avg", avgPrice);
        model.addAttribute("page", page);
        return "product";
    }

    //categories page
    @GetMapping("/categories")
    public String categories(@RequestParam(value = "page", defaultValue = "0") int page,
                             @RequestParam(value = "sort", defaultValue = "highToLow") String sort,
                             Model model) {
        if (page < 0) {
            page = 0;
        }
        General general = null;
        List<Category> categories = new ArrayList<>();
        String query;
        switch (sort) {
            case "best-seller":
                query = "select round(avg(price),2) as avgPrice, round(min(price),2) as minPrice, round(max(price),2) as maxPrice, " +
                        "product_category_name_english, products.product_category_name , count(product_category.product_category_name_english) as sold from order_items " +
                        "JOIN products ON order_items.product_id  = products.product_id " +
                        "JOIN product_category ON products.product_category_name = product_category.product_category_name " +
                        "JOIN orders ON order_items.order_id = orders.order_id " +
                        "where order_status = 'delivered' " +
                        "group by products.product_category_name " +
                        "order by sold desc " +
                        "LIMIT " + page * 21 + ",21";
                break;
            case "lowToHigh":
                query = "select round(avg(price),2) as avgPrice, round(min(price),2) as minPrice, round(max(price),2) as maxPrice, " +
                        "product_category_name_english, products.product_category_name from order_items " +
                        "JOIN products ON order_items.product_id  = products.product_id " +
                        "JOIN product_category ON products.product_category_name = product_category.product_category_name " +
                        "group by products.product_category_name " +
                        "order by avgPrice " +
                        "LIMIT " + page * 21 + ",21";
                break;
            case "highToLow":
            default:
                query = "select round(avg(price),2) as avgPrice, round(min(price),2) as minPrice, round(max(price),2) as maxPrice, " +
                        "product_category_name_english, products.product_category_name from order_items " +
                        "JOIN products ON order_items.product_id  = products.product_id " +
                        "JOIN product_category ON products.product_category_name = product_category.product_category_name " +
                        "group by products.product_category_name " +
                        "order by avgPrice desc " +
                        "LIMIT " + page * 21 + ",21";
                break;
        }

        try {
            Future fillCategories =
                    Executors.newSingleThreadExecutor().submit(() -> {
                        try {
                            Statement statement = conn.createStatement();
                            ResultSet res = statement.executeQuery(query);
                            while (res.next()) {
                                categories.add(new Category(res.getString("product_category_name_english"),
                                        res.getString("product_category_name"),
                                        res.getFloat("minPrice"),
                                        res.getFloat("maxPrice"),
                                        res.getFloat("avgPrice")));
                            }
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    });

            Future<General> getGeneral =
                    Executors.newSingleThreadExecutor().submit(() -> {
                        try {
                            Statement statement = conn.createStatement();
                            ResultSet res = statement.executeQuery("select round(avg(avgPrice),2) as totalAverage, round(min(avgPrice),2) as minPrice , " +
                                    "round(max(avgPrice),2) as maxPrice ,count(avgPrice) as count " +
                                    "from (select avg(price) as avgPrice from order_items " +
                                    "join products ON order_items.product_id  = products.product_id " +
                                    "join product_category on products.product_category_name = product_category.product_category_name " +
                                    "group by products.product_category_name) as prices ");
                            while (res.next()) {
                                return new General(res.getFloat("totalAverage"),
                                        res.getFloat("minPrice"),
                                        res.getFloat("maxPrice"),
                                        res.getInt("count")
                                );
                            }
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                        return null;
                    });
            fillCategories.get();
            general = getGeneral.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("categories", categories);
        model.addAttribute("general", general);
        model.addAttribute("page", page);
        model.addAttribute("sort", sort);
        return "categories";
    }


    //category page
    @GetMapping({"/category"})
    public String categoryView(@RequestParam(value = "page", defaultValue = "0") int page,
                               @RequestParam(value = "id") String id,
                               Model model) {
        if (page < 0) {
            page = 0;
        }
        float avgPrice, minPrice, maxPrice;
        maxPrice = minPrice = avgPrice = 0;
        int count = 0;
        Category category = null;
        List<Product> products = new ArrayList<>();

        String query = "select c.product_category_name, product_category_name_english, round(avg(review_score),2) as score, round(avg(price),2) as price," +
                " count(p.product_id) as sold, min(price) as min, max(price) as max from product_category c " +
                "JOIN products p ON c.product_category_name = p.product_category_name " +
                "JOIN order_items ON p.product_id = order_items.product_id " +
                "JOIN orders ON order_items.order_id = orders.order_id " +
                "JOIN order_reviews ON orders.order_id = order_reviews.order_id " +
                "where c.product_category_name = '" + id + "' and order_status = 'delivered' " +
                "group by c.product_category_name ";

        try {
            Statement statement = conn.createStatement();
            ResultSet res = statement.executeQuery(query);
            while (res.next()) {
                category = new Category(res.getString("product_category_name_english"),
                        res.getString("product_category_name"),
                        res.getFloat("min"),
                        res.getFloat("max"),
                        res.getFloat("price"),
                        res.getFloat("score"),
                        res.getInt("sold"));
            }

            statement = conn.createStatement();
            res = statement.executeQuery("select p.product_id, round(avg(review_score),2) as score, round(avg(price),2) as price, " +
                    "count(p.product_id) as sold, product_category_name_english, p.product_category_name from products p " +
                    "JOIN product_category ON p.product_category_name = product_category.product_category_name " +
                    "JOIN order_items ON p.product_id = order_items.product_id " +
                    "JOIN orders ON order_items.order_id = orders.order_id " +
                    "JOIN order_reviews ON orders.order_id = order_reviews.order_id " +
                    "where p.product_category_name ='" + id + "'and order_status = 'delivered' " +
                    "group by p.product_id ");
            while (res.next()) {
                products.add(new Product(res.getString("product_id"),
                        res.getString("product_category_name_english"),
                        res.getString("product_category_name"),
                        res.getFloat("price"),
                        res.getFloat("score"),
                        res.getInt("sold")));
            }

            statement = conn.createStatement();
            res = statement.executeQuery("select round(avg(avgPrice),2) as totalAverage, round(min(avgPrice),2) as minPrice , " +
                    "round(max(avgPrice),2) as maxPrice ,count(avgPrice) as count " +
                    "from (select avg(price) as avgPrice from order_items " +
                    "join products ON order_items.product_id  = products.product_id " +
                    "join product_category on products.product_category_name = product_category.product_category_name " +
                    "group by products.product_category_name) as prices ");
            while (res.next()) {
                avgPrice = res.getFloat("totalAverage");
                minPrice = res.getFloat("minPrice");
                maxPrice = res.getFloat("maxPrice");
                count = res.getInt("count");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        model.addAttribute("products", products);
        model.addAttribute("category", category);
        model.addAttribute("count", count);
        model.addAttribute("min", minPrice);
        model.addAttribute("max", maxPrice);
        model.addAttribute("avg", avgPrice);
        model.addAttribute("page", page);
        return "category";
    }

    //sellers page
    @GetMapping("/sellers")
    public String seller(Model model) {
        List<Integer> zip_codes = new ArrayList<>();
        List<String> seller_id = new ArrayList<>();
        try {
            Statement statement = conn.createStatement();
            ResultSet res = statement.executeQuery("SELECT zip_code FROM sellers");
            while (res.next()) {
                zip_codes.add(res.getInt("zip_code"));
            }
            statement = conn.createStatement();
            res = statement.executeQuery("SELECT seller_id FROM sellers");
            while (res.next()) {
                seller_id.add(res.getString("seller_id"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        model.addAttribute("codes", zip_codes);
        model.addAttribute("ids", seller_id);
        return "sellers";
    }

    //seller single view page
    @GetMapping({"/seller"})
    public String sellerView(@RequestParam(value = "id") String id,
                               Model model) {

        Seller seller = null;
        List<ProductSold> productSold = new ArrayList<>();

        String query = "select oi.seller_id , sellers.zip_code, geolocation_city, " +
                "geolocation_state, count(orders.order_id) as sold, " +
                "ifnull((select count(orders.order_id)  from order_items " +
                "join orders on order_items.order_id = orders.order_id " +
                "where seller_id = oi.seller_id and seller_id='"+id+"' " +
                "and order_status = 'delivered' " +
                "group by seller_id),0) as delivered  from order_items oi " +
                "join sellers on oi.seller_id = sellers.seller_id " +
                "join geolocation on sellers.zip_code = geolocation.zip_code " +
                "join orders on oi.order_id = orders.order_id " +
                "where oi.seller_id='"+id+"' " +
                "group by oi.seller_id";

        try {
            Statement statement = conn.createStatement();
            ResultSet res = statement.executeQuery(query);
            while (res.next()) {
                seller = new Seller(res.getString("seller_id"),
                        res.getString("geolocation_city"),
                        res.getString("geolocation_state"),
                        res.getInt("sold"),
                        res.getInt("delivered"),
                        res.getInt("zip_code")
                );
            }

            statement = conn.createStatement();
            res = statement.executeQuery("select product_id , count(orders.order_id) as sold, " +
                    "ifnull((select count(orders.order_id)  from order_items " +
                    "join orders on order_items.order_id = orders.order_id " +
                    "where product_id = oi.product_id and seller_id='"+id+"' " +
                    "and order_status = 'delivered' " +
                    "group by product_id),0) as delivered  from order_items oi " +
                    "join orders on oi.order_id = orders.order_id " +
                    "where seller_id='"+id+"'" +
                    "group by product_id ");
            while (res.next()) {
                productSold.add(new ProductSold(res.getString("product_id"),
                        res.getInt("sold"),
                        res.getInt("delivered"))
                );
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        model.addAttribute("seller", seller);
        model.addAttribute("productSold", productSold);
        return "seller";
    }

    //customer page
    @GetMapping("/customers")
    public String customerView(Model model) {
        return "customers";
    }

    //single customer view page
    @GetMapping({"/customer"})
    public String customerView(@RequestParam(value = "id") String id,
                             Model model) {

        Customer customer = null;
        List<Seller> seller = new ArrayList<>();
        List<ProductSold> productSold = new ArrayList<>();

        String query = "select orders.customer_id, geolocation_city, geolocation_state, customers.zip_code, " +
                "round(sum(price),2) as spent, count(order_items.product_id) as productsBought from order_items " +
                "join orders on order_items.order_id = orders.order_id " +
                "join customers on orders.customer_id = customers.customer_id " +
                "join geolocation on customers.zip_code = geolocation.zip_code " +
                "where orders.customer_id = '"+id+"' " +
                "group by orders.customer_id " +
                "order by productsBought desc ";

        try {
            Statement statement = conn.createStatement();
            ResultSet res = statement.executeQuery(query);
            while (res.next()) {
                customer = new Customer(res.getString("customer_id"),
                        res.getString("geolocation_city"),
                        res.getString("geolocation_state"),
                        res.getInt("zip_code"),
                        res.getInt("productsBought"),
                        res.getFloat("spent")
                );
            }

            statement = conn.createStatement();
            res = statement.executeQuery("select seller_id, geolocation_city, geolocation_state, " +
                    "round(sqrt(power(abs(geolocation_lat-(select geolocation_lat from customers " +
                    "join geolocation on customers.zip_code = geolocation.zip_code where customer_id ='"+id+"')),2) " +
                    "+ power(abs(geolocation_lng-(select geolocation_lng from customers " +
                    "join geolocation on customers.zip_code = geolocation.zip_code where customer_id ='"+id+"')),2)),3) as distance " +
                    "from sellers " +
                    "join geolocation on sellers.zip_code = geolocation.zip_code " +
                    "where geolocation_lat is not null  " +
                    "order by distance " +
                    "limit 20 ");
            while (res.next()) {
                seller.add(new Seller(res.getString("seller_id"),
                        res.getString("geolocation_city"),
                        res.getString("geolocation_state"),
                        res.getFloat("distance"))
                );
            }

            statement = conn.createStatement();
            res = statement.executeQuery("select product_id , count(orders.order_id) as sold, " +
                    "ifnull((select count(orders.order_id)  from order_items " +
                    "join orders on order_items.order_id = orders.order_id " +
                    "where product_id = oi.product_id and customer_id='"+id+"' " +
                    "and order_status = 'delivered' " +
                    "group by product_id),0) as delivered  from order_items oi " +
                    "join orders on oi.order_id = orders.order_id " +
                    "where customer_id='"+id+"'" +
                    "group by product_id ");
            while (res.next()) {
                productSold.add(new ProductSold(res.getString("product_id"),
                        res.getInt("sold"),
                        res.getInt("delivered"))
                );
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        model.addAttribute("customer", customer);
        model.addAttribute("seller", seller);
        model.addAttribute("productSold", productSold);
        return "customer";
    }

    //search page
    @GetMapping("/search")
    public String search(@RequestParam(value = "query") String query, Model model) {
        try {
            Future<Boolean> isProduct = Executors.newSingleThreadExecutor().submit(() -> {
                try {
                    Statement statement = conn.createStatement();
                    ResultSet res = statement.executeQuery("SELECT EXISTS(SELECT * FROM products " +
                            "WHERE product_id='"+ query +"') as exist ");
                    while (res.next()) {
                        return res.getBoolean("exist");
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                return false;
            });
            Future<Boolean> isCustomer = Executors.newSingleThreadExecutor().submit(() -> {
                try {
                    Statement statement = conn.createStatement();
                    ResultSet res = statement.executeQuery("SELECT EXISTS(SELECT * FROM customers " +
                            "WHERE customer_id='"+ query +"') as exist ");
                    while (res.next()) {
                        return res.getBoolean("exist");
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                return false;
            });
            Future<Boolean> isSeller = Executors.newSingleThreadExecutor().submit(() -> {
                try {
                    Statement statement = conn.createStatement();
                    ResultSet res = statement.executeQuery("SELECT EXISTS(SELECT * FROM sellers " +
                            "WHERE seller_id='"+ query +"') as exist ");
                    while (res.next()) {
                        return res.getBoolean("exist");
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                return false;
            });
            if(isProduct.get()){
                return "forward:/product?id="+query;
            }else if (isCustomer.get()){
                return "forward:/customer?id="+query;
            }else if(isSeller.get()){
                return "forward:/seller?id="+query;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "notFound";
    }
}
