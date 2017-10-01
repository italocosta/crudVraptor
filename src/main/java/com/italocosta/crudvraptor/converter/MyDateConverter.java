package com.italocosta.crudvraptor.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Priority;
import javax.enterprise.inject.Alternative;
import javax.interceptor.Interceptor;

import br.com.caelum.vraptor.Convert;
import br.com.caelum.vraptor.converter.ConversionException;
import br.com.caelum.vraptor.converter.ConversionMessage;
import br.com.caelum.vraptor.converter.DateConverter;

@SuppressWarnings("deprecation")
@Alternative
@Priority(Interceptor.Priority.APPLICATION)
@Convert(Date.class)
public class MyDateConverter extends DateConverter{	

	@Override
	public Date convert(String value, Class<? extends Date> type) {
		if (value == null || value.equals("")) {
			return null;
		}
		try {
			return (Date) new SimpleDateFormat("yyyy-MM-dd").parse(value);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new ConversionException(new ConversionMessage("is_not_a_valid_date ", value));
		}
	}

}