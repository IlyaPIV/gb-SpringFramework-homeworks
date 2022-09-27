package gb.homework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.List;

//@WebServlet(name = "ProductsList", urlPatterns = "/products")
public class ProductsServlet implements Servlet {

    private static final Logger logger = LoggerFactory.getLogger(ProductsServlet.class);
    private transient ServletConfig config;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.config = servletConfig;
    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        logger.info("New request to server");

        List<Product> productList = ProductsGenerator.generateList(Integer.parseInt(servletRequest.getParameter("size")));

        for (Product prod:
             productList) {
            servletResponse.getWriter().println("<h3>" + prod.toString() + "</h3>");
        }

    }

    @Override
    public String getServletInfo() {
        return "Products list servlet";
    }

    @Override
    public void destroy() {
        logger.info(getServletInfo() + " destroyed");
    }
}
