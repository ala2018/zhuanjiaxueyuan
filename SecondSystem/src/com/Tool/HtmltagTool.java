package com.Tool;

public class HtmltagTool {
	/*
	 * html标签属性变量
	 * 
	 */
    private String h_class="";
    private String h_id="";
    private String h_name="";
    private String h_style="";
    private String h_align="";
    private String h_onclick="";
    private String h_href="";
    /*
     * html标签变量
     * 
     */
	private StringBuffer h_div;
	private StringBuffer h_a;
	private StringBuffer h_fieldset;
	private StringBuffer h_legend;
	private StringBuffer h_h;
	/*
	 * 属性获取和设置方法
	 * 
	 */
	public String getH_class() {
		return h_class;
	}
	public void setH_class(String h_class) {
		this.h_class =" class=\""+h_class+"\"" ;
	}
	public String getH_id() {
		return h_id;
	}
	public void setH_id(String h_id) {
		this.h_id = " id=\""+h_id+"\"";
	}
	public String getH_name() {
		return h_name;
	}
	public void setH_name(String h_name) {
		this.h_name = " name=\""+h_name+"\"";
	}
	public String getH_style() {
		return h_style;
	}
	public void setH_style(String h_style) {
		this.h_style = " style=\""+h_style+"\"";
	}
	public String getH_align() {
		return h_align;
	}
	public void setH_align(String h_align) {
		this.h_align = " align=\""+h_align+"\"";
	}
	public String getH_onclick() {
		return h_onclick;
	}
	public void setH_onclick(String h_onclick) {
		this.h_onclick = " onclick=\""+h_onclick+"\"";
	}
	public String getH_href() {
		return h_href;
	}
	public void setH_href(String h_href) {
		this.h_href = " href=\""+h_href+"\"";
	}
	
	/*
	 * html标签获取方法
	 */
	public StringBuffer getH_div() {
		 StringBuffer h_div=new StringBuffer();
		 h_div.append("<div");
		 if(h_id!="")
			 h_div.append(h_id);
		 if(h_name!="")
			 h_div.append(h_name);
		 if(h_align!="")
			 h_div.append(h_align);
		 if(h_style!="")
			 h_div.append(h_style);
		 if(h_class!="")
			 h_div.append(h_class);
		 
		 h_div.append(">").append(this.h_div.toString()).append("</div>");
		return h_div;
	}
	
	public void setH_div(String text) {
		this.h_div.append(text);
	}
	public StringBuffer getH_a() {
		StringBuffer h_a=new StringBuffer();
		 h_a.append("<a");
		 if(h_id!="")
			 h_a.append(h_id);
		 if(h_name!="")
			 h_a.append(h_name);
		 if(h_align!="")
			 h_a.append(h_align);
		 if(h_style!="")
			 h_a.append(h_style);
		 if(h_class!="")
			 h_a.append(h_class);
		 if(h_href!="")
			 h_a.append(h_href);
		 h_a.append(">").append(this.h_a.toString()).append("</a>");
		return h_a;
	}
	


	public void setH_a(String text) {
		this.h_a.append(text);
	}



	public StringBuffer getH_fieldset() {
		 StringBuffer h_fieldset=new StringBuffer();
		 h_fieldset.append("<fieldset");
		 if(h_id!="")
			 h_fieldset.append(h_id);
		 if(h_name!="")
			 h_fieldset.append(h_name);
		 if(h_align!="")
			 h_fieldset.append(h_align);
		 if(h_style!="")
			 h_fieldset.append(h_style);
		 if(h_class!="")
			 h_fieldset.append(h_class);
		 
		 h_fieldset.append(">").append(this.h_fieldset.toString()).append("</fieldset>");
		return h_fieldset;
	}

	public void setH_fieldset(String text) {
		this.h_fieldset.append(text);
	}
	public StringBuffer getH_legend() {
		 StringBuffer h_legend=new StringBuffer();
		 h_legend.append("<legend");
		 if(h_id!="")
			 h_legend.append(h_id);
		 if(h_name!="")
			 h_legend.append(h_name);
		 if(h_align!="")
			 h_legend.append(h_align);
		 if(h_style!="")
			 h_legend.append(h_style);
		 if(h_class!="")
			 h_legend.append(h_class);
		 
		 h_legend.append(">").append(this.h_legend.toString()).append("</legend>");
		return h_legend;
	}

	public void setH_legend(String text) {
		this.h_legend.append(text);
	}
	public StringBuffer getH_h(int num) {
		 StringBuffer h_h=new StringBuffer();
		 h_h.append("<h").append(num);
		 if(h_id!="")
			 h_h.append(h_id);
		 if(h_name!="")
			 h_h.append(h_name);
		 if(h_align!="")
			 h_h.append(h_align);
		 if(h_style!="")
			 h_h.append(h_style);
		 if(h_class!="")
			 h_h.append(h_class);
		 
		 h_h.append(">").append(this.h_h.toString()).append("</h").append(num).append(">");
		return h_h;
	}
	public void setH_h(String text) {
		this.h_h.append(text);
	}

  
}
