package com.example.javaWeb;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "calculator", value = "/calculator")
public class Calculator extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getAttribute("number1") != null && req.getAttribute("number2") != null) {

            Double number1 = Double.valueOf(req.getAttribute("number1").toString());
            Double number2 = Double.valueOf(req.getAttribute("number2").toString());
            Calculations calc = new Calculations(number1,number2);
            Object result = null;

            if (req.getParameter("operation").equals("addition")) {
                result = calc.addition();
            } else if (req.getParameter("operation").equals("subtraction")) {
                result = calc.subtraction();
            } else if (req.getParameter("operation").equals("multiplication")) {
                result = calc.multiplication();
            } else if (req.getParameter("operation").equals("division")) {
                result = calc.division();
            } else if (req.getParameter("operation").equals("exponentiation")) {
                result = calc.exponentiation();
            } else if (req.getParameter("operation").equals("interest_calculation")) {
                result = calc.interest_calculation();
            }

            req.setAttribute("result", result);
        }
        getServletContext().getRequestDispatcher("/calculator.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("number1", req.getParameter("number1"));
        req.setAttribute("number2", req.getParameter("number2"));
        req.setAttribute("addition", req.getParameter("addition"));
        req.setAttribute("subtraction", req.getParameter("subtraction"));
        req.setAttribute("multiplication", req.getParameter("multiplication"));
        req.setAttribute("division", req.getParameter("division"));
        req.setAttribute("exponentiation", req.getParameter("exponentiation"));
        req.setAttribute("interest_calculation", req.getParameter("interest_calculation"));
        doGet(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }

    public class Calculations {
        Double a;
        Double b;
        Calculations(Double a, Double b) {
            this.a = a;
            this.b = b;
        }

        Double addition() {
            return a + b;
        }
        Double subtraction() {
            return a - b;
        }
        Double multiplication() {
            return a * b;
        }
        Double division() {
            return a / b;
        }
        Double exponentiation() {
            return Math.pow(a,b);
        }
        Double interest_calculation() {
            return (a / 100) * b;
        }
    }
}
