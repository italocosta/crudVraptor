package com.italocosta.crudvraptor.converter;

import java.text.NumberFormat;
import java.text.ParseException;

import javax.annotation.Priority;
import javax.enterprise.inject.Alternative;
import javax.interceptor.Interceptor;

import br.com.caelum.vraptor.Convert;
import br.com.caelum.vraptor.converter.ConversionException;
import br.com.caelum.vraptor.converter.ConversionMessage;
import br.com.caelum.vraptor.converter.DoubleConverter;

@SuppressWarnings("deprecation")
@Alternative
@Priority(Interceptor.Priority.APPLICATION)
@Convert(Double.class)
public class MyDoubleConverter extends DoubleConverter {
	
	@Override
	public Double convert(String value, Class<? extends Double> type) {
		if (value == null || value.equals("")) {
			return null;
		}
		try {
			return NumberFormat.getNumberInstance().parse(value.replace(".", ",")).doubleValue();
		} catch (ParseException e) {
			e.printStackTrace();
			throw new ConversionException(new ConversionMessage("is_not_a_valid_number", value));
		}
	}
}
