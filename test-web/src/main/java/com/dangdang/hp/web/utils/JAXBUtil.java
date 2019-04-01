package com.dangdang.hp.web.utils;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import com.dangdang.hp.web.response.BaseResponse;

public class JAXBUtil {

	/**
	 * JavaBean转换成xml
	 * 
	 * @param obj
	 * @param encoding
	 * @return String
	 */
	public static String convertToXml(Object obj, String encoding) {
		String result = null;
		try {
			JAXBContext context = JAXBContext.newInstance(obj.getClass());
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);

			StringWriter writer = new StringWriter();
			marshaller.marshal(obj, writer);
			result = writer.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * JavaBean转换成xml
	 * 
	 * @param obj
	 * @return String
	 */
	public static String convertToXml(Object obj) {
		String result = convertToXml(obj, EncodeConstant.UTF_8);
		return result;
	}

	public static void main(String[] args) {

		BaseResponse response = new BaseResponse();

		String str = JAXBUtil.convertToXml(response);

		System.out.println(str);

	}

}
