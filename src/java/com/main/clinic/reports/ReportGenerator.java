
package com.main.clinic.reports;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import net.sf.jasperreports.engine.JRException;

import net.sf.jasperreports.engine.JRPrintPage;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

/**
 *
 * @author krish
 */
@Stateless
public class ReportGenerator  {
       
	private JasperPrint jasperPrint;
        
        public ReportGenerator() {
	}

	public boolean generateReport(String path, Map<String, Object> parameters) throws NamingException, SQLException {
		boolean flag = false;
		Connection con = null;
		HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		try {
			JasperDesign jasperDesign = new JasperDesign();
			String jrXml = FacesContext.getCurrentInstance().getExternalContext().getRealPath(path);
			jasperDesign = JRXmlLoader.load(jrXml);
			JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
                        InitialContext initialContext = new InitialContext();
                        DataSource dataSource = (DataSource)initialContext.lookup("java:app/DS");
                        con = dataSource.getConnection();
                       
			
			jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, con);
			List<JRPrintPage> pages;
			pages = jasperPrint.getPages();
			if (!pages.isEmpty()) {
				flag = true;
				ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
				httpServletResponse.setContentType("application/pdf");
				httpServletResponse.addHeader("Content-disposition", "inline; filename=report.pdf");
				JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
			}
		} catch (IOException | JRException e) {
		} finally {
			try {
				if (con != null && !con.isClosed()) {
					con.close();
				}
			} catch (SQLException e) {
			}
		}
		if (!flag) {
			try {
				PrintWriter writer = httpServletResponse.getWriter();
				writer.write("<html><body><h2 style='color: #D00000;'>Document Empty..!</h2></body></html>");
				httpServletResponse.setHeader("Content-Type", "text/html");
			} catch (IOException e) {
			}
		}
		FacesContext.getCurrentInstance().responseComplete();
		return flag;
	}

	public HashMap<String, Object> generateAddress() {
		//MyCompany company = myCompanyBusinessLocal.find(1L);
		HashMap<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("companyName", "Dental Clinic");
		parameters.put("address1", "Nandikkara");
		parameters.put("address2", "Thrissur");
		//parameters.put("address3", company.getAddress3());
		parameters.put("gstNo", "580301");
		parameters.put("cstNo", "4697");
		parameters.put("ownerName", "Jishnu");
		return parameters;
	}
	private void prepareReport(String path, Map<String, Object> parameters) throws JRException, SQLException, NamingException {
		JasperDesign jasperDesign = new JasperDesign();
		String jrXml = FacesContext.getCurrentInstance().getExternalContext().getRealPath(path);
		jasperDesign = JRXmlLoader.load(jrXml);
		JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
                        InitialContext initialContext = new InitialContext();
                        DataSource dataSource = (DataSource)initialContext.lookup("java:app/DS");
            try (Connection con = dataSource.getConnection()) {
                jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, con);
            }
	}        

}
