package servletik;

import resources.ResourceServerController;
import resources.ResourceServerMBean;
import resources.TestResource;
import sax.ReadXMLFileSAX;

import javax.management.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.management.ManagementFactory;

public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String filePath = req.getParameter("path");
        if (filePath == null) {
            resp.getWriter().println("no parameter path was given");
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        TestResource testResource = (TestResource)ReadXMLFileSAX.readXML(filePath);
        ResourceServerMBean serverData = new ResourceServerController(testResource);
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = null;
        try {
            name = new ObjectName("Admin:type=ResourceServerController");
        } catch (MalformedObjectNameException e) {
            e.printStackTrace();
        }
        try {
            mbs.registerMBean(serverData, name);
        } catch (InstanceAlreadyExistsException e) {
            e.printStackTrace();
        } catch (MBeanRegistrationException e) {
            e.printStackTrace();
        } catch (NotCompliantMBeanException e) {
            e.printStackTrace();
        }
    }
}
