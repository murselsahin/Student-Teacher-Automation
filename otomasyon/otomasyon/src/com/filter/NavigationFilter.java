package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.session.Session;

public class NavigationFilter implements Filter {

	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filter) throws IOException, ServletException {
		HttpServletRequest req  = (HttpServletRequest)request;
		HttpServletResponse hsr = (HttpServletResponse)response;
		
		if(req.getRequestURI().endsWith("yonetici_giris.jsp") || req.getRequestURI().endsWith("dersekle.jsp") 
				|| req.getRequestURI().endsWith("ogretmen_ders.jsp") || req.getRequestURI().endsWith("dersduzenle.jsp")
				|| req.getRequestURI().endsWith("ogretmen_bolum_degistir.jsp") 
				|| req.getRequestURI().endsWith("ogretmen_ders_cikar.jsp") 
				|| req.getRequestURI().endsWith("ogretmen_ogrenci_ekle.jsp")
				|| req.getRequestURI().endsWith("ogrenci_ders_cikar.jsp"))
		{
			if(!Session.admin_giris)
				hsr.sendRedirect("anasayfa.jsp");
			
		}
		
		if(req.getRequestURI().endsWith("ogretmen_giris.jsp")|| req.getRequestURI().endsWith("notgirisi.jsp")
				|| req.getRequestURI().endsWith("ogretmen_bilgi_degis.jsp")
				|| req.getRequestURI().endsWith("skala_degis.jsp"))
		{
			if(!Session.ogretmen_giris)
				hsr.sendRedirect("anasayfa.jsp");
		}
		if(req.getRequestURI().endsWith("ogrenci_giris.jsp")|| req.getRequestURI().endsWith("derskayit.jsp")
				|| req.getRequestURI().endsWith("transkript.jsp") || req.getRequestURI().endsWith("notbilgisi.jsp")
				||  req.getRequestURI().endsWith("ogrenci_bilgi_degis.jsp"))
		{
			if(!Session.ogrenci_giris)
				hsr.sendRedirect("anasayfa.jsp");
		}
		
		
		filter.doFilter(request, response);
		
	}

	
	
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
