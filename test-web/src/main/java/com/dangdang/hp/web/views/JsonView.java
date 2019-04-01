package com.dangdang.hp.web.views;

import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.web.servlet.view.AbstractView;

import com.dangdang.hp.web.response.BaseResponse;

public class JsonView extends AbstractView {
	
	private static final String CONTENT_TYPE = "application/json";
	
	public JsonView(){
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
		
		JSONObject jsonObj =JSONObject.fromObject(respone);
		
		String responseStr = jsonObj.toString();

		PrintWriter writer = response.getWriter();

		writer.write(responseStr);

		writer.flush();

		writer.close();

	}

}
