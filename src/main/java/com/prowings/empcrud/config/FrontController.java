package com.prowings.empcrud.config;

import java.util.Properties;

import org.hibernate.engine.spi.Mapping;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

public class FrontController extends AbstractAnnotationConfigDispatcherServletInitializer  {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[]  {SpringWebMvcConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		String[]mapping= {"/"};
		return mapping;
	}
	@Bean
	public View jsonTmplate()
	{
		MappingJackson2JsonView view=new MappingJackson2JsonView();
		Properties props=new Properties();
		props.put("order", 1);
		view.setAttributes(props);
		view.setPrettyPrint(true);
		return view;
	}
	@Bean
	public ViewResolver viewResolver()
	{
		return new BeanNameViewResolver();
	}

}
