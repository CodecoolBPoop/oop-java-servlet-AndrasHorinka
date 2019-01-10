package com.codecool.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "WebShopServlet", urlPatterns = {"/webshop"}, loadOnStartup = 1)
public class WebShop extends HttpServlet {



    void initItems(ItemStore store) {
        store.addItem(new Item("Panasonic RP-HF400B Wireless Bluetooth Headphones", 40.00));
        store.addItem(new Item("Nokia Lumia 620 oldschool mobile", 10.00));
        store.addItem(new Item("Oakley Sunglass Romeo", 70.00));
        store.addItem(new Item("Cannon EOS D60", 150.00));
    }



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        PrintWriter out = response.getWriter();

//        Initializing Store
        ItemStore store = new ItemStore();
        initItems(store);
        ShoppingCartServlet cart = new ShoppingCartServlet();



//        Initializing variables for the Webpage
        String title = "Webshop";
        StringBuffer buffer = new StringBuffer();
        for (Item item: store.items) {
            buffer.append("<tr>");
            buffer.append("<td>");
            buffer.append(item.getName());
            buffer.append("</td>");
            buffer.append("<td>");
            buffer.append(item.getPrice());
            buffer.append("</td>");
            buffer.append("<td>");
            buffer.append("<div class=\"btn-group\">");

            buffer.append("<form action=\"WebShop\" method=\"POST\">");
            buffer.append("<input type=\"text\" value=\"add\" name=\"add\" hidden readonly>");
            buffer.append("<input type=\"text\" value=\""+item.getId()+"\" name=\"id\" hidden readonly>");
            buffer.append("<button type=\"submit\" class=\"btn btn-success\">");
            buffer.append("Add");
            buffer.append("</button>");
            buffer.append("</form>");

            buffer.append("<form action=\"WebShop\" method=\"POST\">");
            buffer.append("<input type=\"text\" value=\"remove\" name=\"add\" hidden readonly>");
            buffer.append("<input type=\"text\" value=\""+item.getId()+"\" name=\"id\" hidden readonly>");
            buffer.append("<button type=\"submit\" class=\"btn btn-danger\">");
            buffer.append("Remove");
            buffer.append("</button>");
            buffer.append("</form>");

            buffer.append("</div>");
            buffer.append("</td>");
            buffer.append("</tr>");
        }


        out.println(
                "<!DOCTYPE html>\n" +
                        "<html lang=\"en\">\n" +
                        "<head>\n" +
                        "    <meta charset=\"UTF-8\">\n" +
                        "    <title>" +title+ "</title>\n" +
                        "    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css\" integrity=\"sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS\" crossorigin=\"anonymous\">\n" +
                        "\n" +
                        "    </head>\n" +
                        "<body class=\"bg-dark\"¬>\n" +
                        "    <div class=\"container\">\n" +
                        "        <div class=\"row\">\n" +
                        "            <div class=\"col\">\n" +
                        "                <div class=\"jumbotron bg-warning\">\n" +
                        "                    <div class=\"h1 text-center\">\n" +
                        "                        WebShop\n" +
                        "                    </div>\n" +
                        "                </div>\n" +
                        "            </div>\n" +
                        "        </div>\n" +
                        "        <div class=\"row\">\n" +
                        "            <div class=\"col\">\n" +
                        "                <table class=\"table table-stripped table-bordered table-primary text-center\">\n" +
                        "                    <tr>\n" +
                        "                        <th>\n" +
                        "                            Name\n" +
                        "                        </th>\n" +
                        "                        <th>\n" +
                        "                            Price\n" +
                        "                        </th>\n" +
                        "                        <th>\n" +
                        "                            Options\n" +
                        "                        </th>\n" +
                        "                    </tr>\n" +
                        buffer.toString() +
                        "       </form>" +
                        "                </table>\n" +
                        "            </div>\n" +
                        "        </div>\n" +
                        "    </div>\n" +
                        "</body>\n" +
                        "</html>"
        );
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        doGet(request, response);
    }

}
