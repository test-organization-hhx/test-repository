package com.dangdang.hp.web.views;

import java.io.PrintWriter;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

import com.dangdang.hp.web.response.BaseResponse;
import com.dangdang.hp.web.utils.JAXBUtil;

public class XmlView extends AbstractView {

	private static final String CONTENT_TYPE = "application/xml";

	public XmlView() {
		setContentType(CONTENT_TYPE);
	}

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		response.setContentType(getContentType());

		Set<Entry<String, Object>> set = model.entrySet();

		BaseResponse respone = null;

		if (set != null && set.size() > 0) {
			for (Entry<String, Object> entry : set) {
				Object obj = entry.getValue();
				if (obj instanceof BaseResponse) {
					respone = (BaseResponse) obj;
					break;
				}
			}
		}
		
		if(respone == null){
			
		}
		
		String responseStr = JAXBUtil.convertToXml(respone);

		PrintWriter writer = response.getWriter();

		writer.write(responseStr);

		writer.flush();

		writer.close();

	}

}
